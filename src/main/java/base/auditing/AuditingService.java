package base.auditing;

import java.util.ArrayList;
import java.util.List;

public class AuditingService{
    private final List<ReportedObject> reportedObjects = new ArrayList<>();

    public void report(ReportedObject reportedObject){
        reportedObjects.add(reportedObject);
    }
}
