package regulators.java.parser.providers;

import org.junit.jupiter.api.Test;
import regulators.java.parser.parsedObjects.types.CLass;
import regulators.java.parser.parsedObjects.types.ENum;
import regulators.java.parser.parsedObjects.types.INterface;
import regulators.java.parser.parsedObjects.types.InvalidTypeDefinition;

import static org.junit.jupiter.api.Assertions.*;

class TypeDefinitionProviderTest {

    TypeDefinitionProvider provider = new TypeDefinitionProvider();

    @Test
    void provideClass() {
        assertTrue(provider.provide("class cls{....}") instanceof CLass);
        assertTrue(provider.provide("private\nstatic\n\tclass\tcls\n\t{{}{}()();;}") instanceof CLass);
        assertTrue(provider.provide("private\nstatic\nclass\ncls<T, x extends String> {{}{}()();;}") instanceof CLass);
        assertTrue(provider.provide("private  static  class   cls<T, x extends String> extends L implements Q, S{}") instanceof CLass);



    }

    @Test
    void provideInterface() {
        assertTrue(provider.provide("interface cls{....}") instanceof INterface);
        assertTrue(provider.provide("private\nstatic\n\tinterface\tcls\n\t{{}{}()();;}") instanceof INterface);
        assertTrue(provider.provide("private\nstatic\ninterface\ncls<T, x extends String> {{}{}()();;}") instanceof INterface);
        assertTrue(provider.provide("private  static  interface   cls<T, x extends String> extends L implements Q, S{}") instanceof INterface);


    }

    @Test
    void provideEnum(){
        assertTrue(provider.provide("enum cls{....}") instanceof ENum);
        assertTrue(provider.provide("private\nstatic\n\tenum\tcls\n\t{{}{}()();;}") instanceof ENum);
        assertTrue(provider.provide("private\nstatic\nenum\ncls<T, x extends String> {{}{}()();;}") instanceof ENum);
        assertTrue(provider.provide("private  static  enum   cls<T, x extends String> extends L implements Q, S{}") instanceof ENum);


    }

    @Test
    void ProvideInvalidType(){
        assertTrue(provider.provide("") instanceof InvalidTypeDefinition);
        assertTrue(provider.provide(";") instanceof InvalidTypeDefinition);
        assertTrue(provider.provide("abc") instanceof InvalidTypeDefinition);
        assertTrue(provider.provide("abc;") instanceof InvalidTypeDefinition);

        assertTrue(provider.provide("class cls implements") instanceof InvalidTypeDefinition);
        assertTrue(provider.provide("public class cls implements") instanceof InvalidTypeDefinition);
        assertTrue(provider.provide("interface cls implements") instanceof InvalidTypeDefinition);
        assertTrue(provider.provide("public interface cls implements") instanceof InvalidTypeDefinition);
        assertTrue(provider.provide("enum cls implements") instanceof InvalidTypeDefinition);
        assertTrue(provider.provide("public enum cls implements") instanceof InvalidTypeDefinition);
    }

}