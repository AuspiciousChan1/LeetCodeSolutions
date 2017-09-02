import org.omg.PortableInterceptor.INACTIVE;
import utils.MyPrint;
import utils.Sort;
import utils.TypeConverter;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {
    //15. 3Sum
    //Time Limit Exceeded
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        for(int i = 0; i < len-2; i++){
            for(int j = i+1; j < len-1; j++){
                for(int k = j+1; k < len; k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        Set<List<Integer>> set = new HashSet<>();
                        set.addAll(result);
                        List<Integer> list = new LinkedList<Integer>();
                        list.add(nums[i]);
                        if(nums[j] < nums[i]){
                            list.add(0, nums[j]);
                        }
                        else {
                            list.add(nums[j]);
                        }
                        if(nums[k] < list.get(0)){
                            list.add(0, nums[k]);
                        }
                        else if (nums[k] < list.get(1)){
                            list.add(1, nums[k]);
                        }
                        else {
                            list.add(2, nums[k]);
                        }

                        if(set.add(TypeConverter.roundDoubleList(Sort.bubleSort(TypeConverter.IntegerList_To_DoubleList(list))))){
                            result.add(list);
                        }
                        MyPrint.printList(result.get(result.size() - 1), "    ");
//                        list.clear();
//                        MyPrint.printList(result.get(0), "    ");
                    }
                }
            }
        }
        return result;
    }

}
