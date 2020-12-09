class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> hashmap;
        int length = strs.size();
        for (int i =0; i < length; ++i) {
            char cKey[] = vector<i>.c_str();
            std::sort(cKey, 0,cKey.size());
            string key = cKey;
            vector<string>::iterator it = find(hashmap.begin(), hashmap.end(), key);
            if (it == hashmap.end()) {
                hashmap.push_back(key, new vector<string>());
            }

        }
        string iter = 
    }
};
