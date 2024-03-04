import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class X12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        // 字符串转换成字符列表
        char[] letters = s.toCharArray();
        int xNum = 0;
        int yNum = 0;
        int res = 0;
        // 遍历列表
        for (char s1 : letters) {
            // 判断每一个字符是不是和x一样
            if (s1 == 'X') {
                // 一样计数
                xNum ++;
            }
            // 不一样计数
            else {
                yNum ++;
            }
            // 当两个数字一样
            if (xNum == yNum){
                // 对结果计数
                res ++;
                // 两个数字清零
                xNum = 0;
                yNum = 0;
            }
        }
        System.out.println(res);
    }
}
