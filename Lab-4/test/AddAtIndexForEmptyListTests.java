import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class AddAtIndexForEmptyListTests {

    LinkedList<Integer> populatedList;

    @Before
    public void setUp() {
        populatedList = new LinkedList<Integer>();
        populatedList.add(2);
        populatedList.add(4);
        populatedList.add(6);
    }

    @Test
    public void addToEmptyList() {
        LinkedList<Integer> emptyList = new LinkedList<>();
        emptyList.add(0, 4);
        assertFalse(emptyList.isEmpty());
        assertEquals(1, emptyList.size());
        assertEquals(new Integer(4), emptyList.get(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addingAtIndexLessThanZeroThrowsAnException() {
        LinkedList<Integer> emptyList = new LinkedList<>();
        emptyList.add(-1, 4);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addingAtIndexGreaterThanSizeThrowsAnException() {
        LinkedList<Integer> emptyList = new LinkedList<>();
        emptyList.add(4, 4);
    }
}
