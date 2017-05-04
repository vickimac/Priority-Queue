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


public class HeapPriorityQueueTest extends PriorityQueueTest {
    
    public HeapPriorityQueueTest() {
    }

    @Before
    @Override
    public void setUp() 
    {
        instance = new HeapPriorityQueue<>(8);
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
        
        String expResult = "[(4, 4), (3, 3), (1, 1), (2, 2)]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    @Test
    @Override
    public void testAddNames() throws Exception
    {
        System.out.println("addNames");
        
            Person personTest1 = new Person("Susan");
            instance.add(personTest1, 54);
            
            Person personTest3 = new Person("John");
            instance.add(personTest3, 39);  
            
            Person personTest4 = new Person("Mary");
            instance.add(personTest4, 21);

            Person personTest2 = new Person("Billy");
            instance.add(personTest2, 7);

        String expResult = "[(Susan, 54), (John, 39), (Billy, 7), (Mary, 21)]";
        String result = instance.toString();
        assertEquals(expResult, result);
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
        
        String expResult = "[(5, 5), (4, 4), (1, 1), (3, 3), (2, 2)]";
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
        
        String expResult = "[(4, 4), (3, 3), (1, 1), (2, 2)]";
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
            
        String expResult = "[(6, 6), (4, 4), (1, 1), (3, 3), (2, 2)]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    
}
