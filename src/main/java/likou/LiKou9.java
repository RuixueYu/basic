package likou;

import static jdk.nashorn.internal.objects.NativeString.substring;

public class LiKou9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(-12344321));
    }
    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        for (int i = 0,j = s.length()-1; i < s.length() && i < j ; i++, j--) {
            String s1 = String.valueOf(s.charAt(i));
            String s2 = String.valueOf(s.charAt(j));
            if(!s1.equals(s2))
                return false;
        }
        return true;
    }

}
