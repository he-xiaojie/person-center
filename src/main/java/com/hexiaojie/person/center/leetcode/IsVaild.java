package com.hexiaojie.person.center.leetcode;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 */
public class IsVaild {
    public static void main(String[] args) {
        System.out.println(isValid("(){}}{"));
    }

    private static boolean isValid(String s){
        char[] chars = s.toCharArray();


        Stack<Character> stack = new Stack<>();
        int length = s.length();
        for(int i = 0; i < length; i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                //压栈
                stack.push(c);
            } else{
                if(stack.empty()){
                    return false;
                }
                Character pop = stack.pop();
                if(pop != '(' && c == ')'){
                    return false;
                }
                if(pop != '{' && c == '}'){
                    return false;
                }
                if(pop != '[' && c == ']'){
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
