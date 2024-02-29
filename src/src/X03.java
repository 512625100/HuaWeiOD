import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class X03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个自然数：");
        int num = scanner.nextInt();

        // 创建一个等式变量 例如 9 =
        String str = num + "=";
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<Object> objects = new ArrayList<>();
        int rs = 0;
        // 遍历输入的自然数次数
        for (int i = 1; i <= num;i++){
            // 创建一个变量存储自然数之和
            int z = 0;
            // 遍历输入的自然数次数，因为第一次遍历i时，i的第一个数字是1，等第二次遍历时，i的数字为2，j就会从2开始
            for (int j = i; j <= num ; j++){
                // z与j累计相加
                z += j;
                // 当自然数之和大于0时
                if (z > 0){
                    // 字符串追加，列入 1 + 2 + 3 +
                    stringBuilder.append(j + "+");
                    // 当自然数与累计后的数字之和相等
                    if (z == num){
                        // 计算存在结果的个数
                        rs ++;
                        // 结果拼接，例如 9 = 2 + 3 + 4 +
                        String x = str + stringBuilder;
                        // 把结果存入到列表中
                        objects.add(x);
                    }
                    // 如果自然数之和大于了输入的自然数
                    if (z > num){
                        // 清楚字符串拼接中的值
                        stringBuilder.setLength(0);
                        // 退出循环
                        break;
                    }
                }
            }
        }
        // 对列表中存入的元素逆序排序
        Collections.reverse(objects);
        // 循环遍历输出结果
        for (Object object : objects) {
            // 字符串截取 例如 9 = 2 + 3 + 4 + 去除掉数字4后面的加号
            System.out.println(object.toString().substring(0,object.toString().length()-1));
        }
        // 输出存在结果的个数
        System.out.println("result:" + rs);
    }
}