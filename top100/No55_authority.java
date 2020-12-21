class Solution {
    public boolean canJump(int[] nums) {
        int availableLength = 0;
        int length = nums.length;
        for(int i=0; (i < length) && (availableLength <= length -1); ++i) {
            if (availableLength < i) {
                return false;
            }
            availableLength = availableLength > i+nums[i] ? availableLength : i+nums[i];
        }
        return (availableLength >= length -1) ? true :false;
    }
}