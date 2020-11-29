class Solution {
public:
    vector<string> generateParenthesis(int n) {

    }

    vector<string> generate(int n, int leftCount, int rightCount, vector<string> &result) {
        if (leftCount + rightCount == n) {
            return result;
        } else if (leftCount == 0 || leftCount == rightCount) {
            result.push_back('(');
            leftCount++;
            generate(n, leftCount, rightCount, result);
        } else if (leftCount == n) {
            result.push_back(')');
            rightCount++;
            generate(n, leftCount, rightCount, result);
        }
    }
};