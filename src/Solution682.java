import java.util.Stack;

public class Solution682 {

    /**
     * 棒球比赛
     * @param ops
     * @return
     */
    public int calPoints(String[] ops) {
        Stack<String> stack=new Stack<>();
        Stack<String> stackB=new Stack<>();
        int grade=0;
        for (int i = 0; i < ops.length; i++) {
            String op=ops[i];
            if (op.equals("C")){
                //表示您获得的最后一个有效回合的分数是无效的，应该被移除。
                stack.pop();
            }else if (op.equals("D")){
                //表示本轮获得的得分是前一轮有效回合得分的两倍。
                int num=Integer.parseInt(stack.peek());
                stack.push(String.valueOf(num*2));
            }else if (op.equals("+")){
                //表示本轮获得的得分是前两轮有效回合得分的总和。
                stackB.push(stack.pop());
                int a=Integer.parseInt(stack.peek());
                int b=Integer.parseInt(stackB.peek());
                int c=a+b;
                stack.push(stackB.pop());
                stack.push(String.valueOf(c));
            }else{
                stack.push(op);
            }
        }
        while (!stack.isEmpty()){
            grade+=Integer.parseInt(stack.pop());
        }
        return grade;
    }

    public static void main(String[] args) {
        Solution682 solution=new Solution682();
        String[] a={"5","2","C","D","+"};
        String[] b={"5","-2","4","C","D","9","+","+"};
        System.out.println(solution.calPoints(a));
        System.out.println(solution.calPoints(b));
    }
}
