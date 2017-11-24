package utils;

import java.awt.*;
import java.util.*;
import java.util.List;

public class TypeConverter {
    public static List<Integer> roundDoubleList(List<Double> doubleList){
        List<Integer> integerList = new ArrayList<>();
        for (double d :
                doubleList) {
            integerList.add((Math.round((float)d)));
        }
        return integerList;
    }

    public static List<Double> IntegerList_To_DoubleArrayList(List<Integer> integerList){
        List<Double> doubleList = new ArrayList<>();
        for (int k :
                integerList) {
            doubleList.add((double) k);
        }
        return doubleList;
    }
}
