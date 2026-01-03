/* PalindromeCheck.java
   Author: ***
   Purpose: Checks if the string is a palindrome by using stacks
 */

import java.util.*;

public class PalindromeCheck {
   public static boolean isPalindrome(String input) {
      // Remove non-alphabetic characters and convert to lowercase for case-insensitive comparison
   
      Stack<Character> stack1 = new Stack<>();
      Stack<Character> stack2 = new Stack<>();
   
      // Push all characters onto the first stack
      for (char c : input.toCharArray()) {
         stack1.push(Character.toLowerCase(c));
         //Store all characters in lowercase
      }
   
      int length = stack1.size();
      int mid = length / 2;
   
      // Pop half of the characters from stack1 and push them onto stack2
      for (int i = 0; i < mid; i++) {
         stack2.push(stack1.pop());
      }
   
      // If the string has an odd number of characters, remove the middle character
      if (length % 2 != 0) {
         stack1.pop();
      }
   
      // Compare the two stacks
      while (!stack1.isEmpty() && !stack2.isEmpty()) {
         if (!stack1.pop().equals(stack2.pop())) {
            return false;
         }
      }
   
      // If both stacks are empty, the string is a palindrome
      return true;
   }

   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      System.out.println("PALINDROME CHECKER........");
      System.out.println("(Enter 'exit' to close the program)");
      String input;
   
      do {
         System.out.println("Enter the string: ");
         input = scan.next();
         if (input.equalsIgnoreCase("exit")) {
            System.out.println("Exiting the program.......");
            break;
         }
         boolean palindrome = PalindromeCheck.isPalindrome(input);
         if (palindrome) {
            System.out.println(input + " is a Palindrome");
         } else {
            System.out.println(input + " is not a Palindrome");
         }
      } while(! input.equalsIgnoreCase("exit"));
      scan.close();
   }
}
