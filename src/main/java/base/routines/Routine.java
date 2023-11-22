package base.routines;

public interface Routine<CONTEXT extends RoutineContext> {

    void execute(CONTEXT context);
}
