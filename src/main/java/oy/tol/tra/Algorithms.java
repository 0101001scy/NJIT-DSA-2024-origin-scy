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
}