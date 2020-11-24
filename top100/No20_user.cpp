class Solution {
public:
    bool isValid(string s) {
        stack<char> strStack;
        int length = s.size();
        int i = 0;
        while(i < length) {
            if(strStack.empty() || !isEqual(strStack.top(), s[i])) {
                strStack.push(s[i]);
            } else {
                strStack.pop();
            }
            i++;
        }
        if (strStack.empty()) {
            return true;
        }  else {
            return false;
        }
    }

    bool isEqual(const char& str1, const char& str2) {
        switch(str1) {
            case '(':
                return (str2 == ')') ? true : false;
            case '{':
                return (str2 == '}') ? true : false;
            case '[':
                return (str2 == ']') ? true : false;
            default :
                return false;
        }
    }
};