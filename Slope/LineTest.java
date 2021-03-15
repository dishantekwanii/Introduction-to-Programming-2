package test3;

import java.util.Arrays;
public class LineTest {
   public static void main(String[] args) {
      
      Line l1 = new Line(1, 2, 3, 4);
      System.out.println(l1); 
    
      Line l2 = new Line(new Point(5,6), new Point(7,8)); 
      System.out.println(l2);  
      
      
      System.out.println(l1);  
     
      System.out.println("begin is: " + l1.getP1()); 
     
      System.out.println("end is: " + l1.getP2()); 
      
      System.out.printf("length is: %.2f%n", l1.slope())
   }
}