package in.ineuron;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question6 {

	public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) {
            return result;
        }

        Map<Character, Integer> pFreq = new HashMap<>();
        Map<Character, Integer> windowFreq = new HashMap<>();

        // Calculate frequency of characters in p
        for (char c : p.toCharArray()) {
            pFreq.put(c, pFreq.getOrDefault(c, 0) + 1);
        }

        int start = 0;
        int end = 0;
        int windowSize = p.length();

        while (end < s.length()) {
            char rightChar = s.charAt(end);
            windowFreq.put(rightChar, windowFreq.getOrDefault(rightChar, 0) + 1);

            if (end - start + 1 == windowSize) {
                // Check if window is an anagram
                if (pFreq.equals(windowFreq)) {
                    result.add(start);
                }

                char leftChar = s.charAt(start);
                windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);

                if (windowFreq.get(leftChar) == 0) {
                    windowFreq.remove(leftChar);
                }

                start++;
            }

            end++;
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> indices = findAnagrams(s, p);

        System.out.println("Start indices of anagrams: " + indices);
    }
}
