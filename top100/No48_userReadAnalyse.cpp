    class Solution {
    public:
        void rotate(vector<vector<int>>& matrix) {
            int length = matrix[0].size();
            //矩阵转置
            for (int i = 0; i < length; ++i) {
                for (int j=i; j < length; ++j) {
                    swap(matrix[j][i], matrix[i][j]);
                }
            }
            //矩阵列翻转
            for (int i=0; i < length; ++i) {
                for (int j=i; j <= length/2; ++j) {
                    swap(matrix[i][j], matrix[i][length - 1 -j]);   
                }
            }
        }
    };