import java.util.Stack;

public class MyQueue232 {
    /**
     * 用栈实现队列
     */

    Stack<Integer> stack;
    Stack<Integer> stackB;

    /** Initialize your data structure here. */
    public MyQueue232() {
        stack=new Stack<>();
        stackB=new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (stack.size()>1){
            stackB.push(stack.pop());
        }
        int popNum=stack.pop();
        while (!stackB.isEmpty()){
            stack.push(stackB.pop());
        }
        return popNum;
    }

    /** Get the front element. */
    public int peek() {
        while (!stack.isEmpty()){
            stackB.push(stack.pop());
        }
        int popNum=stackB.peek();
        while (!stackB.isEmpty()){
            stack.push(stackB.pop());
        }
        return popNum;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue232 obj = new MyQueue232();
        obj.push(1);
        obj.push(2);
        int a=obj.peek();  // 返回 1
        int b=obj.pop();   // 返回 1
        boolean c=obj.empty(); // 返回 false
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */