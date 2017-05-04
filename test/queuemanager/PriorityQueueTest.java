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
public abstract class PriorityQueueTest {
    
    public PriorityQueue<Person> instance;
    
    public PriorityQueueTest() {
    }
    
    @Before
    public abstract void setUp();

    /**
     * Test of isEmpty method, of class PriorityQueue.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testNotEmpty() throws Exception
    {
        System.out.println("notEmpty");
        
            Person personTest1 = new Person("1");
            instance.add(personTest1, 1);
            
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }
    
    @Test
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
        
        String expResult = "[(4, 4), (3, 3), (2, 2), (1, 1)]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    
    @Test
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

        String expResult = "[(Susan, 54), (John, 39), (Mary, 21), (Billy, 7)]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    
    @Test(expected = QueueUnderflowException.class)
    public void testEmptyRemove() throws Exception
    {
        System.out.println("emptyRemove");
        
        instance.remove();
    }

         @Test
    public void testHead() throws Exception
    {     
        System.out.println("head");
        
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
        
        String expResult = "5";
        String result = instance.head().getName();
        assertEquals(expResult, result);
    }
}
