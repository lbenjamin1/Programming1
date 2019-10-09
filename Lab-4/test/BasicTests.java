import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BasicTests {

    LinkedList<String> list;

    @Before
    public void setUp() {
        list = new LinkedList<String>();
    }

    @Test
    public void listIsEmptyWhenConstructed() {
        assertTrue(new LinkedList<String>().isEmpty());
    }

    @Test
    public void listHasASizeOf0WhenConstructed() {
        assertEquals(0, new LinkedList<String>().size());
    }
    @Test
    public void listIsNotEmptyWhenAValueIsAdded() {
        list.add("value #1");
        assertFalse(list.isEmpty());
    }

    @Test
    public void listSizeIsIncrementedWhenASingleValueIsAdded() {
        list.add("value #1");
        assertEquals(1, list.size());
    }

    @Test
    public void listIsNotEmptyWhenMultipleValuesAdded() {
        list.add("value #1");
        list.add("Value #2");
        assertFalse(list.isEmpty());
    }

    @Test
    public void listSizeIsIncrementedWhenMultipleValuesAdded() {
        list.add("value #1");
        list.add("Value #2");
        list.add("Value #3");
        assertEquals(3, list.size());
    }
}
