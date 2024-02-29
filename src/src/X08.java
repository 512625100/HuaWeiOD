import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;

import java.util.*;

public class X08 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入L1和L2服务器cpu的数量：");
        String nums = scanner.nextLine();
        String[] s = nums.split(" ");
        System.out.println("请输入L1组各cpu的算力：");
        String s1 = scanner.nextLine();
        System.out.println("请输入L2组各cpu的算力：");
        String s2 = scanner.nextLine();

        HashMap<Object, Object> map = new HashMap<>();
        // 遍历L1组各cpu的算力
        for (int i = 0;i<Integer.parseInt(s[0]);i++){
            // 遍历L2组各cpu的算力
            for (int j = 0;j<Integer.parseInt(s[1]);j++){
                // 创建List 存储L1组cpu算力
                List<String> list1 = Arrays.asList(s1.split(" "));
                // 创建List 存储L2组cpu算力
                List<String> list2 = Arrays.asList(s2.split(" "));

//                System.out.println("转换前==============================");
//                System.out.println(list1);
//                System.out.println(list2);

                // L1组cpu的算力按照顺序与L2组各cpu算力互换
                Integer temp = Integer.valueOf(list1.get(i));
                list1.set(i, list2.get(j));
                list2.set(j, String.valueOf(temp));

//                System.out.println("转换后——————————————————————————————");
                // 计算互换后L1组cpu的算力之和
                int sum1 = list1.stream().mapToInt(num -> Integer.parseInt(num)).sum();
                // 计算互换后L2组cpu的算力之和
                int sum2 = list2.stream().mapToInt(num -> Integer.parseInt(num)).sum();
//                System.out.println(list1+" = " + sum1);
//                System.out.println(list2+" = " + sum2);

                // 判断L1组和L2组cpu算力之和是否相等
                if (sum1 == sum2){
//                    System.out.println(list2.get(j) + " " + list1.get(i));
                    // 如果相等，把互换的cpu的算力添加到字典里
                    map.put(list2.get(j),list1.get(i));
                }


            }
        }

        TreeMap<Object, Object> treeMap = new TreeMap<>(map);
        // 获取字典中key最小的
        Object o = treeMap.firstKey();
        // 获取字典中key最小的value
        Object o1 = treeMap.get(treeMap.firstKey());
        // 输出
        System.out.println(o + " " + o1);


    }
}
