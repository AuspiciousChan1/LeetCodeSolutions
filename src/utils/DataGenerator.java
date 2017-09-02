package utils;

public class DataGenerator {
    //字符串蜈蚣函数，将字符串重复多次后返回
    public static String StringcCentipede(Object o, int t){
        String str = "";
        for (int i = 0; i < t; i++){
            str = str + o.toString();
        }
        return str;
    }


}
