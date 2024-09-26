package ExampleStack;

public class circularQueue {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    // using one pointer method: end

    protected int end = 0;
    protected int front = 0;
    private int size = 0;

    public circularQueue() {
        this(DEFAULT_SIZE);
    }
    public circularQueue(int size){
        this.data = new int[size];
    }

    public boolean isFull() {
        return size == data.length; // pointer is at the last index, so end modulo size.
    }

    public boolean isEmpty(){
        return end == 0; // pointer pointing to -1 index.
    }
    public boolean insert(int item){
        if(isFull()){
            System.out.println("Queue is Full!!");
            return false;
        }
        data[end] = item;
        end = end % data.length;
        size++;
        end++;
        return true;
    }

    public int remove() throws Exception{
        if (isEmpty()){
            throw new Exception("Queue is Empty");
        }
        int removed = data[front++]; // remove the first element in the array.
        front = front % data.length;
        size--;
        return removed;
    }

    public int front() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is Empty!!");
        }
        return data[front];
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Empty!");
            return;
        }
        int i = front;
        do {
            System.out.print(data[i] +" -> ");
            i = i % data.length;
            i++;
        }while(i != end);
        System.out.println("END");
    }
}
