class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<int> result;
        vector<vector<int>> results;
        vector<int> visit(nums.size());
        dfs(nums, result, results, visit);
        return results;
    }
    void dfs (vector<int>& nums, vector<int>& result, vector<vector<int>>& results, vector<int>& visit) {
        int length = nums.size();
        //从DFS的角度来看，以下if的逻辑应该放在for外面而不是for里面
        //首先判断当前节点是否满足条件，不满足条件再遍历连接的所有节点
        if (result.size() == length) {
            results.push_back(result);
            return;
        }
        for (int i = 0; i < length; ++i) {
            if (visit[i] == 0) {
                result.push_back(nums[i]);
                visit[i] = 1;
                dfs(nums, result, results, visit);
                result.pop_back();
                visit[i] = 0;
            }   
        }
    }
};