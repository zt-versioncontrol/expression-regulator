package base.Execution;

import base.components.execution.ScriptExecutor;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class ExecutionChainer {
    private final ExecutorService executorService;

    public ExecutionChainer(ExecutorService executorService) {
        this.executorService = executorService;
    }

    // TODO: 11/30/2023 write test
    public void execute(ScriptExecutor executor){
        List<Field> chainedParameters = Arrays.stream(executor.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(ChainedParameter.class))
                .toList();

        for (Field chainedParameter : chainedParameters) {
            chainedParameter.setAccessible(true);
            ChainedParameter annotation = chainedParameter.getAnnotation(ChainedParameter.class);

            ScriptExecutor chainedExecutor = executorService.getScriptExecutor(annotation.executor());
            if (chainedExecutor == null){
                throw new ExecutorNotFoundException();
            }

            execute(chainedExecutor);
            try {
                chainedParameter.set(executor, chainedExecutor.execute());
            }catch (IllegalArgumentException e){
                throw new IncompatibleExecutorException();
            }
            catch (IllegalAccessException ignored){}
        }
    }

    public static class ExecutorNotFoundException extends RuntimeException{}
    public static class IncompatibleExecutorException extends RuntimeException{}
}
