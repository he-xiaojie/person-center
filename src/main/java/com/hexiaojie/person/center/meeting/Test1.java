package com.hexiaojie.person.center.meeting;

import java.util.Stack;

public class Test1 {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
     * 输入：s = "()[]{}"
     * 输出：true
     */

    public static void main(String[] args) {

        System.out.println(isValid("()[]{}"));
    }

    public static boolean  isValid(String s){
        int length = s.length();
        if(length == 0){
           return false;
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(int i = 0; i < length; i++){
            char c = chars[i];
            if(c == '(' || c == '{' || c == '['){
               stack.push(c);
            }else{
                if(stack.empty()){
                    return false;
                }
                Character popC = stack.pop();
                if(popC != '(' && c == ')'){
                    return false;
                }
                if(popC != '{' && c == '}'){
                    return false;
                }
                if(popC != '[' && c == ']'){
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
