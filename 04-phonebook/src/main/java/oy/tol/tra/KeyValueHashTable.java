package oy.tol.tra;
  
public class KeyValueHashTable<K extends Comparable<K>, V> implements Dictionary<K, V> {

    // This should implement a hash table.

    private Pair<K, V>[] values = null;
    private int count = 0;
    private int collisionCount = 0;
    private int maxProbingSteps = 0;
    private int reallocationCount = 0;
    private static final double LOAD_FACTOR = 0.45;
    private static final int DEFAULT_CAPACITY = 20;

    
    public KeyValueHashTable(int capacity) throws OutOfMemoryError {
        ensureCapacity(capacity);
    }

    public KeyValueHashTable() throws OutOfMemoryError {
        ensureCapacity(DEFAULT_CAPACITY);
    }

    @Override
    public Type getType() {
        return Type.NONE;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void ensureCapacity(int capacity) throws OutOfMemoryError {
        if (capacity < DEFAULT_CAPACITY) {
            capacity = DEFAULT_CAPACITY;
        }
        values = (Pair<K, V>[]) new Pair[(int) ((double) capacity * (1.0 + LOAD_FACTOR))];
        reallocationCount = 0;
        count = 0;
        collisionCount = 0;
        maxProbingSteps = 0;
    }

    @Override
    public int size() {
        //  Implement this.
        return 0;
    }
 
    @Override
    public String getStatus() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Hash table load factor is %.2f%n", LOAD_FACTOR));
        builder.append(String.format("Hash table capacity is %d%n", values.length));
        builder.append(String.format("Current fill rate is %.2f%%%n", (count / (double)values.length) * 100.0));
        builder.append(String.format("Hash table had %d collisions when filling the hash table.%n", collisionCount));
        builder.append(String.format("Hash table had to probe %d times in the worst case.%n", maxProbingSteps));
        builder.append(String.format("Hash table had to reallocate %d times.%n", reallocationCount));
        return builder.toString();
    }

    @Override
    public boolean add(K key, V value) throws IllegalArgumentException, OutOfMemoryError {
        if (key == null || value == null) {  
            throw new IllegalArgumentException("Key and value cannot be null");  
        }    
        if (shouldReallocate()) {  
            reallocate((int)((double)(values.length) * (1.0 / LOAD_FACTOR)));  
        }     
        int hash = key.hashCode();
        int index = hash % values.length;    
        while (values[index] != null) {              
            if (values[index].getKey().equals(key)) {  
                values[index] = new Pair<>(key, value);  
                return true;  
            }              
            index = (index + 1) % values.length;  
            collisionCount++;               
            if (collisionCount > maxProbingSteps) {                  
            }  
        }     
        values[index] = new Pair<>(key, value);  
        count++;  
        return true;  
    }  

    
    @Override  
public V find(K key) throws IllegalArgumentException {  
    
    if (key == null) {  
        throw new IllegalArgumentException("Key cannot be null");  
    }  
    int hash = key.hashCode();
    int index = hash % values.length;
    
    while (values[index] != null) {  
        if (values[index].getKey().equals(key)) {  
           
            return values[index].getValue();  
        }  
        
        index = (index + 1) % values.length;  
    }  
   
    return null;  
}

    @Override
    @java.lang.SuppressWarnings({"unchecked"})
    public Pair<K,V> [] toSortedArray() {
        Pair<K, V> [] sorted = (Pair<K,V>[])new Pair[count];
        int newIndex = 0;
        for (int index = 0; index < values.length; index++) {
           if (values[index] != null) {
              sorted[newIndex++] = new Pair<>(values[index].getKey(), values[index].getValue());
           }
        }
        Algorithms.fastSort(sorted);
        return sorted;
      }
      private boolean shouldReallocate() {  
        return ((double)count / values.length) > LOAD_FACTOR;  
    }  
    @SuppressWarnings("unchecked")
    private void reallocate(int i) throws OutOfMemoryError {
        if (count < DEFAULT_CAPACITY) {
            count = DEFAULT_CAPACITY;
        }
        reallocationCount++;
        Pair<K, V>[] oldPairs = values;
        this.values = (Pair<K, V>[]) new Pair[(int)((double)count * (1.0 + LOAD_FACTOR))];
        count = 0;
        collisionCount = 0;
        maxProbingSteps = 0;
        for (int index = 0; index < oldPairs.length; index++) {
            if (oldPairs[index] != null) {
                add(oldPairs[index].getKey(), oldPairs[index].getValue());
            }
        }
    }

    @Override
    public void compress() throws OutOfMemoryError {
        int newCapacity = (int)(count * (1.0 / LOAD_FACTOR));
		    if (newCapacity < values.length) {
			      reallocate(newCapacity);
		    } 
    }
 
}
