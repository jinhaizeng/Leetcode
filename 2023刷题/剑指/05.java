/**
 * 剑指 Offer 05. 替换空格
 */

/**
 * 最开始的思路，如果从工程的角度出发就应该考虑直接调用string的replace方法直接实现，其实就是s.replace(" ", "%20")
 */


/**
 * 如果不调用函数，要实现替换的话，就是遍历字符串，考虑将字符串转数组，遍历数组并处理，最后将数组转回到字符串，核心点就来到了Stirng和List的互相转换
 * 参考链接https://blog.csdn.net/qq_38749759/article/details/78945552
 */
class Solution {
    public String replaceSpace(String s) {
        String result = "";
        for (int i=0; i < s.length(); i++) {
            String cur = String.valueOf(s.charAt(i));
            result += " ".equals(cur) ? "%20" : cur;
        }
        return result;
    }
}

/**
 * 没有想到的思路，用StirngBuilder，char是否等于" "，直接用等号即可
 * StirngBuilder、StringBuffer和String的区别：https://cloud.tencent.com/developer/article/1655564
 */