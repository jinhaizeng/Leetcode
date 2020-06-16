//第一种方法：相当于嵌套了三层循环，算法复杂度为O(n^3),面对巨量的数据时，会直接崩溃
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        int maxLength = 0;
        //遍历所有的子串，看所有的子串有没有重复的
        //返回长度的话，就不用care长度相同但是字符串内容不同的情况
        for(int i=0;i < arr.length; ++i){
            for(int j= i; j < arr.length ; ++j){
                if(isRepeated(arr ,i,j)){
                    int length = j - i + 1;
                    if(maxLength < length)
                        maxLength = length;
                }
            }
        }
        return maxLength;
    }


    /**
     * 用于判断字符串是不是重复的
     * @param strArr：传入待查重数组
     * @param start：数组开始位置
     * @param end：数组结束位置
     * @return 字符串不重复返回true，字符串重复返回false
     */
    public  boolean isRepeated(char[] strArr,int start ,int end){
        Set strSet = new HashSet();
        //第一次写的是：i = 0，明显是错误的，遍历开始的位置都不能确定
        for(int i=start ;i <= end; ++i){
            if(strSet.contains(strArr[i]))
                return false;
            else
                strSet.add(strArr[i]);
        }
        return true;
    }
}

//方法二：leetcode上面的思路
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        int maxLength = 0;
        int length = 0;
        for(int i=0, j=0; j < s.length(); ++j){
            //如果不重复子串汇总含有重复内容
            if(map.containsKey(s.charAt(j))){
                //此处有一个问题，因为map是不断往里面填充数据，有重复内容也不会把原来的数据删除掉，就比如abba这组数据，遍历到最后一个a的时候
                //如果直接查找上一个重复元素的位置+1，i=1，相当于回到了第一个b的位置，而现在在第二个b的位置。
                //总结下即有一个原则：左指针只可以往右走但是不可以往右走
                i = Math.max(i,map.get(s.charAt(j)) + 1);

            }
            //map的put函数有个小特性：如果是重复添加键值对，即key已经存在了，则直接减value更新至最新即可。（多去查查oracle的库，没坏处）
            map.put(s.charAt(j),j);
            length = j-i+1;
            maxLength = Math.max(maxLength,length);
        }
        return maxLength;
    }
}