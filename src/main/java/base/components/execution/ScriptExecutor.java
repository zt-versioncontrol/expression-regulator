package base.components.execution;

public abstract class ScriptExecutor<PARSED_SCRIPT, CONTEXT> {
    protected final PARSED_SCRIPT parsedScript;
    protected final CONTEXT context;

    public ScriptExecutor(PARSED_SCRIPT parsedScript, CONTEXT context) {
        this.parsedScript = parsedScript;
        this.context = context;
    }

    public abstract Object execute();
}
