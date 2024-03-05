import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class X14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int res = num;

        for (int i = 1; i <= num; i++) {
            // 正则找到包含数字4的数字
            if (Pattern.matches(".*[4].*", Integer.toString(i))) {
                // 总数减1
                res --;
            }
        }
        System.out.println(res);
    }
}
