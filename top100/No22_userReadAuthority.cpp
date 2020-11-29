class Solution {
public:
/*一看官方答案的写法
    vector<string> generateParenthesis(int n) {
        int leftCount = 0, rightCount = 0;
        vector<string> results;
        string result = "";
        if (n == 0) {
            return results;
        }
        generate(n, leftCount, rightCount, results, result);
        return results;
    }

    vector<string> generate(int n, int leftCount, int rightCount, vector<string> &results, string &result) {
        if (leftCount + rightCount == 2 * n) {
            results.push_back(result);
        }

        if (leftCount < n) {
            result.push_back('(');
            generate(n, leftCount + 1, rightCount, results, result);
            result.pop_back();
        }

        if (leftCount - rightCount > 0 && rightCount < n) {
            result.push_back(')');
            generate(n, leftCount, rightCount + 1, results, result);
            result.pop_back();
        }
    
    return results;
    }
    */
   //第二遍阅读官方文档后的写法
    vector<string> generateParenthesis(int n) {
        vector<string> results;
        string result = "";
        DLR(n, 0, 0, results, result);
        return results;
    }

    void DLR(int n, int leftCount, int rightCount, vector<string> &results, string &result) {
        if (result.size() == 2 * n) {
            results.push_back(result);
            return;
        }

        if (leftCount < n) {
            result.push_back('(');
            DLR(n, leftCount + 1, rightCount, results, result);
            result.pop_back();
        }

        if (leftCount > rightCount) {
            result.push_back(')');
            DLR(n, leftCount, rightCount + 1, results, result);
            result.pop_back();
        }
    }
};