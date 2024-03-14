package oy.tol.tra;
 
   public class QueueFactory {  
      private QueueFactory() {         
      }  
      public static QueueInterface<Integer> createIntegerQueue(int capacity) {      
          QueueImplementation<Integer> queue = new QueueImplementation<>(10);   
          return queue;  
      }     
  }


    