import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class AddAtIndexForPopulatedListTests {

    LinkedList<Integer> populatedList;

    @Before
    public void setUp() {
        populatedList = new LinkedList<Integer>();
        populatedList.add(2);
        populatedList.add(4);
        populatedList.add(6);
    }

    @Test
    public void itCanAddAValueAtTheBeginningOfTheList() {
        populatedList.add(0, 1);
        assertFalse(populatedList.isEmpty());
        assertEquals(4, populatedList.size());
        assertEquals(new Integer(1), populatedList.get(0));
        assertEquals(new Integer(2), populatedList.get(1));
    }

    @Test
    public void itCanAddAValueInTheMiddleOfTheList() {
        populatedList.add(1, 3);
        assertFalse(populatedList.isEmpty());
        assertEquals(4, populatedList.size());
        assertEquals(new Integer(2), populatedList.get(0));
        assertEquals(new Integer(3), populatedList.get(1));
        assertEquals(new Integer(4), populatedList.get(2));
    }

    @Test
    public void itCanAddAValueAtTheEndOfTheList() {
        populatedList.add(3, 7);
        assertFalse(populatedList.isEmpty());
        assertEquals(4, populatedList.size());
        assertEquals(new Integer(6), populatedList.get(2));
        assertEquals(new Integer(7), populatedList.get(3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addingAtIndexLessThanZeroThrowsIndexOutOfBoundsException() {
        populatedList.add(-1, 4);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addingAtIndexGreaterThanSizeThrowsIndexOutOfBoundsException() {
        populatedList.add(4, 4);
    }
}
