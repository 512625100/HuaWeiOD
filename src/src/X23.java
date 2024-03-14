import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class X23 {
    public static void main(String[] args) throws ScriptException {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        ArrayList<Object> objects = new ArrayList<>();

        char[] charArray = s.toCharArray();

        // 遍历输入的字符串，寻找合法的数学表达式
        for (int i = 0; i < charArray.length; i++) {
            // 获取字符串的第一个字符
            char c = charArray[i];
//            System.out.println((int) c);
            int res = 0;
            StringBuilder stringBuilder = new StringBuilder();
            // 遍历获取第二个字符，如果第一字符是数字，贼继续拼接，不是数字不拼接
            for (int i1 = i; i1 < charArray.length; i1++) {
                if ((int) c < 97 && (int) c >= 49) {
                    char c1 = charArray[i1];
                    if ((int) c1 >= 97) {
                        break;
                    }
                    res++;
                    stringBuilder.append(c1);
                }
            }
            // 判断拼接后的数字是不是为null或者为0，清空
            if (stringBuilder == null || stringBuilder.length() == 0) {
                stringBuilder.setLength(0);
            }

            // 遍历拼接好的字符串
            for (int n = 0; n < stringBuilder.length(); n++) {
                char cc = stringBuilder.charAt(n);
                // 判断字符串的第一个是不是数字 或者是加减乘除，不是清空
                if (!Character.isDigit(cc) && cc != '+' && cc != '-' && cc != '*') {
                    stringBuilder.setLength(0);
                }
                // 判断符号后面是否连接符号，如果是符号字符串清空
                if (n > 0 && (cc == '+' || cc == '-' || cc == '*')) {
                    char prev = stringBuilder.charAt(n - 1);
                    if (prev == '+' || prev == '-' || prev == '*') {
                        stringBuilder.setLength(0);
                    }
                }
            }
            // 符合的字符串添加到list中
            objects.add(stringBuilder);

//            i += res;
        }

        // 对list的元素长队排序降序
        Collections.sort(objects, (s1, s2) -> Integer.compare(s2.toString().length(), s1.toString().length()));
        // 选择第一个
        String string = objects.get(0).toString();

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine se = manager.getEngineByName("js");

        //保留二位小数
        // 对字符串进行计算
        String sNewTwo = String.format("%d",  se.eval(string)).toString();

        // 输出
        System.out.println(sNewTwo);

    }
}