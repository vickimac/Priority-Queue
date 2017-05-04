package queuemanager;

/**
 * A wrapper for bundling up an item and its integer priority.
 * 
 * @param <T>
 */
public class PriorityItem<T> {

    private final T item;
    private final int priority;
    private PriorityItem<T> next = null;

    public PriorityItem(T item, int priority) {
        this.item = item;
        this.priority = priority;
    }

    public T getItem() {
        return item;
    }

    public int getPriority() {
        return priority;
    }
    
    public PriorityItem<T> getNext()
    {
        return next;
    }
    
    public void setNext(T newItem, int priority)
    {
        this.next = new PriorityItem<T>(newItem, priority);
    }
    
    public void setNextItem(PriorityItem<T> prioItem)
    {
        this.next = prioItem;
    }

    @Override
    public String toString() {
        return "(" + getItem() + ", " + getPriority() + ")";
    }
}
