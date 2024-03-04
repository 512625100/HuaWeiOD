import java.text.DecimalFormat;
import java.util.*;

public class X11 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String minAverageLost = scanner.nextLine();

        String avg = scanner.nextLine();
        List<String> list = Arrays.asList(avg.split(" "));

        // 设置平均值变量
        double res = 0;
        // 遍历数组列表
        for(int i = 1 ; i <= list.size() ; i++){
            // 创建数字和变量
            int count = 0;
            // 创建几个数字变量
            int num = 1;
            // 创建列表存储元素下标
            ArrayList<Integer> integers = new ArrayList<>();
            // 遍历数组列表，第一次从第一个数字遍历，结束后，会从第二数字开始遍历
            for (int j = i; j <= list.size() ; j++){
                // 求数字和
                count += Integer.parseInt(list.get(j - 1));
                // 求平均值
                res = (double) count /num;
                // 数字个数加1
                num ++;
                // 判断平均值是否小于等于最小值
                if (res <= Integer.parseInt(minAverageLost) ) {
                    // 如果小于，添加元素下标到list里面
                    integers.add(j-1);
                    // 如果j与数组列表大小相等，说明遍历到最后一个数字了，已经是最长的了，不需要在遍历了
                    if (j == list.size()){
                        // 把j赋值给i，i层会退出遍历
                        i = j;
                    }
                } 
                // 如果不满足，把j赋值给i，退出遍历，这样会从不符合的数字开始遍历，把不符合的过滤掉
                else {
                    i = j;
                    break;
                }

            }
            // 如果list的长度大于1，代表里面有两个数的平均值小于等于最小值
            if (integers.size() > 1){
                // 字符串拼接
                System.out.print(integers.get(0) + "-" + integers.get(integers.size()-1) + " ");
            }
        }
    }
}
