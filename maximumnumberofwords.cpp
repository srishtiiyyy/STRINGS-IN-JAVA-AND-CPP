/*
====================================================================
LeetCode 1935: Maximum Number of Words You Can Type
====================================================================

📝 Problem Statement:
You are given a string `text` representing a sentence and a string 
`brokenLetters` representing letters that cannot be used (broken 
keys on a keyboard). You want to count how many words in `text` 
can be typed using the keyboard.

- Words are separated by spaces.
- A word cannot be typed if it contains any broken letters.

Return the count of words that can be typed.

--------------------------------------------------------------------
Example 1:
Input: text = "hello world", brokenLetters = "ad"
Output: 1
Explanation: Only "hello" can be typed.

Example 2:
Input: text = "leet code", brokenLetters = "lt"
Output: 1
Explanation: Only "code" can be typed.

--------------------------------------------------------------------
💡 Approach:
1. Create a boolean vector `mpp` of size 26 to mark broken letters.
2. Iterate through the text character by character.
   - Track if the current word is valid using a boolean `found`.
   - If a broken letter is found, mark `found=false`.
   - On encountering a space, if `found=true`, increment `count`.
3. After the loop, check the last word if valid and increment `count`.
4. Return the count of typeable words.

Time Complexity: O(n + m) where n = length of text, m = length of brokenLetters
Space Complexity: O(26) ~ O(1)

====================================================================
*/

#include <bits/stdc++.h>
using namespace std;

// -------------------- SOLUTION FUNCTION --------------------
int canBeTypedWords(string text, string brokenLetters) {
    vector<int> mpp(26, 0);

    // Mark broken letters
    for (char &ch : brokenLetters) {
        mpp[ch - 'a'] = 1;
    }

    bool found = true; // Is current word typeable
    int count = 0;     // Count of typeable words

    for (char &ch : text) {
        if (ch == ' ') {
            if (found) count++;  // End of a word
            found = true;        // Reset for next word
        }
        else if (mpp[ch - 'a'] == 1) {
            found = false;       // Found broken letter
        }
    }

    // Check last word
    if (found) count++;

    return count;
}

// -------------------- MAIN FUNCTION --------------------
int main() {
    string text1 = "hello world";
    string broken1 = "ad";

    string text2 = "leet code";
    string broken2 = "lt";

    string text3 = "leet code";
    string broken3 = "e";

    cout << "Test 1: " << canBeTypedWords(text1, broken1) << endl; // Expected 1
    cout << "Test 2: " << canBeTypedWords(text2, broken2) << endl; // Expected 1
    cout << "Test 3: " << canBeTypedWords(text3, broken3) << endl; // Expected 0

    return 0;
}
