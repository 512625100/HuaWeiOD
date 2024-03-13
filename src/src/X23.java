import java.util.ArrayList;
import java.util.Scanner;

public class X23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        ArrayList<Object> objects = new ArrayList<>();

        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            StringBuilder stringBuilder = new StringBuilder();
            for (int i1 = i; i1 < charArray.length;) {
                if (Character.getNumericValue(c) < 10 && Character.getNumericValue(c) >= 0){
                    stringBuilder.append(c);
                }
                i1++;
            }
            objects.add(stringBuilder);

        }

        System.out.println(objects);

    }
}
