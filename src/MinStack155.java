import java.util.Stack;

/**
 * 最小栈
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 */
class MinStack155 {
    Stack<Integer> stack;
    Stack<Integer> minNumStack;//栈中最小元素

    /**
     * initialize your data structure here.
     */
    public MinStack155() {
        stack = new Stack<>();
        minNumStack=new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minNumStack.isEmpty()){//如果min栈为空就直接压栈
            minNumStack.push(x);
        }else{
            if (x<=minNumStack.peek()){//否则和栈顶元素比较决定是否插入，
                // 保证栈顶元素是stack中所有元素中对应的最小值。
                minNumStack.push(x);
            }
        }

    }

    public void pop() {
        int num=stack.pop();
        if (num==minNumStack.peek()){
            minNumStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minNumStack.peek();
    }

    public static void main(String[] args) {
        MinStack155 minStack = new MinStack155();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();   // 返回 -3.
        minStack.pop();
        minStack.top();      // 返回 0.
        minStack.getMin();   // 返回 -2.


    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
