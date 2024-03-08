import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class X18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nums = scanner.nextLine();
        String values = scanner.nextLine();
        String minValue = scanner.nextLine();

        List<String> list = Arrays.asList(values.split(" "));
        list.remove(0);
        System.out.println(list);
        int res = 0;
        for (int i = 0;i < list.size();i++){
            int i1 = Integer.parseInt(list.get(i));
            for (int j = 1;j < list.size();j++){
                if (null != list.get(j)){
                    int i2 = Integer.parseInt(list.get(j));
                    if (i1 + i2 > Integer.parseInt(minValue)){
                        res ++;
                        list.remove(i);
                        list.remove(j);
                    }
                }
            }
        }
        System.out.println(res);


    }
}
