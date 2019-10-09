import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RemoveTests {

    LinkedList<Character> list = new LinkedList<>();

    @Before
    public void setUp() {
        list = new LinkedList<>();
        list.add('a');
    }

    @Test
    public void itReturnsTheRemovedItem() {
        Character removedValue = list.remove();
        assertEquals(new Character('a'), removedValue);
    }

    @Test
    public void listIsEmptyWhenAllItemsRemoved() {
        list.remove();

        assertTrue(list.isEmpty());
    }

    @Test
    public void listHasSizeZeroWhenAllItemsRemoved() {
        list.remove();

        assertEquals(0, list.size());
    }

    @Test
    public void itRemovesTheFirstItem() {
        list.add('b');

        assertEquals(new Character('a'), list.remove());
        assertEquals(1, list.size());
        assertEquals(new Character('b'), list.get(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void itThrowsIndexOutOfBoundsExceptionWhenRemovingFromEmptyList() {
        list = new LinkedList<>();
        list.remove();
    }
}
