/*
LeetCode 1544: Make The String Great

Approach:
- Use `result` as a stack.
- Traverse each character:
   - If top of stack differs from current by 32 → pop.
   - Else, push.
*/

#include <bits/stdc++.h>
using namespace std;

string makeGood(string s) {
    int n = s.size();
    string result = "";
    int i = 0;
    while (i < n) {
        if (result.empty()) { // ✅ instead of result==""
            result.push_back(s[i]);
            i++;
        }
        else if (abs(result.back() - s[i]) == 32) { // ✅ simplified check
            result.pop_back();
            i++;
        }
        else {
            result.push_back(s[i]);
            i++;
        }
    }
    return result;
}

int main() {
    string s;
    cin >> s;
    cout << makeGood(s) << endl;
    return 0;
}
