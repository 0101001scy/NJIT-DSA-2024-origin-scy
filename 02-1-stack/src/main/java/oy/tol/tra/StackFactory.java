package oy.tol.tra;
  
public class StackFactory {
   private StackFactory() {
   }
    public static StackInterface<Integer> createIntegerStack() {
      return new StackImplementation<>();
   }
   public static StackInterface<Integer> createIntegerStack(int capacity) {
      return new StackImplementation<>(capacity);
   }
   public static String stackToString(StackInterface<Integer> stack) {  
      if (stack.isEmpty()) {  
          return "[]";  
      }  
      StringBuilder sb = new StringBuilder("[");  
      int temp;  
      boolean first = true;  
      while (!stack.isEmpty()) {  
          temp = stack.pop();  
          if (!first) {  
              sb.append(", ");  
          }  
          sb.append(temp);  
          first = false;  
      }  
      sb.append("]");  
      return sb.toString();  
  }   
   public static void stackString() {  
       StackInterface<Integer> stack = StackFactory.createIntegerStack();  
       stack.push(110);  
       stack.push(119);  
       stack.push(121);  
 
       String stackString = StackFactory.stackToString(stack);  
       System.out.println(stackString);  
   }  
}
  
 
