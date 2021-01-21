class Solution {
    public int maxProduct(int[] nums) {
        int length = nums.length;
        int[] max = new int[length];
        int[] min = new int[length];
        max[0] = nums[0];
        min[0] = nums[0];
        for (int i = 1; i < length; ++i) {
            max[i] = max[i-1]*nums[i] > nums[i] ? max[i-1]*nums[i] : nums[i];
            max[i] = min[i-1]*nums[i] > max[i] ? min[i-1]*nums[i] : max[i];

            min[i] = max[i-1]*nums[i] < nums[i] ? max[i-1]*nums[i] : nums[i];
            min[i] = min[i-1]*nums[i] < min[i] ? min[i-1]*nums[i] : min[i];
        }
        int maxResult = max[0];
        for(int i=0; i < length; ++i) {
            maxResult = maxResult > max[i] ? maxResult : max[i];
        }
        return maxResult;
    }
}