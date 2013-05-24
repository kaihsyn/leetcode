public class Solution125 {
    public boolean isPalindrome(String s) {
        boolean pal = true;
        
        int left = 0;
        int right = s.length() - 1;
        
        int vleft, vright;
        
        while(left < right) {
            while(left < s.length()
                  && (s.charAt(left) < 'a' || s.charAt(left) > 'z')
                  && (s.charAt(left) < 'A' || s.charAt(left) > 'Z')
                  && (s.charAt(left) < '0' || s.charAt(left) > '9')) {
                left++;
            }
            
            while(right >= 0
                  && (s.charAt(right) < 'a' || s.charAt(right) > 'z')
                  && (s.charAt(right) < 'A' || s.charAt(right) > 'Z')
                  && (s.charAt(right) < '0' || s.charAt(right) > '9')) {
                right--;
            }
            
            if(left >= s.length() || right < 0) {
                if(!(left >= s.length() && right < 0)) {
                    pal = false;
                }
                break;
            }
            
            if(s.charAt(left) >= 'a') {
                vleft = s.charAt(left) - 'a' + 'A';
            } else {
                vleft = s.charAt(left);
            }
            
            if(s.charAt(right) >= 'a') {
                vright = s.charAt(right) - 'a' + 'A';
            } else {
                vright = s.charAt(right);
            }
            
            if(vleft != vright) {
                pal = false;
                break;
            }
            
            left++;
            right--;
        }
        
        return pal;
    }
}