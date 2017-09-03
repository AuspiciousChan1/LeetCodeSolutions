package utils;

import java.util.*;

public class Sort {

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
    //引用Search中的函数
    public static List<Double> quickSort(List<Double> l){
        int len = l.size();
//        MyPrint.println("len = " + len);
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
            List<Double> r = new ArrayList<>();
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
        double key = Search.getMedian(l.get(frontIndex), l.get((frontIndex + backIndex) / 2), l.get(backIndex));
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
        List<Double> l0 = new ArrayList<>();
        Iterator<Double> iterator = l.iterator();
        for(int i = 0; i < frontIndex; i++){
            l0.add(iterator.next());
        }
        List<Double> l1 = new ArrayList<>();
        while (iterator.hasNext()){
            l1.add(iterator.next());
        }
        List<Double> l00 = quickSort(l0);
        List<Double> l11 = quickSort(l1);
        List<Double> result = new ArrayList<>();

        result.addAll(l00);
        result.addAll(l11);
        return result;
//        return l;
    }
}
