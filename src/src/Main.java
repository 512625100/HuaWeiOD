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

        int number = scanner.nextInt();
        int N = scanner.nextInt();
        int X = scanner.nextInt();

        int[] return_list = new int[number];
        int[] risk_list = new int[number];
        int[] max_cost_list = new int[number];

        for (int i = 0; i < number; i++) {
            return_list[i] = scanner.nextInt();
        }

        for (int i = 0; i < number; i++) {
            risk_list[i] = scanner.nextInt();
        }

        for (int i = 0; i < number; i++) {
            max_cost_list[i] = scanner.nextInt();
        }

        int[] max_status = new int[number];
        int max_return = 0;
        int max_return_risk = 0;

        for (int i = 0; i < number; i++) {
            for (int j = i + 1; j < number; j++) {
                if (risk_list[i] + risk_list[j] <= X) {
                    int max_return_product_index = return_list[i] > return_list[j] ? i : j;
                    int other_return_product_index = i + j - max_return_product_index;
                    int max_return_cost = Math.min(N, max_cost_list[max_return_product_index]);
                    int other_return_cost = Math.min(N - max_return_cost, max_cost_list[other_return_product_index]);
                    int cur_return = return_list[max_return_product_index] * max_return_cost + return_list[other_return_product_index] * other_return_cost;
                    if (cur_return > max_return) {
                        max_return = cur_return;
                        max_return_risk = risk_list[i] + risk_list[j];
                        max_status[max_return_product_index] = max_return_cost;
                        max_status[other_return_product_index] = other_return_cost;
                    }
                }
            }
        }

        for (int i = 0; i < number; i++) {
            System.out.print(max_status[i] + " ");
        }
    }
}