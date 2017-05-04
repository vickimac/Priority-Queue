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

/**
 *
 * @author Vicki
 */
public class UnsortedArrayPriorityQueueTest extends PriorityQueueTest {
    
    public UnsortedArrayPriorityQueueTest() {
    }

    @Before
    @Override
    public void setUp() 
    {
        instance = new UnsortedArrayPriorityQueue<>(8);
    }
    
    @Test(expected = QueueOverflowException.class)
    public void testOverflowException() throws Exception
    {
        System.out.println("overflowException");
        
            Person personTest1 = new Person("1");
            instance.add(personTest1, 1);

            Person personTest2 = new Person("2");
            instance.add(personTest2, 2);

            Person personTest3 = new Person("3");
            instance.add(personTest3, 3);

            Person personTest4 = new Person("4");
            instance.add(personTest4, 4);
            
            Person personTest5 = new Person("5");
            instance.add(personTest5, 5);
            
            Person personTest6 = new Person("6");
            instance.add(personTest6, 6);
            
            Person personTest7 = new Person("7");
            instance.add(personTest7, 7);
            
            Person personTest8 = new Person("8");
            instance.add(personTest8, 8);
            
            Person personTest9 = new Person("9");
            instance.add(personTest9, 9);
    }
    
    @Test
    @Override
    public void testAdd() throws Exception {
        System.out.println("add");
        
            Person personTest1 = new Person("1");
            instance.add(personTest1, 1);

            Person personTest2 = new Person("2");
            instance.add(personTest2, 2);

            Person personTest3 = new Person("3");
            instance.add(personTest3, 3);

            Person personTest4 = new Person("4");
            instance.add(personTest4, 4);
        
        String expResult = "[(1, 1), (2, 2), (3, 3), (4, 4)]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testAddNoOrder() throws Exception
    {
        System.out.println("addNoOrder");
        
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
        
        String expResult = "[(3, 3), (5, 5), (1, 1), (2, 2), (4, 4)]";
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
        
        String expResult = "[(3, 3), (1, 1), (2, 2), (4, 4)]";
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
        
        String expResult = "[(3, 3), (1, 1), (2, 2), (4, 4), (6, 6)]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
