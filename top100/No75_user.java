class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        int redIndex=-1, whiteIndex=-1, blueIndex=-1;
        for (int i=0; i < nums.length; ++i) {
            switch(nums[i]) {
                case 0:
                    redIndex++;
                    whiteIndex++;
                    blueIndex++;
                    result.add(redIndex, nums[i]);
                    break;
                case 1:
                    whiteIndex++;
                    blueIndex++;
                    result.add(whiteIndex, nums[i]);
                    break;
                case 2:
                    blueIndex++;
                    result.add(blueIndex, nums[i]);
                    break;
            }

        }
        //感觉开销有点大，这个方法暂时不考虑了，直接看答案吧
    
        nums = (int []) result.toArray(b);
    }
}