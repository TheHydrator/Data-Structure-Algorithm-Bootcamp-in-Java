package ExampleStack;

public class customQueue {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    // using one pointer method: end

    int end = 0;

    public customQueue() {
         this(DEFAULT_SIZE);
    }
    public customQueue(int size){
        this.data = new int[size];
    }

    public boolean isFull() {
        return end == data.length; // pointer is at the last index.
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
        end++;
        return true;
    }

    public int remove() throws Exception{
        if (isEmpty()){
            throw new Exception("Queue is Empty");
        }
        int removed = data[0];
        // shift the elements to the left.
        for (int i = 1; i < end; i++) {
            data[i - 1] = data[i];
        }
        end--;
        return removed;
    }

    public int front() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is Empty!!");
        }
        return data[0];
    }

    public void display(){
        for (int i = 0; i < end; i++) {
            System.out.print(data[i] + " <- ");
        }
        System.out.println("END");
    }

}
