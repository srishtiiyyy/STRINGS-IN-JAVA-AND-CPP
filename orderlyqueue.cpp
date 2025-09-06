/*
LeetCode 899: Orderly Queue

Question:
You are given a string s and an integer k.
You can choose one of the first k letters of s and append it to the end of the string.
Return the lexicographically smallest string you can get after applying the move any number of times.

Example 1:
Input: s = "cba", k = 1
Output: "acb"

Example 2:
Input: s = "baaca", k = 3
Output: "aaabc"

--------------------------------------------------------
Approach:
Case 1: k > 1
- If k > 1, we can effectively rearrange the string in any order (like sorting).
- So the answer is just the sorted string.

Case 2: k == 1
- Only the first character can be moved to the end.
- That means we can only generate rotations of the string.
- Try all rotations and return the lexicographically smallest.

--------------------------------------------------------
Time Complexity:
- k > 1: O(n log n) for sorting.
- k == 1: O(n^2) (checking all n rotations, each of length n).
Space Complexity: O(n).
--------------------------------------------------------
*/

#include <bits/stdc++.h>
using namespace std;

string orderlyQueue(string s,int k){
    if(k>1){
        sort(s.begin(),s.end());
        return s;
    }
    int n=s.length();
    string result=s;
    if(k==1){
        for(int i=1;i<n;i++){
            string temp=s.substr(i,n)+s.substr(0,i);
            result=min(result,temp);
        }
        return result;
    }
}
// ---------------- MAIN FUNCTION -----------------
int main() {
    string s;
    int k;
    cin >> s >> k;
    cout << orderlyQueue(s, k) << endl;
    return 0;
}