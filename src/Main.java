import utils.MyPrint;
import utils.Sort;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-1,0,1,2,-1,-4};
        MyPrint.printList(solution.threeSum(nums), "    ");

    }
}
