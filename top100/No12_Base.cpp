class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        int size = nums.size();
        int a = 0, b = 0, c = 0;
        vector<int> sonVector;
        vector<vector<int>> fatherVector;
        while (a < size) {
            b = a + 1;

            while (b < size) {
                c = b + 1;

                while (c < size) {
                    sonVector.clear();
                    if (nums[c] == -(nums[a]+nums[b])) {
                        sonVector.push_back(nums[a]);
                        sonVector.push_back(nums[b]);
                        sonVector.push_back(nums[c]);
                        std::sort(sonVector.begin(), sonVector.end());
                        if (std::find(fatherVector.begin(), fatherVector.end(), sonVector) == fatherVector.end()) {
                            fatherVector.push_back(sonVector);
                        } 
                        
                    }

                    c++;
                }

                b++;
            }
            a++;
        }

        return fatherVector;
    }
};