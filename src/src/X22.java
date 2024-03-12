import java.util.*;

public class X22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String score = scanner.nextLine();
        String subject = scanner.nextLine();

        List<String> scoreList = Arrays.asList(score.split(" "));
        List<String> subjectList = Arrays.asList(subject.split(" "));
        HashMap<String, Integer> subjectHashMap = new HashMap<String, Integer>();
        HashMap<String, Integer> stringListHashMap = new HashMap<>();
        int pNum = Integer.parseInt(scoreList.get(0));
        int sNum = Integer.parseInt(scoreList.get(1));
        for (int j = 1; j <= sNum; j++) {
            String s = subjectList.get(j-1);
            subjectHashMap.put(s,j);
        }

        ArrayList<List> lists = new ArrayList<>();
        for (int i = 0; i < pNum; i++) {
            String student = scanner.nextLine();
            List<String> list = Arrays.asList(student.split(" "));
            lists.add(list);

        }

        String s = scanner.nextLine();
        if (subjectList.contains(s)){
            for (List list : lists) {
                System.out.println(list);
                stringListHashMap.put(list.get(0).toString(), Integer.parseInt(list.get(subjectHashMap.get(s)).toString()));
            }
        }else{
            for (List list : lists) {
                int count = 0;
                for (int i = 1; i < list.size(); i++) {
                    count += Integer.parseInt(list.get(i).toString());
                }
                stringListHashMap.put(list.get(0).toString(), count);
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(stringListHashMap.entrySet());
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                // 首先按值倒序排序
                if (o1.getValue() != o2.getValue()) {
                    return o2.getValue() - o1.getValue();
                } else {
                    // 当值相等时，按键的首字母ASCII码排序
                    return o1.getKey().charAt(0) - o2.getKey().charAt(0);
                }
            }
        });

        // 输出排序后的Map
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

//        System.out.println(stringListHashMap);
    }
}
