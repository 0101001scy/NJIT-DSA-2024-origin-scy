package oy.tol.tra; 
import java.util.Arrays;  
  
public class QueueImplementation<E> implements QueueInterface<E> {  
    private static final int DEFAULT_CAPACITY = 10;  
    private Object[] values;  
    private int front;  
    private int rear;  
    private int size;  
    private int capacity;  
  
    public QueueImplementation() {  
        this(DEFAULT_CAPACITY);  
    }  
  
    public QueueImplementation(int capacity) {  
        this.capacity = capacity;  
        values = new Object[capacity];  
        front = 0;  
        rear = 0;  
        size = 0;  
    }  
    @Override  
    public int capacity() {  
        return capacity;  
    }  
  
    @Override  
public void enqueue(E element) throws QueueAllocationException {  
    if (size == capacity) {   
        size();  
    }  
    values[rear] = element;  
    rear = (rear + 1) % capacity;  
    size++;  
}

@Override  
@SuppressWarnings("unchecked")  
public E dequeue() throws QueueIsEmptyException {  
    if (isEmpty()) {  
        throw new QueueIsEmptyException("Queue is empty");  
    }  
    E element = (E) values[front];  
    values[front] = null;  
    front = (front + 1) % capacity;  
    size--;  
    return element;  
}  
  
@Override  
@SuppressWarnings("unchecked")  
public E element() throws QueueIsEmptyException {  
    if (isEmpty()) {  
        throw new QueueIsEmptyException("Queue is empty");  
    }  
    return (E) values[front];  
}
  
    @Override  
    public int size() {  
        return size;  
    }  
  
    @Override  
    public boolean isEmpty() {  
        return size == 0;  
    }  
  
    @Override  
    public void clear() {  
        Arrays.fill(values, null);  
        front = 0;  
        rear = 0;  
        size = 0;  
    }  
  
    @Override  
    public String toString() {  
        StringBuilder sb = new StringBuilder();  
        sb.append("values: ");  
        for (int i = 0; i < capacity; i++) {  
            sb.append(values[i] == null ? " " : values[i].toString()).append(" ");  
        }  
        sb.append("\nindex:  ");  
        for (int i = 0; i < capacity; i++) {  
            sb.append(i).append(" ");  
        }  
        sb.append("\nfront: ").append(front).append(" rear: ").append(rear).append("\n");  
        sb.append("size: ").append(size).append(" capacity: ").append(capacity);  
        return sb.toString();  
    }  
}