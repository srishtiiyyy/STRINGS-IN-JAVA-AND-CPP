/*
LeetCode 443: String Compression

Question:
You are given an array of characters chars. 
You need to compress it using the following algorithm:
- Begin with an empty string s. For each group of consecutive repeating characters in chars:
    * Append the character to s.
    * If the group length is greater than 1, append the length of the group.
- The compressed string s should not be returned separately, 
  but instead be stored in the input character array chars.
- After you are done modifying the input array, 
  return the new length of the array.

You must write an algorithm that uses only O(1) extra space.

Example:
Input: ["a","a","b","b","c","c","c"]
Output length: 6
The array is modified to: ["a","2","b","2","c","3"]

--------------------------------------------------------
Approach:
1. Use two pointers:
   - i to iterate the array
   - index to store the compressed result
2. For each group of identical characters:
   - Place the character at chars[index]
   - If frequency > 1, convert the count to string and write each digit
3. Return index as the new compressed length.

Time Complexity: O(n)   (each character visited once)
Space Complexity: O(1)  (in-place compression)
--------------------------------------------------------
*/

#include <bits/stdc++.h>
using namespace std;

int compress(vector<char>& chars) {
    int n = chars.size();
    int index = 0;  // position to write
    int i = 0;

    while (i < n) {
        char curr_char = chars[i];
        int count = 0;

        // count occurrences
        while (i < n && chars[i] == curr_char) {
            count++;
            i++;
        }

        // write the character
        chars[index++] = curr_char;

        // if count > 1, write its digits
        if (count > 1) {
            string cnt = to_string(count);
            for (char c : cnt) {
                chars[index++] = c;
            }
        }
    }
    return index;
}

int main() {
    int n;
    cin >> n;
    vector<char> chars(n);

    for (int i = 0; i < n; i++) cin >> chars[i];

    int newLen = compress(chars);

    cout << newLen << endl;
    for (int i = 0; i < newLen; i++) cout << chars[i] << " ";
    cout << endl;
    return 0;
}
