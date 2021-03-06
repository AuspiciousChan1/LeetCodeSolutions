package utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2017/9/3.
 * Name：
 * Introduction:
 */
public class Search {
    public static double getMedian(double a, double b, double c){
        double t;
        if(a > b){
            t = a;
            a = b;
            b = t;
        }
        if(b > c){
            b = c;
        }
        if(a > b) {
            return a;
        }
        return b;
    }

    public static int getMedian(int a, int b, int c){
        return (int)Math.round(getMedian((double)a, (double)b, (double)c));
    }

    //二分法查找，如果找到，则返回对应的index，否则，返回的值为如果target在列表中，它所对应的index。
    //预期使用要求：列表为从小到大有序。
    public static int binsearch(ArrayList<Double> l, double target){
        if(l != null){
            switch (l.size()){
                case 0:
                    return 0;
                case 1:
                    return target > l.get(0) ? 1 : 0;
                default:
                    int begin = 0;
                    int end = l.size() - 1;
                    while(end - begin > 1){
                        int mid = (begin + end) / 2;
                        if(target == l.get(mid)){
                            return mid;
                        }
                        else if(target > l.get(mid)){
                            begin = mid + 1;
                        }
                        else {
                            end = mid - 1;
                        }
                    }
                    if(target <= l.get(begin)){
                        return begin;
                    }
                    else if(target <= l.get(end)){
                        return end;
                    }
                    else {
                        return end + 1;
                    }
            }

        }
        else{
            return -1;
        }
    }
}
