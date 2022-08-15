package likou;

public class LiKou3 {
    public static void main(String[] args) {
        String s = "rzzzkyifjytpmkejcrueovhrohfavrdmqf";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 1;
        int length = 1;
        int tindex = 0;
        if(s.length() > 0){
            String part = s.substring(0,1);
            for (int i = 1; i < s.length(); i++) {
                String curr = s.substring(i,i+1);
                int index = part.indexOf(curr);
                if(index != -1){
                    length -= index;
                    tindex= s.indexOf(part,tindex) + index;
                    part = s.substring(tindex + 1,i + 1);
                    maxLength = maxLength > length ? maxLength : length;
                }else{
                    length += 1;
                    part += curr;
                    maxLength = maxLength > length ? maxLength : length;
                }
            }
            return maxLength;
        }
        return 0;

    }
}
