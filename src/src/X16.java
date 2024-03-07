import java.util.*;


/**
 * @Description:
 * 有一个字符串数组Qwords和一个字符串chars,
 * 假如可以用chars中的字母拼写出words中的某个“单词”(字符串)，那么我们就认为你掌握了这个单词。words的字符仅由 a-z 英文小写字母组成。
 * 例如: abcchars 由 a-z 英文小写字母和“?”“组成。其中英文问号"?"表示万能字符，能够在拼写时当做任意一个英文字母Q。 例如:"?"可以当做"a"等字母。
 * 注意:每次拼写时，chars中的每个字母和万能字符都只能使用一次。输出词汇表words中你掌握的所有单词的个数。没有掌握任何单词，则输出0。输入描述:
 * 第1行输入数组words的个数，记为N。
 * 从第2行开始到第N+1行依次输入数组words的每个字符串元素第N+2行输入字符串a chars。输出描述:
 * 输出一个整数，表示词汇表words中你掌握的单词个数。补充说明:
 * 注意:
 * 1 <= words.length <= 100
 * 1 <= words[il.length, chars.length <= 100
 * 所有字符串中都仅包含小写英文字母、英文问号
 * @Author: 徐洪超
 * @Date: 2024/3/07
 */
public class X16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入单词个数：");
        String num = scanner.nextLine();
        System.out.println("请输入字符串元素words：");
        ArrayList<String> words = new ArrayList<>();
        HashMap<Character, Integer> charMap = new HashMap<>();
        int res = 0;
        // 把输入的words放进列表中
        for (int i = 0; i < Integer.parseInt(num); i++) {
            String s = scanner.nextLine();
            words.add(s);
        }

        System.out.println("请输入字符串chars：");
        String chars = scanner.nextLine();
        // 输入的字符串chars转换成列表
        char[] charArray1 = chars.toCharArray();

        int n = 1;
        // 循环chars列表，对列表中的每个字母进行计数，例如a出现一次，为a：1存入map中
        for (char c : charArray1) {
            // 如果存在则加1
            if (charMap.containsKey(c)){
                charMap.put(c,charMap.get(c) + 1);
            }
            // 如果不存在则赋值1
            else {
                charMap.put(c,n);
            }
        }

        // 遍历字符串列表的次数，一次获取word
        for (int j = 0;j<words.size();j++){

            HashMap<Character, Integer> wordMap = new HashMap<>();
            String s = words.get(j);
            int needNum = 0;
            // 把每个word转换成list，遍历每个字母
            for (char c : s.toCharArray()) {
                // 如果存在则加1
                if (wordMap.containsKey(c)){
                    wordMap.put(c,wordMap.get(c) + 1);
                }
                // 如果不存在则赋值1
                else {
                    wordMap.put(c,n);
                }
            }
            // 对存储word的字母和个数的map进行遍历
            Set<Map.Entry<Character, Integer>> entrySet = wordMap.entrySet();
            for (Map.Entry<Character, Integer> entry : entrySet) {
                // 获取每个字母和字母存在的个数
                Character key = entry.getKey();
                Integer value = entry.getValue();
                // 如果char的map中不存在word中的key，代表word里的字母需要value个问好
                if (!charMap.containsKey(key)){
                    needNum += value;
                }
                // 如果word中字母的个数减去char中字母的个数大于零，说明需要word减去char的个数
                else if(value - charMap.get(key) > 0){
                    needNum += (value - charMap.get(key));
                }
            }
            // 如果char中的万能符问好，不为空
            if (charMap.get('?') != null){
                // 且需要的万能福问好小于实际存在的
                if (needNum <= charMap.get('?') ){
                    // 结果加1
                    res ++;
                }
            }
            // 如果char中的万能符问好，为空
            else {
                // 且需要的值为0
                if (needNum == 0){
                    // 结果加1
                    res ++;
                }
            }
        }
        System.out.println(res);
    }
}
