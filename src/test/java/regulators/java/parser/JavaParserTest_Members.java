package regulators.java.parser;

import base.drivers.parsing.ExecutionReport;
import base.drivers.parsing.ReportingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import regulators.java.parser.parsedObjects.members.FIeld;
import regulators.java.parser.parsedObjects.members.MEthod;
import regulators.java.parser.parsedObjects.types.CLass;
import regulators.java.parser.validation.validators.structureValidators.logic.StatementValidator;
import regulators.java.parser.validation.validators.structureValidators.members.AbstractMethodValidator;
import regulators.java.parser.validation.validators.structureValidators.members.MethodValidator;
import regulators.java.parser.validation.validators.wordValidators.identifiers.IdentifierIsNotKeyWordValidator;
import regulators.java.parser.validation.validators.wordValidators.identifiers.IdentifierValidator;
import regulators.java.parser.validation.validators.wordValidators.qualifiers.UniqueQualifiersValidator;
import regulators.java.parser.validation.validators.wordValidators.qualifiers.members.MethodQualifiersValidator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JavaParserTest_Members {

    JavaParserTest_Types.DummyService reportingService;
    JavaParser parser;

    @BeforeEach
    void initialize(){
        reportingService = new JavaParserTest_Types.DummyService();
        parser = new JavaParser(reportingService);
    }


    @Test
    void method() {
        String file1 = "class cls{ public static<T,R> List<Boolean> meth(int k, Map<String, Queue<Double>> mp){s1;s2;s3;;;}}";
        MEthod method = (MEthod) ((CLass) parser.parse(file1).getTypeDefinitions().get(0)).getMembers().get(0);

        assertEquals(0, reportingService.report.invalidations.size());
        assertEquals("meth", method.getIdentifier());
        assertIterableEquals(List.of("public", "static"), method.getQualifiers());
        assertEquals("List", method.getType().getType());
        assertEquals(1, method.getType().getGenericTypesSelectors().size());
        assertEquals("Boolean", method.getType().getGenericTypesSelectors().get(0).getType());


        assertEquals(2, method.getGenerics().getGenericTypes().size());
        assertEquals("T", method.getGenerics().getGenericTypes().get(0).getIdentifier());
        assertEquals("R", method.getGenerics().getGenericTypes().get(1).getIdentifier());

        assertEquals(2, method.getParameters().size());
        assertEquals("k", method.getParameters().get(0).getIdentifier());
        assertEquals("int", method.getParameters().get(0).getType().getType());
        assertEquals("mp", method.getParameters().get(1).getIdentifier());
        assertEquals("Map", method.getParameters().get(1).getType().getType());
        assertEquals("String", method.getParameters().get(1).getType().getGenericTypesSelectors().get(0).getType());
        assertEquals("Queue", method.getParameters().get(1).getType().getGenericTypesSelectors().get(1).getType());
        assertEquals("Double", method.getParameters().get(1).getType().getGenericTypesSelectors().get(1).getGenericTypesSelectors().get(0).getType());

        assertEquals(5, method.getStatements().size());
        assertEquals("s1;", method.getStatements().get(0).getStatement());
        assertEquals("s2;", method.getStatements().get(1).getStatement());
        assertEquals("s3;", method.getStatements().get(2).getStatement());
        assertEquals(";", method.getStatements().get(3).getStatement());
        assertEquals(";", method.getStatements().get(4).getStatement());
    }

    @Test
    void invalidMethod() {
        String file1 = "class cls{public static static abstract <String> int 1meth(){abc}}";
        String file2 = "class cls{ ()(){}}";
        String file3 = "class cls{ void meth()}";

        parser.parse(file1);
        assertTrue(reportingService.report.invalidations.stream().anyMatch(invalidation -> invalidation.validator.equals(UniqueQualifiersValidator.class)));
        assertTrue(reportingService.report.invalidations.stream().anyMatch(invalidation -> invalidation.validator.equals(MethodQualifiersValidator.class)));
        assertTrue(reportingService.report.invalidations.stream().anyMatch(invalidation -> invalidation.validator.equals(IdentifierValidator.class)));
        assertTrue(reportingService.report.invalidations.stream().anyMatch(invalidation -> invalidation.validator.equals(StatementValidator.class)));

        parser.parse(file2);
        assertTrue(reportingService.report.invalidations.stream().anyMatch(invalidation -> invalidation.validator.equals(MethodValidator.class)));

        parser.parse(file3);
        assertTrue(reportingService.report.invalidations.stream().anyMatch(invalidation -> invalidation.validator.equals(AbstractMethodValidator.class)));
    }

    @Test
    void field() {
        String file1 = "class cls{public final Map<Integer, String> fi = new Map<>();}";

        FIeld field = (FIeld) ((CLass) parser.parse(file1).getTypeDefinitions().get(0)).getMembers().get(0);

        assertEquals(0, reportingService.report.invalidations.size());
        assertEquals("fi", field.getIdentifier());
        assertIterableEquals(List.of("public", "final"), field.getQualifiers());
        assertEquals("Map", field.getType().getType());
        assertEquals(2, field.getType().getGenericTypesSelectors().size());
        assertEquals("Integer", field.getType().getGenericTypesSelectors().get(0).getType());
        assertEquals("String", field.getType().getGenericTypesSelectors().get(1).getType());
        assertEquals("new Map<>();", field.getInitializer());
    }

    @Test
    void invalidField() {
        String file1 = "class cls{public protected static fi;}";
        String file2 = "class cls{ static static String fi;}";

        parser.parse(file1);
        assertTrue(reportingService.report.invalidations.stream().anyMatch(invalidation -> invalidation.validator.equals(UniqueQualifiersValidator.class)));
        assertTrue(reportingService.report.invalidations.stream().anyMatch(invalidation -> invalidation.validator.equals(IdentifierIsNotKeyWordValidator.class)));

        parser.parse(file2);
        assertTrue(reportingService.report.invalidations.stream().anyMatch(invalidation -> invalidation.validator.equals(UniqueQualifiersValidator.class)));
    }

    static class DummyService implements ReportingService {
        public ExecutionReport report;
        @Override
        public void addExecutionReport(ExecutionReport report) {
            this.report = report;
        }
    }
}