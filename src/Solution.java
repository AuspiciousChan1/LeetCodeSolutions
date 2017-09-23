import org.omg.PortableInterceptor.INACTIVE;
import org.w3c.dom.NodeList;
import utils.MyPrint;
import utils.Search;
import utils.Sort;
import utils.TypeConverter;

import java.util.*;

public class Solution {
    //------------------------------------------------------------------------------------------------------------------
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
    //==================================================================================================================


    //------------------------------------------------------------------------------------------------------------------
    //2.Two Sum
    //Accepted
    //背景
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //我的答案
    private void addEle(int e, ListNode l){
        ListNode p = new ListNode(e);
        l.next = p;
    }
    private boolean hasNext(ListNode l){
        return l.next != null;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l11 = new ListNode(-1);
        l11.next = l1;
        ListNode l22 = new ListNode(-2);
        l22.next = l2;
        ListNode listNode = new ListNode(0);

        ListNode p1, p2, p;
        p1 = l11;
        p2 = l22;
        p = listNode;

        boolean a = false;
        //标答用的或，为空的一边记为0
        while (hasNext(p1) && hasNext(p2)){
            p1 = p1.next;
            p2 = p2.next;

            int sum = p1.val + p2.val + (a ? 1 : 0);
            if (sum > 9){
                sum -= 10;
                a = true;
            }
            else {
                a = false;
            }
            addEle(sum, p);
            p = p.next;
        }

        ListNode pp = p;
        while (p1.next != null){
            p1 = p1.next;
            addEle(p1.val, p);
            p = p.next;
        }
        while (p2.next != null){
            p2 = p2.next;
            addEle(p2.val, p);
            p = p.next;
        }
        if(a){
            boolean jud = false;
            while (pp.next != null){
                pp = pp.next;
                if(pp.val == 9){
                    pp.val = 0;
                }
                else {
                    pp.val++;
                    jud = true;
                    break;
                }
            }
            if(!jud){
                pp.next = new ListNode(1);
            }
        }
        return listNode.next;
    }

    //系统答案
    public ListNode addTwoNumbers_Solution(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
    //==================================================================================================================

    //------------------------------------------------------------------------------------------------------------------
    //3. Longest Substring Without Repeating Characters
    //Working
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int start = 0, end = 0;
        int len = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(hashMap.keySet().contains(c)){
                int ind = hashMap.get(c);
                if(ind >= start){
                    len = Math.max(len, end - start);
                    start = ++ind;
                }
                hashMap.replace(c, i);
            }
            else {
                hashMap.put(c, i);
            }
            end++;
        }
        return Math.max(len, end - start);
    }
    //==================================================================================================================


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
