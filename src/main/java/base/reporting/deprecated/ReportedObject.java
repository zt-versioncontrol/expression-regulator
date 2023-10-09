package base.reporting.deprecated;

@Deprecated
public abstract class ReportedObject {
    public final Class<?> reporter;

    public ReportedObject(Class<?> reporter) {
        this.reporter = reporter;
    }
}
