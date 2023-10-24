package regulators.java.parser.parsedObjects.types;

import regulators.java.parser.parsedObjects.attributes.GenericType;
import regulators.java.parser.parsedObjects.attributes.TypeSelector;
import regulators.java.parser.parsedObjects.members.AbstractMethod;
import regulators.java.parser.parsedObjects.members.FIeld;
import regulators.java.parser.parsedObjects.members.MEthod;

import java.util.ArrayList;

public class INterface extends TypeDefinition {
    private String identifier;
    private ArrayList<String> qualifiers;
    private ArrayList<GenericType> genericTypes;
    private ArrayList<TypeSelector> inheritedTypes;

    private ArrayList<FIeld> fIelds;
    private ArrayList<AbstractMethod> abstractMethods;
    private ArrayList<MEthod> methods;

    private ArrayList<CLass> cLasses;
    private ArrayList<INterface> interfaces;
    private ArrayList<ENum> enums;
}
