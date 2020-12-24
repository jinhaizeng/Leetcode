class Solution {
    public void sortColors(int[] nums) {
        int length = nums.length;
        int redIndex=0, blueIndex=length - 1;
        for (int i=0; i <= blueIndex; ++i) {
            if (2 == nums[i]) {
                while((i <= blueIndex) && nums[i] == 2) {
                    swap(nums, i, blueIndex);
                    blueIndex--;
                }
            }
            if (0 == nums[i]) {
                swap(nums, i, redIndex);
                redIndex++;
            }
        }
    }
    public void swap(int[] nums, int i, int index) {
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }
}