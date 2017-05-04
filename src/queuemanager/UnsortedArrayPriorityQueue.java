/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

/**
 * Implementation of the PriorityQueue ADT using an unsorted array for storage
 * 
 * @author Vicki
 * 
 * @param<T> The type of things being stored
 */
public class UnsortedArrayPriorityQueue<T> implements PriorityQueue<T> {

    /**
     * Where the data is actually stored
     */
    private Object[] storage;
    
    /**
     * The size of the storage array
     */
    private int capacity;
    
    /**
     * The index of the last item stored
     * 
     * This is equal to the item count minus one
     */
    private int tailIndex;
    
    
    /**
     * Create a new empty queue of the given size
     * 
     * @param size 
     */
    public UnsortedArrayPriorityQueue(int size)
    {
        storage = new Object[size];
        capacity = size;
        tailIndex = -1;
    }
    
    @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty())
        {
            throw new QueueUnderflowException();
        }
        else
        {
            // Scan backwards looking for highest priority and its index
            int priority = ((PriorityItem<T>) storage[tailIndex]).getPriority();
            int topPrioIndex = tailIndex;
            int i = tailIndex;
            while (i >= 0)
            {
                if (priority < ((PriorityItem<T>) storage[i]).getPriority())
                {
                    priority = ((PriorityItem<T>) storage[i]).getPriority();
                    topPrioIndex = i;
                }
                i = i - 1;
            }
            return ((PriorityItem<T>) storage[topPrioIndex]).getItem();
        }
    }
        
    @Override
    public void add(T item, int priority) throws QueueOverflowException {
        tailIndex++;
        
        if (tailIndex >= capacity)
        {
            // No resizing implemented
            tailIndex = tailIndex - 1;
            throw new QueueOverflowException();
        }
        storage[tailIndex] = new PriorityItem<>(item, priority);
    }


    @Override
    public void remove() throws QueueUnderflowException {
        if (isEmpty())
        {
            throw new QueueUnderflowException();
        }
        else
        {
            // Scan backwards looking for highest priority and its index
            int priority = ((PriorityItem<T>) storage[tailIndex]).getPriority();
            int topPrioIndex = tailIndex;
            int i = tailIndex;
            while (i >= 0)
            {
                if (priority < ((PriorityItem<T>) storage[i]).getPriority())
                {
                    priority = ((PriorityItem<T>) storage[i]).getPriority();
                    topPrioIndex = i;
                }
                i = i - 1;
            }
           
            // replace highest priority with the next one up, and then continue replacing
            for (int j = topPrioIndex; j < tailIndex; j++)
            {
                storage[j] = storage[j + 1];
            }
            tailIndex = tailIndex - 1;
        }
    }

    @Override
    public boolean isEmpty() {
        return tailIndex < 0;
    }
    
    public String toString()
    {
        String result = "[";
        for (int i = 0; i <= tailIndex; i++)
        {
            if (i > 0)
            {
                result = result + ", ";
            }
            result = result + storage[i];
        }
        result = result + "]";
        return result;
    }
    
}
