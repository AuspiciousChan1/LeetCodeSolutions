package utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyPrint {
    //（根）简单的输出
    public static void print(Object o) {
        System.out.print(o);
    }

    //（1）带有前同步信号(preamble)和结束标记(endMark)的输出
    public static void print(Object o,String preamble, String endMark) {
        print(preamble + o + endMark);
    }

    //（1.1）带结束符的输出
    public static void print(Object o, String endMark) {
        print(o, "", endMark);
    }

    //（1.1.1）回车结尾的输出
    public static void println(Object o){
        print(o, "\n");
    }
    //（1.1.2）空格结尾的输出
    public static void prints(Object o) {
        print(o, " ");
    }
    //（1.1.3）制表符结尾的输出
    public static void printt(Object o) {
        print(o, "\t");
    }


    //(1.2)带有固定分隔线的输出
    public static void myPrint(Object o, String top, String bottom, int minLen){
        String finalTop =  DataGenerator.StringcCentipede(top, (int) Math.ceil((double)minLen/top.length()));
        finalTop = "\n" + finalTop + "\n";
        String finalBottom =  DataGenerator.StringcCentipede(bottom, (int) Math.ceil((double)minLen/bottom.length()));
        finalBottom = "\n" + finalBottom + "\n";
        print(o, finalTop, finalBottom);
    }

    //（1.2.1）
    public static void myPrint(Object o){
        myPrint(o, "-", "=", 100);
    }
    //（1.2.2）带有固定标题和固定分隔线的输出
    public static void myPrint(String title, Object o, String top, String middle, String bottom, int minLen){
        myPrint(title, top, middle, minLen);
        String finalEnd = DataGenerator.StringcCentipede(bottom, (int) Math.ceil((double)minLen/bottom.length()));
        finalEnd = "\n" + finalEnd + "\n";
        print(o, finalEnd);
    }
    //(1.2.2.1)
    public static void myPrint(String title, Object o){
        MyPrint.myPrint(title, o, "-", ".", "=", 100);
    }


    //（1.3）输出列表中的元素，并以seperator对应的字符串隔开，最后以回车结尾
    public static void printList(List l, String seperator){
        int len = l.size();
        for (int i = 0; i < len - 1; i++){
            print(l.get(i), seperator);
        }
        print(l.get(len - 1), "\n");
    }

    public static void printList(List l,int amountEachRow, String seperator){
        int len = l.size();
        for (int i = 0; i < len - 1; i++){
            if((i+1) % amountEachRow == 0){
                print(l.get(i), "\n");
            }
            else{
                print(l.get(i), seperator);
            }
        }
        print(l.get(len - 1), "\n");
    }


}
