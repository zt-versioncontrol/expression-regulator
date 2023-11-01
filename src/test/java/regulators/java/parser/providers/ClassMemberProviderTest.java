package regulators.java.parser.providers;

import base.parsing.AbstractType;
import org.junit.jupiter.api.Test;
import regulators.java.parser.parsedObjects.members.*;
import regulators.java.parser.parsedObjects.types.CLass;
import regulators.java.parser.parsedObjects.types.ENum;
import regulators.java.parser.parsedObjects.types.INterface;

import static org.junit.jupiter.api.Assertions.*;

class ClassMemberProviderTest {

    ClassMemberProvider provider = new ClassMemberProvider();

    //tests should only ensure that a valid expression returns the correct type
    //the result of invalid expressions in ignored
    //many invalid expressions produce objects of type FIeld
    //errors caused by objects returned from invalid expressions are caught later, while parsing or validating

    @Test
    void provideClass() {
        assertTrue(provider.provide("class cls{....}") instanceof CLass);
        assertTrue(provider.provide("private\nstatic\n\tclass\tcls\n\t{{}{}()();;}") instanceof CLass);
        assertTrue(provider.provide("private\nstatic\nclass\ncls<T, x extends String> {{}{}()();;}") instanceof CLass);
        assertTrue(provider.provide("private  static  class   cls<T, x extends String> extends L implements Q, S{}") instanceof CLass);

        assertTrue(provider.provide("class cls implements") instanceof CLass);
        assertTrue(provider.provide("public class cls implements") instanceof CLass);

    }

    @Test
    void provideInterface() {
        assertTrue(provider.provide("interface cls{....}") instanceof INterface);
        assertTrue(provider.provide("private\nstatic\n\tinterface\tcls\n\t{{}{}()();;}") instanceof INterface);
        assertTrue(provider.provide("private\nstatic\ninterface\ncls<T, x extends String> {{}{}()();;}") instanceof INterface);
        assertTrue(provider.provide("private  static  interface   cls<T, x extends String> extends L implements Q, S{}") instanceof INterface);

        assertTrue(provider.provide("interface cls implements") instanceof INterface);
        assertTrue(provider.provide("public interface cls implements") instanceof INterface);
    }

    @Test
    void provideEnum(){
        assertTrue(provider.provide("enum cls{....}") instanceof ENum);
        assertTrue(provider.provide("private\nstatic\n\tenum\tcls\n\t{{}{}()();;}") instanceof ENum);
        assertTrue(provider.provide("private\nstatic\nenum\ncls<T, x extends String> {{}{}()();;}") instanceof ENum);
        assertTrue(provider.provide("private  static  enum   cls<T, x extends String> extends L implements Q, S{}") instanceof ENum);

        assertTrue(provider.provide("enum cls implements") instanceof ENum);
        assertTrue(provider.provide("public enum cls implements") instanceof ENum);
    }

    @Test
    void provideStaticBlock() {
        assertTrue(provider.provide("static{}") instanceof StaticBlock);
        assertTrue(provider.provide("  \nstatic\n\t{....}") instanceof StaticBlock);

        assertTrue(provider.provide("static {") instanceof StaticBlock);
        assertTrue(provider.provide("static   {\n\t} ") instanceof StaticBlock);
    }

    @Test
    void provideInitializationBlock() {
        assertTrue(provider.provide("{}") instanceof InitializationBlock);
        assertTrue(provider.provide("  \n\t{\n}  ") instanceof InitializationBlock);
        assertTrue(provider.provide(" {  ") instanceof InitializationBlock);

    }

    @Test
    void provideAbstractMethod() {
        assertTrue(provider.provide("public abstract fun\n();") instanceof AbstractMethod);
        assertTrue(provider.provide("private method fun()") instanceof AbstractMethod);
        assertTrue(provider.provide("protected final\n<T>\nList<String> fun()") instanceof AbstractMethod);

        assertTrue(provider.provide("()") instanceof AbstractMethod);
        assertTrue(provider.provide("({\n)}") instanceof AbstractMethod);
        assertTrue(provider.provide("protected static<T, L {}> List<Integer>()") instanceof AbstractMethod);
        assertTrue(provider.provide("void fun{}()") instanceof AbstractMethod);

    }

    @Test
    void provideMethod() {
        assertTrue(provider.provide("void\nfun()\n{...}\t") instanceof MEthod);
        assertTrue(provider.provide("private abstract fun(){}") instanceof MEthod);
        assertTrue(provider.provide("protected static<T, L {}> List<Integer> (){}") instanceof MEthod);
        assertTrue(provider.provide("(){}") instanceof MEthod);
    }

    @Test
    void provideField() {
        assertTrue(provider.provide("string s;") instanceof FIeld);
        assertTrue(provider.provide("string s = \"s\"") instanceof FIeld);
        assertTrue(provider.provide("private int ii =  577") instanceof FIeld);
        assertTrue(provider.provide("public static List<String> lst = new ArrayList<>()l") instanceof FIeld);
        assertTrue(provider.provide("InstanceProvider p = new (expression)\n\t->\n\t{return null;)") instanceof FIeld);
    }
}