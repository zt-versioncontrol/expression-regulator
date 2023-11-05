package regulators.java.parser.validation.selectors.simple;

import base.expressions.validation.selectors.simple.ByExtractor;
import regulators.java.parser.extractors.associations.ExtendedInterfacesExtractor;
import regulators.java.parser.extractors.associations.SuperClassExtractor;
import regulators.java.parser.extractors.logic.FieldInitializerExtractor;
import regulators.java.parser.extractors.logic.StatementsExtractor;
import regulators.java.parser.extractors.members.ImportsExtractor;
import regulators.java.parser.extractors.members.PackageExtractor;

public class ByExtractorSelectors {
    public static class ExtendedInterfacesSelector extends ByExtractor {
        protected ExtendedInterfacesSelector() {
            super(ExtendedInterfacesExtractor.class);
        }
    }

    public static class FieldInitializerSelector extends ByExtractor {
        protected FieldInitializerSelector() {
            super(FieldInitializerExtractor.class);
        }
    }

    public static class ImportSelector extends ByExtractor {
        protected ImportSelector() {
            super(ImportsExtractor.class);
        }
    }

    public static class PackageSelector extends ByExtractor {
        protected PackageSelector() {
            super(PackageExtractor.class);
        }
    }

    public static class StatementSelector extends ByExtractor {
        protected StatementSelector() {
            super(StatementsExtractor.class);
        }
    }

    public static class SuperCLassSelector extends ByExtractor {

        protected SuperCLassSelector() {
            super(SuperClassExtractor.class);
        }
    }
}
