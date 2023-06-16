package in.ineuron;

import java.util.Stack;

public class Question7 {
	
	public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();

        int count = 0;
        String currentString = "";

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                count = count * 10 + (c - '0');
            } else if (c == '[') {
                countStack.push(count);
                stringStack.push(currentString);
                count = 0;
                currentString = "";
            } else if (c == ']') {
                StringBuilder sb = new StringBuilder(stringStack.pop());
                int repeatCount = countStack.pop();

                for (int i = 0; i < repeatCount; i++) {
                    sb.append(currentString);
                }

                currentString = sb.toString();
            } else {
                currentString += c;
            }
        }

        return currentString;
    }

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        String decodedString = decodeString(s);

        System.out.println("Decoded string: " + decodedString);
    }


}
