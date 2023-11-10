package regulators.java.parser;

import base.drivers.parsing.ExecutionReport;
import base.drivers.parsing.ReportingService;
import base.expressions.Expression;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import regulators.java.parser.parsedObjects.JavaFile;
import regulators.java.parser.parsedObjects.types.CLass;
import regulators.java.parser.parsedObjects.types.ENum;
import regulators.java.parser.parsedObjects.types.INterface;
import regulators.java.parser.validation.validators.structureValidators.associations.ImportValidator;
import regulators.java.parser.validation.validators.wordValidators.qualifiers.OnePublicTypeInFileValidator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JavaParserTest_File {
    DummyService reportingService;
    JavaParser parser;

    @BeforeEach
    void initialize(){
        reportingService = new DummyService();
        parser = new JavaParser(reportingService);
    }


    @Test
    void empty() {
        String empty = "";
        JavaFile f1 = parser.parse(empty);

        assertNull(reportingService.report.thrownException);
        assertEquals(0, reportingService.report.invalidations.size());
    }

    @Test
    void validFile() {
        String file1 = "package pkg;\nimport p1.p2.c1;\nimport p3.p4.c2;\npublic class cls{\n\t}\ninterface inter{\n\t}\nenum en{\n\t;}";
        JavaFile javaFile1 = parser.parse(file1);

        assertNull(reportingService.report.thrownException);
        assertEquals(0, reportingService.report.invalidations.size());

        assertEquals("package pkg;", javaFile1.getPkg());
        assertEquals(2, javaFile1.getImports().size());
        assertEquals(3, javaFile1.getTypeDefinitions().size());

        Expression tree = reportingService.report.expressionTree;
        assertEquals("package pkg;", javaFile1.getPkg());
        assertIterableEquals(List.of("import p1.p2.c1;", "import p3.p4.c2;"), javaFile1.getImports());

        assertTrue(javaFile1.getTypeDefinitions().get(0) instanceof CLass);
        assertTrue(javaFile1.getTypeDefinitions().get(1) instanceof INterface);
        assertTrue(javaFile1.getTypeDefinitions().get(2) instanceof  ENum);
    }

    @Test
    void invalidFile() {
        String file1 = "package pkg; impor p1.c1;\nimport t**\n;\nimport p2.p3.c3 class cls{}\n public class cls1{} ;;; public interface i{}";
        JavaFile javaFile1 = parser.parse(file1);

        assertEquals("package pkg;", javaFile1.getPkg());
        assertIterableEquals(List.of("impor p1.c1;", "import t**\n;"), javaFile1.getImports());
        assertEquals(3, javaFile1.getTypeDefinitions().size());

        assertTrue(reportingService.report.invalidations.stream().anyMatch(invalidation -> invalidation.validator.equals(ImportValidator.class)));
        assertTrue(reportingService.report.invalidations.stream().anyMatch(invalidation -> invalidation.validator.equals(OnePublicTypeInFileValidator.class)));
    }

    static class DummyService implements ReportingService{
        public ExecutionReport report;
        @Override
        public void addExecutionReport(ExecutionReport report) {
            this.report = report;
        }
    }
}