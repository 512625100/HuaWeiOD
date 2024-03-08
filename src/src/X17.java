import java.util.Scanner;

/**
 * @Description:
 * 有位客人来自异国，在该国使用m进制计数。该客人有个幸运数字n(n<m)，每次购物时，其总是喜欢计算本次支付的花费(折算为异国的价格后)中存在多少幸运数字。
 * 问:当其购买一个在我国价值k的产品时，其中包含多少幸运数字?
 * 输入描述:
 * 第-行输入为 k, n, m。
 * 其中:
 * k 表示 该客人购买的物品价值(以十进制计算的价格)n 表示 该客人的幸运数字
 * m 表示 该客人所在国度的采用的进制
 * 输出描述:
 * 输出幸运数字的个数，行末无空格，
 * 补充说明:
 * 当输入非法内容时，输出0
 * String binary = Integer.toBinaryString(decimal); // 二进制表示
 * System.out.println("二进制: " + binary);
 *
 * String octal = Integer.toOctalString(decimal); // 八进制表示
 * System.out.println("八进制: " + octal);
 *
 * String hexadecimal = Integer.toHexString(decimal).toUpperCase(); // 十六进制表示
 * System.out.println("十六进制: " + hexadecimal);
 * @Author: 徐洪超
 * @Date: 2024/3/07
 */

public class X17 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int k = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);
        int m = Integer.parseInt(s[2]);
        int res = 0;
        if (n < m){
            // 对购买价值k进行m进制转换
            String string = Integer.toString(k, m);
            // 转换后的数字转换成列表
            char[] charArray = string.toCharArray();
            // 遍历列表
            for (char c : charArray) {
                // 判断列表中的元素与幸运数字是否一致
                if (String.valueOf(c).equals(String.valueOf(n))){
                    // 一致加1
                    res ++;
                }
            }
            System.out.println(res);
            System.out.println(string);
        }else{
            System.out.println(0);
        }

    }
}
