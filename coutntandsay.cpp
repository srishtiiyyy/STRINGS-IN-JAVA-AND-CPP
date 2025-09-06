/*
LeetCode 38: Count and Say

Question:
The count-and-say sequence is a sequence of digit strings defined as follows:

- countAndSay(1) = "1"
- countAndSay(n) is the way you would "say" the previous term.
  For example:
  "1" is read off as "one 1" → "11"
  "11" is read off as "two 1s" → "21"
  "21" is read off as "one 2, then one 1" → "1211"

Given a positive integer n, return the nth term of the count-and-say sequence.

--------------------------------------------------------
Example:
Input: n = 4
Output: "1211"

Explanation:
countAndSay(1) = "1"
countAndSay(2) = "11"
countAndSay(3) = "21"
countAndSay(4) = "1211"

--------------------------------------------------------
Approach:
1. Base case: if n == 1 → return "1".
2. Recursively compute countAndSay(n-1).
3. Traverse the string and "say" it:
   - Count consecutive identical digits.
   - Append "<count><digit>" to result.
4. Return the built result string.

Time Complexity: O(k * n) where k is average length of strings up to n.
Space Complexity: O(k) for building strings.
--------------------------------------------------------
*/

#include <bits/stdc++.h>
using namespace std;

string countAndSay(int n) {
    if (n == 1) return "1";

    string prev = countAndSay(n - 1);
    string res = "";

    for (int i = 0; i < prev.size(); i++) {
        char ch = prev[i];
        int count = 1;
        while (i < prev.size() - 1 && prev[i] == prev[i + 1]) {
            count++;
            i++;
        }
        res += to_string(count) + string(1, ch);
    }
    return res;
}

int main() {
    int n;
    cin >> n;

    cout << countAndSay(n) << endl;
    return 0;
}
