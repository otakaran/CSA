/**
 * Write a description of class ArrayMistakes here.
 * 
 * @author Otakar Andrysek
 * @version 1.0
 */
public class ArrayMistakes
{
      public static void main()
      {
          int[] nums = new int[4];
          
          nums[0]=6;
          nums[1]=9;
          nums[2]=14;
          nums[3]=19;

          System.out.print("\nForward");
          for (int i = 0; i < nums.length; i++) 
          {
              System.out.print(": " + nums[i]);
          }
        
          System.out.print("\nBackward" );
          for (int i = nums.length - 1; i >= 0; i--) 
          { 
              System.out.print(": " + nums[i]);
          }
        }
}