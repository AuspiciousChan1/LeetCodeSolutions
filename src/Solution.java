import org.omg.PortableInterceptor.INACTIVE;
import utils.MyPrint;
import utils.Search;
import utils.Sort;
import utils.TypeConverter;

import java.util.*;

public class Solution {
    //1.Two Sum
    //Accepted
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }
    //------------------------------------------------------------------------------------------------------------------
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
                    }
                }
            }
        }
        return result;
    }
    //==================================================================================================================

}
