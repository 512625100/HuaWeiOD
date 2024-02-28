import java.util.Scanner;
import java.util.*;
import java.util.stream.Stream;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static int[][] visited;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count1 = in.nextInt();
        int count2 = in.nextInt();
        int[] nums1 = new int[count1];
        int sum1 = 0;
        for (int i = 0; i < count1; i++) {
            nums1[i] = in.nextInt();
            sum1 += nums1[i];
        }
        int sum2 = 0;
        int[] nums2 = new int[count2];
        HashMap<Integer, Integer> num2_map = new HashMap<>();
        for (int i = 0; i < count2; i++) {
            nums2[i] = in.nextInt();
            sum2 += nums2[i];
            if(!num2_map.containsKey(nums2[i])) {
                num2_map.put(nums2[i], 1);
            }
        }

        Arrays.sort(nums1);
        int i=0;
        while(true){
            if(i>=count1){
                break;
            } else {
                int target = nums1[i] - (sum1-sum2)/2;
                if (num2_map.containsKey(target)) {
                    System.out.println(nums1[i] + " " + target);
                    break;
                }
            }
            i+=1;
        }

    }

}