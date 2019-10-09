import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetTests {

    private LinkedList<String> list;

    @Before
    public void setUp() {
        list = new LinkedList<String>();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void itThrowsIndexOutOfBoundsExceptionWhenGettingIndexLessThanZero() {
        list.get(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void itThrowsIndexOutOfBoundsExceptionWhenGettingIndexGreaterThanSize() {
        String expectedValue = "value #1";

        list.add(expectedValue);

        list.get(2);
    }

    @Test
    public void itCanGetTheItemAtTheBeginningOfTheList() {
        String expectedValue = "value #1";

        list.add(expectedValue);

        assertEquals(expectedValue, list.get(0));
    }

    @Test
    public void itCanGetTheItemAtTheEndOfTheList() {
        String value1 = "value #1";
        list.add(value1);

        String value2 = "Value #2";
        list.add(value2);

        assertEquals(value1, list.get(0));
        assertEquals(value2, list.get(1));
    }

    @Test
    public void itCanGetTheItemInTheMiddleOfTheList() {
        String value1 = "value #1";
        list.add(value1);

        String value2 = "Value #2";
        list.add(value2);

        String value3 = "Value #3";
        list.add(value3);

        assertEquals(value1, list.get(0));
        assertEquals(value2, list.get(1));
        assertEquals(value3, list.get(2));
    }
}
