import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class RemoveAtIndexTests {

    LinkedList<Character> list;

    @Before
    public void setUp() {
        list = new LinkedList<>();
        list.add('x');
        list.add('y');
        list.add('z');
    }

    @Test
    public void itCanRemoveFromTheBeginningOfTheList() {
        Character removedCharacter = list.remove(0);

        assertEquals(new Character('x'), removedCharacter);
        assertFalse(list.isEmpty());
        assertEquals(2, list.size());
        assertEquals(new Character('y'), list.get(0));
    }

    @Test
    public void itCanRemoveFromTheMiddleOfTheList() {
        Character removedCharacter = list.remove(1);

        assertEquals(new Character('y'), removedCharacter);
        assertFalse(list.isEmpty());
        assertEquals(2, list.size());
        assertEquals(new Character('x'), list.get(0));
        assertEquals(new Character('z'), list.get(1));
    }

    @Test
    public void itCanRemoveFromTheEndOfTheList() {
        Character removedCharacter = list.remove(2);
        assertEquals(new Character('z'), removedCharacter);
        assertFalse(list.isEmpty());
        assertEquals(2, list.size());
        assertEquals(new Character('y'), list.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void itThrowsAnIndexOutOfBoundsExceptionWhenRemovingAtIndexLessThan0() {
        list.remove(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void itThrowsAnIndexOutOfBoundsExceptionWhenRemovingIndexEqualToSize() {
        list.remove(3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void itThrowsAnIndexOutOfBoundsExceptionWhenRemovingIndexGreaterThanSize() {
        list.remove(4);
    }
}
