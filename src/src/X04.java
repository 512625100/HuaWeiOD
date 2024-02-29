import java.util.*;

public class X04 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入开源项目的个数：");
        String num = scanner.nextLine();
        System.out.println("请输入权重值列表：");
        String weight = scanner.nextLine();
        List<String> weightNum = Arrays.asList(weight.split(" "));

        System.out.println("请输入开源项目纬度统计：");
        List<String> projectNum = null;

        Map<String, Integer> map = new HashMap<>();

        // 遍历开源数目的个数
        for (int i = 0 ; i < Integer.parseInt(num); i ++){
            int count = 0;
            // 把纬度值列表按照空格分隔，转换成列表
            projectNum = Arrays.asList(scanner.nextLine().split(" "));
            // 遍历开源项目权重列表，从第二个值开始
            for (int j = 1;j <= 5; j ++){
                // 计算每个权重值与每个纬度值的计算并相加
                count += Integer.parseInt(weightNum.get(j-1)) * Integer.parseInt(projectNum.get(j));
            }
            // 把每个开源项目和热度存入字典
            map.put(projectNum.get(0),count);
        }
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(map.entrySet());
        // 对字典进行排序
        Collections.sort(sortedList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                // 如果字典中的两个value值相等
                if (o1.getValue().equals(o2.getValue())) {
                    // 按照key的小写字母的字典序排序
//                    return o2.getKey().compareToIgnoreCase(o1.getKey());
                    return o1.getKey().toLowerCase().compareTo(o2.getKey().toLowerCase());
                } else {
                    // 否则按照value值大小排序
                    return o2.getValue().compareTo(o1.getValue());
                }
            }
        });

        // 遍历打印字典中的key
        for (Map.Entry<String, Integer> entry : sortedList) {
            System.out.println(entry.getKey());
        }
        System.out.println(map);
        System.out.println(sortedList);
    }
}
