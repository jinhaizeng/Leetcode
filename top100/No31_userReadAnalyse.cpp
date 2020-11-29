class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int length = nums.size();
        if (length <= 1) {
            return;
        }

        int point = length - 2;
        while (point >= 0 && nums[point] >= nums[point + 1]) {
            --point;
        }

        if (point >= 0) {
            int second = length - 1;
            while (nums[point] >= nums[second]) {
                --second;
            }
            swap(nums[point], nums[second]);
        }
        
        reverse(nums.begin() + point + 1, nums.end());
    }
};