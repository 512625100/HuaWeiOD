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
        for (int n = 0 ; n < primeNumber.size() ; n++){
            Integer i1 = primeNumber.get(n);
            for (int m = 0 ; m < primeNumber.size() ; m++) {
                Integer i2 = primeNumber.get(m);
                if (i1 * i2 == num) {
                    all.add(i1*i2);
                    if (i1 < i2) {
                        System.out.println(i1 + " " + i2);
                    }
                }
            }
        }
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

