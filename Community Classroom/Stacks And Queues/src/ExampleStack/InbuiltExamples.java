package ExampleStack;

import java.util.*;

public class InbuiltExamples {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(15);
        stack.push(20);
        stack.push(25);
        stack.push(30);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(15);
        queue.add(20);
        queue.add(25);
        queue.add(30);

        System.out.println(queue.peek());
        System.out.println(queue.remove());
        System.out.println(queue.peek());

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(10);
        deque.addLast(18);
        deque.addLast(40);
        deque.removeFirst();
        deque.add(20);
        deque.add(30);
        System.out.println(deque);

    }
}
