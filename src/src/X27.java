import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.DoubleToIntFunction;

public class X27 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        ArrayList<Integer> integers = new ArrayList<>();
        // 判断输入的宝石个数是否大于0，不大于0 返回0 ，因为没有宝石可以购买
        if (i > 0){
            // 每个宝石的价格添加到integers列表中
            for (int i1 = 0; i1 < i; i1++) {
                int i2 = scanner.nextInt();
                integers.add(i2);
            }

            int value = scanner.nextInt();
            // 计算最多购买宝石数列表
            ArrayList<Integer> counts = new ArrayList<>();
            // 外层遍历是对宝石价格累加，第一遍是从第一个开始累加，第二次循环是从第二个开始
            for (int i1 = 0; i1 < integers.size(); i1++) {
                // 存储宝石累计价格
                int res = 0;
                // 存储宝石最多购买数
                int count = 0;
                // 循环对宝石价格累加
                for (int i2 = i1; i2 < integers.size(); i2++) {
                    int integer2 = integers.get(i2);
                    res += integer2;
                    // 如果宝石累加价格小于自身拥有财富
                    if (res <= value){
                        // 宝石数量加1
                        count ++;
                    }else {
                        // 否则退出
                        break;
                    }
                }
                // 对符合购买的数量加到list中
                counts.add(count);
            }
            // 对list排序
            Collections.sort(counts);
            // 输出最大
            System.out.println(counts.get(counts.size()-1));
        }else {
            int i1 = scanner.nextInt();
            System.out.println(0);
        }

    }
}

