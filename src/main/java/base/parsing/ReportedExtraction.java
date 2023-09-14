package base.parsing;

import base.auditing.ReportedObject;

public class ReportedExtraction extends ReportedObject {
    public final String origin;
    public final String normalized;
    public final String extracted;


    public ReportedExtraction(Class<? extends ExpressionExtractor> reporter,
                              String origin,
                              String normalized,
                              String extracted) {
        super(reporter);
        this.origin = origin;
        this.normalized = normalized;
        this.extracted = extracted;
    }
}
