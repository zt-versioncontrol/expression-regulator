package base.reporting.deprecated;

import java.util.List;

@Deprecated
public interface Auditor {
    //an instance of auditor is meant to be created somewhere and then filterReportedObjects is called
    // to obtain reported objects which will be passed to buildReports to obtain reports
    List<ReportedObject> filterReportedObjects(List<ReportedObject> reportedObjects);
    List<Report> BuildReports(List<ReportedObject> filteredReportedObjects);
}
