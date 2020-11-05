class Solution {
public:
    int maxArea(vector<int>& height) {
        //以下内容为基础做法
        int leftPoint = 0;
        int rightPoint = height.size() - 1;
        int maxContainer = 0;

        while (leftPoint < rightPoint) {
            int tempContainer = min(height[leftPoint], height[rightPoint]) * (rightPoint - leftPoint);
            maxContainer = max(maxContainer, tempContainer);
            if (height[leftPoint] <= height[rightPoint]) {
                leftPoint++;
            } else {
                rightPoint--;
            }
        }

        return maxContainer;
    }
};