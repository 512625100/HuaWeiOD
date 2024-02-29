import java.util.*;

public class X10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入家庭成员总数：");
        String nums = scanner.nextLine();
        System.out.println("请输入各家庭成员财富值：");
        String money = scanner.nextLine();
        System.out.println("请输入连接节点：");

        List<String> list = Arrays.asList(money.split(" "));
        HashMap<Integer, Integer> moneyMap = new HashMap<>();
        ArrayList<List<String>> objects = new ArrayList<>();
        for (int i = 0;i < Integer.parseInt(nums);i++){
            moneyMap.put(i+1,Integer.parseInt(list.get(i)));
        }

        for (int n = 0; n < Integer.parseInt(nums) ; n++ ){
            String nodes = scanner.nextLine();
            List<String> nodeList = Arrays.asList(nodes.split(" "));
            objects.add(nodeList);
        }

        for (int j = 0; j < Integer.parseInt(nums) ; j++ ){
            List<String> node1 = objects.get(j);
            String s1 = node1.get(0);
            for (int k = j+1; k < Integer.parseInt(nums) ; k++ ){
                List<String> node2= objects.get(k);
                String s2 = node2.get(0);
                System.out.println("------------" + s1);
                System.out.println("============" + s2);
            }
        }
        System.out.println(moneyMap);
        System.out.println(objects);
    }
}
