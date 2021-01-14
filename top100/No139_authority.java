class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> hashset = new HashSet<String>(wordDict);
        int length = s.length();
        boolean[] dp = new boolean[length+1];
        dp[0] = true;
        for(int i=1; i <= length; ++i) {
            for(int j=0; j < i; ++j) {
                if (dp[j] && hashset.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[length];
    }
}