package utils;

import java.util.*;

public class Sort {

    //冒泡排序
    //没有引用其他自建函数
    public static List<Double> bubleSort(Collection<Double> c)throws NullPointerException{
        LinkedList<Double> lList = new LinkedList<Double>();
        while (!c.isEmpty()){
            Iterator<Double> iterator = c.iterator();
            double min = iterator.next();
            while(iterator.hasNext()){
                double t = iterator.next();
                if(t < min){
                    min = t;
                }
            }
            if(c.remove(min)){
                lList.add(min);
            }
            else {
                throw new NullPointerException();
            }
        }
        return lList;

    }
    //没写完
    public static List<Double> quickSort()throws UnsupportedOperationException{
        throw new UnsupportedOperationException("\"quickSort\" has not been finished yet");
    }
}
