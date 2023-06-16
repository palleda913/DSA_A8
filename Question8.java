package in.ineuron;


public class Question8 {
    public static boolean canSwapLetters(String s, String goal) {
        if(s.length()!=goal.length())
        	return false;
        
        int start=0;
        int end=goal.length()-1;
        while(start<s.length()) {
            if (s.charAt(start) != goal.charAt(end)) {
               return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ab";
        String goal = "ba";
        boolean result = canSwapLetters(s, goal);

        System.out.println("Can swap letters: " + result);
    }
}