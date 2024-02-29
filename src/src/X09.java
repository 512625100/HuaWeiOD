import java.util.*;

public class X09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入指令的总个数：");
        String n = scanner.nextLine();
        System.out.println("请输入幸运数字：");
        String m = scanner.nextLine();
        System.out.println("请输入n个指令：");
        String nums = scanner.nextLine();
        List<String> list = Arrays.asList(nums.split(" "));

        // 创建列表存储坐标位置
        ArrayList<Integer> integers = new ArrayList<>();

        int j = 0;
        // 添加初始坐标0
        integers.add(j);
        // 遍历指令的总个数
        for (int i = 0; i < Integer.parseInt(n) ; i++){
            // 按照顺序获取n个指令
            String stepNum = list.get(i);
            // 如果指令大于0
            if (Integer.parseInt(stepNum) > 0) {
                // 并且指令值与幸运数字相等
                if (Integer.parseInt(stepNum) == Integer.parseInt(m)) {
                    // 坐标 加 指令 加 1
                    j += Integer.parseInt(stepNum) + 1;
                    // 坐标位置加入list
                    integers.add(j);
                }
                // 指令值与幸运值不相等
                else {
                    // 坐标 加 指令
                    j += Integer.parseInt(stepNum);
                    // 坐标位置加入list
                    integers.add(j);
                }
            }
            // 如果指令值等于0
            else if (Integer.parseInt(stepNum) == 0){
                // 坐标不变
                j = j;
                // 坐标位置加入list
                integers.add(j);
            }
            // 如果指令值小于零
            else if (Integer.parseInt(stepNum) < 0){
                // 并且指令值等于幸运数字
                if (Integer.parseInt(stepNum) == Integer.parseInt(m)) {
                    // 坐标 加 指令 加 1
                    j += Integer.parseInt(stepNum) - 1;
                    // 坐标位置加入list
                    integers.add(j);
                }
                // 指令值与幸运值不相等
                else {
                    // 坐标 加 指令
                    j += Integer.parseInt(stepNum);
                    // 坐标位置加入list
                    integers.add(j);
                }
            }
        }
        // 坐标列表排序
        Collections.sort(integers);
        // 输出列表最后一位
        System.out.println(integers.get(integers.size() - 1));
    }
}
