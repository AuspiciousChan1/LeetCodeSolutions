import org.w3c.dom.NodeList;
import utils.DataGenerator;
import utils.MyPrint;
import utils.Search;
import utils.Sort;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;


public class Main {

    public static void main(String[] args) {
        int num = 1;
        int falseAmount = 0;
        while (num-- > 0){
            LinkedList<Double> linkedList = DataGenerator.randomLinkedList(500);
            List<Double> arrayList = Sort.quickSort(linkedList);
            if(Sort.isOrdered(arrayList)){
                for (int i = 0; i < 500; i++){
                    double target = arrayList.get(i);
                    int ind = Search.binsearch(arrayList, target);
                    if(!Objects.equals(arrayList.get(ind), arrayList.get(i))){
                        falseAmount++;
                        MyPrint.print(arrayList.get(ind) + " " + target, "\n");
                    }
                }
            }
        }
        MyPrint.print(falseAmount);
    }
}
