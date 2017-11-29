package utils;

import MyTypes.Graphs.Graph;
import MyTypes.Graphs.MyGraph;

import java.util.ArrayList;
import java.util.Collection;
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

    //生成随机ArrayList
    public static ArrayList<Double> sortedRandomArrayList(int size){
        ArrayList<Double> arrayList = new ArrayList<>(size);
        arrayList.add(Math.random());
        for(int i = 1; i < size; i++){
            arrayList.add(Math.random() + arrayList.get(i - 1));
        }
        return arrayList;
    }

    public static Graph generatorPetersonGraph() {
        MyGraph myGraph = new MyGraph();
        ArrayList<String> nodesId = new ArrayList<>(10);

        nodesId.add(myGraph.addNode(null, null));
        return null;
    }
}
