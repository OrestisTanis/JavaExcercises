package testpackage;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ListOperationsTest {
    private ListOperations listOperations;
    
    public ListOperationsTest() {
    }
   
    @Before
    public void setUp() {
        listOperations = new ListOperations();
    }
    
    @Test
    public void testAddNameToList() {
        boolean itemAdded = listOperations.addNameToList("NewName");
        assertTrue(itemAdded);
    }  
    
    @Test
    public void testAddNameToListNull() {
        listOperations.addNameToList(null);
        assertEquals(listOperations.getSizeOfList(), 0);
    }  
    
    @Test
    public void testAddNameToListCheckName() {
        listOperations.addNameToList("NewName");
        int sizeOfList = listOperations.getSizeOfList();
        String name = listOperations.getList().get(sizeOfList - 1);
        assertEquals(name, "NewName");
    } 

    @Test
    public void testRemoveNameFromList() {
        listOperations.addNameToList("Name");
        listOperations.removeNameFromList("Name");
        assertEquals(listOperations.getSizeOfList(), 0);
    }

    @Test
    public void testGetSizeOfList() {
        listOperations.addNameToList("Name");
        listOperations.addNameToList("Name");
        listOperations.addNameToList("Name");
        assertEquals(listOperations.getSizeOfList(), 3);
    }
}
