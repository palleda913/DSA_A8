package in.ineuron;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Question4 {
    public static TreeNode buildTree(String s) {
        if (s.isEmpty() || s.equals("()")) {
            return null;
        }

        int i = s.indexOf('(');

        int value = Integer.parseInt(s.substring(0, i));
        TreeNode root = new TreeNode(value);

        int j = findClosingParenthesis(s, i);
        root.left = buildTree(s.substring(i + 1, j));
        root.right = buildTree(s.substring(j + 2, s.length() - 1));

        return root;
    }

    private static int findClosingParenthesis(String s, int start) {
        int count = 0;
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
                if (count == 0) {
                    return i;
                }
            }
        }
        return -1; // Invalid input
    }

    public static void main(String[] args) {
        String input = "4(2(3)(1))(6(5))";
        TreeNode root = buildTree(input);

        // Testing the constructed binary tree
        System.out.println("Root value: " + root.val);
        System.out.println("Left child value: " + root.left.val);
        System.out.println("Right child value: " + root.right.val);
    }
}
