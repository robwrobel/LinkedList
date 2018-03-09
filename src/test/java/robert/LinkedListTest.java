package robert;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

import static org.testng.Assert.*;

public class LinkedListTest {
    LinkedList<String> list;

    @BeforeMethod
    public void setUp() {
        list = new LinkedList<>();
    }

    @Test
    public void givenEmptyList_whenAddElement_thenListSizeIs1() {
        list.add("First element");
        assertEquals(list.size(),1);
    }

    @Test
    public void givenEmptyList_whenAddElement_thenHeadAndTailAreTheSame() {
        list.add("First element");
        assertEquals(list.head,list.tail);
    }

    @Test
    public void givenListOfSize1_whenAddElement_thenTailHasThisElementAndListSizeIs2() {
        list.add("First element");
        list.add("Second element");

        assertEquals(list.size(), 2);
        assertEquals(list.tail.element, "Second element");
    }

    @Test
    public void givenEmptyList_whenAddFirstElement_thenHeadHasThisElementAndListSizeIs2() {
        list.add("Element");
        list.addFirst("First element");
        assertEquals(list.size(),2 );
        assertEquals(list.head.element, "First element");
    }

    @Test
    public void givenListWith3Elements_whenGettingFirstMiddleAndLastElement_thenProperElementsAreReturn() {
        list.add("FirstElement");
        list.add("SecondElement");
        list.add("ThirdElement");

        assertEquals(list.getFirst(), "FirstElement");
        assertEquals(list.get(1), "SecondElement");
        assertEquals(list.getLast(), "ThirdElement");
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void givenEmptyList_whenGettingFirstElement_thenExceptionIsThrown() {
        list.getFirst();
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void givenEmptyList_whenGettingLastElement_thenExceptionIsThrown() {
        list.getLast();
    }

    @Test
    public void givenListWith3Elements_whenGettingBoundaryElements_thenProperElementsAreReturned() {
        list.add("FirstElement");
        list.add("SecondElement");
        list.add("ThirdElement");

        assertEquals(list.get(0), "FirstElement");
        assertEquals(list.get(2), "ThirdElement");
    }

    @Test (expectedExceptions = IndexOutOfBoundsException.class)
    public void givenListWith2Elements_whenGettingElementWithMinusIndex_thenExeptionIsThrown() {
        list.add("FirstElement");
        list.add("SecondElement");
        list.get(-1);
    }

    @Test (expectedExceptions = IndexOutOfBoundsException.class)
    public void givenListWith2Elements_whenGettingElementWithTooHighIndex_thenExeptionIsThrown() {
        list.add("FirstElement");
        list.add("SecondElement");
        list.get(2);
    }

    @Test
    public void givenListWith2Elements_whenAddingElementInTheMiddle_thenElementIsInsertedProperly() {
        list.add("FirstElement");
        list.add("SecondElement");
        list.add(1,"MiddleElement");

        assertEquals(list.get(0), "FirstElement");
        assertEquals(list.get(1), "MiddleElement");
        assertEquals(list.get(2), "SecondElement");
        assertEquals(list.size(), 3);

    }

    @Test (expectedExceptions = NoSuchElementException.class)
    public void givenEmptyList_whenRemoveFirst_thenExceptionIsThrown() {
        list.remove();
    }

    @Test (expectedExceptions = NoSuchElementException.class)
    public void givenEmptyList_whenRemoveLast_thenExceptionIsThrown() {
        list.removeLast();
    }

    @Test
    public void givenListWith3Elements_whenRemoveFirstElement_thenFirstElementIsReturned() {
        list.add("FirstElement");
        list.add("SecondElement");
        list.add("ThirdElement");

        assertEquals(list.remove(0), "FirstElement");
        assertEquals(list.head.element, "SecondElement");
        assertEquals(list.size(), 2);

    }

    @Test
    public void givenListWith3Elements_whenRemoveLastElement_thenLastElementIsReturned() {
        list.add("FirstElement");
        list.add("SecondElement");
        list.add("ThirdElement");

        assertEquals(list.remove(2), "ThirdElement");
        assertEquals(list.tail.element, "SecondElement");
        assertEquals(list.size(), 2);

    }

    @Test
    public void givenListWith3Elements_whenRemoveMiddleElement_thenMiddleElementIsReturned() {
        list.add("FirstElement");
        list.add("SecondElement");
        list.add("ThirdElement");

        assertEquals(list.remove(1),"SecondElement");
        assertEquals(list.size(),2);
    }

    @Test
    public void givenListWith3Elements_whenTryingToRemoveNotExistingElement_thenFalseIsReturned() {
        list.add("FirstElement");
        list.add("SecondElement");
        list.add("ThirdElement");

        assertFalse(list.remove("FourthElement"));
        assertEquals(list.size(),3);
    }

    @Test
    public void givenListWith3Elements_whenTryingToRemoveExistingElement_thenTrueIsReturned() {
        list.add("FirstElement");
        list.add("SecondElement");
        list.add("ThirdElement");

        assertTrue(list.remove("SecondElement"));
        assertEquals(list.size(),2);
    }
}
