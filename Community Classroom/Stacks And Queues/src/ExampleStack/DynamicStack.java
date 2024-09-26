package ExampleStack;

public class DynamicStack extends customStack{
    public DynamicStack() {
        super(); // it will call customStack
    }
    public DynamicStack(int size){
        super(size); // this will call customStack(int size)
    }

    @Override
    public boolean push(int item) {
        // this take care of being full.
        if(this.isFull()){
            // double the array size.
            int[] temp = new int [data.length * 2];

            // copy all previous items in new data.
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }

            data = temp;
        }
        // at this point we know that array is not full, so we can insert item normally.
        // insert item
        return super.push(item);
    }
}
