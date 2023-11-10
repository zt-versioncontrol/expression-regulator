package regulators.java.parser;

import base.components.expression.ExpressionComponent;
import base.components.expression.ExpressionComponentsInitializer;
import base.drivers.parsing.ParsingDriver;
import base.drivers.parsing.ReportingService;
import regulators.java.parser.parsedObjects.JavaFile;

import java.util.HashSet;
import java.util.Set;

public class JavaParser extends ParsingDriver<JavaFile> {

    public JavaParser() {
        super(new ComponentsInitializer());
    }

    public JavaParser(ReportingService reportingService) {
        super(new ComponentsInitializer(), reportingService);
    }

    public JavaFile parse(String expression){
        JavaFile javaFile = new JavaFile();
        execute(javaFile, expression);

        return javaFile;
    }

    private static class ComponentsInitializer implements ExpressionComponentsInitializer {

        @Override
        public Set<ExpressionComponent> initialize() {
            Set<ExpressionComponent> components = new HashSet<>();

            components.addAll(new regulators.java.parser.extractors._Initializer().initialize());
            components.addAll(new regulators.java.parser.providers._Initializer().initialize());
            components.addAll(new regulators.java.parser.validation.selectors._Initializer().initialize());
            components.addAll(new regulators.java.parser.validation.validators._Initializer().initialize());

            return components;
        }
    }
}
