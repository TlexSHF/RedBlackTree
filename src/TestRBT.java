import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestRBT {

    RedBlackTree tree;

    @BeforeEach
    public void BeforeEach() {
        tree = new RedBlackTree();
    }

    //TESTS BASED ON PAGE 440 IN BOOK

    @Test
    public void TestPut1() {
        tree.put(19, "S");

        assertEquals("S", tree.root.value);
        assertEquals("S", tree.get(19));

        /*      ( S    )        */
    }
    @Test
    public void TestPut2() {
        tree.put(19, "S");
        tree.put(5, "E");

        assertEquals("S", tree.root.value);
        assertEquals("E", tree.root.left.value);

        assertEquals("S", tree.get(19));
        assertEquals("E", tree.get(5));

        assertFalse(tree.root.isRed);
        assertTrue(tree.root.left.isRed);
    }
    @Test
    public void TestPut3() {
        tree.put(19, "S");
        tree.put(5, "E");
        tree.put(1, "A");

        assertEquals("E", tree.root.value);
        assertEquals("A", tree.root.left.value);
        assertEquals("S", tree.root.right.value);

        assertEquals("S", tree.get(19));
        assertEquals("E", tree.get(5));
        assertEquals("A", tree.get(1));

        assertFalse(tree.root.isRed);
        assertFalse(tree.root.left.isRed);
        assertFalse(tree.root.right.isRed);

    }
    @Test
    public void TestPut4() {
        tree.put(19, "S");
        tree.put(5, "E");
        tree.put(1, "A");
        tree.put(18, "R");

        assertEquals("E", tree.root.value);
        assertEquals("A", tree.root.left.value);
        assertEquals("R", tree.root.right.value);
    /*
                ( E    )
          ( A   )      ( R   S )
     */

    }
    @Test
    public void TestPut5() {
        tree.put(19, "S");
        tree.put(5, "E");
        tree.put(1, "A");
        tree.put(18, "R");
        tree.put(3, "C");

        assertEquals("E", tree.root.value);
        assertEquals("A", tree.root.left.value);
        assertEquals("R", tree.root.right.value);
    /*
                ( E    )
          ( A  C )      ( R   S )
     */
    }
    @Test
    public void TestPut6() {
        tree.put(19, "S");
        tree.put(5, "E");
        tree.put(1, "A");
        tree.put(18, "R");
        tree.put(3, "C");
        tree.put(8, "H");

        assertEquals("E", tree.root.value);
        assertEquals("A", tree.root.left.value);
        assertEquals("S", tree.root.right.value);

    /*
                   ( E   R )
          ( A  C )  ( H    )  ( S    )
     */
    }
}