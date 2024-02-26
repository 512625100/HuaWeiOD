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
        for (int i=0;i < numFriends;i++){

            int height = scanner.nextInt();
            friendsHeight.add(height);

        }

        Collections.sort(friendsHeight, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int different1 = Math.abs(o1 - mingHeight);
                int different2 = Math.abs(o2 - mingHeight);
                if (different1 == different2){
                    return o1 - o2;
                }
                return different1 - different2;
            }
        });

        for (Integer integer : friendsHeight) {
            System.out.print(integer + " ");
        }
    }
}
