import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class X05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入历史日志条数：");
        String num = scanner.nextLine();
        System.out.println("请时输入URL地址：");
        ArrayList<List> objects = new ArrayList<>();
        // 遍历日志的条数，获取url地址
        for (int i = 0; i < Integer.parseInt(num);i++){
            String urls = scanner.nextLine();
            // 把输入的每一行地址按照/分割转换成列表中
            List<String> split = Arrays.asList(urls.split("/"));
            // 把处理后的list放进objects列表中
            objects.add(split);
        }
        System.out.println("请输入层级和关键字：");
        String keyword = scanner.nextLine();
        List<String> list = Arrays.asList(keyword.split(" "));

        Integer res = 0;
        // 遍历列表
        for (List object : objects) {
            // 如果url转换成的列表中元素的个数小于层级的数字 退出循环
            if (object.size() - 1 < Integer.parseInt(list.get(0))){
                break;
            }
            // 如果url转成的列表中元素的个数不小于
            else {
                // 获取url列表中的层级关键字
                String s = object.get(Integer.parseInt(list.get(0))).toString();
                // 判断获取的关键字和输入的关键字是否相等
                if (s.equals(list.get(1))) {
                    // 相等加1
                    res ++;
                }
            }
        }
        // 输出相等的个数
        System.out.println(res);
    }
}
