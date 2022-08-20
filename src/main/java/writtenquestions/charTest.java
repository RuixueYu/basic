package writtenquestions;

/**
 * @Author: YuRuixue
 * @Description: TODO
 * @date 2022/4/4 19:09
 */
public class charTest {
    public static void main(String[] args) {
 //        char a = 97;
//        char b = 'a';
//        System.out.println(a);//a
//        System.out.println(b);//a
        String s = "hello,world";
        char[] arr = s.substring(5).toCharArray();
        change(s,arr);
        String arrs = new String(arr);
        System.out.println(s+"---"+arrs);
    }
    public static void change(String s,char[] arr){
        s = "beautiful";
        arr[5] = '*';
    }
}
