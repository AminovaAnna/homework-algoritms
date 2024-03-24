package pro.sky.algorithms;

import java.util.Arrays;

import static java.lang.Integer.valueOf;

public class Main {
    public static void main(String[] args) {
        IntegerList list = new IntegerArrayList(5);
        System.out.println(list.isEmpty());
        list.add(valueOf("5"));
        list.add(valueOf("1"));
        list.add(valueOf("2"));
        list.add(valueOf("3"));
        list.add(valueOf("4"));
        list.add(valueOf("5"));
        list.add(valueOf("6"));

        System.out.println(list);
        list.remove(valueOf("3"));
        System.out.println(list);
        list.remove(5);
        System.out.println(list);
        list.remove(valueOf("5"));
        System.out.println(list);
        list.remove(valueOf("5"));
        System.out.println(list);

        list.set(0, valueOf("99"));
        System.out.println(list);

        list.add(1, valueOf("100"));
        System.out.println(list);
        list.add(valueOf("99"));
        System.out.println(list);
        System.out.println(list.size());


        System.out.println(contains(list, "100"));
//        System.out.println(list.contains(Integer.valueOf("10011")));


        System.out.println(list.indexOf(valueOf("99")));
        System.out.println(list.lastIndexOf(valueOf("99")));
        System.out.println(list.isEmpty());

        IntegerList l2 = new IntegerArrayList(10);
        l2.add(valueOf("99"));
        l2.add(valueOf("100"));
        l2.add(valueOf("2"));
        l2.add(valueOf("4"));
        l2.add(valueOf("99"));
     //   l2.add("99");
        System.out.println(' ');
        System.out.println(list.equals(l2));

        System.out.println(Arrays.toString(list.toArray()));
        list.clear();
        System.out.println(Arrays.toString(list.toArray()));

 //       list.get(0);

        list.add(valueOf("0"));
        list.add(1, valueOf("1"));
        System.out.println(list);


        void quickSort() {
            out.add(27);
            out.add(4);
            out.add(113);
            out.add(1);
            Integer[] test = out.toArray();
            int i = out.size();
            IntegerArrayList.quickSort(out.toArray(), 0, out.size() - 1);
            System.out.println(out.toArray());
        }
    }
}
