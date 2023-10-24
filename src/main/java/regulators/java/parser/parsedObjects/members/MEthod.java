package regulators.java.parser.parsedObjects.members;

import regulators.java.parser.parsedObjects.attributes.TypeSelector;
import regulators.java.parser.parsedObjects.types.CLass;
import regulators.java.parser.parsedObjects.types.ENum;
import regulators.java.parser.parsedObjects.types.INterface;

import java.util.ArrayList;

public class MEthod extends ClassMember {
    private ArrayList<String> qualifiers;
    private TypeSelector type;
    private String identifier;
    private ArrayList<MethodParameter> parameters;
    private ArrayList<CLass> classes;
    private ArrayList<INterface> interfaces;
    private ArrayList<ENum> enums;

    private ArrayList<String> statements;
}
