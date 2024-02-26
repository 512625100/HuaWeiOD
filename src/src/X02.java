import java.util.*;

public class X02 {
    static  int maxSide = 18;

    public static void main(String[] args) {

        // 输入围棋棋子坐标
        Scanner in = new Scanner(System.in);
        // 围棋坐标转换成list
        List<String> locBlacks = Arrays.asList(in.nextLine().split(" "));
        List<String> locWhites = Arrays.asList(in.nextLine().split(" "));
        List<String> listBlacks = transform(locBlacks);
        List<String> listWhites = transform(locWhites);
        System.out.println(counting(listBlacks) + " " + counting(listWhites));
    }

    // 判断气的坐标
    static int counting(List<String> chess) {
        // 存放所有气的坐标
        ArrayList<String> all = new ArrayList<>();
        // 遍历棋子的坐标
        for (String o : chess) {
            // 添加棋子本身坐标
            all.add(o);
            String[] s = o.split("_");
            // 拆分棋子x坐标和y坐标
            Integer x = Integer.parseInt(s[0]);
            Integer y = Integer.parseInt(s[1]);
            // 气的坐标
            if (x >= 0) {
                // 判断是否超出棋盘
                if (x - 1 >= 0){
                    all.add((x - 1) + "_" + s[1]);
                }
            }
            if (x < maxSide) {
                if(x + 1 < maxSide){
                    all.add((x + 1) + "_" + s[1]);
                }
            }
            if (y >= 0) {
                if (y - 1 >= 0) {
                    all.add(s[0] + "_" + (y - 1));
                }
            }
            if (y < maxSide) {
                if (y + 1 < maxSide) {
                    all.add(s[0] + "_" + (y + 1));
                }
            }
        }
        // 棋盘坐标去重
        HashSet<Object> objects = new HashSet<>(all);
        // 去重的坐标减去棋子本身坐标
        return  objects.size() - chess.size();
    }

    // 输入的数组转换成list
    static List transform(List locs) {
        ArrayList<String> all = new ArrayList<>();
        for (int i = 0;i < locs.size();){
            all.add(locs.get(i) + "_" + locs.get(i + 1));
            i += 2;
        }
        return all;
    }
}