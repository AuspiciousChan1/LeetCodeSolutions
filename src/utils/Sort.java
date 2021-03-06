package utils;

import java.util.*;

public class Sort {

    public static<T> boolean isOrdered(List<Double> l){
        if(l == null){
            throw new NullPointerException("Input \"l\" is null");
        }
        int len = l.size();
        switch (len){
            case 1:
                return true;
            default:
                Iterator<Double> iterator = l.iterator();
                double form = iterator.next();
                while (iterator.hasNext()){
                    double d = iterator.next();
                    if(form > d){
                        return false;
                    }
                    form = d;
                }
                return true;
        }

    }
    //冒泡排序
    //没有引用其他自建函数
    public static LinkedList<Double> bubleSort(Collection<Double> c)throws NullPointerException{
        LinkedList<Double> lList = new LinkedList<>();
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
    //快速排序
    private static double getKeyForQuickSort(List<Double> l, int start, int end){
        double a = l.get(start);
        double b = l.get((start + end) / 2);
        double c = l.get(end - 1);
        if(a > b){
            double t = a;
            a = b;
            b = t;
        }
        if(c < a){

            return a;
        }
        else if(c > b){
            return b;
        }
        else {
            return c;
        }
    }
    //引用函数getKeyForQuickSort
    public static ArrayList<Double> quickSort(ArrayList<Double> l){
        int len = l.size();
        if(len < 2){
            return l;
        }
        else if(len == 2){
            List<Double> r = new ArrayList<>();
            double a = l.get(0);
            double b = l.get(1);
            l.set(0, Math.min(a, b));
            l.set(1, Math.max(a, b));
            return l;
        }
        else if(len == 3){
            ArrayList<Double> r = new ArrayList<>();
            double a = l.get(0);
            double b = l.get(1);
            double c = l.get(2);
            if(a > b){
                double t = a;
                a = b;
                b = t;
            }
            if(c < b){
                double t = c;
                c = b;
                b = t;
            }
            if(a > b){
                double t = a;
                a = b;
                b = t;
            }
            r.add(a);
            r.add(b);
            r.add(c);
            return r;
        }
        boolean allValueTheSame = true;
        for (double d :
                l) {
            if(d != l.get(0)){
                allValueTheSame = false;
                break;
            }
        }
        if (allValueTheSame){
            return l;
        }
        int frontIndex = 0;
        int backIndex = len - 1;
        double key = getKeyForQuickSort(l, frontIndex, backIndex + 1);
//        MyPrint.myPrint("key : " + key);
        int f = frontIndex, b = backIndex;
        while (f <= backIndex){
            if(l.get(f) <= key){
                if(l.get(f) == key && frontIndex !=0){
                    f++;
                    continue;
                }
                double temp = l.get(f);
                l.set(f, l.get(frontIndex));
                l.set(frontIndex, temp);
                frontIndex++;
            }
            f++;
        }
        while (b >= frontIndex){
            if(l.get(b) >= key){
                double temp = l.get(b);
                l.set(b, l.get(backIndex));
                l.set(backIndex, temp);
                backIndex--;
            }
            b--;
        }
        ArrayList<Double> l0 = new ArrayList<>(l.subList(0, frontIndex)) ;
        ArrayList<Double> l1 = new ArrayList<>(l.subList(frontIndex, l.size()));

        ArrayList<Double> l00 = quickSort(l0);
        ArrayList<Double> l11 = quickSort(l1);
        ArrayList<Double> result = new ArrayList<>();

        result.addAll(l00);
        result.addAll(l11);
        return result;
    }

}
