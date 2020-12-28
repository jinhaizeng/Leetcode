//垃圾没搞出来
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subset = new ArrayList<Integer>();
        List<List<Integer>> subsets = new ArrayList<List<Integer>>();
        subsets.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; ++i) {
            backtrace(subsets, subset, i, nums);
            subset.clear();
        }
        return subsets;
    }
    public void backtrace(List<List<Integer>> subsets, List<Integer> subset, int end, int[] nums) {
        if ((end > nums.length -1) || subset.contains(nums[end])) {
            return;
        }

        subset.add(nums[end]);
        List<Integer> temp = new ArrayList<Integer>(subset)
        subsets.add(temp);
        for (int i = end; i < nums.length; ++i) {
            backtrace(subsets, temp, i, nums);
        }
    }
}