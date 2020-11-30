class Solution {
public:
    int search(vector<int>& nums, int target) {
        int length = nums.size();
        if (length == 0) {
            return -1;
        }

        if (nums[0] == target) {
            return 0;
        }
        int i = 0;
        //升序数组的遍历
        if (nums[0] < target) {
            while ( i < length && nums[i] < target) {
                ++i;
            }
        } else {
            //降序数组的遍历
            i = length - 1;
            while (i > 0 && nums[i] > target) {
                --i;
            }
        }
        if (i > 0 && i < length && nums[i] == target) {
            return i;
        } else {
            return -1;
        }
}
};