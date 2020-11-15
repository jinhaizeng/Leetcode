//此种官方第一步的解法，写着玩玩，没想到好超时了
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
            for (; secondPoint < length - 1; ++secondPoint) {
                if (secondPoint > firstPoint + 1 && nums[secondPoint] == nums[secondPoint - 1]) {
                    continue;
                }

                thirdPoint = secondPoint + 1;
                for (; thirdPoint < length; ++thirdPoint) {
                    if (thirdPoint > secondPoint + 1 && nums[thirdPoint] == nums[thirdPoint - 1]) {
                        continue;
                    }

                    if (nums[firstPoint] + nums[secondPoint] + nums[thirdPoint] == 0 ) {
                        result.push_back({nums[firstPoint], nums[secondPoint], nums[thirdPoint]});
                    }
                }
            }
        }

        return result;
    }
};