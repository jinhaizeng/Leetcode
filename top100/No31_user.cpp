class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int length = nums.size();
        if (length == 0) {
            return;
        }
        int point = length - 1;
        while (point > 1 && nums[point - 1] >= nums[point]) {
            --point;
        }

        if (point > 1) {
            int temp = nums[point - 1];
            nums[point - 1] = nums[point];
            nums[point] = temp;
        } else {
            if (nums[point - 1] < nums[point]) {
                
            }
            sort(nums.begin(), nums.end());
        }
    }
};