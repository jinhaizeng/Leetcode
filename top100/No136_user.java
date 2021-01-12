class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i < nums.length; ++i) {
            if(map.get(nums[i]) == null || map.get(nums[i]) != 1) {
                map.put(nums[i], 1);
            } else {
                map.remove(nums[i]);
            }
        }
        for (Integer i : map.keySet()) {
            return i;
        }
    }
}