package pro.sky.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringJoiner;

public class StringArrayList implements StringList {

    private String[] ArrayList;
    private int position = 0;

    public StringArrayList(int size) {
        this.ArrayList = new String[size];
    }

    @Override
    public String add(String item) {
        if (item == null) throw new NullPointerException();
        if (position == ArrayList.length - 1) {
            grow();
        }
        ArrayList[position] = item;
        position++;
        return item;
    }

    @Override
    public String add(int index, String item) {
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
    public String set(int index, String item) {
        rangeCheck(index);
        ArrayList[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        int index = indexOf(item);
        if (index == -1) {
            throw new ItemNotFoundException();
        }
        return remove(index);
    }

    @Override
    public String remove(int index) {
        rangeCheck(index);
        String removed = ArrayList[index];
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
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) { //что такое item?
        for (int i = 0; i < position; i++) {
            if (ArrayList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) { //почему?
        for (int i = position - 1; i >= 0; i--) {
            if (ArrayList[i].equals(item)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public String get(int index) {
        rangeCheck(index);
        return ArrayList[index];
    }

    @Override
    public boolean equals(StringList otherList) {
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
    public String[] toArray() {
        return Arrays.copyOf(ArrayList, position);
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= position) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private void grow() {
        String[] newArray = new String[ArrayList.length * 2];
        for (int i = 0; i < ArrayList.length; i++) {
            newArray[i] = ArrayList[i];
        }
        this.ArrayList = newArray;
    }


    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(" ", "[", "]");
        for (int i = 0; i < position; i++) {
        joiner.add(ArrayList[i]);
        }
        return joiner.toString();
    }
}
