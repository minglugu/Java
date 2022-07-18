import java.util.Scanner;
import java.util.Stack;

/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2022-01-15
 * @description 前中后缀表达式: CSDN
 */
public class TestDemo {


    // https://www.nowcoder.com/practice/d77d11405cc7470d82554cb392585106?tpId=13&tqId=11174&ru=/exam/oj
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        int j = 0; // j定义到for loop外面
        for (int i = 0; i < pushA.length; i++) {
            // for (int j = 0; j < pushA.length; j++)
            stack.push(pushA[i]);
            while (j < popA.length && !stack.empty() && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }
/*      while (j < popA.length) {
            if(pushA[i] != popA[j]) {
                stack.push(pushA[i]);
            } else {
                stack.pop();
                j++;
            }
        }
*/
        }
        return stack.empty();
    }

    public static void main2(String[] args) {
        //Leetcode 150. 逆波兰表达式求值
        // https://leetcode.com/problems/evaluate-reverse-polish-notation/submissions/

        String[] tokens = {"3", "4", "+", "5", "*"};
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            String val = tokens[i];
            if(!isOperator(val)) {
               // 不是运算符 isOperator == false
                stack.push(Integer.parseInt(val));
            }else {
                // 到底是什么运算符
                int num2 = stack.pop(); // right of operator
                int num1 = stack.pop(); // left of operator
                switch(val) {
                    case "+":
                        stack.push(num1 + num2); // push result to the stack
                        break;
                    case "-":
                        stack.push(num1 - num2); // push result to the stack
                        break;
                    case "*":
                        stack.push(num1 * num2); // push result to the stack
                        break;
                    case "/":
                        stack.push(num1 / num2); // push result to the stack
                        break;
                }
            }
        }
        stack.pop();
    }

    private static boolean isOperator(String x) {
        if(x.equals("+") || x.equals("-") || x.equals("*") || x.equals("/")) {
            return true;
        }
        return false;
    }

    public static void main1(String[] args) {
        // stack
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());// pop the top element of the stack and delete it
        System.out.println(stack.peek());// get the top element of the stack without deleting it
        System.out.println(stack.pop());// pop the top element of the stack and delete it

        System.out.println(stack.empty());
        System.out.println("=============");
        System.out.println(stack.isEmpty());// Stack extends Vector
    }


}
