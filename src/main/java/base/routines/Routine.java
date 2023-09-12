package base.routines;

public interface Routine<CONTEXT> {

    void execute(CONTEXT context);

    default void before(){}
    default void after(){}
}
