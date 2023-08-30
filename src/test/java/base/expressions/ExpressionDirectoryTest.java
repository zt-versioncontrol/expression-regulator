package base.expressions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utility.Revertible;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionDirectoryTest {
    ExpressionDirectory expressionDirectory;

    @BeforeEach
    void setUp() {
        Level1Expression level1Expression = new Level1Expression("e");
        expressionDirectory = new ExpressionDirectory(level1Expression);
    }

    @Test
    void back() {
        expressionDirectory.nextDerivedExpression();
        expressionDirectory.moveToIteratedExpression();
        assertEquals("ee1", expressionDirectory.getExpressionString());
        expressionDirectory.back();
        assertEquals("e", expressionDirectory.getExpressionString());


        expressionDirectory.reset();
        expressionDirectory.nextDerivedExpression();
        expressionDirectory.moveToIteratedExpression();
        expressionDirectory.nextDerivedExpression();
        expressionDirectory.moveToIteratedExpression();
        assertEquals("eee1", expressionDirectory.getExpressionString());
        expressionDirectory.back();
        assertEquals("ee1", expressionDirectory.getExpressionString());
        expressionDirectory.back();
        assertEquals("e", expressionDirectory.getExpressionString());

        assertThrowsExactly(Revertible.NoPreviousStateException.class, () -> expressionDirectory.back());
        assertThrowsExactly(Revertible.NoPreviousStateException.class, () -> expressionDirectory.back());
    }

    @Test
    void reset() {
        expressionDirectory.reset();
        assertEquals("e", expressionDirectory.getExpressionString());
       assertThrowsExactly(ExpressionDirectory.InvalidDirectoryStateException.class, expressionDirectory::getIteratedExpressionString);

        expressionDirectory.nextDerivedExpression();
        expressionDirectory.moveToIteratedExpression();
        assertEquals("ee1", expressionDirectory.getExpressionString());
        expressionDirectory.reset();
        assertEquals("e", expressionDirectory.getExpressionString());
        assertThrowsExactly(ExpressionDirectory.InvalidDirectoryStateException.class, expressionDirectory::getIteratedExpressionString);

        expressionDirectory.nextDerivedExpression();
        expressionDirectory.nextDerivedExpression();
        assertEquals("ee2", expressionDirectory.getIteratedExpressionString());
        expressionDirectory.reset();
        assertThrowsExactly(ExpressionDirectory.InvalidDirectoryStateException.class, expressionDirectory::getIteratedExpressionString);
    }

    @Test
    void nextDerivedExpression() {
        assertThrowsExactly(ExpressionDirectory.InvalidDirectoryStateException.class, expressionDirectory::getIteratedExpressionString);
        assertTrue(expressionDirectory.nextDerivedExpression());
        assertEquals("ee1", expressionDirectory.getIteratedExpressionString());
        assertTrue(expressionDirectory.nextDerivedExpression());
        assertEquals("ee2", expressionDirectory.getIteratedExpressionString());
        assertTrue(expressionDirectory.nextDerivedExpression());
        assertEquals("ee3", expressionDirectory.getIteratedExpressionString());
        assertTrue(expressionDirectory.nextDerivedExpression());
        assertEquals("ee11", expressionDirectory.getIteratedExpressionString());
        assertFalse(expressionDirectory.nextDerivedExpression());
        assertThrowsExactly(ExpressionDirectory.InvalidDirectoryStateException.class, expressionDirectory::getIteratedExpressionString);
        assertFalse(expressionDirectory.nextDerivedExpression());
        assertThrowsExactly(ExpressionDirectory.InvalidDirectoryStateException.class, expressionDirectory::getIteratedExpressionString);
    }

    @Test
    void resetDerivedExpressionIterator() {
        expressionDirectory.resetDerivedExpressionIterator();
        assertThrowsExactly(ExpressionDirectory.InvalidDirectoryStateException.class, expressionDirectory::getIteratedExpressionString);

        expressionDirectory.nextDerivedExpression();
        expressionDirectory.moveToIteratedExpression();
        expressionDirectory.resetDerivedExpressionIterator();
        assertThrowsExactly(ExpressionDirectory.InvalidDirectoryStateException.class, expressionDirectory::getIteratedExpressionString);
        expressionDirectory.nextDerivedExpression();
        expressionDirectory.nextDerivedExpression();
        assertEquals("eee2", expressionDirectory.getIteratedExpressionString());
        expressionDirectory.resetDerivedExpressionIterator();
        assertThrowsExactly(ExpressionDirectory.InvalidDirectoryStateException.class, expressionDirectory::getIteratedExpressionString);
        expressionDirectory.nextDerivedExpression();
        assertEquals("eee1", expressionDirectory.getIteratedExpressionString());
        expressionDirectory.resetDerivedExpressionIterator();
        assertThrowsExactly(ExpressionDirectory.InvalidDirectoryStateException.class, expressionDirectory::getIteratedExpressionString);

        expressionDirectory.reset();
        expressionDirectory.filterDerivedExpressionIterator(Level2Expression2.class);
        expressionDirectory.resetDerivedExpressionIterator();
        expressionDirectory.nextDerivedExpression();
        assertEquals("ee1", expressionDirectory.getIteratedExpressionString());
    }

    @Test
    void filterDerivedExpressionIterator() {
        expressionDirectory.filterDerivedExpressionIterator(Level2Expression2.class);
        assertTrue(expressionDirectory.nextDerivedExpression());
        assertEquals("ee11", expressionDirectory.getIteratedExpressionString());
        assertFalse(expressionDirectory.nextDerivedExpression());

        expressionDirectory.reset();
        expressionDirectory.nextDerivedExpression();
        assertEquals("ee1", expressionDirectory.getIteratedExpressionString());
        expressionDirectory.nextDerivedExpression();
        expressionDirectory.nextDerivedExpression();
        expressionDirectory.nextDerivedExpression();
        expressionDirectory.filterDerivedExpressionIterator(Level2Expression2.class);
        assertThrowsExactly(ExpressionDirectory.InvalidDirectoryStateException.class, expressionDirectory::getIteratedExpressionString);
        expressionDirectory.nextDerivedExpression();
        assertEquals("ee11", expressionDirectory.getIteratedExpressionString());
    }

    @Test
    void filterRemainingDerivedExpressionIterator() {
        expressionDirectory.filterRemainingDerivedExpressionIterator(Level2Expression2.class);
        assertTrue(expressionDirectory.nextDerivedExpression());
        assertEquals("ee11", expressionDirectory.getIteratedExpressionString());
        assertFalse(expressionDirectory.nextDerivedExpression());

        expressionDirectory.reset();
        expressionDirectory.nextDerivedExpression();
        expressionDirectory.filterRemainingDerivedExpressionIterator(Level2Expression.class);
        assertThrowsExactly(ExpressionDirectory.InvalidDirectoryStateException.class, expressionDirectory::getIteratedExpressionString);
        expressionDirectory.nextDerivedExpression();
        assertEquals("ee2", expressionDirectory.getIteratedExpressionString());
        expressionDirectory.nextDerivedExpression();
        assertEquals("ee3", expressionDirectory.getIteratedExpressionString());
        assertFalse(expressionDirectory.nextDerivedExpression());
        assertThrowsExactly(ExpressionDirectory.InvalidDirectoryStateException.class, expressionDirectory::getIteratedExpressionString);

        expressionDirectory.reset();
        expressionDirectory.nextDerivedExpression();
        expressionDirectory.nextDerivedExpression();
        expressionDirectory.moveToIteratedExpression();
        expressionDirectory.nextDerivedExpression();
        expressionDirectory.nextDerivedExpression();
        expressionDirectory.nextDerivedExpression();
        expressionDirectory.nextDerivedExpression();
        expressionDirectory.filterRemainingDerivedExpressionIterator(Level3Expression.class);
        assertFalse(expressionDirectory.nextDerivedExpression());

    }

    @Test
    void moveToIteratedExpression() {
        assertThrowsExactly(ExpressionDirectory.InvalidDirectoryStateException.class, expressionDirectory::moveToIteratedExpression);

        expressionDirectory.nextDerivedExpression();
        expressionDirectory.nextDerivedExpression();
        expressionDirectory.nextDerivedExpression();
        expressionDirectory.moveToIteratedExpression();
        assertEquals("ee3", expressionDirectory.getExpressionString());
        expressionDirectory.nextDerivedExpression();
        expressionDirectory.moveToIteratedExpression();
        assertEquals("eee1", expressionDirectory.getExpressionString());

        expressionDirectory.nextDerivedExpression();
        assertThrowsExactly(ExpressionDirectory.InvalidDirectoryStateException.class, expressionDirectory::moveToIteratedExpression);
    }

    @Test
    void getExpressionType() {
        assertEquals(Level1Expression.class, expressionDirectory.getExpressionType());
        expressionDirectory.nextDerivedExpression();
        expressionDirectory.nextDerivedExpression();
        expressionDirectory.nextDerivedExpression();
        expressionDirectory.moveToIteratedExpression();
        assertEquals(Level2Expression.class, expressionDirectory.getExpressionType());
        expressionDirectory.nextDerivedExpression();
        expressionDirectory.moveToIteratedExpression();
        assertEquals(Level3Expression.class, expressionDirectory.getExpressionType());
    }

    @Test
    void getExpressionString() {
        assertEquals("e", expressionDirectory.getExpressionString());
        expressionDirectory.nextDerivedExpression();
        expressionDirectory.nextDerivedExpression();
        expressionDirectory.nextDerivedExpression();
        expressionDirectory.moveToIteratedExpression();
        assertEquals("ee3", expressionDirectory.getExpressionString());
        expressionDirectory.nextDerivedExpression();
        expressionDirectory.moveToIteratedExpression();
        assertEquals("eee1", expressionDirectory.getExpressionString());
    }

    @Test
    void getIteratedExpressionType() {
        assertThrowsExactly(ExpressionDirectory.InvalidDirectoryStateException.class, expressionDirectory::getIteratedExpressionType);
        expressionDirectory.nextDerivedExpression();
        assertEquals(Level2Expression.class, expressionDirectory.getIteratedExpressionType());
        expressionDirectory.nextDerivedExpression();
        assertEquals(Level2Expression.class, expressionDirectory.getIteratedExpressionType());
        expressionDirectory.moveToIteratedExpression();
        assertThrowsExactly(ExpressionDirectory.InvalidDirectoryStateException.class, expressionDirectory::getIteratedExpressionType);
        expressionDirectory.nextDerivedExpression();
        assertEquals(Level3Expression.class, expressionDirectory.getIteratedExpressionType());
    }

    @Test
    void getIteratedExpressionString() {
        assertThrowsExactly(ExpressionDirectory.InvalidDirectoryStateException.class, expressionDirectory::getIteratedExpressionString);
        expressionDirectory.nextDerivedExpression();
        assertEquals("ee1", expressionDirectory.getIteratedExpressionString());
        expressionDirectory.nextDerivedExpression();
        assertEquals("ee2", expressionDirectory.getIteratedExpressionString());
        expressionDirectory.moveToIteratedExpression();
        assertThrowsExactly(ExpressionDirectory.InvalidDirectoryStateException.class, expressionDirectory::getIteratedExpressionType);
        expressionDirectory.nextDerivedExpression();
        assertEquals("eee1", expressionDirectory.getIteratedExpressionString());
    }



    private static class Level1Expression extends Expression{

        public Level1Expression(String expression) {
            super(expression);
        }

        @Override
        protected String normalize(String expression) {
            return expression;
        }

        @Override
        protected List<Expression> computeDerivedExpressions() {
            return List.of(new Level2Expression("ee1", null),
                    new Level2Expression("ee2", null),
                    new Level2Expression("ee3", null),
                    new Level2Expression2("ee11", null)
            );
        }
    }

    private static class Level2Expression extends Expression{

        public Level2Expression(String expression, Expression origin) {
            super(expression);
        }

        @Override
        protected String normalize(String expression) {
            return expression;
        }

        @Override
        protected List<Expression> computeDerivedExpressions() {
            return List.of(new Level3Expression("eee1"),
                    new Level3Expression("eee2"),
                    new Level3Expression("eee3")
            );
        }
    }

    private static class Level2Expression2 extends Expression{

        public Level2Expression2(String expression, Expression origin) {
            super(expression);
        }

        @Override
        protected String normalize(String expression) {
            return expression;
        }

        @Override
        protected List<Expression> computeDerivedExpressions() {
            return new ArrayList<>();
        }
    }

    private static class Level3Expression extends Expression{

        public Level3Expression(String expression) {
            super(expression);
        }

        @Override
        protected String normalize(String expression) {
            return expression;
        }

        @Override
        protected List<Expression> computeDerivedExpressions() {
            return null;
        }
    }
}