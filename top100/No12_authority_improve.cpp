//一层循环+双指针，减小时间复杂度 O(N^2)
class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> result;
        int length = nums.size();
        std::sort(nums.begin(), nums.end());
        int firstPoint = 0, secondPoint = 0, thirdPoint = 0;

        for (firstPoint = 0; firstPoint < length - 2; ++firstPoint) {
            if (firstPoint > 0 && nums[firstPoint] == nums[firstPoint - 1]) {
                continue;
            }

            secondPoint = firstPoint + 1;
            thirdPoint = length -1;
            for (; secondPoint < thirdPoint; ++secondPoint) {
                if (secondPoint > firstPoint + 1 && nums[secondPoint] == nums[secondPoint - 1]) {
                    continue;
                }

                while (secondPoint < thirdPoint && nums[secondPoint] + nums[thirdPoint] + nums[firstPoint] > 0) {
                    thirdPoint--;
                }

                if (secondPoint == thirdPoint) {
                    break;
                }


                if (nums[firstPoint] + nums[secondPoint] + nums[thirdPoint] == 0 ) {
                    result.push_back({nums[firstPoint], nums[secondPoint], nums[thirdPoint]});
                }
            }
        }

        return result;
    }
};