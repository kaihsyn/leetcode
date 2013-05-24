/* Palindrome Partitioning II
 *
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 *
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using
 * 1 cut.
 */

public class Solution132 {
    public int minCut(String s) {
        int min_cut = s.length() - 1;
        boolean[][] pal = new boolean[s.length()][s.length()];
        int[] cut = new int[s.length()];
        
        cut[0] = 0;
        for(int i = 1; i < s.length(); i++) {
            cut[i] = i;
        }
        
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j <= i; j++) {
                if(s.charAt(i) == s.charAt(j) && (i - j < 2 || pal[j + 1][i - 1])) {
                    pal[j][i] = true;
                    if(j != 0) {
                        cut[i] = Math.min(cut[i], cut[j - 1] + 1);
                    } else {
                        cut[i] = 0;
                    }
                }
            }
        }
        
        return cut[s.length() - 1];
    }
}
