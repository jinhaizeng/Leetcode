class Solution {
public:
    int search(vector<int>& nums, int target) {
        if (nums.size() == 0) {
            return -1;
        }

        if (nums[0] == target) {
            return 0;
        }
        //升序数组的遍历
        if (nums[0] < target) {
            int i = 0;
            while ( i < nums.size() && nums[i] < target) {
                ++i;
            }
            if (i < nums.size() && nums[i] == target) {
                return i;
            } else {
                return -1;
            }
        } else {
            //降序数组的遍历
            int i = nums.size() - 1;
            while (i > 0 && nums[i] > target) {
                --i;
            }
            if (i > 0 && nums[i] == target) {
                return i;
            } else {
                return -1;
            }
        }
    }
};