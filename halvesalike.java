/*
LeetCode 1704: Determine if String Halves Are Alike

Approach 1:
- Divide string into two halves.
- Count vowels in each half using a HashSet.
- Compare counts.
*/

import java.util.*;

public class halvesalike {
    public static boolean halvesAreAlike(String s) {
        int n = s.length();
        int mid = n / 2;
        int countL = 0, countR = 0;

        Set<Character> vowels = new HashSet<>(Arrays.asList(
            'a','e','i','o','u','A','E','I','O','U'
        ));

        for (int i = 0; i < mid; i++) {
            if (vowels.contains(s.charAt(i))) countL++;
        }
        for (int j = mid; j < n; j++) {
            if (vowels.contains(s.charAt(j))) countR++;
        }
        return countL == countR;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(halvesAreAlike(s));
    }
}
