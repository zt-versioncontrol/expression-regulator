package regulators.json.extractor.parsedObjects;

import base.parsing.AbstractType;
import base.parsing.StringDerivedArray;
import regulators.json.extractor.extractors.StatementsExtractor;
import regulators.json.extractor.providers.StatementProvider;

import java.util.ArrayList;

public class Script {
    @AbstractType
    @StringDerivedArray(extractor = StatementsExtractor.class, provider = StatementProvider.class)
    private ArrayList<Statement> statements;

}
