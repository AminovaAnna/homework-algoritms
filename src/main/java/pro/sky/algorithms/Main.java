package pro.sky.algorithms;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StringList list = new StringArrayList(5);
        System.out.println(list.isEmpty());
        list.add("5");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");

        System.out.println(list);
        list.remove("3");
        System.out.println(list);
        list.remove(5);
        System.out.println(list);
        list.remove("5");
        System.out.println(list);
        list.remove("5");
        System.out.println(list);

        list.set(0,"99");
        System.out.println(list);

        list.add(1, "100");
        System.out.println(list);
        list.add("99");
        System.out.println(list);
        System.out.println(list.size());


        System.out.println(list.contains("100"));
        System.out.println(list.contains("10011"));


        System.out.println(list.indexOf("99"));
        System.out.println(list.lastIndexOf("99"));
        System.out.println(list.isEmpty());

        StringList l2 = new StringArrayList(10);
        l2.add("99");
        l2.add("100");
        l2.add("2");
        l2.add("4");
        l2.add("99");
     //   l2.add("99");
        System.out.println(' ');
        System.out.println(list.equals(l2));

        System.out.println(Arrays.toString(list.toArray()));
        list.clear();
        System.out.println(Arrays.toString(list.toArray()));

 //       list.get(0);

        list.add("0");
        list.add(1,"1");
        System.out.println(list);


    }
}
