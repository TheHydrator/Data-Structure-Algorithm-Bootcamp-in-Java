package ExampleStack;

public class QueueMain {
    public static void main(String[] args) throws Exception{
        circularQueue queue = new circularQueue(6);
        queue.insert(10);
        queue.insert(15);
        queue.insert(20);
        queue.insert(25);
        queue.insert(30);

        queue.display();
        System.out.println(queue.remove());
        queue.insert(5);
        queue.display();

    }
}
