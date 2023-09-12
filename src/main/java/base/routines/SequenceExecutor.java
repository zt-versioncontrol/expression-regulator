package base.routines;

import java.util.ArrayList;
import java.util.List;

public abstract class SequenceExecutor<CONTEXT extends ArrayList> {
    private final List<Routine<CONTEXT>> routines;
    private CONTEXT context;


    public SequenceExecutor(List<Routine<CONTEXT>> routines, CONTEXT context) {
        this.routines = routines;
        this.context = context;
    }

    public void setContext(CONTEXT context) {
        this.context = context;
    }

    public CONTEXT getContext() {
        return context;
    }

    public CONTEXT executeSequence(CONTEXT context){
        for (Routine<CONTEXT> routine : routines) {
            setupContext();
            routine.before();
            routine.execute(context);
            cleanContext();
            routine.after();
        }

        return context;
    }

    public abstract void setupContext();
    public abstract void cleanContext();
}
