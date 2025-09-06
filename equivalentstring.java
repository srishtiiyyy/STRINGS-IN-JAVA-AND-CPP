/*
LeetCode 1662: Check If Two String Arrays are Equivalent

Question:
You are given two string arrays word1 and word2.
Return true if the concatenation of word1 equals the concatenation of word2.

Example:
Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
Output: true
Explanation: "abc" == "abc"

--------------------------------------------------------
Approach 1 (Concatenation):
- Concatenate all strings in word1 → s1
- Concatenate all strings in word2 → s2
- Return (s1.equals(s2))

Approach 2 (Two-pointer optimal):
- Maintain two pointers across word1 and word2.
- Compare character by character without building big strings.
- Carefully move to the next string when one finishes.
- If mismatch → return false.
- If both finish together → return true.

Time Complexity:
- Approach 1: O(L) with O(L) extra space.
- Approach 2: O(L) with O(1) space.
Where L = total number of characters.

--------------------------------------------------------
*/

import java.util.*;

public class equivalentstring{

    // Approach 1: Concatenation
    public static boolean arrayStringsAreEqualConcat(String[] word1, String[] word2) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        for (String w : word1) s1.append(w);
        for (String w : word2) s2.append(w);
        return s1.toString().equals(s2.toString());
    }

    // Approach 2: Two-pointer
    public static boolean arrayStringsAreEqualTwoPointer(String[] word1, String[] word2) {
        int w1i = 0, i = 0;
        int w2j = 0, j = 0;

        while (w1i < word1.length && w2j < word2.length) {
            if (word1[w1i].charAt(i) != word2[w2j].charAt(j)) return false;

            i++; j++;

            if (i == word1[w1i].length()) { i = 0; w1i++; }
            if (j == word2[w2j].length()) { j = 0; w2j++; }
        }
        return (w1i == word1.length && w2j == word2.length);
    }

    // ---------------- MAIN FUNCTION -----------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] word1 = new String[n];
        for (int i = 0; i < n; i++) word1[i] = sc.next();

        int m = sc.nextInt();
        String[] word2 = new String[m];
        for (int i = 0; i < m; i++) word2[i] = sc.next();

        System.out.println(arrayStringsAreEqualConcat(word1, word2) ? "true" : "false");
        System.out.println(arrayStringsAreEqualTwoPointer(word1, word2) ? "true" : "false");
    }
}
