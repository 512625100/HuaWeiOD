import java.util.*;

public class X22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String score = scanner.nextLine();
        String subject = scanner.nextLine();
        // 存储分数列表
        List<String> scoreList = Arrays.asList(score.split(" "));
        // 存储学科列表
        List<String> subjectList = Arrays.asList(subject.split(" "));
        // 存储学科与数字对应的map {"shuxue" : 1 , "yuwen" : 2}
        HashMap<String, Integer> subjectHashMap = new HashMap<String, Integer>();
        // 存储学生与分数的map {"fangfang" : 185}
        HashMap<String, Integer> stringListHashMap = new HashMap<>();
        int pNum = Integer.parseInt(scoreList.get(0));
        int sNum = Integer.parseInt(scoreList.get(1));
        // 分居学科数字添加到map
        for (int j = 1; j <= sNum; j++) {
            String s = subjectList.get(j-1);
            subjectHashMap.put(s,j);
        }

        ArrayList<List> lists = new ArrayList<>();
        // 把输入的学生和各个学科的分数转换成list，存进list中
        for (int i = 0; i < pNum; i++) {
            String student = scanner.nextLine();
            List<String> list = Arrays.asList(student.split(" "));
            lists.add(list);
        }

        String s = scanner.nextLine();
        // 判断输入的学科是不是在学科的map中，
        // 如果存在,把学生和学科对应的数字在lists里分别获取出来
        // 如果学科对应的是1，就从[[fang,95,90],[xiao,88,90]]中获取95和88存到学生和分数的map中
        if (subjectList.contains(s)){
            for (List list : lists) {
                stringListHashMap.put(list.get(0).toString(), Integer.parseInt(list.get(subjectHashMap.get(s)).toString()));
            }
        }
        // 如果不存在，把学生和后面的分数之和存到map中
        else{
            for (List list : lists) {
                int count = 0;
                for (int i = 1; i < list.size(); i++) {
                    count += Integer.parseInt(list.get(i).toString());
                }
                stringListHashMap.put(list.get(0).toString(), count);
            }
        }

        // 把学生和获取的分数map进行转换成list
        List<Map.Entry<String, Integer>> list = new ArrayList<>(stringListHashMap.entrySet());
        // 对list进行排序
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                // 首先按值倒序排序
                if ((int)o1.getValue() != (int)o2.getValue()) {
                    return o2.getValue() - o1.getValue();
                } else {
                    // 当值相等时，按键的首字母ASCII码排序
                    return Character.getNumericValue(o1.getKey().charAt(0)) - Character.getNumericValue(o2.getKey().charAt(0));
                }
            }
        });

        // 输出排序后的Map
        for (Map.Entry<String, Integer> entry : list) {
            System.out.print(entry.getKey() + " ");
        }
    }
}
