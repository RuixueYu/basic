package writtenquestions;

/**
 * @Author: YuRuixue
 * @Description: 解析结构的成员变量所占用的字节数 short 2 long 4 char 1
 * @date 2022/8/18/0018 18:57
 */
public class ParsingStruct {
    public static void main(String[] args) {

    }
    public static int parseStruct(String str) {
        int byteNum = 0;
        String[] strings = str.split(" ");
        for (String string : strings) {
            switch (string) {
                case "char" :
                    byteNum += 1;
                    break;
                case "long" :
                    byteNum += 4;
                    break;
                case "short" :
                    byteNum += 2;
                default:
            }
        }
        return byteNum;
    }
}
