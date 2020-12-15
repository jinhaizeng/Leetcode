class Solution {
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int[] maxCa = new int[length];
        int maxSub =0;
        maxCa[0] = nums[0];
        maxSub = maxCa[0];
        for(int i=1; i < length; ++i) {
            maxCa[i] = (maxCa[i-1] + nums[i] > nums[i]) ? maxCa[i-1] + nums[i] : nums[i];
            maxSub = (maxCa[i] > maxSub) ? maxCa[i] : maxSub;
        }
        return maxSub;
    }
}