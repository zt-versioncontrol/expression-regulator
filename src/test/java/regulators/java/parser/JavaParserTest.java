package regulators.java.parser;

import base.drivers.parsing.ExecutionReport;
import base.drivers.parsing.ReportingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import regulators.java.parser.validation.validators.structureValidators.associations.ImportValidator;
import regulators.java.parser.validation.validators.wordValidators.qualifiers.members.MethodQualifiersValidator;
import regulators.java.parser.validation.validators.wordValidators.qualifiers.types.FileClassQualifiersValidator;

import static org.junit.jupiter.api.Assertions.*;

class JavaParserTest {
    JavaParserTest_Types.DummyService reportingService;
    JavaParser parser;

    @BeforeEach
    void initialize(){
        reportingService = new JavaParserTest_Types.DummyService();
        parser = new JavaParser(reportingService);
    }

    @Test
    void validExpression() {
        parser.parse(SampleExpressions.EXPRESSION_1);
        assertNull(reportingService.report.thrownException);
        assertEquals(0, reportingService.report.invalidations.size());

        parser.parse(SampleExpressions.EXPRESSION_2);
        assertNull(reportingService.report.thrownException);
        assertEquals(0, reportingService.report.invalidations.size());
    }

    @Test
    void invalidExpression() {
        parser.parse(SampleInvalidExpressions.EXPRESSION_1);
        assertNull(reportingService.report.thrownException);

        assertTrue(reportingService.report.invalidations.stream().anyMatch(invalidation -> {
            return invalidation.validator.equals(ImportValidator.class) &&
                    invalidation.invalidExpression.getExpressionString().equals("imprt static org.junit.jupiter.api.Assertions.*;");
        }));

        assertTrue(reportingService.report.invalidations.stream().anyMatch(invalidation -> {
            return invalidation.validator.equals(FileClassQualifiersValidator.class) &&
                    invalidation.invalidExpression.getOriginalExpression().getExpressionString().startsWith("private class JavaParserTest_Types");
        }));

        assertTrue(reportingService.report.invalidations.stream().anyMatch(invalidation -> {
            return invalidation.validator.equals(MethodQualifiersValidator.class) &&
                    invalidation.invalidExpression.getExpressionString().startsWith("void int clss()");
        }));

        assertTrue(reportingService.report.invalidations.stream().anyMatch(invalidation -> {
            return invalidation.validator.equals(MethodQualifiersValidator.class) &&
                    invalidation.invalidExpression.getExpressionString().startsWith("public abstract void addExecutionReport");
        }));
    }

    static class DummyService implements ReportingService {
        public ExecutionReport report;
        @Override
        public void addExecutionReport(ExecutionReport report) {
            this.report = report;
        }
    }
}