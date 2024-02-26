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

        for (int i = 0 ; i < Integer.parseInt(num); i ++){
            int count = 0;
            projectNum = Arrays.asList(scanner.nextLine().split(" "));
            for (int j = 1;j <= 5; j ++){
               count += Integer.parseInt(weightNum.get(j-1)) * Integer.parseInt(projectNum.get(j));
            }
            map.put(projectNum.get(0),count);
        }
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(map.entrySet());
        Collections.sort(sortedList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue().equals(o2.getValue())) {
//                    return o2.getKey().compareToIgnoreCase(o1.getKey());
                    return o1.getKey().toLowerCase().compareTo(o2.getKey().toLowerCase());
                } else {
                    return o2.getValue().compareTo(o1.getValue());
                }
            }
        });

        for (Map.Entry<String, Integer> entry : sortedList) {
            System.out.println(entry.getKey());
        }
        System.out.println(map);
        System.out.println(sortedList);
    }
}
