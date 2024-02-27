public class X07 {
    public static void main(String[] args) {
//        int n = 100; // 设置要判断的最大值为100
//
//        System.out.println("100以内的质数有：");
//        for (int i = 2; i <= n; i++) {
//            if (isPrime(i)) {
//                System.out.print(i + " ");
//            }
//        }
        int j = 0;
        int i = 1;
        for (i = 2; i < 100; i++) {
            for (j = 2; j <= i; j++) {
                if ((i % j) == 0) {
                    break;

                }
            }
            if (j == i) {
                System.out.print(i + "  ");
            }
        }
    }

//    private static boolean isPrime(int num) {
//        if (num < 2) {
//            return false;
//        }
//        else if (num == 2 || num == 3) {
//            return true;
//        }
//        else if (num % 6 != 1 && num % 6 != 5) {
//            return false;
//        }
//        else {
//            int sqrtNum = (int) Math.sqrt((double) num);
//
//            for (int i = 5; i <= sqrtNum; i += 6) {
//                if (num % i == 0 || num % (i + 2) == 0) {
//                    return false;
//                }
//            }
//
//            return true;
//        }
//    }
}

