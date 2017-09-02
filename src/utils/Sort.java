package utils;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Sort {
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
}
