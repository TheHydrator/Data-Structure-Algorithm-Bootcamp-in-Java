package HeapDataStructures;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) throws Exception{
        Heap<Integer> heap = new Heap<>();
        heap.insert(10);
        heap.insert(20);
        heap.insert(15);
        heap.insert(40);
        heap.insert(50);

//        System.out.println(heap.remove());
//        System.out.println(heap.remove());
//        System.out.println(heap.remove());

        ArrayList<Integer> list = heap.heapSort(); // time complexity is O(nlog(n)).
        System.out.println(list);

    }
}
