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
        // 把每个成员与财富值 添加到map中 对应1有多少，2有多少
        for (int i = 0;i < Integer.parseInt(nums);i++){
            moneyMap.put(i+1,Integer.parseInt(list.get(i)));
        }

        // 循环遍历连接节点，变成list放入list中[[1,2],[1,3],[2,4]]
        for (int n = 0; n < Integer.parseInt(nums) - 1; n++ ){
            String nodes = scanner.nextLine();
            List<String> nodeList = Arrays.asList(nodes.split(" "));
            objects.add(nodeList);
        }

        // 创建最大值列表
        ArrayList<Integer> max = new ArrayList<>();
        // 循环遍历连接节点列表，挨个获取列表中的每一个
        for (int j = 0; j < Integer.parseInt(nums) - 1 ; j++ ){
            // 获取列表中的第一个连接列表[[1,2],[1,3],[2,4]],第一次获取的是[1,2],依次获取
            List<String> node1 = objects.get(j);
            // 列表里的第一个值[1,2]中的1
            int s1 = Integer.parseInt(node1.get(0));
            // 把成员1的财富值存进变量
            int count = moneyMap.get(s1);
            // 把1和子节点的财富值相加（moneyMap.get()获取字典中，每个成员的财富值）
            count += moneyMap.get(Integer.parseInt(node1.get(1)));
            // 丛连接列表的第二个开始遍历
            for (int k = j+1; k < Integer.parseInt(nums) - 1; k++ ){
                // 获取列表中的第一个连接列表[[1,2],[1,3],[2,4]],第二次获取的是[1,3],依次获取
                List<String> node2= objects.get(k);
                // 列表里的第一个值[1,3]中的1
                int s2 = Integer.parseInt(node2.get(0));
                // 判断是不是同一个父节点
                if(s1==s2){
                    // 相同，把子节点的财富值相加
                    count += moneyMap.get(Integer.parseInt(node2.get(1)));
                }
            }
            // 每次获取的财富值存进列表
            max.add(count);
        }
        // 排序
        Collections.sort(max);
        // 获取最大值
        System.out.println(max.get(max.size()-1));
    }
}
