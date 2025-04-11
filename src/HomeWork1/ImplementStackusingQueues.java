package HomeWork1;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue1.offer(x);
    }

    public int pop() {
        if (empty()) {
            return -1;
        }

        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }

        int top = queue1.poll();
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return top;
    }

    public int top() {
        if (empty()) {
            return -1;
        }

        int top = 0;
        while (!queue1.isEmpty()) {
            top = queue1.poll();
            queue2.offer(top);
        }

        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return top;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}


