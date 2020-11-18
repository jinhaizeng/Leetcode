class Solution {
public:
    vector<string> letterCombinations(string digits) {
        vector<string> result;
        string combination;
        if (digits.empty()) {
            return result;
        }

        unordered_map<char, string> phoneMap {
            {'2', "abc"},
            {'3', "def"},
            {'4', "ghi"},
            {'5', "jkl"},
            {'6', "mno"},
            {'7', "pqrs"},
            {'8', "tuv"},
            {'9', "wxyz"}
        };

        WFS(result, phoneMap, combination, digits, 0);
        return result;
    }

    void WFS(vector<string>& result, unordered_map<char, string>& phoneMap,
            string& combination, const string& digits, int start) {
        if (start == digits.size()) {
            result.push_back(combination);
        } else {
            const char& num = digits[start];
            const string& letters = phoneMap.at(num);
            for (const char& letter : letters) {
                combination.push_back(letter);
                WFS(result, phoneMap, combination, digits, start + 1);
                combination.pop_back();
            }
        }
    }
};