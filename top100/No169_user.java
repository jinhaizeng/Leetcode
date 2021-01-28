class Solution {
    public int majorityElement(int[] nums) {
        int length = nums.length;
        int maj = nums[0];
        int count = 0;
        for (int i=1; i < length; ++i) {
            if (maj == nums[i]) {
                count++;
            } else {
                if (count == 0) {
                    maj = nums[i];
                } else {
                    count--;
                }
            }
        }
        return maj;
    }
}