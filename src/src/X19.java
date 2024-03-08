import java.util.Scanner;

/**
 * @Description:
 * 题目描述:
 * 给你一个字符串s，字符串s首尾相连成一个环形 ，请你在环中找出'0'字符出现了偶数次最长子字符串Q的长度。输入描述:
 * 输入是一串小写字母组成的字符串
 * 输出描述:
 * 输出是一个整数
 * 补充说明:
 * 1 <= s.length <= 5 x 10^5
 * s 只包含小写 英文字母
 * @Author: 徐洪超
 * @Date: 2024/3/08
 */


public class X19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入小写字母组成的字符串：");
        String s = scanner.nextLine();
        // 字符串转换成列表
        char[] charArray = s.toCharArray();
        int res = 0;
        // 遍历列表
        for (char c : charArray) {
            // 看列表中是否包含字母o，如果有计数累加
            if (String.valueOf(c).equals("o")){
                res++;
            }
        }

        // 如果存在的数字除以2没有剩余，证明整个字符串中存在偶数个o，那么整个串的长度就是本字符串长度，
        // 如果为奇数，就说明本字符串中除了多余的字母o以外，剩余的o为偶数，字符串最长
        if (res %2 == 0){
            System.out.println(charArray.length);
        }else{
            System.out.println(charArray.length - 1);
        }
    }
}
