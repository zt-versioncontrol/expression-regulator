package regulators.java.parser;

public class SampleExpressions {

    public static final String EXPRESSION_1 = """
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

                
                void initialize(){
                    reportingService = new DummyService();
                    parser = new JavaParser(reportingService);
                }

                
                void clss() {
                    String file1 = "";


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

                
                void interfac() {
                    String file1 = "";

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

                
                void enm() {
                    String file1 = "";

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

                    String file2 = "";

                    enm = (ENum) parser.parse(file2).getTypeDefinitions().get(0);
                    assertIterableEquals(List.of("A", "B  C"), enm.getConstantIdentifiers());
                }

               
                void invalidClass() {
                    String file1 = "";
                    String file2 = "";
                    String file3 = "";
                    String file4 = "";

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

                
                void invalidInterface() {
                    String file1 = "";
                    String file2 = "";
                    String file3 = "";
                    String file4 = "";

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

                
                void invalidEnum() {
                    String file1 = "";
                    String file2 = "";
                    String file3 = "";
                    String file4 = "";

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
                    public void addExecutionReport(ExecutionReport report) {
                        this.report = report;
                    }
                }
            }""";

    public static final String EXPRESSION_2 = """
            package utility.string;

            import utility.structure.Pair;

            import java.util.ArrayList;
            import java.util.Comparator;
            import java.util.List;

            public class ParsingUtilities {
         

                
                public static Pair<Integer, Integer> firstScopeBoundaries(String expression, String leftIndicator, String rightIndicator){
                    int firstScopeStart = expression.indexOf(leftIndicator);
                    if (firstScopeStart == -1) return new Pair<>(-1, -1);

                    int nextLeftIndex = expression.indexOf(leftIndicator, firstScopeStart + leftIndicator.length());
                    int nextRightIndex = expression.indexOf(rightIndicator);
                    int depth = 1;
                    while (nextRightIndex >= 0) {
                        if (firstScopeStart > nextRightIndex){
                            nextRightIndex = expression.indexOf(rightIndicator, nextRightIndex + rightIndicator.length());
                        } else if (nextLeftIndex > nextRightIndex || nextLeftIndex == -1) {
                            if (depth == 1) {
                                return new Pair<>(firstScopeStart, nextRightIndex + rightIndicator.length() - 1);
                            }
                            nextRightIndex = expression.indexOf(rightIndicator, nextRightIndex + rightIndicator.length());
                            depth--;
                        } else {
                            depth++;
                            nextLeftIndex = expression.indexOf(leftIndicator, nextLeftIndex + leftIndicator.length());
                        }
                    }

                    return new Pair<>(firstScopeStart, -1);
                }

                
                public static List<Pair<Integer, Integer>> scopeBoundaries(String expression, String startIndicator, String endIndicator){
                    List<Pair<Integer, Integer>> scopeBoundaries = new ArrayList<>();
                    Pair<Integer, Integer> nextScopeBoundaries = firstScopeBoundaries(expression, startIndicator, endIndicator);
                    int offset = 0;
                    while (nextScopeBoundaries.first != -1){
                        scopeBoundaries.add(
                                new Pair<>(nextScopeBoundaries.first + offset,
                                        nextScopeBoundaries.second == -1? -1 : nextScopeBoundaries.second + offset)
                        );

                        if (nextScopeBoundaries.second != -1) {
                            expression = expression.substring(nextScopeBoundaries.second + 1);
                            offset += nextScopeBoundaries.second + 1;
                            nextScopeBoundaries = firstScopeBoundaries(expression, startIndicator, endIndicator);
                        }else {
                            break;
                        }
                    }

                    return scopeBoundaries;
                }


                public static List<Pair<Integer, Integer>> noneIntersectedScopeBoundaries(String expression,
                                                                                          List<Pair<String, String>> scopeIndicators,
                                                                                          List<String> symmetricScopeIndicators)
                {
                    List<Pair<Integer, Integer>> independentScopes = new ArrayList<>();
                    List<Pair<Integer, Integer>> nonIntersectedScopes = new ArrayList<>();

                    for (Pair<String, String> scopeIndicator : scopeIndicators) {
                        independentScopes.addAll(scopeBoundaries(expression, scopeIndicator.first, scopeIndicator.second));
                    }
                    for (String symmetricScopeIndicator : symmetricScopeIndicators) {
                        independentScopes.addAll(symmetricScopeBoundaries(expression, symmetricScopeIndicator));
                    }

                    independentScopes.sort(Comparator.comparingInt(scope -> scope.first));
                    for (int i = 0; i < independentScopes.size(); i++) {
                        Pair<Integer, Integer> scopeInCheck = independentScopes.get(i);
                        
                        nonIntersectedScopes.add(scopeInCheck);

                        
                        if ((scopeInCheck.second == -1) || (i == independentScopes.size()-1)) return nonIntersectedScopes;
                        
                        if (scopeInCheck.second <  independentScopes.get(i+1).first) continue;

                        
                        Integer offset = scopeInCheck.second+1;
                        List<Pair<Integer, Integer>> remainingScopes = noneIntersectedScopeBoundaries(expression.substring(offset), scopeIndicators, symmetricScopeIndicators);
                        
                        for (Pair<Integer, Integer> remainingScope : remainingScopes) {
                            nonIntersectedScopes.add(new Pair<>(remainingScope.first+offset, remainingScope.second==-1? -1 : remainingScope.second+offset));
                        }
                        return nonIntersectedScopes;
                    }
                    return nonIntersectedScopes;
                }



                public static List<Pair<Integer, Integer>> symmetricScopeBoundaries(String expression, String indicator){
                    List<Integer> indicatorIndices = SearchingUtilities.indicesOf(expression, indicator);
                    List<Pair<Integer, Integer>> boundaries = new ArrayList<>();

                    for (int i = 0; i < indicatorIndices.size(); i+=2) {
                        int start = indicatorIndices.get(i);
                        int end = indicatorIndices.size() > (i+1)? indicatorIndices.get(i+1) + (indicator.length()-1) : -1;
                        boundaries.add(new Pair<>(start, end));
                    }

                    return boundaries;
                }

                
                public static List<String> indexSplit(String string, List<Integer> indices){
                    if (indices.isEmpty()) return List.of(string);

                    List<String> splits = new ArrayList<>();

                    List<Integer> sortedIndices = new ArrayList<>(indices);
                    sortedIndices.sort(Integer::compare);

                    int start = 0;

                    for (int i = 0; i < sortedIndices.size(); i++) {
                        splits.add(string.substring(start, sortedIndices.get(i)));
                        if (sortedIndices.size()-1>i && sortedIndices.get(i).equals(sortedIndices.get(i+1))){
                            start = sortedIndices.get(i);
                        }else start = sortedIndices.get(i) + 1;
                    }

                    splits.add(string.substring(start));

                    return splits;
                }
            }
            """;
}
