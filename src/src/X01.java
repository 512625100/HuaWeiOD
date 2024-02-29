import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class X01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入小明的身高：");
        int mingHeight = scanner.nextInt();
        System.out.println("请输入班级人数：");
        int numFriends = scanner.nextInt();

        ArrayList<Integer> friendsHeight = new ArrayList<>();

        System.out.println("请输入各学生身高：");
        // 遍历班级人数的次数
        for (int i=0;i < numFriends;i++){

            // 获取每个同学的身高
            int height = scanner.nextInt();
            // 同学的身高存进列表
            friendsHeight.add(height);

        }

        // 对同学的列表进行排序
        Collections.sort(friendsHeight, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int different1 = Math.abs(o1 - mingHeight);
                int different2 = Math.abs(o2 - mingHeight);
                // 如果两个身高的绝对值相同，身高高的在后
                if (different1 == different2){
                    return o1 - o2;
                }
                return different1 - different2;
            }
        });

        // 遍历输入身高
        for (Integer integer : friendsHeight) {
            System.out.print(integer + " ");
        }
    }
}
