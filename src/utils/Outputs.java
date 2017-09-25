package utils;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Outputs {
    //（根）简单的输出
    public static void output(Object o) {
        System.out.print(o);
    }

    //（1）带有前同步信号(preamble)和结束标记(endMark)的输出
    public static void output(Object o,String preamble, String endMark) {
        output(preamble + o + endMark);
    }

    //（1.1）带结束符的输出
    public static void output(Object o, String endMark) {
        output(o, "", endMark);
    }

    //（1.1.1）回车结尾的输出
    public static void outputln(Object o){
        output(o, "\n");
    }
    //（1.1.2）空格结尾的输出
    public static void outputs(Object o) {
        output(o, " ");
    }
    //（1.1.3）制表符结尾的输出
    public static void outputt(Object o) {
        output(o, "\t");
    }


    //(1.2)带有固定分隔线的输出
    public static void myOutput(Object o, String top, String bottom, int minLen){
        String finalTop =  DataGenerator.StringcCentipede(top, (int) Math.ceil((double)minLen/top.length()));
        finalTop = "\n" + finalTop + "\n";
        String finalBottom =  DataGenerator.StringcCentipede(bottom, (int) Math.ceil((double)minLen/bottom.length()));
        finalBottom = "\n" + finalBottom + "\n";
        output(o, finalTop, finalBottom);
    }

    //（1.2.1）
    public static void myOutput(Object o){
        myOutput(o, "-", "=", 100);
    }
    //（1.2.2）带有固定标题和固定分隔线的输出
    public static void myOutput(Object o, String title, String top, String middle, String bottom, int minLen){
        myOutput(title, top, middle, minLen);
        String finalEnd = DataGenerator.StringcCentipede(bottom, (int) Math.ceil((double)minLen/bottom.length()));
        finalEnd = "\n" + finalEnd + "\n";
        output(o, finalEnd);
    }
    //(1.2.2.1)
    public static void myOutput(Object o, String title){
        myOutput(o, title, "-", ".", "=", 100);
    }


    //（1.3）输出列表中的元素，并以seperator对应的字符串隔开，最后以回车结尾
    public static void outputList(List l, String seperator){
        int len = l.size();
        for (int i = 0; i < len - 1; i++){
            output(l.get(i), seperator);
        }
        output(l.get(len - 1), "\n");
    }

    public static String soutputList(List l, String seperator){
        if(l == null || l.size() == 0){
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        int len = l.size();
        for (int i = 0; i < len - 1; i++){
            stringBuffer.append(l.get(i).toString()).append(seperator);
        }
        stringBuffer.append(l.get(l.size() - 1).toString());
        return stringBuffer.toString();
    }

    public static void outputList(List l, String seperator, int amountEachRow){
        int len = l.size();
        for (int i = 0; i < len - 1; i++){
            if((i+1) % amountEachRow == 0){
                output(l.get(i), "\n");
            }
            else{
                output(l.get(i), seperator);
            }
        }
        output(l.get(len - 1), "\n");
    }
}
