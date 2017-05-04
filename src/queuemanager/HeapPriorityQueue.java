/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

/**
 * Much of this code was inspired by:
 *      Sanfoundry (n.d.) Java Program to Implement Max Heap [online].
 *      Available from < http://www.sanfoundry.com/java-program-implement-max-heap/ > [09 November 2016]
 * 
 * and was adapted to match the needs of this task.
 *
 * @author Victoria Maciver 14006476
 */
public class HeapPriorityQueue<T> implements PriorityQueue<T> {

    /**
     * Where the data is actually stored.
     */
    private Object[] storage;
    
    /**
     * Current size of the tree.
     */
    private int size = 0;
    
    /**
     * Maximum size that the tree can be.
     */
    private int maxsize;
    
    /**
     * Position of the first item in the tree
     *
     * Has to be 1 rather than 0 as it needs to be multiplied to find its children.
     */
    private static final int FRONT = 1;
    
    /**
     * Create a new empty tree of the given size.
     * 
     * @param maxsize 
     */
    public HeapPriorityQueue(int maxsize)
    {
        this.maxsize = maxsize;
        maxsize = 0;
        storage = new Object[this.maxsize];
    }
    
    /**
     * Find the parent of the current position.
     * If it is 1 then it will round up as it is an integer.
     * 
     * @param pos
     * @return 
     */
    private int parent(int pos)
    {
        return pos / 2;
    }
    
    /**
     * Swap the items of fpos (first position) and spos (second position).
     * 
     * @param fpos
     * @param spos 
     */
    private void swap(int fpos, int spos)
    {
        Object tmp;
        tmp = storage[fpos];
        storage[fpos] = storage[spos];
        storage[spos] = tmp;
        maxHeap();
    }
  
    /**
     * Go down the tree and make sure it maintains max heap property, swapping any items that break this rule.
     * 
     * @param pos 
     */
    private void siftDown(int pos)
    {
        int root = pos;
        
        // if root only has 1 child
        if ((root + 1) == size) 
        {
            // and that child is more than root
            if (((PriorityItem<T>) storage[root+1]).getPriority() > ((PriorityItem<T>) storage[root]).getPriority())
            {
                // swap them
                swap(root, root + 1);
            }
        }
        
        // while root has 2 children
        while ((root * 2 + 1) <= size) 
        {
            int child = root * 2 + 1; // root*2 + 1 points
            
            // if left child is less than right child
            if(child + 1 <= size && ((PriorityItem<T>) storage[child]).getPriority() > ((PriorityItem<T>) storage[child+1]).getPriority())
            {
                // swap them
                swap(child, child + 1);
                child = child + 1; // then point to the right child instead
                siftDown(child); // make sure everything from that point maintains heap priority too
            }
           
            // if root is less than child
            if (((PriorityItem<T>) storage[root]).getPriority() < ((PriorityItem<T>) storage[child]).getPriority())
            {
                // swap them
                swap(root, child);
                siftDown(child); // make sure everything from that point maintains heap priority too
            }
            
            // if root is less than other child
            else if (child + 1 <= size && ((PriorityItem<T>) storage[root]).getPriority() < ((PriorityItem<T>) storage[child+1]).getPriority())
            {
                 swap(root, child + 1);
                 siftDown(child);
             }
            else
            {
                // if root is not smaller than its children, check the entire tree to make sure that it is in correct order.
                // if it is, exit the while loop.
                checkTree();
                return;
            }
        }
    }
    
    /**
     * Recursive method to keep checking entire tree until all children are less than their parents.
     * Swaps the child with the parent if it is less.
     */
    private void checkTree()
    {
        // count number of times something had to be swapped
        int badCount = 0;
        
        for (int i = 1; (i*2)+1 <= size; i++)
        {
                if ((((PriorityItem<T>) storage[i]).getPriority() < ((PriorityItem<T>) storage[i*2]).getPriority()) || ((PriorityItem<T>) storage[i]).getPriority() < ((PriorityItem<T>) storage[(i*2)+1]).getPriority())
                {
                    swap(i, i*2);

                    badCount++;
                } 
        }
        
        // if something had to be swapped, check again to make sure that it is in correct order after swap
        if (badCount > 0)
        {
            checkTree();
        }
    }
    
    /**
     * Check entire tree to make sure it is maintaining max heap property
     */
    private void maxHeap()
    {
        for (int i = (size / 2 - 1); i>=FRONT; i--)
        {
            siftDown(i);
        }
    }
            
    @Override
    public void add(T item, int priority) throws QueueOverflowException {
        
        size++;
        storage[size] = new PriorityItem(item, priority);
        int current = size;
        int parentCurrent;
        
        // if the current is the front of the queue then it has no parent
        if (current == 1)
        {
            parentCurrent = 1;
        }
        else
        {
            parentCurrent = current / 2;
        }

        // if current is more than its parent, swap them
        while (((PriorityItem<T>) storage[current]).getPriority() > ((PriorityItem<T>) storage[parentCurrent]).getPriority())
        {
            swap(current, parent(current));
            current = parent(current);
            checkTree();
        }
        
        // if the left child is less than the right child
        if (current*2+1 <= size && ((PriorityItem<T>) storage[current*2]).getPriority() < ((PriorityItem<T>) storage[(current*2)+1]).getPriority())
        {
            swap(current*2, (current*2)+1);
        }
        
        // then make sure entire tree is maintaining max heap property after the swap
        siftDown(FRONT);
        
    }

    @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty())
        {
            throw new QueueUnderflowException();
        }
        else
        {
            return ((PriorityItem<T>) storage[FRONT]).getItem();
        }
    }

    @Override
    public void remove() throws QueueUnderflowException {
        if (isEmpty())
        {
            throw new QueueUnderflowException();
        }
        else
        {
            // replace the front item with the last item, reduce the size and then reorder the tree
            storage[FRONT] = storage[size];
            size = size - 1;
            siftDown(FRONT);
            
        }
    }

    @Override
    public boolean isEmpty() {
        return size < FRONT;
    }
    
    @Override
    public String toString()
    {
        String result = "[";
        for (int i = FRONT; i <= size; i++)
        {
            if (i > FRONT)
            {
                result = result + ", ";
            }
            result = result + storage[i];
        }
        result = result + "]";
        return result;
    }
    
}
