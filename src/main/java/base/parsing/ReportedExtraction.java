package base.parsing;

import base.auditing.ReportedObject;

public class ReportedExtraction extends ReportedObject {
    public final String origin;
    public final String extracted;


    public ReportedExtraction(Class<? extends ExpressionExtractor> reporter, Long sequenceNumber, String origin, String extracted) {
        super(reporter, sequenceNumber);
        this.origin = origin;
        this.extracted = extracted;
    }
}
