package regulators.java.parser.parsedObjects.members;

import regulators.java.parser.parsedObjects.attributes.TypeSelector;

import java.util.ArrayList;

public class FIeld extends ClassMember {
    private ArrayList<String> qualifiers;
    private TypeSelector type;
    private String identifier;
    private String initializer;
}
