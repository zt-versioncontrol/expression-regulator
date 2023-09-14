package base.parsing;

import base.auditing.ReportedObject;

public class ReportedArrayExtraction extends ReportedObject {
    public final String origin;
    public final String normalized;
    public final Iterable<String> extracted;


    public ReportedArrayExtraction(Class<? extends ExpressionArrayExtractor> reporter,
                                   String origin,
                                   String normalized,
                                   Iterable<String> extracted) {
        super(reporter);
        this.origin = origin;
        this.normalized = normalized;
        this.extracted = extracted;
    }
}
