/*
LeetCode 1704: Determine if String Halves Are Alike

Approach 1:
- Divide string into two halves.
- Count vowels in each half using an unordered_set.
- Compare counts.
*/
// bool isVowel(char c) {
//     return c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||
//            c=='A'||c=='E'||c=='I'||c=='O'||c=='U';
// }


#include <bits/stdc++.h>
using namespace std;

bool halvesAreAlike(string s) {
    int n = s.size();
    int mid = n / 2;
    int countL = 0, countR = 0;

    unordered_set<char> st = {'a','e','i','o','u','A','E','I','O','U'};

    for (int i = 0; i < mid; i++) {
        if (st.find(s[i]) != st.end()) countL++;
    }
    for (int j = mid; j < n; j++) {
        if (st.find(s[j]) != st.end()) countR++;
    }
    return countL == countR;
}

int main() {
    string s;
    cin >> s;
    cout << (halvesAreAlike(s) ? "true" : "false") << endl;
    return 0;
}
