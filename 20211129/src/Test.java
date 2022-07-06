import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2021-11-29
 * @coding questions
 * https://www.nowcoder.com/questionTerminal/784efd40ed8e465a84821c8f3970b7b5
 * 输入一个字符串，求出该字符串包含的字符集合，按照字母输入的顺序输出
 */
public class Test {

    // method 1
    public static void func(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // sb用toString()转换成string，然后用ch+“ ”将char转换成String
            if(!sb.toString().contains(ch + "")) {
                sb.append(ch);
            }
        }
        System.out.println(sb.toString());
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // 牛客网里面的OJ题，需要处理循环输入
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            func(str);
        }
    }

    // method 2：利用哈希的思想
    // 定义一个整型数组（值对应的ASCII表），来标记当前这个字符是否出现过？出现过，那么标记为1.下次同样的字符出现，不是0，就不加入。
    public static String func2(String str) {
        StringBuilder strBuilder = new StringBuilder();
        // int[] array new int[58]; // 52 letter in lower and upper case and some other characters b/t Z and a.
        int[] array = new int[127];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i); //把char的ASCII值，作为array的index。 e.g. 'a' 在index为97的位置
            // if(array[ch-65] == 0) { // a is 65 in ASCII table, A放在index 0的位置
            // ch 'A'->[0], 'Z'->[25],'a'->[32],'z'->[57]
            if(array[ch] == 0) {
                strBuilder.append(ch);
                array[ch] = 1;
            }
        }
        return strBuilder.toString();
    }
}
