package in.ineuron;

public class Question3 {

	public static int minStepsRequired(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] arr = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                } else {
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
                }
            }
        }

        int lcsLength = arr[m][n];
        return m + n - 2 * lcsLength;
    }

    public static void main(String[] args) {
        String word1 = "seea";
        String word2 = "eat";
        int steps = minStepsRequired(word1, word2);
        System.out.println(steps); 
    }
}

