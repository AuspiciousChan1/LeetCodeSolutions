package utils;

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
    public static int binsearch(List<Double> l, double target){
        int start = 0;
        int end = l.size();
        while (end - start > 0){
            int mid = (start + end)/2;
            MyPrint.print(start + " " + mid + " " + end + "\n");
            try {
                if(target > l.get(mid)){
                    start = mid + 1;
                }
                else if(target < l.get(mid)){
                    end = mid;
                }
                else {
                    return mid;
                }
            }
            catch (IndexOutOfBoundsException e){

            }

            l = l.subList(start, end);
        }
        return start;
    }
}
