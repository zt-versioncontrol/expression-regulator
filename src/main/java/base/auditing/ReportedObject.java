package base.auditing;

public abstract class ReportedObject {
    public final Class<?> reporter;
    public final Long sequenceNumber;

    public ReportedObject(Class<?> reporter, Long sequenceNumber) {
        this.reporter = reporter;
        this.sequenceNumber = sequenceNumber;
    }
}
