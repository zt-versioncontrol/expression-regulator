package base.parsing;

import base.auditing.AuditingService;

import java.util.List;

public abstract class ExpressionArrayExtractor {
    private final ExpressionNormalizer normalizer;
    private AuditingService auditingService;

    public ExpressionArrayExtractor() {
        normalizer = getNormalizer();
    }

    public List<String> extractArrayFromExpression(String expression){
        String normalized = normalizer.normalize(expression);
        List<String> extracted = extract(expression);

        auditingService.report(new ReportedArrayExtraction(this.getClass(), expression, normalized, extracted));

        return extracted;
    }

    public void setAuditingService(AuditingService auditingService) {
        this.auditingService = auditingService;
    }

    protected abstract List<String> extract(String expression);
    protected abstract ExpressionNormalizer getNormalizer();
}
