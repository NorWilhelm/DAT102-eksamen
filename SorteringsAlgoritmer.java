package no.hvl.dat102.sortering;

import java.util.LinkedList;
import java.util.Queue;

public class SorteringsAlgoritmer {

    /**
     * Bubble Sort
     *
     * @param data - arrayen som skal bli sortert
     */
    public static <T extends Comparable<T>> void bubbleSort(T[] data) {
        for (int pos = data.length - 1; pos >= 0; pos--) {
            for (int scan = 0; scan <= pos - 1; scan++) {
                if (data[scan].compareTo(data[scan + 1]) > 0) {
                    swap(data, scan, scan+1);

                }
            }
        }

    }

    /**
     * Selection Sort
     *
     * @param data - arrayen som skal bli sortert
     */
    public static <T extends Comparable<T>> void selectionSort(T[] data) {
        int min;
        T temp;
        for (int index = 0; index < data.length - 1; index++) {
            min = index;
            for (int scan = index + 1; scan < data.length; scan++) {
                if (data[scan].compareTo(data[min]) < 0) {
                    min = scan;
                }
            }
            swap(data,min, index);
        }
    }

    /**
     * Hjelpemetode for å bytte to indexer i en array
     *
     * @param data - arrayen som skal bli sortert
     * @param index1 - den første indexen
     * @param index2 - den andre indexen
     */
    private static <T extends Comparable<T>> void swap(T[] data, int index1, int index2) {
        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

    /**
     * Insertion Sort
     *
     * @param data - arrayen som skal bli sortert
     */
    public static <T extends Comparable<T>> void insertionSort(T[] data) {
        for (int i = 1; i < data.length; i++) {
            T key = data[i];
            int position = i;

            while (position > 0 && data[position-1].compareTo(key) > 0) {
                data[position] = data[position-1];
                position--;
            }
            data[position] = key;
        }
    }

    // TODO - Shellsort

    /**
     * Merge Sort
     *
     * @param data - arrayen som skal bli sortert
     */
    public static <T extends Comparable<T>> void mergeSort(T[] data) {
        mergeSort(data, 0, data.length-1);
    }

    /**
     * Recursively sorts a range of objects in the specified array using the merge sort algorithm
     *
     * @param data - arrayen som skal bli sortert
     * @param min - Indexen av det første elementet
     * @param max - Indexen av det siste elementet
     */
    private static <T extends Comparable<T>> void mergeSort(T[] data, int min, int max) {
        if (min < max) {
            int mid = (min+max)/2;
            mergeSort(data, min, mid);
            mergeSort(data, mid+1, max);
            merge(data, min, mid, max);
        }
    }

    /**
     * Merges two sorted subarrays of the specified array
     *
     * @param data - arrayen som skal bli sortert
     * @param first the beginning index of the first subarray
     * @param mid the ending index of the first subarray
     * @param last the ending index of the second subarray
     */
    private static <T extends Comparable<T>> void merge(T[] data, int first, int mid, int last) {
        @SuppressWarnings("unchecked")
        T[] temp = (T[])(new Comparable[data.length]);

        int first1 = first; // start of first subarray, end is 'mid'
        int first2 = mid+1; // start of second subarray, end is 'last'
        int index = first1; // next index open in temp array

        /* copy smaller item from each subarray into temp until one of the subarrays is exhausted */
        while (first1 <= mid && first2 <= last) {
            if(data[first1].compareTo(data[first2]) < 0) {
                temp[index] = data[first1];
                first1++;
            } else {
                temp[index] = data[first2];
                first2++;
            }
            index++;
        }

        /* copy the remaining elements from first subarray, if any */
        while (first1 <= mid) {
            temp[index] = data[first1];
            first1++; index++;
        }

        /* copy the remaining elements from second subarray, if any */
        while (first2 <= last) {
            temp[index] = data[first2];
            first2++; index++;
        }

        /* copy merged data into original array */
        for (index = first; index <= last; index++) {
            data[index] = temp[index];
        }
    }

    /**
     * Quick Sort
     *
     * @param data - arrayen som skal bli sortert
     */
    public static <T extends Comparable<T>> void quickSort(T[] data) {
        quickSort(data, 0, data.length-1);
    }

    /**
     * KvikkSort med min og max verdi
     *
     * @param data - arrayen som skal bli sortert
     * @param min - den minste indexen i partisjonen som skal sorteres
     * @param max - den største indexen i partisjonen som skal sorteres
     */
    public static <T extends Comparable<T>> void quickSort(T[] data, int min, int max) {
        if (min < max) {
            /* create partition */
            int indexOfPartition = partition(data, min, max);
            /* sort the left partition (lower values) */
            quickSort(data, min, indexOfPartition-1);
            /* sort the right partition (higher values) */
            quickSort(data, indexOfPartition+1, max);
        }
    }

    /**
     * Used by the quick sort algorithm to find the partition
     *
     * @param data - arrayen som skal bli sortert
     * @param min - den minste indexen i partisjonen som skal sorteres
     * @param max - den største indexen i partisjonen som skal sorteres
     * @return the index of the partition value
     */
    private static <T extends Comparable<T>> int partition(T[] data, int min, int max) {
        T partitionelement;
        int left, right;
        int middle = (min+max)/2;

        /* use the middle data value as the partition element */
        partitionelement = data[middle];

        /* move it out of the way for now */
        swap(data, middle, min);
        left = min;
        right = max;

        while (left < right) {
            /* search for an element that is smaller than the partition element */
            while (left < right && data[left].compareTo(partitionelement) <= 0) {
                left++;
            }
            /* search for an element that is bigger than the partition element */
            while (data[right].compareTo(partitionelement) > 0) {
                right--;
            }

            /* swap the elements */
            if (left < right) {
                swap(data, left, right);
            }
        }
        /* move the partition element into place */
        swap(data, min, right);
        return right;
    }

    // TODO - CountingSort



    /**
     * Radix Sort (must be an Integer array)
     *
     * @param data - arrayen som skal bli sortert
     *
     */
    public static void radixSort(Integer[] data) {
        String temp;
        Integer numObj;
        int digit, num;

        @SuppressWarnings("unchecked")
        Queue<Integer>[] digitQueues = (LinkedList<Integer>[]) (new LinkedList[10]);

        /* create linked list inside the queue */
        for (int digitVal = 0; digitVal <= 9; digitVal++) {
            digitQueues[digitVal] = new LinkedList<>();
        }

        /* sort the list */
        for (int position = 0; position <= 3; position++) {

            for (Integer datum : data) {
                /* format the string to have 4 digits (by adding 0's to the front) to account for numbers below 1000
                 *  i.e. 78 -> 0078 */
                temp = String.format("%04d", datum);
                digit = Character.digit(temp.charAt(3 - position), 10);
                digitQueues[digit].add(datum);
            }

            /* gather numbers back into list */
            num = 0;
            for (int digitVal = 0; digitVal <= 9; digitVal++) {
                while (!digitQueues[digitVal].isEmpty()) {
                    numObj = digitQueues[digitVal].remove();
                    data[num] = numObj;
                    num++;
                }
            }

        }

    }

    // 4d)

    private static final int MIN = 10;

    /**
     * Insertion Sort which can sort subarrays
     *
     * @param data - arrayen som skal bli sortert
     * @param first the index of the first element
     * @param last the index of the last element
     */
    public static <T extends Comparable<T>> void insertionSortV2(T[] data, int first, int last) {
        for (int i = first+1; i <= last; i++) {
            T key = data[i];
            int position = i;

            while (position > 0 && data[position-1].compareTo(key) > 0) {
                data[position] = data[position-1];
                position--;
            }
            data[position] = key;
        }
    }

    public static <T extends Comparable<T>> void newQuickSort(T[] data, int min, int max) {
        quickSortV2(data, min, max);
        insertionSortV2(data, min, max);
    }

    public static <T extends Comparable<T>> void quickSortV2(T[] data, int min, int max) {
        if ((max - min + 1) > MIN) {
            /* find the index of partition */
            int indexOfPartition = partition(data, min, max);
            /* sort the left subarray */
            quickSortV2(data, min, indexOfPartition-1);
            /* sort the right subarray */
            quickSortV2(data, indexOfPartition+1, max);
        }
    }


}
