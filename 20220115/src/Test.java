import java.lang.reflect.Array;
import java.util.Stack;

/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2022-01-15
 *
 * OJ questions
 */
public class Test {
    //括号匹配问题。 Leetcode 20. 有效的括号
    // "({)}" 不匹配； “（{}）” 匹配
/*    1. 左括号多
    2. 右括号多
    3. 左右顺序不匹配*/
    // 解题思路：如果是左括号，入栈；如果是右括号，peek() == s[i],就出栈；还需要看栈是否是空，右括号是否还有剩余
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if( ch == '[' || ch == '(' || ch == '{') {
                // 左括号，入栈
                stack.push(ch);
            } else {
                //右括号
                if(stack.empty()) {
                    System.out.println("More right brackets");
                    return false;
                }
                char top = stack.peek(); // 看是哪个左括号
                if(top == '(' && ch == ')' || top == '{' && ch == '}' || top == '[' && ch == ']') {
                    stack.pop();
                }else {
                    System.out.println("左右括号不匹配");
                    return false; // 左右括号不匹配
                }
            }
        }
        // for loop走完，stack不为空
        if(stack.empty() == false) {
            System.out.println("左括号多");
            return false;
        }
        return true;
    }


    // Leetcode 155.最小栈,O(1)时间复杂度，需要用两个栈，一个是普通栈，一个是最小栈存每次比较后的最小值
    public class MinStack{
        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }
        public void push(int val) {
            // 普通栈，都会放入val
            stack.push(val);
            if (!minStack.empty()) {
                // 拿到minstack栈顶的元素
                int top = minStack.peek();
                // 比较，如果val小于等于top，那么就push到minStack
                if(top >= val) {
                    minStack.push(val);
                }
            } else {
                // minStack空的时候，必须push
                minStack.push(val);
            }
        }

        //stack出栈的时候，要检查是否和minStack栈顶的元素一样，否则最小值就会有误
        public void pop() {
            int popVal = stack.pop();
            if(!minStack.empty()) {
                int top = minStack.peek();
                if(popVal == top) {
                    minStack.pop();
                }
            }
        }

        public int top() {
            return stack.peek();
        }
        public int getMin() {
            return minStack.peek();
        }
    }

}
