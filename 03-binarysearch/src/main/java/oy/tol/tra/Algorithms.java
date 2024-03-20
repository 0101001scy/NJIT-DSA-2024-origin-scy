package oy.tol.tra;

public class Algorithms { 
    public static <T> void reverse(T[] array) {  
        int left = 0;  
        int right = array.length - 1;  
        while (left < right) {  
            T temp = array[left];  
            array[left] = array[right];  
            array[right] = temp;  
            left++;  
            right--;  
        }  
    }  
     
    public static <T extends Comparable<T>> void sort(T[] array) { 
        for (int i = 0; i < array.length - 1; i++) {  
            for (int j = 0; j < array.length - i - 1; j++) {  
                if (array[j].compareTo(array[j + 1]) > 0) {  
                    T temp = array[j];  
                    array[j] = array[j + 1];  
                    array[j + 1] = temp;  
                }  
            }  
        }
    }
     
                public static <T extends Comparable<T>> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex) {  
                    while (fromIndex <= toIndex) {  
                        int mid = fromIndex + (toIndex - fromIndex) / 2;  
                          
                        if (aValue.compareTo(fromArray[mid]) == 0) {  
                            return mid;   
                        } else if (aValue.compareTo(fromArray[mid]) < 0) {  
                            toIndex = mid - 1;  
                        } else {  
                            fromIndex = mid + 1; 
                        }  
                    }  
                      
                    return -1;  
                }  
            

    
     public static <E extends Comparable<E>> void fastSort(E[] array) {  
        quickSort(array, 0, array.length - 1);  
    }  
      
    public static <E extends Comparable<E>> void quickSort(E[] array, int begin, int end) {  
        if (begin < end) {  
            int pivotIndex = partition(array, begin, end);  
            quickSort(array, begin, pivotIndex - 1); // Sort before pivot  
            quickSort(array, pivotIndex + 1, end); // Sort after pivot  
        }  
    }  
      
    private static <E extends Comparable<E>> int partition(E[] array, int begin, int end) {  
        E pivot = array[begin]; // First element as pivot  
        int i = begin + 1; // Index for smaller elements  
        int j = end; // Index for larger elements  
      
        while (true) {  
            // Move pointer i until we find an element greater than or equal to pivot  
            while (i <= j && array[i].compareTo(pivot) < 0) {  
                i++;  
            }  
            // Move pointer j until we find an element smaller than or equal to pivot  
            while (i <= j && array[j].compareTo(pivot) > 0) {  
                j--;  
            }  
            if (i > j) {  
                break;  
            }  
            // Swap elements at i and j  
            E temp = array[i];  
            array[i] = array[j];  
            array[j] = temp;  
        }  
        // Swap pivot with element at index j  
        E temp = array[begin];  
        array[begin] = array[j];  
        array[j] = temp;  
        return j; // Return pivot index  
    }
     
}