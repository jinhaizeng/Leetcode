class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1){
            return nums[0];
        }

        int length = nums.length;
        int[] money = new int[length];
        money[0] = nums[0];
        money[1] = Math.max(nums[0], nums[1]);
        for(int i=2; i < length; i += 2) {
            money[i] = Math.max(money[i-2] + nums[i], money[i-1]);
            if (i+1 < length) {
                money[i+1] = Math.max(money[i-1] + nums[i+1], money[i]);
            }
        }
        return Math.max(money[length - 2],money[length -1]);
    }
}