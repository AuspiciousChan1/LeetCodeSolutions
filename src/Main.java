import jdk.management.resource.internal.inst.DatagramDispatcherRMHooks;
import utils.DataGenerator;
import utils.Outputs;
import utils.Search;
import utils.Sort;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<Double> arrayList = DataGenerator.randomArrayList(100);
        arrayList = (ArrayList<Double>) Sort.quickSort(arrayList);
        Outputs.outputln(Sort.isOrdered(arrayList));
        Outputs.outputList(arrayList, " ");
        Outputs.output(Search.binsearch(arrayList, arrayList.get(50)));

    }
}
