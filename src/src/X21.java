import java.util.ArrayList;
import java.util.Scanner;

public class X21 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        // 最后结果拼接 例如 21 = （接后面的相加字串）
        String res = num + "=";
        // 存放每个与num相当的数字相加串
        ArrayList<String> strings = new ArrayList<>();
        // 遍历num次，
        for (int i = 1; i <= num; i++) {
            // 对总数进行求和
            int n = 0;
            // 对字符串进行拼接
            StringBuilder str = new StringBuilder();
            // 丛1开始遍历，下一次从2开始
            for (int j = i; j < num; j++) {
                // 对数字进行累加
                n += j;
                // 对字符串进行拼接 1 + 2 + 3 +
                str.append(j + "+");
                // 如果累加的数字和输入的一样
                if (n == num){
                    // 把结果添加到list中
                    strings.add(str.toString());
                    // 退出循环
                    break;
                }
            }
        }
        // 找到list中最后一个加入的元素，一定是最短的
        String s = strings.get(strings.size() - 1);
        // 结果拼接 21 = 10 + 21 s.substring(0,s.length() -1)对字符串截取
        System.out.println(res + s.substring(0,s.length() -1));


    }
}
