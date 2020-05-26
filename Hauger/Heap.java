public class Heap {

    private int[] heap;
    private int size;

    public Heap(int capasity) {
        heap = new int[capasity];
    }

    public void insert(int value) {
        if (isFull())
            throw new IndexOutOfBoundsException("Haugen er full");

        heap[size++] = value;

        fixHeadAbove(size);
        size++;
    }

    public int delete(int index) {
        if (isEmpty())
            throw new IndexOutOfBoundsException("Haug er tom");

        int parent = getParent(index);
        int deletedValue = heap[index];

        heap[index] = heap[size - 1];

        if (index == 0 || heap[index] < heap[parent])
            fixHeapBelow(index, size - 1);
        else
            fixHeadAbove(index);

        size--;
        return deletedValue;
    }

    private void fixHeapBelow(int index, int lastHeapIndex) {
        int childToSwap;

        while (index <= lastHeapIndex) {
            int leftChild = getChild(index, true);
            int rightChild = getChild(index, false);
            if (leftChild <= lastHeapIndex) {
                if (rightChild > lastHeapIndex)
                    childToSwap = leftChild;
                else
                    childToSwap = heap[leftChild] > heap[rightChild] ? leftChild : rightChild;

                if (heap[index] < heap[childToSwap]) {
                    int temp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = temp;
                }
                else
                    break;

                index = childToSwap;
            }
            else
                break;
        }
    }

    public void fixHeadAbove(int index) {
        int newValue = heap[index];
        while (index > 0 && newValue > heap[getParent(index)]) {
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }

        heap[index] = newValue;
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i]);
            System.out.print(", ");
        }
        System.out.println();
    }

    public boolean isFull() {
        return size == heap.length;
    }

    public int getParent(int index) {
        return (index - 1) / 2; // Trenger ikke å bruke floor() fordi vi bruker int, som ved divisjon, rundes ned til første hele tall
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getChild(int index, boolean left) {
        return 2 * index + (left ? 1 : 2); // Ternary-uttryk

    }

}
