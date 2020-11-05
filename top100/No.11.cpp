class Solution {
public:
    int maxArea(vector<int>& height) {
        //以下内容为自己尝试的优化解法 超出时间限制，需要调试，有时间自己写程序调试吧
        int leftPoint = 0;
        int rightPoint = height.size() - 1;
        int maxContainer = 0;

        while (leftPoint < rightPoint) {
            int tempContainer = min(height[leftPoint], height[rightPoint]) * (rightPoint - leftPoint);
            maxContainer = max(maxContainer, tempContainer);
            if (height[leftPoint] <= height[rightPoint]) {
                while ((leftPoint < height.size() -1) && (height[leftPoint + 1] <= height[leftPoint])) {
                    leftPoint++;
                }
            } else {
                while ((rightPoint > 0) && (height[rightPoint - 1] <= height[rightPoint])) {
                    rightPoint--;
                }
            }
        }

        return maxContainer;
    }
};