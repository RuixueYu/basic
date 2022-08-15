package likou;

/**
 * @Author: YuRuixue
 * @Description: 撤销与恢复
 * @date 2022/2/11 22:20
 */

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;

/**
 * 撤销/恢复操作具有广泛的用途，比如word文档中输入一个单词，可以点撤销，然后可以再恢复。
 * 编程实现如下功能：  从标准输入读取到一个字符串，字符串可包含0个或多个单词，单词以空格或者tab分隔； 如果遇到 "undo" 字符串，表示"撤销"操作，前一个字符串被撤销掉； 如果遇到"redo"字符串，表示恢复刚才撤销掉的字符串.
 * 例如:   输入字符串 "hello undo redo world."，  对字符串中的 undo 和 redo 处理后， 最终输出的结果为 "hello world."
 */
public class UndoAndRedo {
    public static void main(String[] args) {
        String str ="hello undo redo world ";
        String[] s = str.split(" ");
        ArrayList<String> list = new ArrayList<>();
        list.add(s[0]);
        String deStr = "";
        int index = 0;
        for (int i = 1; i < s.length; i++) {
            if(s[i].equals("undo") ){
                deStr =s[i-1];
                index = list.size() - 1;
                list.remove(list.size() - 1);
            }else if(s[i].equals("redo")){
                list.add(index,deStr);
            }else {
                list.add(s[i]);
            }
        }
        System.out.println(StringUtils.join(list," "));
    }
}
