package in.ineuron;

import java.util.Stack;

public class Question2 {
	
	public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '*') {
                stack.push(ch);
            } else if (ch == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        int count=0;
        while (!stack.isEmpty()) {
            if (stack.pop() == '(') {
                count++;
            } else {
                if (count > 0) {
                    count--;
                }
            }
        }
        return count==0;
	}
	 
	 public static void main(String[] args) {
		  String s = "()(";
	      System.out.println(isValid(s));  
	 }
}

