package regulators.java.parser.parsedObjects.members;


public class StaticBlock implements ClassMember, EnumMember {
    private String block;

    public StaticBlock(String block) {
        this.block = block;
    }
}
