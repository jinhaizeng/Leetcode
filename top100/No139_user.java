class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        char[] words = s.toCharArray();
        length = words.length;
        int left=0, right=0;
        string temp = "";
        for(; right < length; ++right) {
            temp += String.valueOf(words[right]);
            if (wordDict.contains(temp)) {
                left = right;
                temp = "";    
            }
        }
        if (left = words.length -1) {
            return true;
        } else {
            return false;
        }
    }
}