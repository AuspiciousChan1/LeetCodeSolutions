import utils.MyPrint;
import utils.Sort;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.longestPalindrome("ccccvbks");
        MyPrint.print(s);
    }
}
