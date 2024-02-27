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
        for (int i = 0; i < Integer.parseInt(num);i++){
            String urls = scanner.nextLine();
            List<String> split = Arrays.asList(urls.split("/"));
            objects.add(split);
        }
        System.out.println("请输入层级和关键字：");
        String keyword = scanner.nextLine();
        List<String> list = Arrays.asList(keyword.split(" "));
        Integer res = 0;
        for (List object : objects) {
            if (object.size() - 1 < Integer.parseInt(list.get(0))){
                break;
            }else {
                String s = object.get(Integer.parseInt(list.get(0))).toString();
                if (s.equals(list.get(1))) {
                    res ++;
                }
            }
        }
        System.out.println(res);
    }
}
