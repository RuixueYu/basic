package algorithms.sort.test;

/**
 * @Author: YuRuixue
 * @Description: 获取不同ip的最大子网掩码长度
 * @date 2022/8/17/0017 20:10
 */
public class IPSameMask {
    public static void main(String[] args) {
        String[] IPs = {"192.168.129.23","192.169.206.36"};
        System.out.println(maxMaskLength(IPs));
    }

    public static int maxMaskLength(String[] IPs) {
        String[] bin_32 = new String[IPs.length];
        for (int i = 0; i < IPs.length; i++) {
            int[] ints = new int[4];
            StringBuilder stringBuilder = new StringBuilder();
            for (String s : IPs[i].split("\\.")) {
                ints[i] = Integer.parseInt(s);
                stringBuilder.append(intToBin(ints[i]));
            }
            bin_32[i] = stringBuilder.toString();
        }
        return longestCommonPrefix(bin_32);
    }
    //整数转为8位二进制数
    public static String intToBin(int n) {
        //二进制数
        int binaryInt = Integer.parseInt(Integer.toBinaryString(n));
        //补0补够8位
        String binaryInt_8 = String.format("%08d",binaryInt);
        return binaryInt_8;
    }
    public static int longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return 0;
        }
        String res = strs[0];
        int i = 1;
        while (i < strs.length) {
            while (strs[i].indexOf(res) != 0) {
                res = res.substring(0, res.length() - 1);
            }
            i += 1;
        }
        return res.length();

    }
}

