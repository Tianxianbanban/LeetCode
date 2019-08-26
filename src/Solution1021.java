import java.util.Stack;

class Solution1021 {
    /**
     * 删除最外层的括号
     * @param S
     * @return
     */
    public String removeOuterParentheses(String S) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        Stack<Character> stackB = new Stack<>();
        int left = 0;
        int right = 0;
        for (int i = 0; i < S.length(); i++) {
            char a = S.charAt(i);
            if (a == '(') {
                left++;
                stack.push(a);
            } else {
                right++;
                stack.push(a);
            }
            if (left == right) {
                stack.pop();
                while (stack.size() > 1) {
                    stackB.push(stack.pop());
                }
                stack.pop();
                while (!stackB.isEmpty()) {
                    result.append(stackB.pop());
                }
                left=0;
                right=0;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution1021 solution = new Solution1021();
        System.out.println(solution.removeOuterParentheses("(()())(())"));
        System.out.println(solution.removeOuterParentheses("(()())(())(()(()))"));
        System.out.println(solution.removeOuterParentheses("()()"));
    }
}