#include <bits/stdc++.h>
using namespace std;

// ------------------- Approach 1: Using Vector -------------------
string reverseWordsWithVector(string s) {
    int n = s.length();
    vector<string> words;
    int i = 0;

    while (i < n) {
        while (i < n && s[i] == ' ') i++; // skip spaces
        if (i >= n) break;

        int start = i;
        while (i < n && s[i] != ' ') i++; // go till next space
        int end = i - 1;

        string wordFound = s.substr(start, end - start + 1);
        words.push_back(wordFound);
    }

    string ans = "";
    for (int i = words.size() - 1; i >= 0; i--) {
        ans += words[i];
        if (i != 0) ans.push_back(' ');
    }
    return ans;
}

// ------------------- Approach 2: In-Place Reverse -------------------
void reverseString(string &s, int start, int end) {
    while (start < end) {
        swap(s[start++], s[end--]);
    }
}

string reverseWordsInPlace(string s) {
    int n = s.length();
    reverseString(s, 0, n - 1); // reverse entire string

    int i = 0, j = 0, start = 0, end = 0;

    while (j < n) {
        while (j < n && s[j] == ' ') j++; // skip spaces
        if (j == n) break;

        start = i;

        while (j < n && s[j] != ' ') {
            s[i++] = s[j++];
        }

        end = i - 1;
        reverseString(s, start, end);

        if (j < n) {
            s[i++] = ' ';
        }
    }

    if (i > 0 && s[i - 1] == ' ') i--;
    return s.substr(0, i);
}

// ------------------- Main Function -------------------
int main() {
    string s = " amazing coding skills ";

    cout << "Input string: [" << s << "]" << endl;

    // Approach 1
    string ans1 = reverseWordsWithVector(s);
    cout << "Using Vector: [" << ans1 << "]" << endl;

    // Approach 2
    string ans2 = reverseWordsInPlace(s);
    cout << "Using In-Place Reversal: [" << ans2 << "]" << endl;

    return 0;
}
