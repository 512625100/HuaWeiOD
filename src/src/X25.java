import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class X25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        List<String> list = Arrays.asList(s.split(" "));

        // 创建车位列表
        ArrayList<Integer> integers = new ArrayList<>();
        // 遍历输入的车位列表，当遍历到不是1的数字时跳过，对数字1相加，
        // 相加后的数字代表总共占了几个车位，为0的代表车位没有被占
        // 当遇到数字为0时，第一层循环的i应该变为第二层循环的i2，这样第一层循环就从0开始
        for (int i = 0; i < list.size(); i++) {
            // 计算总共占了几个车位
            int res = 0;
            for (int i2 = i; i2 < list.size(); i2++) {
                int i3 = Integer.parseInt(list.get(i2));
                if (i3 == 1){
                    res += 1;
                }else{
                    i = i2;
                    break;
                }
            }
            // 对占了车位的数字加到列表中
            integers.add(res);
        }

        int count = 0;
        // 遍历车位列表
        for (Integer integer : integers) {
            // 如果所占车位为1 ，2 ，3 直接对数字加1
            if (integer > 0 && integer <= 3){
                count ++;
            }
            // 如果占的车位大于3，看数字中包含几个3，对包含的加1
            else if (integer > 3){
                for (int i = 1; i <= integer; i++) {
                    if (i % 3 == 0) {
                        // 对总数加1
                        count++;
                    }
                }
                // 如果最后的一个数字除以三不等0，代表多出一个车
                if (integer % 3 != 0){
                    // 对总数加1
                    count ++;
                }
            }
        }
        System.out.println(count);
    }
}
