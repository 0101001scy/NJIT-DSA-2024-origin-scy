package oy.tol.tra;
public class StackImplementation<E> implements StackInterface<E> {  
    private Object[] itemArray;  
    private int capacity;  
    private int currentIndex = -1;  
    private static final int DEFAULT_STACK_SIZE = 10;  
  
    public StackImplementation() throws StackAllocationException {  
        this(DEFAULT_STACK_SIZE);  
    }  
  
    public StackImplementation(int capacity) throws StackAllocationException {  
        if (capacity < 2) {  
            throw new StackAllocationException("Stack size must be at least 2.");  
        }  
        try {  
            this.itemArray = new Object[capacity];  
            this.capacity = capacity;  
        } catch (OutOfMemoryError e) {  
            throw new StackAllocationException("Failed to allocate memory for stack.");  
        }  
    }  
  
    @Override  
    public int capacity() {  
        return capacity;  
    }  
  
    @Override  
    public void push(E element) throws StackAllocationException, NullPointerException {  
        if (currentIndex == capacity - 1) {  
            throw new StackAllocationException("Stack is full, cannot push element.");  
        }  
        if (element == null) {  
            throw new NullPointerException("Cannot push null element into stack.");  
        }  
        itemArray[++currentIndex] = element;  
    }  
  
    @SuppressWarnings("unchecked")  
    @Override  
    public E pop() throws StackIsEmptyException {  
        if (isEmpty()) {  
            throw new StackIsEmptyException("Stack is empty, cannot pop element.");  
        }  
        return (E) itemArray[currentIndex--];  
    }  
  
    @SuppressWarnings("unchecked")  
    @Override  
    public E peek() throws StackIsEmptyException {  
        if (isEmpty()) {  
            throw new StackIsEmptyException("Stack is empty, cannot peek element.");  
        }  
        return (E) itemArray[currentIndex];  
    }  
  
    @Override  
    public int size() {  
        return currentIndex + 1;  
    }  
  
    @Override  
    public void clear() {  
        currentIndex = -1;  
    }  
  
    @Override  
    public boolean isEmpty() {  
        return currentIndex == -1;  
    }  
  
    @Override  
    public String toString() {  
        StringBuilder builder = new StringBuilder("[");  
        for (int index = 0; index <= currentIndex; index++) {  
            builder.append(itemArray[index].toString());  
            if (index < currentIndex) {  
                builder.append(", ");  
            }  
        }  
        builder.append("]");  
        return builder.toString();  
    }

	public StackInterface<Integer> getStackContents() {
		return null;
	}

	@Override
	public Object stream() {
		throw new UnsupportedOperationException("Unimplemented method 'stream'");
	}  
  
      
}