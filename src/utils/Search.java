package utils;

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
        return (int)getMedian((double)a, (double)b, (double)c);
    }

}
