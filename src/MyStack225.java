import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈
 */
class MyStack225 {

    Queue<Integer> queueA;
    Queue<Integer> queueB;

    /** Initialize your data structure here. */
    public MyStack225() {
        queueA=new LinkedList<>();
        queueB=new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queueA.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int queueSize=queueA.size();
        for (int i = 0; i < queueSize-1; i++) {
            queueB.add(queueA.poll());
        }
        while (!queueB.isEmpty()){
            queueA.add(queueB.poll());
        }
        return queueA.poll();
    }

    /** Get the top element. */
    public int top() {
        int queueSize=queueA.size();
        int num;
        for (int i = 0; i < queueSize-1; i++) {
            queueB.add(queueA.poll());
        }
        num=queueA.peek();
        queueB.add(queueA.poll());
        while (!queueB.isEmpty()){
            queueA.add(queueB.poll());
        }
        return num;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queueA.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */