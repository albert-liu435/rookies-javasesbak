package com.rookie.bigdata.easy.A0020;

/**
 * @ClassName Solution
 * @Description Solution
 * @Author
 * @Date 2020/7/1 9:38
 * @Version 1.0
 * <p>
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {


    public static boolean isValid(String s) {

        char[] stack = new char[s.length() - 1];
        int top = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack[top++] = c;
            } else if (c == ')' && stack[--top] != '(') {
                return false;
            }else if (c == '}' && stack[--top] != '{') {
                return false;
            }else if (c == ']' && stack[--top] != '[') {
                return false;
            }
        }


        return top==0;
    }


    public static void main(String[] args) {
        System.out.println(isValid("()[]{}({[]})"));
        System.out.println(isValid("(])]"));
    }

}
