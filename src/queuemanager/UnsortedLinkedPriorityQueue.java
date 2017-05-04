/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

/**
 *
 * @author Vicki
 */
public class UnsortedLinkedPriorityQueue<T> implements PriorityQueue<T> {

    /**
     * Stores the head of the queue
     */
    private PriorityItem<T> top;
    
    public UnsortedLinkedPriorityQueue()
    {
        top = null;
    }
    
    @Override
    public void add(T item, int priority) throws QueueOverflowException {
        if (top == null)
        {
            top = new PriorityItem<T>(item, priority);
        }
        else
        {
            PriorityItem<T> node = top;
            top = new PriorityItem<T>(item, priority);
            top.setNextItem(node);
        }
    }

    @Override
    public T head() throws QueueUnderflowException {
        PriorityItem<T> topPrioItem = top;
        
        // find any items higher than the priority of the top item, then save their position and see if there are more in the rest of the queue
        if (top != null)
        {
            for (PriorityItem<T> i = top; i != null; i = i.getNext())
            {
                if (i.getPriority() > topPrioItem.getPriority())
                {

                    topPrioItem = i;
                    if (i.getNext() != null)
                    {
                        i = i.getNext();
                    }
                    else
                    {
                        break;
                    }
                }
            }
            return topPrioItem.getItem();
        }
        else
        {
            throw new QueueUnderflowException();
        }
       
    }

    @Override
    public void remove() throws QueueUnderflowException {
        PriorityItem<T> beforeTopPrio = top;
        
        // similar to head, but find the item before the top priority instead
        // then point the before item to the item after the top priority
        // or if the top priority is the last in the queue, just make it point to null.
        if (top == null)
        {
            throw new QueueUnderflowException();
        }
        else
        {
            for (PriorityItem<T> i = top; i != null; i = i.getNext())
            {
                if (beforeTopPrio.getNext() != null && i.getNext() != null)
                {
                    // if item priority is more than the top prio
                    if (i.getNext().getPriority() > beforeTopPrio.getNext().getPriority())
                    {
                        
                        beforeTopPrio = i;
                        if (i.getNext() != null)
                        {
                            i = i.getNext();
                        }
                        else
                        {
                            break;
                        }
                    }
                }
                else
                {
                    break;
                }
            }
            if (top.getItem() == this.head())
            {
                top = top.getNext();
            }
            else if (beforeTopPrio.getNext().getNext() != null)
            {
                // set the next pointer of the item before the top prio to the one after the top item
                beforeTopPrio.setNextItem(beforeTopPrio.getNext().getNext());
            }
            else
            {
                beforeTopPrio.setNextItem(null);
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }
    
    @Override
    public String toString()
    {
        String result = "[";
        for (PriorityItem<T> node = top; node != null; node = node.getNext())
        {
            if (node != top)
            {
                result = result + ", ";
            }
            result = result + "(" + node.getItem() + ", " + node.getPriority() +")";
        }
        result = result + "]";
        return result;
    }
    
}
