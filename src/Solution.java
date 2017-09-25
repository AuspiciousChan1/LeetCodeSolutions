import org.omg.PortableInterceptor.INACTIVE;
import org.w3c.dom.NodeList;
import utils.*;

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
    //Accepted
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
    //5. Longest Palindromic Substring
    //Accepted
    private int maxStart, maxEnd;
    private void getMax(int i0, int i, String s){
        if(i0 != -1){
            int front = i0, back = i;
            while (--front >= 0 && ++back < s.length() && s.charAt(front) == s.charAt(back));
            if(front < 0){
                front = 0;
            }
            else if(back >= s.length()){
                front++;
                back--;
            }
            else{
                front++;
                back--;
            }
            if(back + 1 - front > maxEnd - maxStart){
                maxStart = front;
                maxEnd = back + 1;
            }
        }
    }
    public String longestPalindrome(String s) {
        if(s.length() <= 1){
            return s;
        }

        maxStart = 0;
        maxEnd = 1;
        char[] cs = new char[1005];
        if(s.charAt(0) ==s.charAt(1)){
            maxStart = 0;
            maxEnd = 2;
        }
        for(int i = 2; i < s.length(); i++){
            char c = s.charAt(i);
            int i0 = -1;
            if(s.charAt(i) == s.charAt(i - 2)){
                i0 = i - 2;
                getMax(i0, i, s);
            }
            if(s.charAt(i) == s.charAt(i - 1)){
                i0 = i - 1;
                getMax(i0, i, s);
            }
        }
        return s.substring(maxStart, maxEnd);
    }
    //==================================================================================================================


    //------------------------------------------------------------------------------------------------------------------
    //6. ZigZag Conversion
    //Accepted
    private static int getRow(int index, int numRows){
        if (numRows == 1){
            return 0;
        }
        else if (numRows == 2){
            return index % 2;
        }
        else if(numRows > 2){
            int rem = index % (2 * numRows - 2);
            if(rem >= numRows){
                rem = 2 * numRows - rem - 2;
            }
            return rem;
        }
        return -1;
    }
    public String convert(String s, int numRows) {
        ArrayList<String> listArrayList = new ArrayList<>(numRows);
        for(int i = 0; i < numRows; i++){
            listArrayList.add("");
        }
        for(int i = 0; i < s.length(); i++){
            listArrayList.set(getRow(i, numRows), listArrayList.get(getRow(i, numRows)) + s.charAt(i));
        }
        StringBuilder rep = new StringBuilder();
        for (String str :
                listArrayList) {
            rep.append(str);
        }
        return rep.toString();
    }
    //==================================================================================================================


    //------------------------------------------------------------------------------------------------------------------
    //7. Reverse Integer
    public int reverse(int x) {
        boolean isNegative = x < 0;
        Stack<Integer> stack = new Stack<>();
        int rev = 0;
        while (x / 10 != 0){
            stack.push(x % 10);
            x /= 10;
        }
        stack.push(x);
        int power = 0;
        while (!stack.empty()){
            if(power == 9 && stack.peek() > 2){
                return 0;
            }
            rev += stack.pop() * Math.round(Math.pow(10, power++));

        }
        if (isNegative ^ rev<0){
            return 0;
        }
        return rev;
    }
    //==================================================================================================================


    //------------------------------------------------------------------------------------------------------------------
    //8. String to Integer (atoi)
    private String removeFrontSpaces(String str){
        int start = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' '){
                start++;
            }
            else {
                break;
            }
        }
        return str.substring(start);
    }
    public int myAtoi(String str) {
        if (str == null){
            return 0;
        }
        else {
            boolean isNegative = false;
            Stack<Integer> stack = new Stack<>();
            //去掉开头的空格，这样第一位（index = 0）就是符号（+、-）或者数字了。
            str = removeFrontSpaces(str);
            for(int i = 0; i < str.length(); i++){
                //如果是数字，则加入栈中（此处不用考虑位数，如果前面都是0，多少位都没关系）
                if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                    stack.push(str.charAt(i) - '0');
                }
                //开头遇到负号，说明为负数
                else if(i == 0 && str.charAt(0) == '-'){
                    isNegative = true;
                }
                //开头遇到正号，说明为正数
                else if(i == 0 && str.charAt(0) == '+'){
                }
                else {
                    break;
                }
            }
            if (stack.size() == 0){
                return 0;
            }
            int power = 0;
            int rem = 0;
            boolean over = false;
            while (!stack.empty()){
                if(power == 9 && stack.peek() > 2){
                    over = true;
                }
                else if(power > 9 && stack.peek() != 0){
                    over = true;
                }
                rem += stack.pop() * Math.round(Math.pow(10, power++));
            }

            //如果超出范围
            if(rem < 0 || over){
                return isNegative ? -2147483648 : 2147483647;//小于0则取-2^31；大于0则取2^31-1
            }
            //在范围内，则加上符号返回。
            return isNegative ? -rem : rem;
        }
    }
    //==================================================================================================================


    //------------------------------------------------------------------------------------------------------------------
    //9. Palindrome Number
    //Accepted
    public boolean isPalindrome(int x) {
        String str = x + "";
        int len = str.length();
        int i, j = len;
        for (i = 0; i < len / 2; i ++){
            j--;
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
        }
        return true;
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
                        Outputs.outputList(result.get(result.size() - 1), "    ");
                    }
                }
            }
        }
        return result;
    }
    //==================================================================================================================

}
