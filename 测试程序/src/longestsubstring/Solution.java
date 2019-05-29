package longestsubstring;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        //遍历所有的子串，看所有的子串有没有重复的
        for(int i=0;i < arr.length; ++i){
            for(int j=i+1; j < arr.length; ++j){
                
            }
        }

    }

    /**
     * 用于判断字符串是不是重复的
     * @param str
     * @return 字符串不重复返回true，字符串重复返回false
     */
    public boolean isRepeated(char[] strArr,int start ,int end){
        Set strSet = new HashSet();
        for(char i:strArr){
            if(strSet.contains(i))
                return false;
            else
                strSet.add(i);
        }
        return true;
    }
}
