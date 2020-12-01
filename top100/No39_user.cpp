class Solution {
public:
    //初步思路是没问题的，接下来的就是不能有子数组的问题
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<int> result;
        vector<vector<int>> results;
        find(candidates, target, results, result, 0);
        return results;
    }
    void find(vector<int>& candidates, int target, vector<vector<int>>& results, vector<int>& result, int left) {
        int length = candidates.size();
        for (int i = left; i < length; ++i) {
            if(target - candidates[i] == 0) {
                result.push_back(candidates[i]);
                results.push_back(result);
                result.pop_back();
            }
            if (target - candidates[i] > 0) {
                cout << "target: " << target << endl;
                cout << "candidates: " << candidates[i] << endl;
                result.push_back(candidates[i]);
                find(candidates, target - candidates[i], results, result, i);
                result.pop_back();
            }
        }
    }
};