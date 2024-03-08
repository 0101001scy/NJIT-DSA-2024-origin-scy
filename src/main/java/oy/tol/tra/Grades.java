package oy.tol.tra;  
  public class Grades {  
   private Integer[] grades = null;  
  
   public Grades(Integer[] grades) {  
      this.grades = grades;     
   }  
   public void reverse() {      
      Algorithms.reverse(grades);  
   }  
   public void sort() {   
      Algorithms.sort(grades);  
   }  
   public Integer[] getArray() {  
      return grades;  
   }  
}