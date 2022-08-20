package writtenquestions;

import java.math.BigDecimal;

/**
 * @Author: Yu Ruixue
 * @Description: 计算UHF Passive RFID 18000-6C协议中的反向数据速率
 * DR可选值：64/3  8
 * M可选值：1 2 4 8
 * Tari可选值： 6.25 12.5 25 单位us
 * 最小值0，004kbps
 * 最大值1.241kbps
 * @date 2022/5/27/0027 19:35
 */
public class BackscatterDataRate{
    public static void main(String[] args) {
        System.out.println(calculateBDR((double) 64/3,1,6.25));
    }
    static double calculateBDR(double DR,int M,double Tari){
        //先计算TRcal
        double TRcal = calculateTRcal(Tari);

        //再计算反向数据速率
        double BDR =  DR * 1e3 / (M * TRcal);
        System.out.println(BDR);
        //反向数据速率四舍五入,保留三位小数
        double BDR_3 = new BigDecimal(BDR).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println("反向数据速率为：" + BDR_3 + "kbps");
        return BDR_3;
    }
    static double calculateTRcal(double Tari){
        //data-1长度等于 1.5Tari-2Tari
        double data1LenMin = 1.5 * Tari;
        double data1LenMax = 2 * Tari;

        //随机选择data-1数据长度 [x, y]的double类型的随机数
        double data1Length = data1LenMin + Math.random() * data1LenMax % (data1LenMax - data1LenMin + 1);

        //计算RTcal长度 RTcal长度等于data-0 + data - 1长度
        double RTcalLength = Tari + data1Length;

        //最短的RTCal
        //double RTcalLength = Tari + data1LenMin;

        //最长的RTCal
        //double RTcalLength = Tari + data1LenMax;

        //TRcal长度等于 1.1RTcal-3RTcal
        double TRcalLenMin = 1.1 * RTcalLength;
        double TRcalLenMax = 3 * RTcalLength;

        //最短的TRcal
        //double TRcalLength = TRcalLenMin;

        //最长的TRcal
        //double TRcalLength = TRcalLenMax;

        //随机选择TRcal长度
        double TRcalLength = TRcalLenMin + Math.random() * TRcalLenMax % (TRcalLenMax - TRcalLenMin + 1);

        return TRcalLength;
    }
}
