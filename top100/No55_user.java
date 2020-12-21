class Solution {
    public boolean canJump(int[] nums) {
        return dfs(nums, 0);
    }

    public boolean dfs(int[] nums, int root) {
        boolean result = false;
        System.out.println("zengjinhai, root: " + root );

        if(0 == nums.length || root >= nums.length - 1) {
            return true;
        }

        if(root < nums.length) {
            int step = nums[root];
            for(int i=step; i > 0; --i) {
                System.out.println("root: " + (root + i) + "result: " + result);
                result = dfs(nums, root + i);
                if(result) return result;
            }
        }
        return result;
    }
}