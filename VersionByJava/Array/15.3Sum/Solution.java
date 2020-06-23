package ArrayNO153Sum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for (int firstIndex=0; firstIndex < nums.length - 2; ++firstIndex) {
            if ((firstIndex == 0) || (nums[firstIndex - 1] != nums[firstIndex])) {
                int secondIndex = firstIndex + 1;
                int thirdIndex = nums.length - 1;
                int remainder = 0 - nums[firstIndex];

                while (secondIndex < thirdIndex) {
                    if (nums[secondIndex] + nums[thirdIndex] == remainder) {
                        result.add(Arrays.asList(nums[firstIndex], nums[secondIndex], nums[thirdIndex]));
                        while ((secondIndex < thirdIndex) && (nums[secondIndex + 1] == nums[secondIndex])) {
                            ++secondIndex;
                        }

                        while ((secondIndex < thirdIndex) && (nums[thirdIndex - 1] == nums[thirdIndex])) {
                            --thirdIndex;
                        }

                        ++secondIndex;
                        --thirdIndex;
                    } else if (nums[secondIndex] + nums[thirdIndex] < remainder) {
                        while ((secondIndex < thirdIndex) && (nums[secondIndex + 1] == nums[secondIndex])) {
                            ++secondIndex;
                        }

                        ++secondIndex;
                    } else {
                        while ((secondIndex < thirdIndex) && (nums[thirdIndex - 1] == nums[thirdIndex])) {
                            --thirdIndex;
                        }

                        --thirdIndex;
                    }
                }
            }
        }

        return result;
    }
}
