/**
 * find the longest palindrome of the string
 * @author Siyang Wu
 */
public class LongestPalindromeSubstring {
    // brute: use recursion
    public static String findLongestPalindrome01(String str) {
        if (str.isEmpty()) {
            return null;
        }
        if (str.length() == 1) {
            return str;
        }
        // starts with the first character as the longest palindrome
        String longest = str.substring(0, 1);
        // not sure the palindrome's length is even or odd
        for (int i = 0; i < str.length(); i ++) {
            // for the string whose length is odd
            // i is the center of the string
            // move the center each time
            String temp = checkPalindrome(str, i, i);
            if (temp.length() > longest.length()) {
                longest = temp;
            }
            
            // for the string whose length is even
            // (i, i + 1) is the center of the string
            // move the center each time
            temp = checkPalindrome(str, i, i + 1);
            if (temp.length() > longest.length()) {
                longest = temp;
            }    
        }
        return longest;
    }
    
    public static String checkPalindrome(String s, int start, int end) {
        // start and end are the index;
        while (start >= 0 && end <= s.length() - 1 && s.charAt(start) == s.charAt(end)) {
            start --;
            end ++;
        }
        // when the loop is over, start = start - 1, end = end + 1
        // s.charAt(start) != s.charAt(end)
        // [start + 1, end)  
        return s.substring(start + 1, end);
    }
    
    public static String findLongestPalindrome02(String str) {
        int n = str.length();
        boolean[][] table = new boolean[n][n];
        int maxLength = 1;
        for (int i = 0; i < n; i ++) {
            table[i][i] = true;
        }
        
        // check for sub-string of length 2
        int start = 0;
        for (int i = 0; i < n - 1; i ++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                table[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }
        for (int k = 3; k <= n; k ++) {
            for (int i = 0; i < n - k + 1; i ++) {
                int j = i + k - 1;
                if (table[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {
                    table[i][j] = true;
                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }
        return str.substring(start, start + maxLength);
    }
    
    public static void main(String[] args) {
        String s = "asfgfs";
        System.out.println(findLongestPalindrome01(s));
        System.out.println(findLongestPalindrome02(s));
    }
}
