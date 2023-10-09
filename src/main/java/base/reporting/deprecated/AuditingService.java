package base.reporting.deprecated;

import java.util.ArrayList;
import java.util.List;

@Deprecated
public class AuditingService{
    private final List<ReportedObject> reportedObjects = new ArrayList<>();

    public void report(ReportedObject reportedObject){
        reportedObjects.add(reportedObject);
    }
}
