package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

class test {
    public static void main(String[] args) {

        List<List<Integer>> arrs = new ArrayList<List<Integer>>();
        List<Integer> arr = new ArrayList<>();

        arr.add(1);
        arr.add(3);
        arrs.add(arr);
        arr.add(2);
        arr.add(4);
        Iterator i = arrs.iterator();
        while(i.hasNext()){
            List<Integer> list = (List) i.next();
            Iterator each = list.iterator();
            while(each.hasNext()){
                System.out.print(each.next() + " ");
            }
            System.out.println();
        }
    }
}