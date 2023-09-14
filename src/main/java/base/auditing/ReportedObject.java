package base.auditing;

public abstract class ReportedObject {
    public final Class<?> reporter;

    public ReportedObject(Class<?> reporter) {
        this.reporter = reporter;
    }
}
