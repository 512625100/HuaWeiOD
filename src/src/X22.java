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

        List<Map.Entry<String,Integer>> mapList = new ArrayList<>(stringListHashMap.entrySet());
        Collections.sort(mapList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o2.getValue() > o1.getValue()){
                    return -1;
                }else if (o2.getValue() == o1.getValue()){

                }
                return 0;
            }
        });

        mapList.forEach(entry -> System.out.print(entry.getKey() + " "));

//        System.out.println(stringListHashMap);
    }
}
