package regulators.java.parser.parsedObjects.members;


public class InitializationBlock implements ClassMember, EnumMember {
    private String block;

    public InitializationBlock(String block) {
        this.block = block;
    }
}
