package utils;

import java.util.ArrayList;
import java.util.LinkedList;

public class DataGenerator {
    //字符串蜈蚣函数，将字符串重复多次后返回
    public static String StringcCentipede(Object o, int t){
        String str = "";
        for (int i = 0; i < t; i++){
            str = str + o.toString();
        }
        return str;
    }

    //生成随机LinkedList
    public static LinkedList<Double> randomLinkedList(int size){
        LinkedList<Double> linkedList = new LinkedList<>();
        for(int i = 0; i < size; i++){
            linkedList.add(Math.random());
        }
        return linkedList;
    }

    //生成随机ArrayList
    public static ArrayList<Double> randomArrayList(int size){
        ArrayList<Double> arrayList = new ArrayList<>(size);
        for(int i = 0; i < size; i++){
            arrayList.add(Math.random());
        }
        return arrayList;
    }

}
