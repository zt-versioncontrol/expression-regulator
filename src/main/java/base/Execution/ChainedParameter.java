package base.Execution;

import base.components.execution.ScriptExecutor;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ChainedParameter {
    Class<? extends ScriptExecutor> executor();
}
