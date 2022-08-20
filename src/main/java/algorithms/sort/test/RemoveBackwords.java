package algorithms.sort.test;

/**
 * @Author : YuRuixue
 * @Description: 输入字符数组，反向删除指定的元素并返回新数组
 * 删除的元素个数大于0，数组的起始索引为0
 * 如果要删除的元素多于元素个数，能删的元素都会被删除
 * @date :   2022-08-20 09:59
 */
public class RemoveBackwords {
    public static void main(String[] args) {
        String[] wordsArray = {"a","b","c","c","r","5"};
        String[] backwords = removeBackwords(wordsArray, 1, 3);
        for (String backword : backwords) {
            System.out.println(backword);
        }
    }
    public static String[] removeBackwords(String[] wordsArray, int index, int removeLength) {
        int arrayLength = wordsArray.length;
        String[] strings =  null;
        if(index > 0 && index < arrayLength) {
            if(removeLength > arrayLength || removeLength >= index+1) {
               strings = new String[arrayLength - index - 1];
                for(int i = index + 1;i < arrayLength; i++) {
                    strings[i-index -1] = wordsArray[i];
                }
            }else {
                strings = new String[arrayLength - removeLength];
                int preLength = index - removeLength + 1;
                for(int i = 0;i < preLength; i++) {
                    strings[i] = wordsArray[i];
                }
                for(int i = index + 1;i < arrayLength;i++) {
                    strings[preLength++] = wordsArray[i];
                }
            }
        }
        return strings;
    }
}
