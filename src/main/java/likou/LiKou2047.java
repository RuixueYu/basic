package likou;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 句子中的有效单词数
 */
public class LiKou2047 {
    public static int countValidWords(String sentence) {
        if(sentence.length() > 0){
            String[] s = sentence.split(" ");
            int count = s.length;
            for (String s1 : s) {
                if(s1.equals(""))
                    count --;
            }

            System.out.println(count);
            String regex2 = "^[a-z]+$";
            String regex3 = "^[.,! ]+$";
            for (String s1 : s) {
                if(!(s1.equals(""))){
                    if(Pattern.compile(".*\\d+.*").matcher(s1).matches() || s1.split("-").length - 1 > 1 || s1.split(regex3).length - 1 > 1 || s1.startsWith("-") || s1.endsWith("-")){
                        count --;
                        continue;
                    }

                    if(s1.split("-").length -1 == 1 && !(s1.startsWith("-")) && !(s1.endsWith("-"))){
                        int index = s1.indexOf("-");
                        if(!(String.valueOf(s1.charAt(index - 1)).matches(regex2) && String.valueOf(s1.charAt(index + 1)).matches(regex2)))
                            count --;
                        continue;
                    }
                    if(s1.split(regex3).length -1 == 1){
                        if(!(s1.endsWith(" ") ||s1.endsWith(".") ||s1.endsWith("!") ||s1.endsWith(","))) {
                            count --;
                        }
                    }
                }
            }

            return count;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(countValidWords("cat- and.  d--og"));
    }
}
