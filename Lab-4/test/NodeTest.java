import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class NodeTest {

    private Node<String> node;

    @Before
    public void setUp() {
        this.node = new Node<String>("value");
    }

    @Test
    public void itHasDataWhenItIsConstructed() {
        assertEquals("value", node.getData());
    }

    @Test
    public void itCanSetTheData() {
        String expectedValue = "different value";
        node.setData(expectedValue);

        assertEquals(expectedValue, node.getData());
    }

    @Test
    public void itDoesNotHaveANextNodeWhenConstructed() {
        assertNull(node.getNext());
    }

    @Test
    public void itCanSetTheNextNode() {
        String expectedValue = "another String";
        node.setNext(new Node<>(expectedValue));

        assertEquals(expectedValue, node.getNext().getData());
    }
}