package oy.tol.tra;
 
public class ParenthesisChecker {

   private ParenthesisChecker() {
   }
 
    public static int checkParentheses(StackInterface<Character> stack, String fromString) throws ParenthesesException {  
      int errorCount = 0;  
      for (int i = 0; i < fromString.length(); i++) {  
         char c = fromString.charAt(i);  
         if (isLeftParenthesis(c)) {  
            stack.push(c);  
         } else if (isRightParenthesis(c)) {  
            try {  
               char top = stack.pop();  
               if (!isMatchingPair(c, top)) {  
                  throw new ParenthesesException("Text has mismatched parenthesis types", ParenthesesException.MISMATCHED_PARENTHESIS_TYPES);  
               }  
            } catch (NoSuchElementException e) {  
               throw new ParenthesesException("Text has too many right parentheses", ParenthesesException.TOO_MANY_RIGHT_PARENTHESES);  
            }  
         }  
      }  
        
      if (!stack.isEmpty()) {  
         throw new ParenthesesException("Text has too many left parentheses", ParenthesesException.TOO_MANY_LEFT_PARENTHESES);  
      }  
        
      return errorCount;  
   }  
  
   private static boolean isLeftParenthesis(char c) {  
      return c == '(' || c == '[' || c == '{';  
   }  
  
   private static boolean isRightParenthesis(char c) {  
      return c == ')' || c == ']' || c == '}';  
   }  
  
   private static boolean isMatchingPair(char right, char left) {  
      return (right == ')' && left == '(') ||  
             (right == ']' && left == '[') ||  
             (right == '}' && left == '{');  
   }  
}
