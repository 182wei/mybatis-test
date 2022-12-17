package com.wei.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName Groovy
 * @Description TODO
 * @Author asus
 * @Date 2022/11/22 16:30
 * @Version 1.0
 **/
public class Groovy {
    public static void main(String[] args) {
//        String line ="UNB+UNOA:1+KICT+SJJJPN:POS+220512:1600+1'UNH+395597+CODECO:D:95B:UN:ITG14'BGM+36+1+9'TDT+20+2219W+1++:172:166+++VROS2:103'NAD+CA+11WJ:172:166'EQD+CN+BMOU1671181+2200:102:5+++4'RFF+BN:JJCUBSHWNC25167'DTM+7:202205121558:203'LOC+165+JPUKB:139:6+JJKICT'MEA+AAE+G+KGM:2300'FTX+AAI+++TO SHIPPER'CNT+1:1'UNT+12+395597'UNH+395598+CODECO:D:95B:UN:ITG14'BGM+36+1+9'TDT+20+2219E+1++:172:166+++VRRS5:103'NAD+CA+11WJ:172:166'EQD+CN+TCNU2010317+4500:102:5++3+5'RFF+BM:JJCQDUBAHX20063'DTM+7:202205121547:203'LOC+165+JPUKB:139:6+JJKICT'MEA+AAE+G+KGM:5800'FTX+AAI+++TO CONSIGNEE'CNT+1:1'UNT+12+395598'UNH+395599+CODECO:D:95B:UN:ITG14'BGM+36+1+9'TDT+20+2216N+1++:172:166+++V7A4536:103'NAD+CA+11WJ:172:166'EQD+CN+TWCU2122289+2200:102:5++3+5'RFF+BM:JJCHPUBBNC22188'DTM+7:202205121552:203'LOC+165+JPUKB:139:6+JJKICT'MEA+AAE+G+KGM:4500'FTX+AAI+++TO CONSIGNEE'CNT+1:1'UNT+12+395599'UNH+395600+CODECO:D:95B:UN:ITG14'BGM+34+1+9'TDT+20+2215E+1++:172:166+++C6WS6:103'NAD+CA+11WJ:172:166'EQD+CN+TRHU6953539+4500:102:5+++4'RFF+BM:SHA22954121201'DTM+7:202205121553:203'LOC+165+JPUKB:139:6+JJKICT'MEA+AAE+G+KGM:3900'FTX+AAI+++FROM CONSIGNEE'CNT+1:1'UNT+12+395600'UNH+395601+CODECO:D:95B:UN:ITG14'BGM+34+1+9'TDT+20+22161+1++:172:166+++VRAL7:103'NAD+CA+11WJ:172:166'EQD+CN+TWCU2115016+2200:102:5+++4'RFF+BM:JJCSHUBH2YT1109'DTM+7:202205121545:203'LOC+165+JPUKB:139:6+JJKICT'MEA+AAE+G+KGM:2300'FTX+AAI+++FROM CONSIGNEE'EQD+CN+TCNU4515400+4500:102:5+++4'RFF+BM:JJCSHUBAFU21472'DTM+7:202205121549:203'LOC+165+JPUKB:139:6+JJKICT'MEA+AAE+G+KGM:3900'FTX+AAI+++FROM CONSIGNEE'CNT+1:1'UNT+18+395601'UNH+395602+CODECO:D:95B:UN:ITG14'BGM+34+1+9'TDT+20+2219W+1++:172:166+++VRAL7:103'NAD+CA+11WJ:172:166'EQD+CN+TWCU2079860+2200:102:5++2+5'RFF+BN:JJDUBSHWNC25017'DTM+7:202205121550:203'LOC+165+JPUKB:139:6+JJKICT'MEA+AAE+G+KGM:4700'SEL+OK'FTX+AAI+++FROM SHIPPER'EQD+CN+DFSU6937039+4500:102:5++2+5'RFF+BN:JJCUBSHWNC25171'DTM+7:202205121548:203'LOC+165+JPUKB:139:6+JJKICT'MEA+AAE+G+KGM:30200'SEL+OK'FTX+AAI+++FROM SHIPPER'EQD+CN+HAHU2033578+2200:102:5++2+5'RFF+BN:JJCUBSHKNC25A49'DTM+7:202205121555:203'LOC+165+JPUKB:139:6+JJKICT'MEA+AAE+G+KGM:13600'SEL+OK'FTX+AAI+++FROM SHIPPER'EQD+CN+TWCU2096765+2200:102:5++2+5'RFF+BN:JJCUBSHSNC25A51'DTM+7:202205121556:203'LOC+165+JPUKB:139:6+JJKICT'MEA+AAE+G+KGM:3400'SEL+OK'FTX+AAI+++FROM SHIPPER'CNT+1:1'UNT+34+395602'UNH+395603+CODECO:D:95B:UN:ITG14'BGM+34+1+9'TDT+20+2217E+1++:172:166+++VRNL7:103'NAD+CA+11WJ:172:166'EQD+CN+TWCU2116202+2200:102:5+++4'RFF+BM:JJDSHUBC2061551'DTM+7:202205121543:203'LOC+165+JPUKB:139:6+JJKICT'MEA+AAE+G+KGM:2300'FTX+AAI+++FROM CONSIGNEE'EQD+CN+HAHU4036600+4300:102:5+++4'RFF+BM:JJCSHUBBTB20157'DTM+7:202205121554:203'LOC+165+JPUKB:139:6+JJK";
        String line ="00:COARRI:LOAD REPORT:9:CNDTU:SHJCWZ:202211121000:CNDTU:CNDTU'10:UN8813611:BLUE OCEAN:2245S:CN::202211111835:202211120945:202211111933:202211120745:202211111933:202211120745:145.0' 50:TWCU2041551:20GP:SJJ:SJJ:F:JJCWZKET26260:HAS5325047:0210302:202211120304'\n" + "52:TWTCH::CNDTU::TWTCH::11974.1'99:1' 00:1";
        String pattern = "00[:][^']*";
        String str= "1111";
        String str= "222333";
        String  sex="33";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(line);
        if (m.find()) {
            System.out.println("Found value111: " + m.group(0));//整个匹配到的内容 name = Mouse, age = 13, sex = male
//            System.out.println("Found value: " + m.group(1));//第一个捕获的内容 age = 13
//            String[] split = m.group(0).split("\\+");
//            String substring = split[2].substring(0, 6);
//            System.out.println(substring);
            String[] split = m.group(0).split(":");
           String type = split[1];
            System.out.println(type);

        } else {
            System.out.println("NO MATCH2222");
        }
    }

}

