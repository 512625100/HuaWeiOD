import java.util.*;

/**
 * @Description:
 * 题目描述:
 * 用数组代表每个人的能力，一个比赛活动要求参赛团队的最低能力值Q为N，每个团队可以由1人或2人组成，且1个人只能参加1个团队，请计算出最多可以派出多少支符合要求的团队?输入描述:
 * 6
 * 31579
 * 8
 * 第一行数组代表总人数，范围[1.500000]
 * 第二行数组代表每个人的能力，每个元素的取值范围[1,500000]，数组的大小范围[1.500000]第三行数值为团队要求的最低能力值，范围[1.500000]输出描述:
 * 3
 * 最多可以派出的团队数量
 * @Author: 徐洪超
 * @Date: 2024/3/08
 */


public class X18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入代表总人数：");
        int nums = scanner.nextInt();
        System.out.println("请输入每个人的能力值：");

        // 创建存储能力值的list
        ArrayList<Integer> valueList = new ArrayList<>();
        for (int i = 0; i < nums; i++) {
            // 没输入一个能力值，向list加一个
            int values = scanner.nextInt();
            valueList.add(values);
        }
        System.out.println("请输入最低能力值：");
        int minValue = scanner.nextInt();
        int res = 0;
        // 对能力值列表从大到小降序
        valueList.sort(Comparator.reverseOrder());
        // 遍历能力值列表
        for (int i = 0; i < valueList.size();i++) {
            // 列表里的第一个数字
            Integer i1 = valueList.get(i);
            // 列表中的第二个数字
            Integer i3 = valueList.get(i + 1);
            // 判断第一个和第二个数字的和大不大于最低能力值，如果不大于最低能力值，代表无法再组成两人组了
            if (i1 + i3 >= minValue){
                // 判断第一个数字是否大于等于最低能力值，如果大于则可以自己组成一组
                if (i1 >= minValue){
                    // 从列表中删除第一个人
                    valueList.remove(i);
                    // 对结果加1
                    res ++;
                }
                // 判断第一个值是不是小于最小能力值
                else if (i1 < minValue){
                    // 遍历能力值列表，从后向前遍历
                    for (int j = valueList.size()-1; j >=0 ; j--) {
                        // 获取能力值列表中最小的值
                        Integer i2 = valueList.get(j);
                        // 如果能力值列表中的第一个和最后一个的和大于最小能力值
                        if (i1 + i2 >= minValue){
                            // 删除列表中的最后一个
                            valueList.remove(j);
                            // 删除列表中的第一个
                            valueList.remove(i);
                            // 结果加1
                            res ++;
                            // 退出循环
                            break;
                        }
                        // 遍历数字减1
                        j--;
                    }
                }
            }
            // 如果能力值列表的第一个数字和第二个数字的和小于最小能力值，退出循环
            else {
                break;
            }
            // 遍历数字减一，是为了最外层循环永远从列表的第一个值开始获取
            i --;
        }
        System.out.println(res);

    }
}
