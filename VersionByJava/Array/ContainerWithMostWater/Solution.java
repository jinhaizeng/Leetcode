package ArrayNO11Container;

public class Solution {
    public int maxArea(int[] height) {
        int leftPointer = 0;
        int rightPointer = height.length - 1;
        int presentContainer = 0;
        int maxContainer = 0;
        int containerHeight = 0;

        while (leftPointer < rightPointer) {
            containerHeight = (height[leftPointer] > height[rightPointer]) ? height[rightPointer] : height[leftPointer];
            presentContainer = containerHeight * (rightPointer - leftPointer);

            if (presentContainer > maxContainer) {
                maxContainer = presentContainer;
            }

            if (height[leftPointer] > height[rightPointer]) {
                rightPointer--;
            } else {
                leftPointer++;
            }
        }

        return maxContainer;
    }
}
