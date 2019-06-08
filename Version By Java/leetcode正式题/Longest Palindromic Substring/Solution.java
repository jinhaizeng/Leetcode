//方法二——中心周围展开法：确实可用的方法，解题思路也很清爽

//这个版本的代码还有点小臃肿，有一些没必要的运算还在这里面
class Solution {
    public String longestPalindrome(String s) {
        //判断是否为空这个操作永远都不要忘记呀
        if(s.length() == 0)
            return "";
        char[] arr = s.toCharArray();
        int length = 0, maxLength = 0;
        int left = 0,right = 0;
        StringBuilder sb = new StringBuilder();

        //遍历2n-1个结点
        for(int i = 0; i < s.length() ; ++i){
            length = Math.max(palindromeHelper(arr , i , i),palindromeHelper(arr , i, i+1));
            if(length > maxLength){
                maxLength = length;
                left = i - (length - 1)/2;
                right = i + length/2;
            }
        }
        for(int i=left ; i <= right ; ++i){
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    public int palindromeHelper(char[] arr ,int left,int right){
        int length = 0;
        while(left >=0 && right < arr.length && arr[left] == arr[right]){
            
            length = right - left + 1;
            --left;
            ++right;
        }
        return length;
    }
}

//优化后的代码结构
class Solution {
    /**
     * 遍历这个字符串，看这个字符串的所有子串是否关于中心镜像对称
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        //判断是否为空这个操作永远都不要忘记呀
        //判断要从两个角度去看：对象s是否为空，对象s不为空但是其内部没有值
        if(s == null || s.length() == 0)
            return "";
        char[] arr = s.toCharArray();
        int length = 0, maxLength = 0;
        int left = 0,right = 0;
        StringBuilder sb = new StringBuilder();

        //遍历2n-1个结点
        for(int i = 0; i < s.length() ; ++i){
            length = Math.max(palindromeHelper(arr , i , i),palindromeHelper(arr , i, i+1));
            if(length > maxLength){
                maxLength = length;
                left = i - (length - 1)/2;
                right = i + length/2;
            }
        }
        for(int i=left ; i <= right ; ++i){
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    /**
     * 检查这个数组是否关于中心镜像对称
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public int palindromeHelper(char[] arr ,int left,int right){
        while(left >=0 && right < arr.length && arr[left] == arr[right]){
            //之前这一句反复更新长度，其实可以直接return right -left +1的，就算想要更新长度，也应该在遍历结束再更新
            //不然只会增加无端的计算
            --left;
            ++right;
        }
        return right - left - 1;
    }
}



//leetcode示例代码，处理的对象一直是字符串，没有必要将字符串转化为数组进行处理
public String longestPalindrome(String s) {
    if (s == null || s.length() < 1) return "";
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
        int len1 = expandAroundCenter(s, i, i);
        int len2 = expandAroundCenter(s, i, i + 1);
        int len = Math.max(len1, len2);
        if (len > end - start) {
            start = i - (len - 1) / 2;
            end = i + len / 2;
        }
    }
    return s.substring(start, end + 1);
}

private int expandAroundCenter(String s, int left, int right) {
    int L = left, R = right;
    //注意使用charAt来进行字符串的处理，不是所有时候都需要字符串转化为数组，然后进行处理。1
    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
        L--;
        R++;
    }
    return R - L - 1;
}