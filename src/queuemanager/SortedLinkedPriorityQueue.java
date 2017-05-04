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
public class SortedLinkedPriorityQueue<T> implements PriorityQueue<T> {
    
    /**
     * Stores the head of the queue.
     */
    private PriorityItem<T> top;


    public SortedLinkedPriorityQueue()
    {
        top = null;
    }
    
    @Override
    public void add(T item, int priority) throws QueueOverflowException {
            PriorityItem<T> node = top;
            
            if(top == null)
            {
                top = new PriorityItem<T>(item, priority);
            }
            
            while(node != null)
            {
                // if there is no next node, add the new one after the current one.
                if (node.getNext() == null)
                {
                    if (priority > node.getPriority())
                    {
                        // if the priority of added item is larger than the priority of the current node
                        PriorityItem<T> tempNode = node;
                        // if the top item is the node
                        if (top == node)
                        {
                            top = new PriorityItem<T>(item, priority);
                            top.setNextItem(tempNode);
                        }
                        else
                        {
                            node = new PriorityItem<T>(item, priority);
                            node.setNextItem(tempNode);
                        }
                    }
                    else
                    {
                        node.setNext(item, priority);
                    }
                    break;
                }
                // if there is a next node...
                else
                {
                    // if it is higher priority than the top item
                    PriorityItem<T> tempNode = node; 
                    if (priority > node.getPriority() && top == node)
                    {
                        top = new PriorityItem<T>(item, priority);
                        top.setNextItem(tempNode);
                        break;
                        
                    }
                    // and it is higher priority than the current, set the current to the next.
                     else if (priority < node.getNext().getPriority())
                    {
                        node = node.getNext();
                    }
                     else
                    {
                        // else, insert it between them.
                        PriorityItem<T> newItem = new PriorityItem<T>(item, priority);
                        newItem.setNextItem(node.getNext());
                        node.setNextItem(newItem);
                        break;
                    }
              }
            }
            
            

    }

    @Override
    public T head() throws QueueUnderflowException {
      if (isEmpty())
      {
          throw new QueueUnderflowException();
      }
      return top.getItem();
    }

    @Override
    public void remove() throws QueueUnderflowException {
        if (isEmpty())
        {
            throw new QueueUnderflowException();
        }
        else
        {
            top = top.getNext();
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
