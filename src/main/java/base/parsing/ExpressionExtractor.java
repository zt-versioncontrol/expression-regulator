package base.parsing;

import base.auditing.AuditingService;

public abstract class ExpressionExtractor {
    private final ExpressionNormalizer normalizer;
    private AuditingService auditingService;


    protected ExpressionExtractor() {
        this.normalizer = getNormalizer();
    }

    public String extractFromExpression(String expression){
        String normalized = normalizer.normalize(expression);
        String extracted = extract(normalized);

        auditingService.report(new ReportedExtraction(this.getClass(), expression, normalized, extracted));

        return extracted;
    }

    public void setAuditingService(AuditingService auditingService) {
        this.auditingService = auditingService;
    }

    protected abstract String extract(String expression);
    protected abstract ExpressionNormalizer getNormalizer();
}
