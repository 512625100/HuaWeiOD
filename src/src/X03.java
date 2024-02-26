import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class X03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个自然数：");
        int num = scanner.nextInt();

        String str = num + "=";
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<Object> objects = new ArrayList<>();
        int rs = 0;
        for (int i = 1; i <= num;i++){
            int z = 0;
            for (int j = i; j <= num ; j++){

                z += j;
                if (z > 0){
                    stringBuilder.append(j + "+");
                    if (z == num){
                        rs ++;
                        String x = str + stringBuilder;
                        objects.add(x);
                    }
                    if (z > num){
                        stringBuilder.setLength(0);
                        break;
                    }
                }
            }
        }
        Collections.reverse(objects);
        for (Object object : objects) {
            System.out.println(object.toString().substring(0,object.toString().length()-1));
        }
        System.out.println("result:" + rs);
    }
}