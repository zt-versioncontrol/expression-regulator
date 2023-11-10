package regulators.java.parser;

import base.drivers.parsing.ExecutionReport;
import base.drivers.parsing.ReportingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import regulators.java.parser.parsedObjects.members.*;
import regulators.java.parser.parsedObjects.types.CLass;
import regulators.java.parser.parsedObjects.types.ENum;
import regulators.java.parser.parsedObjects.types.INterface;
import regulators.java.parser.validation.validators.InvalidTypeValidator;
import regulators.java.parser.validation.validators.structureValidators.associations.ImplementedInterfacesValidator;
import regulators.java.parser.validation.validators.structureValidators.members.GenericsValidator;
import regulators.java.parser.validation.validators.structureValidators.members.TypeMemberValidator;
import regulators.java.parser.validation.validators.structureValidators.types.ClassValidator;
import regulators.java.parser.validation.validators.structureValidators.types.EnumValidator;
import regulators.java.parser.validation.validators.structureValidators.types.InterfaceValidator;
import regulators.java.parser.validation.validators.wordValidators.identifiers.IdentifierValidator;
import regulators.java.parser.validation.validators.wordValidators.qualifiers.UniqueQualifiersValidator;
import regulators.java.parser.validation.validators.wordValidators.qualifiers.members.InterfaceMemberQualifiersValidator;
import regulators.java.parser.validation.validators.wordValidators.qualifiers.types.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JavaParserTest_Types {
    DummyService reportingService;
    JavaParser parser;

    @BeforeEach
    void initialize(){
        reportingService = new DummyService();
        parser = new JavaParser(reportingService);
    }

    @Test
    void clss() {
        String file1 = """
                public abstract class cls<T, R extends Q> extends List<String> implements Comparable<Integer>, Map<Double, Boolean> {
                \tint i;
                \tvoid meth(){};
                \tabstract void meth();
                \tclass nes{};;;
                }""";


        CLass clss = (CLass) parser.parse(file1).getTypeDefinitions().get(0);
        assertEquals(0, reportingService.report.invalidations.size());
        assertEquals("cls", clss.getIdentifier());
        assertIterableEquals(List.of("public", "abstract"), clss.getQualifiers());
        assertEquals("T", clss.getGenerics().getGenericTypes().get(0).getIdentifier());
        assertNull(clss.getGenerics().getGenericTypes().get(0).getTypeBound());
        assertEquals(2, clss.getGenerics().getGenericTypes().size());
        assertEquals("R", clss.getGenerics().getGenericTypes().get(1).getIdentifier());
        assertEquals("Q", clss.getGenerics().getGenericTypes().get(1).getTypeBound().getType());
        assertEquals("List", clss.getSuperCLass().getSelector().getType());
        assertEquals("String", clss.getSuperCLass().getSelector().getGenericTypesSelectors().get(0).getType());
        assertEquals("Comparable", clss.getImplementedInterfaces().getInterfaceSelectors().get(0).getType());
        assertEquals("Integer", clss.getImplementedInterfaces().getInterfaceSelectors().get(0).getGenericTypesSelectors().get(0).getType());
        assertEquals("Map", clss.getImplementedInterfaces().getInterfaceSelectors().get(1).getType());
        assertEquals("Double", clss.getImplementedInterfaces().getInterfaceSelectors().get(1).getGenericTypesSelectors().get(0).getType());
        assertEquals("Boolean", clss.getImplementedInterfaces().getInterfaceSelectors().get(1).getGenericTypesSelectors().get(1).getType());

        assertEquals(8, clss.getMembers().size());
        assertTrue(clss.getMembers().get(0) instanceof FIeld);
        assertTrue(clss.getMembers().get(1) instanceof MEthod);
        assertTrue(clss.getMembers().get(2) instanceof EmptyMember);
        assertTrue(clss.getMembers().get(3) instanceof AbstractMethod);
        assertTrue(clss.getMembers().get(4) instanceof CLass);
        assertTrue(clss.getMembers().get(5) instanceof EmptyMember);
        assertTrue(clss.getMembers().get(6) instanceof EmptyMember);
        assertTrue(clss.getMembers().get(7) instanceof EmptyMember);
    }

    @Test
    void interfac() {
        String file1 = """
                public interface inter<T, R> extends i1<Integer>, i2<Double, Boolean> {
                \tint i;
                \tvoid meth();
                \tclass nes{};;;
                }""";

        INterface interfac = (INterface) parser.parse(file1).getTypeDefinitions().get(0);

        assertEquals(0, reportingService.report.invalidations.size());
        assertEquals("inter", interfac.getIdentifier());
        assertIterableEquals(List.of("public"), interfac.getQualifiers());
        assertEquals(2, interfac.getGenerics().getGenericTypes().size());
        assertEquals("T", interfac.getGenerics().getGenericTypes().get(0).getIdentifier());
        assertEquals("R", interfac.getGenerics().getGenericTypes().get(1).getIdentifier());
        assertEquals(2, interfac.getExtendedInterfaces().getInterfaceSelectors().size());
        assertEquals("i1", interfac.getExtendedInterfaces().getInterfaceSelectors().get(0).getType());
        assertEquals("Integer", interfac.getExtendedInterfaces().getInterfaceSelectors().get(0).getGenericTypesSelectors().get(0).getType());
        assertEquals("i2", interfac.getExtendedInterfaces().getInterfaceSelectors().get(1).getType());
        assertEquals("Double", interfac.getExtendedInterfaces().getInterfaceSelectors().get(1).getGenericTypesSelectors().get(0).getType());
        assertEquals("Boolean", interfac.getExtendedInterfaces().getInterfaceSelectors().get(1).getGenericTypesSelectors().get(1).getType());

        assertEquals(6, interfac.getMembers().size());
        assertTrue(interfac.getMembers().get(0) instanceof FIeld);
        assertTrue(interfac.getMembers().get(1) instanceof AbstractMethod);
        assertTrue(interfac.getMembers().get(2) instanceof CLass);
        assertTrue(interfac.getMembers().get(3) instanceof EmptyMember);
        assertTrue(interfac.getMembers().get(4) instanceof EmptyMember);
        assertTrue(interfac.getMembers().get(5) instanceof EmptyMember);
    }

    @Test
    void enm() {
        String file1 = """
                public enum en implements List{
                \tA,B,C;
                \tvoid fun(){};
                \tenum en{}
                }
                """;

        ENum enm = (ENum) parser.parse(file1).getTypeDefinitions().get(0);

        assertEquals(0, reportingService.report.invalidations.size());
        assertEquals("en", enm.getIdentifier());
        assertIterableEquals(List.of("public"), enm.getQualifiers());
        assertEquals("List", enm.getImplementedInterfaces().getInterfaceSelectors().get(0).getType());
        assertIterableEquals(List.of("A", "B", "C"), enm.getConstantIdentifiers());

        assertEquals(3, enm.getMembers().size());
        assertTrue(enm.getMembers().get(0) instanceof MEthod);
        assertTrue(enm.getMembers().get(1) instanceof EmptyMember);
        assertTrue(enm.getMembers().get(2) instanceof ENum);

        String file2 = """
                public enum en{
                \tA,   B  C
                }
                """;

        enm = (ENum) parser.parse(file2).getTypeDefinitions().get(0);
        assertIterableEquals(List.of("A", "B  C"), enm.getConstantIdentifiers());
    }

    @Test
    void invalidClass() {
        String file1 = "clss {}";
        String file2 = "public class cls{";
        String file3 = "public public static class cls g extends class{ q1 class nes{} int i}";
        String file4 = "public protected class {}";

        parser.parse(file1);
        assertTrue(reportingService.report.invalidations.stream().anyMatch(invalidation -> invalidation.validator.equals(InvalidTypeValidator.class)));

        parser.parse(file2);
        assertTrue(reportingService.report.invalidations.stream().anyMatch(invalidation -> invalidation.validator.equals(ClassValidator.class)));

        parser.parse(file3);
        assertTrue(reportingService.report.invalidations.stream().anyMatch(invalidation -> invalidation.validator.equals(FileClassQualifiersValidator.class)));
        assertTrue(reportingService.report.invalidations.stream().anyMatch(invalidation -> invalidation.validator.equals(UniqueQualifiersValidator.class)));
        assertTrue(reportingService.report.invalidations.stream().anyMatch(invalidation -> invalidation.validator.equals(GenericsValidator.class)));
        assertTrue(reportingService.report.invalidations.stream().anyMatch(invalidation -> invalidation.validator.equals(IdentifierValidator.class)));
        assertTrue(reportingService.report.invalidations.stream().anyMatch(invalidation -> invalidation.validator.equals(NestedClassQualifiersValidator.class)));
        assertTrue(reportingService.report.invalidations.stream().anyMatch(invalidation -> invalidation.validator.equals(TypeMemberValidator.class)));

        parser.parse(file4);
        assertTrue(reportingService.report.invalidations.stream().anyMatch(invalidation -> invalidation.validator.equals(IdentifierValidator.class)));
        assertTrue(reportingService.report.invalidations.stream().anyMatch(invalidation -> invalidation.validator.equals(UniqueQualifiersValidator.class)));
    }

    @Test
    void invalidInterface() {
        String file1 = "interfac {}";
        String file2 = "public interface cls{";
        String file3 = "public public static interface inter g extends { q1 private interface nes{} int i}";
        String file4 = "public private interface {}";

        parser.parse(file1);
        assertTrue(reportingService.report.invalidations.stream().anyMatch(invalidation -> invalidation.validator.equals(InvalidTypeValidator.class)));

        parser.parse(file2);
        assertTrue(reportingService.report.invalidations.stream().anyMatch(invalidation -> invalidation.validator.equals(InterfaceValidator.class)));

        parser.parse(file3);
        assertTrue(reportingService.report.invalidations.stream().anyMatch(invalidation -> invalidation.validator.equals(FileInterfaceQualifiersValidators.class)));
        assertTrue(reportingService.report.invalidations.stream().anyMatch(invalidation -> invalidation.validator.equals(GenericsValidator.class)));
        assertTrue(reportingService.report.invalidations.stream().anyMatch(invalidation -> invalidation.validator.equals(UniqueQualifiersValidator.class)));
        assertTrue(reportingService.report.invalidations.stream().anyMatch(invalidation -> invalidation.validator.equals(InterfaceMemberQualifiersValidator.class)));
        assertTrue(reportingService.report.invalidations.stream().anyMatch(invalidation -> invalidation.validator.equals(NestedInterfaceQualifiersValidator.class)));
        assertTrue(reportingService.report.invalidations.stream().anyMatch(invalidation -> invalidation.validator.equals(TypeMemberValidator.class)));

        parser.parse(file4);
        assertTrue(reportingService.report.invalidations.stream().anyMatch(invalidation -> invalidation.validator.equals(IdentifierValidator.class)));
        assertTrue(reportingService.report.invalidations.stream().anyMatch(invalidation -> invalidation.validator.equals(UniqueQualifiersValidator.class)));
    }

    @Test
    void invalidEnum() {
        String file1 = "enu {}";
        String file2 = "public enum cls{";
        String file3 = "public static static enum en abc efg {private int k;q1 enum nes{} int i}";
        String file4 = "public private interface {}";

        parser.parse(file1);
        assertTrue(reportingService.report.invalidations.stream().anyMatch(invalidation -> invalidation.validator.equals(InvalidTypeValidator.class)));

        parser.parse(file2);
        assertTrue(reportingService.report.invalidations.stream().anyMatch(invalidation -> invalidation.validator.equals(EnumValidator.class)));

        parser.parse(file3);
        assertTrue(reportingService.report.invalidations.stream().anyMatch(invalidation -> invalidation.validator.equals(FileEnumQualifiersValidator.class)));
        assertTrue(reportingService.report.invalidations.stream().anyMatch(invalidation -> invalidation.validator.equals(UniqueQualifiersValidator.class)));
        assertTrue(reportingService.report.invalidations.stream().anyMatch(invalidation -> invalidation.validator.equals(ImplementedInterfacesValidator.class)));
        assertTrue(reportingService.report.invalidations.stream().anyMatch(invalidation -> {
            return invalidation.validator.equals(IdentifierValidator.class) && invalidation.invalidExpression.getExpressionString().equals("private int k");
        }));
        assertTrue(reportingService.report.invalidations.stream().anyMatch(invalidation -> invalidation.validator.equals(NestedEnumQualifiersValidator.class)));
        assertTrue(reportingService.report.invalidations.stream().anyMatch(invalidation -> invalidation.validator.equals(TypeMemberValidator.class)));

        parser.parse(file4);
        assertTrue(reportingService.report.invalidations.stream().anyMatch(invalidation -> invalidation.validator.equals(IdentifierValidator.class)));
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