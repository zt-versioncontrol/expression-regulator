package base.auditing;

public class Report {
    public final Class<? extends Auditor> auditorClass;
    public final ReportedObject reportedObject;
    public final String description;
    public final String warnings;

    public Report(Class<? extends Auditor> auditorClass, ReportedObject reportedObject, String description, String warnings) {
        this.auditorClass = auditorClass;
        this.reportedObject = reportedObject;
        this.description = description;
        this.warnings = warnings;
    }
}
