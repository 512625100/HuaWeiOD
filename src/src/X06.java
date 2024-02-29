import java.util.*;

public class X06 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一行数组：");
        String line1 = scanner.nextLine();
        System.out.println("请输入第二行数组：");
        String line2 = scanner.nextLine();
        System.out.println("请输入数组对数：");
        int num = scanner.nextInt();
        List<String> list1 = Arrays.asList(line1.split(" "));
        List<String> list2 = Arrays.asList(line2.split(" "));
        ArrayList<Integer> sort = new ArrayList<>();
        // 遍历第一行数组
        for(int i = 1;i < list1.size();i++){
            // 按照顺序获取第一行数组的每个元素
            Integer num1 = Integer.parseInt(list1.get(i));
            // 遍历第二行数组
            for (int j=1;j<list2.size();j++){
                // 按照顺序获取第二行数组的每个元素
                Integer num2 = Integer.parseInt(list2.get(j));
                // 第一行数组的元素与第二行数组的元素相加
                Integer count = num1+num2;
                // 相加的得到的和加入到sort列表中
                sort.add(count);
            }
        }
        // 对sort列表按照从小到大排序
        Collections.sort(sort);
        System.out.println("后：" + sort);

        int z = 0;
        int m = 0;
        // 按照输入的num（几个元素对）相加得到最小值
        for(int n = 0;n < num ;n++){
           m = sort.get(n);
           z = m + z;
        }
        System.out.println(z);
    }
}
