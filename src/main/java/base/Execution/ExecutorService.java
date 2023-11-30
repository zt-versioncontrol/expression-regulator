package base.Execution;

import base.components.execution.ScriptExecutor;

import java.util.HashMap;
import java.util.Map;

public class ExecutorService {
    private final Map<Class<? extends ScriptExecutor>, ScriptExecutor> executorMap = new HashMap<>();

    public void addScriptExecutor(ScriptExecutor executor){
        executorMap.put(executor.getClass(), executor);
    }

    public ScriptExecutor getScriptExecutor(Class<? extends ScriptExecutor> executorClass){
        return executorMap.get(executorClass);
    }
}
