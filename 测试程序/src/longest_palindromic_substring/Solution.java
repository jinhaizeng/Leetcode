package longest_palindromic_substring;

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


//public class Solution {
//    public String longestPalindrome(String s) {
//        if( s == ""){
//            return s;
//        }
//        char[] charStr = s.toCharArray();
//        int header = 0 ,tail = 0;
//        int fianlHeader = 0,fianlTail = 0;
//        int length = 0, maxLength = 0;
//
//        for(int i = 0; i < s.length(); ++i){
//            header = i;
//            tail = header + 1;
//            length = 0;
//
//            //尾指针越界情况还需要处理
//            if(tail == s.length()){
//                length = 1;
//                if(length > maxLength){
//                    maxLength = length;
//                    fianlHeader = i;
//                    fianlTail = i;
//                }
//                continue;
//            }
//
//            if(charStr[header] != charStr[tail]){
//                --header;
//                //头指针越界
//                if(header < 0){
//                    maxLength = 1;
//                    fianlHeader = i;
//                    fianlTail = i;
//                    continue;
//                }
//                length = 1;
//                if(length > maxLength){
//                    maxLength = length;
//                    fianlHeader = header + 1;
//                    fianlTail = fianlHeader;
//                }
//            }
//
//            while( header >= 0 && tail < s.length() && charStr[header] == charStr[tail]){
//                length += 2;
//
//                if(length > maxLength){
//                    maxLength = length;
//                    fianlHeader = header;
//                    fianlTail = tail;
//                }
//
//                --header;
//                ++tail;
//
//            }
//        }
//        StringBuilder sb = new StringBuilder();
//        for(int i = fianlHeader; i <= fianlTail ; ++i){
//            sb.append(charStr[i]);
//        }
//
//        return sb.toString();
//    }
//}
