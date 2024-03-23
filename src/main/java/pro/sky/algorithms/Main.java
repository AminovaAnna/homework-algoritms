package pro.sky.algorithms;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        IntegerList list = new IntegerArrayList(5);
        System.out.println(list.isEmpty());
        list.add(Integer.valueOf("5"));
        list.add(Integer.valueOf("1"));
        list.add(Integer.valueOf("2"));
        list.add(Integer.valueOf("3"));
        list.add(Integer.valueOf("4"));
        list.add(Integer.valueOf("5"));
        list.add(Integer.valueOf("6"));

        System.out.println(list);
        list.remove(Integer.valueOf("3"));
        System.out.println(list);
        list.remove(5);
        System.out.println(list);
        list.remove(Integer.valueOf("5"));
        System.out.println(list);
        list.remove(Integer.valueOf("5"));
        System.out.println(list);

        list.set(0, Integer.valueOf("99"));
        System.out.println(list);

        list.add(1, Integer.valueOf("100"));
        System.out.println(list);
        list.add(Integer.valueOf("99"));
        System.out.println(list);
        System.out.println(list.size());


        System.out.println(list.contains(Integer.valueOf("100")));
        System.out.println(list.contains(Integer.valueOf("10011")));


        System.out.println(list.indexOf(Integer.valueOf("99")));
        System.out.println(list.lastIndexOf(Integer.valueOf("99")));
        System.out.println(list.isEmpty());

        IntegerList l2 = new IntegerArrayList(10);
        l2.add(Integer.valueOf("99"));
        l2.add(Integer.valueOf("100"));
        l2.add(Integer.valueOf("2"));
        l2.add(Integer.valueOf("4"));
        l2.add(Integer.valueOf("99"));
     //   l2.add("99");
        System.out.println(' ');
        System.out.println(list.equals(l2));

        System.out.println(Arrays.toString(list.toArray()));
        list.clear();
        System.out.println(Arrays.toString(list.toArray()));

 //       list.get(0);

        list.add(Integer.valueOf("0"));
        list.add(1, Integer.valueOf("1"));
        System.out.println(list);


    }
}
