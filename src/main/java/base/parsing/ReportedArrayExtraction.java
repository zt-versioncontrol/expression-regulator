package base.parsing;

import base.auditing.ReportedObject;

public class ReportedArrayExtraction extends ReportedObject {
    public final String origin;
    public final Iterable<String> extracted;


    public ReportedArrayExtraction(Class<? extends ExpressionArrayExtractor> reporter, Long sequenceNumber, String origin, Iterable<String> extracted) {
        super(reporter, sequenceNumber);
        this.origin = origin;
        this.extracted = extracted;
    }
}
