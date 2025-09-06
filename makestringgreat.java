/*
LeetCode 1544: Make The String Great

Approach:
- Use StringBuilder as a stack.
- Traverse each character:
   - If last character differs from current by 32 (ASCII case diff) → remove it.
   - Else, push it.
*/

import java.util.*;

public class makestringgreat {
    public static String makeGood(String s) {
        StringBuilder result = new StringBuilder();
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (result.length() == 0) {
                result.append(s.charAt(i));
                i++;
            } else if (Math.abs(result.charAt(result.length() - 1) - s.charAt(i)) == 32) {
                result.deleteCharAt(result.length() - 1);
                i++;
            } else {
                result.append(s.charAt(i));
                i++;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(makeGood(s));
    }
}
