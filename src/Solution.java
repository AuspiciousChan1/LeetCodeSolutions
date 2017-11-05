import com.sun.deploy.util.ArrayUtil;
import com.sun.xml.internal.fastinfoset.util.CharArrayIntMap;
import org.omg.PortableInterceptor.INACTIVE;
import org.w3c.dom.NodeList;
import utils.*;

import java.lang.reflect.Array;
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
    //11. Container With Most Water
    //Accepted
    public int maxArea(int[] height) {
        int maxS = 0;
        int begin = 0;
        int end = height.length - 1;
        while (begin < end){
            int s = (end - begin) * Math.min(height[begin], height[end]);
            maxS = maxS > s ? maxS : s;
            if(height[begin] < height[end]){
                int b = height[begin];
                while (begin < end && height[++begin] <= b);
            }
            else {
                int e = height[end];
                while (begin < end && height[--end] <= e);
            }
        }
        return maxS;
    }
    //==================================================================================================================

    //------------------------------------------------------------------------------------------------------------------
    //12. Integer to Roman
    /*Given an integer, convert it to a roman numeral.
    Input is guaranteed to be within the range from 1 to 3999.*/
    private String getRoman(String one, String five, String ten, int num){
        String roman = "";
        if(num < 4){
            while (num-- > 0){
                roman += one;
            }
        }
        else if (num ==4){
            roman = one + five;
        }
        else if(num < 9){
            roman += five;
            while (num-- > 5){
                roman += one;
            }
        }
        else {
            roman += one;
            roman += ten;
        }
        return roman;
    }
    public String intToRoman(int num) {
        int ones = num % 10;
        int tens = (num / 10) % 10;
        int hundreds = (num / 100) % 10;
        int thousands = (num / 1000) % 10;
        return getRoman("M", "", "", thousands) +
                getRoman("C", "D", "M", hundreds) +
                getRoman("X", "L", "C", tens) +
                getRoman("I", "V", "X", ones);

    }
    //==================================================================================================================

    //------------------------------------------------------------------------------------------------------------------
    //13. Roman to Integer
    //Accept(beats 77.45%)
    private int getIntFromRoman(char roman){
        switch (roman){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return -1;
        }
    }
    public int romanToInt(String s) {
        int v, vn, sum = 0;
        final int len = s.length();
        vn = getIntFromRoman(s.charAt(0));
        for(int i = 0; i < len - 1; i++){
            v = vn;
            vn = getIntFromRoman(s.charAt(i + 1));
            sum += v < vn ? -v : v;
        }
        sum += getIntFromRoman(s.charAt(len - 1));
        return sum;
    }
    //==================================================================================================================

    //------------------------------------------------------------------------------------------------------------------
    //14. Longest Common Prefix
    //Accept(beats 53.24%)采用二分法
    //最优解使用indexof函数，先看前两个的公共开头，再加第三个，以此类推。对比开头，从strs[0]的最后开始向前判断。（感觉从后向前不如二分法）
    private boolean sameSubstrings(String[] strs, int begin, int back){//长度>=2
        String eq = strs[0].substring(begin, back);
        for (String str : strs) {
            if (!eq.equals(str.substring(begin, back))) {
                return false;
            }
        }
        return true;
    }
    public String longestCommonPrefix(String[] strs) {
        int strAmount = strs.length;
        switch (strAmount){
            case 0:
                return "";
            case 1:
                return strs[0];
            default:
                String common = "";
                int minLen = strs[0].length();
                for(int i = 1; i < strAmount; i++){
                    int len = strs[i].length();
                    minLen = minLen < len ? minLen : len;
                }
                if(minLen == 0){
                    return "";
                }
                int begin = 0, back = minLen;
                while (back > begin + 1){
                    int mid = (begin + back) / 2;
                    if(sameSubstrings(strs, begin, mid)){
                        begin = mid;
                    }
                    else{
                        back = mid;
                    }
                }
                return sameSubstrings(strs, begin, back) ? strs[0].substring(0, begin + 1) : strs[0].substring(0, begin);
        }
    }
    //==================================================================================================================

    //------------------------------------------------------------------------------------------------------------------
    //15. 3Sum
    //尚未解决
    //快速排序
    private int getKeyForQuickSort(int[] arr, int start, int end){
        int a = arr[start];
        int b = arr[(start + end) / 2];
        int c = arr[end - 1];
        if(a > b){
            int t = a;
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
    private int[] quickSort(int[] arr){
        int len = arr.length;
        if(len < 2){
            return arr;
        }
        else if(len == 2){
            int a = arr[0];
            int b = arr[1];
            arr[0] = Math.min(a, b);
            arr[1] = Math.max(a, b);
            return arr;
        }
        else if(len == 3){
            int[] r = new int[3];
            int a = arr[0];
            int b = arr[1];
            int c = arr[2];
            if(a > b){
                int t = a;
                a = b;
                b = t;
            }
            if(c < b){
                int t = c;
                c = b;
                b = t;
            }
            if(a > b){
                int t = a;
                a = b;
                b = t;
            }
            r[0] = a;
            r[1] = b;
            r[2] = c;
            return r;
        }
        boolean allValueTheSame = true;
        for (int d :
                arr) {
            if(d != arr[0]){
                allValueTheSame = false;
                break;
            }
        }
        if (allValueTheSame){
            return arr;
        }
        int frontIndex = 0;
        int backIndex = len - 1;
        int key = getKeyForQuickSort(arr, frontIndex, backIndex + 1);
//        MyPrint.myPrint("key : " + key);
        int f = frontIndex, b = backIndex;
        while (f <= backIndex){
            if(arr[f] <= key){
                if(arr[f] == key && frontIndex !=0){
                    f++;
                    continue;
                }
                int temp = arr[f];
                arr[f] = arr[frontIndex];
                arr[frontIndex] = temp;
                frontIndex++;
            }
            f++;
        }
        while (b >= frontIndex){
            if(arr[b] >= key){
                int temp = arr[b];
                arr[b] = arr[backIndex];
                arr[backIndex] = temp;
                backIndex--;
            }
            b--;
        }
        int[] a0 = Arrays.copyOfRange(arr, 0, frontIndex);
        int[] a1 = Arrays.copyOfRange(arr, frontIndex, arr.length);


        int[] a00 = quickSort(a0);
        int[] a11 = quickSort(a1);
        int[] result = new int[arr.length];
        System.arraycopy(a00, 0, result, 0, a00.length);
        System.arraycopy(a11, 0, result, a00.length, a11.length);
        return result;
    }
    private List<Integer> buildGroup(int a, int b, int c){
        List<Integer> list = new ArrayList<>(3);
        list.add(a);
        list.add(b);
        list.add(c);
        return list;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> setList = new HashSet<>();
        nums = quickSort(nums);
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int n :
                nums) {
            arrayList.add(n);
        }
        int len = nums.length;
        for(int i = 0; i < len  - 1; i++){
            for(int j = i + 1; j < len - 1; i++){
                int a = arrayList.get(i);
                int b = arrayList.get(j);
                Outputs.output(arrayList.indexOf(0-a-b));
            }
        }
        List<List<Integer>> listList = new ArrayList<>();
        listList.addAll(setList);
        return listList;
    }
    //==================================================================================================================

}
