import java.util.*;

public class X13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入产品数，总投资额，总风险值：");
        List<String> nums = Arrays.asList(scanner.nextLine().split(" "));
        System.out.println("请输入投资回报率序列：");
        List<String> return_list = Arrays.asList(scanner.nextLine().split(" "));
        System.out.println("请输入风险值序列：");
        List<String> risk_list = Arrays.asList(scanner.nextLine().split(" "));
        System.out.println("请输入最大投资额度序列：");
        List<String> max_cost_list = Arrays.asList(scanner.nextLine().split(" "));

        ArrayList<Integer> count = new ArrayList<>();
        for (int i = 0;i < Integer.parseInt(nums.get(0)); i++){
            int i1 = Integer.parseInt(return_list.get(i));
            int i2 = Integer.parseInt(max_cost_list.get(i));
            count.add(i1 * i2);
        }

        int maxIndex = -1; // 初始化为-1，表示未找到最大值
        for (int i = 0; i < count.size(); i++) {
            if (maxIndex == -1 || count.get(i) > count.get(maxIndex)) {
                maxIndex = i;
            }
        }

        List<Integer> list = Arrays.asList(0,0,0,0,0);
        Integer max = count.stream().mapToInt(Integer::intValue).max().getAsInt();

        System.out.println(max);
        System.out.println(nums.get(2));

        for (int n = 0;n < Integer.parseInt(nums.get(0));n++){
            Integer num1 = count.get(n);
            int risk1 = Integer.parseInt(risk_list.get(n));
            int max1 = Integer.parseInt(max_cost_list.get(n));
            for (int m = 1;m < Integer.parseInt(nums.get(0));m++){
                Integer num2 = count.get(m);
                int risk2 = Integer.parseInt(risk_list.get(m));
                int max2 = Integer.parseInt(max_cost_list.get(m));
                if (num1 + num2 > max){
                    if (risk1 + risk2 <= 10){
                        if (max1 + max2 <= Integer.parseInt(nums.get(1))){
                            max = num1 + num2;
                            setAllElementsToZero(list);
                            list.set(n,Integer.parseInt(max_cost_list.get(n)));
                            list.set(m,Integer.parseInt(max_cost_list.get(m)));
                        }
                    }
                }else if (num1 + num2 < max){
                    if (Integer.parseInt(max_cost_list.get(maxIndex)) <= Integer.parseInt(nums.get(1))){
                        list.set(maxIndex,Integer.parseInt(max_cost_list.get(maxIndex)));
                    }else {
                        if (risk1 + risk2 <= 10){
                            setAllElementsToZero(list);
                            list.set(n,Integer.parseInt(max_cost_list.get(n)));
                            list.set(m,Integer.parseInt(max_cost_list.get(m)));
                        }
                    }
                }
            }
        }

        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }

    private static void setAllElementsToZero(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, 0); // 将指定索引处的元素设置为0
        }
    }
}
