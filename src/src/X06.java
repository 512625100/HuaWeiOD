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
        for(int i = 1;i < list1.size();i++){
            Integer num1 = Integer.parseInt(list1.get(i));
            for (int j=1;j<list2.size();j++){
                Integer num2 = Integer.parseInt(list2.get(j));
                Integer count = num1+num2;
                sort.add(count);
            }
        }
        Collections.sort(sort);
        System.out.println("后：" + sort);
        int z = 0;
        int m = 0;
        for(int n = 0;n < num ;n++){
           m = sort.get(n);
           z = m + z;
        }
        System.out.println(z);
    }
}
