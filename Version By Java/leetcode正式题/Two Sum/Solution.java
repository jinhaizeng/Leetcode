//第一种思路，两层遍历，依次相加找到对应的结果，
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] elment = new int[2];
        for(int i=0; i < nums.length ; ++i){
            for(int j=i+1; j < nums.length ; ++j){
                if(nums[i]+nums[j] == target){
                    elment[0] = i;
                    elment[1] = j;
                    return elment;
                }  
            }
        }
        return  elment;
    }
}
//第二种思路，一层遍历加map的方法来实现
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] elment = new int[2];
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0; i < nums.length ; ++i){
            if(map.containsKey(target - nums[i])){
                elment[1] = i;
                elment[0] = map.get(target - nums[i]);
                return elment;
            }
            map.put(nums[i],i);
        }
        return elment;
    }
}