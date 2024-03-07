import java.util.Scanner;
import java.util.*;
import java.util.stream.Stream;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wordsCount = scanner.nextInt();
        String[] wordArr = new String[wordsCount];
        for (int i = 0; i < wordsCount; i++) {
            wordArr[i] = scanner.next();
        }
        String chars = scanner.next();
        char[] charArr = new char[26];
        int anyNum = 0;
        int res = 0;
        for (char c : chars.toCharArray()) {
            if (c == '?') {
                anyNum++;
            } else {
                charArr[c - 'a']++;
            }
        }
        for (String word : wordArr) {
            char[] wordsplit = new char[26];
            for (char c : word.toCharArray()) {
                wordsplit[c - 'a']++;
            }
            int needAnyNum = 0;
            for (int i = 0; i < 26; i++) {
                int i1 = wordsplit[i] - charArr[i];
                if (i1 > 0) {
                    needAnyNum += i1;
                }
            }
            if (needAnyNum <= anyNum) {
                res++;
            }
        }
        System.out.println(res);
    }
}