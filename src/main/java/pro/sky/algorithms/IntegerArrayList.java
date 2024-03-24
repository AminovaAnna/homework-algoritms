package pro.sky.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringJoiner;


public class IntegerArrayList implements IntegerList {

    private Integer[] ArrayList;
    private int position = 0;

    public IntegerArrayList(int size) {
        this.ArrayList = new Integer[size];
    }

    @Override
    public Integer add(Integer item) {
        if (item == null) throw new NullPointerException();
        if (position == ArrayList.length - 1) {
            grow();
        }
        ArrayList[position] = item;
        position++;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        if (index < 0 || index > position) {
            throw new ArrayIndexOutOfBoundsException();
        }
        // index = 3
        // position   0  1  2  3  4  5  6  7      = 7
        // ArrayList  1, 2, 3, 4, 5, 6, 7, 8      length = 8
        // ArrayList  1, 2, 3, 4, 4, 5, 6, 7, 8   length  +1
        // ArrayList  1, 2, 3, 9, 4, 5, 6, 7, 8
        //                             3                             4                     5 (ArrayList.length - position)
        System.arraycopy(ArrayList, index, ArrayList, index + 1, position - index);
        ArrayList[index] = item;
        position++;
        return item;

    }

    @Override
    public Integer set(int index, Integer item) {
        rangeCheck(index);
        ArrayList[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        int index = indexOf(item);
        if (index == -1) {
            throw new ItemNotFoundException();
        }
        return remove(index);
    }

    @Override
    public Integer remove(int index) {
        rangeCheck(index);
        Integer removed = ArrayList[index];
        if (index == position - 1) {
            ArrayList[index] = null;
        } else {
            // position = 6, index =2
            //   1, 2, 3, 4, 5, 6
            //   1, 2, 4, 5, 6, 6
            System.arraycopy(ArrayList, index + 1, ArrayList, index, position - index - 1);
        }
        position--;
        return removed;
    }

    @Override
    public boolean contains(Integer item) {
        Integer[] arrayCopy = Arrays.copyOf(ArrayList, ArrayList.length);
        sort(arrayCopy);
        return binarySearch(arrayCopy,item);
    }

    @Override
    public int indexOf(Integer item) { //что такое item?
        for (int i = 0; i < position; i++) {
            if (ArrayList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) { //почему?
        for (int i = position - 1; i >= 0; i--) {
            if (ArrayList[i].equals(item)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public Integer get(int index) {
        rangeCheck(index);
        return ArrayList[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (size() != otherList.size()) return false;
        for (int i = 0; i < size(); i++) {
            if (!get(i).equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return position;
    }

    @Override
    public boolean isEmpty() {
        if (position == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void clear() {
        position = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(ArrayList, position);
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= position) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private void grow() {
        Integer[] newArray = new Integer[ArrayList.length * 2];
        for (int i = 0; i < ArrayList.length; i++) {
            newArray[i] = ArrayList[i];
        }
        this.ArrayList = newArray;
    }


//    @Override
//    public String toString() {
//        StringJoiner joiner = new StringJoiner(" ", "[", "]");
//        for (int i = 0; i < position; i++) {
//            StringJoiner add = joiner.add(StringList[i]);
//        }
//        return joiner.toString();
//    }


    private static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }


    private void sort(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Integer temp = arr[i];
            Integer j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    private boolean binarySearch(Integer[] arr, Integer item) {
        Integer min = 0;
        Integer max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item == arr[mid]) {
                return true;
            }

            if (item < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
    public static void quickSort(Integer[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private static int partition(Integer[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                swapElements(arr, i, j);
            }
        }

        swapElements(arr, i + 1, end);
        return i + 1;
    }


}


