import java.util.ArrayList;
import java.util.Scanner;

public class X07 {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数字：");
        int num = scanner.nextInt();
        int j = 0;
        int i = 1;
        ArrayList<Integer> primeNumber = new ArrayList<>();
        // 计算输入的数字以内有哪些素数
        for (i = 2; i < num; i++) {
            for (j = 2; j <= i; j++) {
                if ((i % j) == 0) {
                    break;
                }
            }
            if (j == i) {
                primeNumber.add(i);
            }
        }
        ArrayList<Integer> all = new ArrayList<>();
        // 遍历素数列表
        for (int n = 0 ; n < primeNumber.size() ; n++){
            // 按照顺序获取素数列表中的元素
            Integer i1 = primeNumber.get(n);
            // 遍历素数列表
            for (int m = 0 ; m < primeNumber.size() ; m++) {
                // 按照顺序获取素数列表中的元素
                Integer i2 = primeNumber.get(m);
                // 判断两个素数相乘是否和输入的相等
                if (i1 * i2 == num) {
                    // 相等加入到all列表中
                    all.add(i1*i2);
                    // 判断第一个素数是不是小于第二个素数
                    if (i1 < i2) {
                        // 如果小于输出
                        System.out.println(i1 + " " + i2);
                    }
                }
            }
        }
        // 判断all列表中是否有符合题目的数值，如果为空，代表没有，输出-1 -1
        if (all.isEmpty()){
            System.out.println(-1 + " " + -1);
        }
    }

}

//public class Main{
//
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//
//        int n = sc.nextInt();
//
//        List<Integer> list = new ArrayList<>();
//        int m = 0;
//        /**
//         * 本题就是求出一个数只有两个因子（1不是素数）
//         * 遍历n求出它所有的因子
//         */
//        while (m!=n){   //当n==m时说明已经不能再除了，跳出循环
//            n = m!=0? m: n;
//            for(int i=2;i<Math.sqrt(n)+1;i++){
//                if(n%i==0){
//                    m = n/i;    //把商作为下次的被除数
//                    list.add(i);    //i就是因子
//                    break;
//                }
//            }
//        }
//
//        list.add(m);
//
//        if(list.size()==2){
//            System.out.println(list.get(0)+" "+list.get(1));
//        }else {
//            System.out.println("-1 -1");
//        }
//    }
//}

