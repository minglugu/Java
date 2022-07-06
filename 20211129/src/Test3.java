import java.util.*;

/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2021-11-29
 * @杨辉三角
 */
public class Test3 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        // 1st row
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        ret.add(list1); //第一行数据存放到ret中
        for (int i = 1; i < numRows; i++) {
            // 每行都有一个list
            List<Integer> list = new ArrayList<>();
            list.add(1); // 每一行的第一个元素是1
            // j < i, 那么就没有到最后一个元素
            // 中间的情况：[i][j] = [i-1][j] + [i-1][j-1], ret的上面一行
            // 找到前面一行
            List<Integer> preRow = ret.get(i-1);
            for (int j = 1; j < i; j++) {
                int num = preRow.get(j) + preRow.get(j-1) ;
                //list.set(j, num);
                list.add(num);
            }
            list.add(1); // 每一行的最后一个元素是1

            // 上面结束了每一行的添加后，把这一行加到reg里面。
            ret.add(list);

        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numRows = sc.nextInt();

        List<List<Integer>> ret = generate(numRows);
        System.out.println(ret);
    }
}