/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class SortedLinkedPriorityQueueTest extends PriorityQueueTest {
    
    public SortedLinkedPriorityQueueTest() {
    }

    @Before
    @Override
    public void setUp() 
    {
        instance = new SortedLinkedPriorityQueue<>();
    }
    
    @Test
    public void testAddReorder() throws Exception
    {
        System.out.println("addReorder");
        
            Person personTest1 = new Person("3");
            instance.add(personTest1, 3);

            Person personTest2 = new Person("5");
            instance.add(personTest2, 5);

            Person personTest3 = new Person("1");
            instance.add(personTest3, 1);

            Person personTest4 = new Person("2");
            instance.add(personTest4, 2);

            Person personTest5 = new Person("4");
            instance.add(personTest5, 4);
        
        String expResult = "[(5, 5), (4, 4), (3, 3), (2, 2), (1, 1)]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
        @Test
    public void testRemove() throws Exception
    {
        System.out.println("remove");
        
            Person personTest1 = new Person("3");
            instance.add(personTest1, 3);

            Person personTest2 = new Person("5");
            instance.add(personTest2, 5);

            Person personTest3 = new Person("1");
            instance.add(personTest3, 1);

            Person personTest4 = new Person("2");
            instance.add(personTest4, 2);

            Person personTest5 = new Person("4");
            instance.add(personTest5, 4);
        
        instance.remove();
        
        String expResult = "[(4, 4), (3, 3), (2, 2), (1, 1)]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
        @Test
    public void testRemoveAdd() throws Exception
    {
        System.out.println("removeAdd");
        
            Person personTest1 = new Person("3");
            instance.add(personTest1, 3);

            Person personTest2 = new Person("5");
            instance.add(personTest2, 5);

            Person personTest3 = new Person("1");
            instance.add(personTest3, 1);

            Person personTest4 = new Person("2");
            instance.add(personTest4, 2);

            Person personTest5 = new Person("4");
            instance.add(personTest5, 4);
            
            instance.remove();
        
            Person personTest6 = new Person("6");
            instance.add(personTest6, 6);
            
        String expResult = "[(6, 6), (4, 4), (3, 3), (2, 2), (1, 1)]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    
}
