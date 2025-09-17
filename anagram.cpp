#include <bits/stdc++.h>
using namespace std;

/*
💡 Problem: Valid Anagram
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
*/

class Solution {
public:
    // 🔹 Approach 1: Sorting
    bool isAnagramSorting(string s, string t) {
        if (s.size() != t.size()) return false;
        sort(s.begin(), s.end());
        sort(t.begin(), t.end());
        return s == t;
    }

    // 🔹 Approach 2: Frequency Count (Optimal for lowercase English letters)
    bool isAnagramCount(string s, string t) {
        if (s.size() != t.size()) return false;

        vector<int> count(26, 0);
        for (char ch : s) count[ch - 'a']++;
        for (char ch : t) count[ch - 'a']--;

        for (int val : count) {
            if (val != 0) return false;
        }
        return true;
    }

    // 🔹 Approach 3: HashMap (Handles Unicode / General case)
    bool isAnagramHashmap(string s, string t) {
        if (s.size() != t.size()) return false;

        unordered_map<char, int> freq;
        for (char ch : s) freq[ch]++;
        for (char ch : t) freq[ch]--;

        for (auto it : freq) {
            if (it.second != 0) return false;
        }
        return true;
    }
};

int main() {
    string s = "anagram";
    string t = "nagaram";

    Solution sol;

    cout << "Approach 1 (Sorting): "
         << (sol.isAnagramSorting(s, t) ? "True" : "False") << endl;

    cout << "Approach 2 (Frequency Count): "
         << (sol.isAnagramCount(s, t) ? "True" : "False") << endl;

    cout << "Approach 3 (HashMap): "
         << (sol.isAnagramHashmap(s, t) ? "True" : "False") << endl;

    return 0;
}
