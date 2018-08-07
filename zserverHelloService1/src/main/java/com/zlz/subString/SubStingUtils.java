package com.zlz.subString;

import org.apache.commons.lang.StringUtils;

/**
 * @Title :截取指定字符串工具
 * @Description :
 * @Author : zhanglz
 * @Date : 2018/8/4 9:41
 */
public class SubStingUtils {



    /***
    * @Title 去除p标签获得纯文本
    * @Description
    * @Author  zhanglz
    * @Date  2018/8/4 15:27
    * @param source 输入文本需要去除的标签,
    * @param p 需要去除的标签,如"<p"
    * @return  java.lang.String
    */
    public static String findPAndCut(String source, String p) {

        if (StringUtils.isBlank(source)) {
            return null;
        }

        if (StringUtils.isBlank(p)) {
            return source;
        }

        int startIndex = source.indexOf(p);
        int endIndex = source.indexOf(">");
        String frontPart = "";
//        String middlePart = "";
        String lastPart = "";

        if (startIndex == 0) {//如果==零，说明标签在开头，截取掉开头，保留剩余部分

            lastPart = source.substring(endIndex + 1);
            return findPAndCut(lastPart, p);
        } else if (startIndex > 0) {//如果>0，说明在中间，保留开头和结尾部分
            frontPart = source.substring(0, startIndex);
            if (endIndex < source.length()) {
                endIndex = endIndex + 1;
            }
//            middlePart = source.substring(startIndex, endIndex);
            lastPart = source.substring(endIndex);
            return findPAndCut(frontPart + lastPart, p);
        } else {
            return source;
        }


    }

    /***
    * @Title 去除编辑文本中的字体、颜色等标签，只保留p标签
    * @Description
    * @Author  zhanglz
    * @Date  2018/8/4 15:23
    * @param source
    * @param lineNum
    * @return  java.lang.String
    */
    public static String getTextWithP(String source,int lineNum,int lineSize){

        if (StringUtils.isBlank(source)) {
            return null;
        }
        String[] ss1 = source.split("</p>");//按照P标签截取数组
        StringBuffer sb = new StringBuffer();//目标字符格式<p>xxxxxxxxxxxxx.....</p>
        int countNum=0;//需要截取几行的标志
        for (String ssTemp : ss1) {
            String ssCutSpan = ssTemp.replaceAll("</span>", "");//去除span标签
            String ssCutNbsp = ssCutSpan.replaceAll("&nbsp;", " ");//去除nbsp
            String ssCutBr = ssCutNbsp.replaceAll("<br/>", "");//去除BR
            String noPStr = findPAndCut(ssCutBr, "<p");//去除p标签

            if (StringUtils.isNotBlank(noPStr)) {

                String dest = findPAndCut(noPStr, "<span");//去除span标签
                if (dest.length() > lineSize) {//超过15个字符,截取12位拼接‘...’
                    sb.append("<p>").append(dest.substring(0, lineSize)).append("...").append("</p>");
                } else {
                    sb.append("<p>").append(dest).append("</p>");
                }
                System.out.println(dest);
                countNum++;
                if (countNum != 0 && countNum == lineNum) {//达到目标行数退出循环
                    break;
                }
            }

        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String ss = "<p style=\"font-family: 微软雅黑, Tahoma;white-space: normal;widows: auto;line-height: 29px;background-color: white\"><span style=\"line-height: 16px;font-size: 14px\"><span style=\"font-family:宋体\">【超星讲座直播<span xml:lang=\"EN-US\">|</span>第<span xml:lang=\"EN-US\">28</span>期】</span></span></p><p style=\"font-family: 微软雅黑, Tahoma;white-space: normal;widows: auto;line-height: 29px;background-color: white\"><span style=\"line-height: 16px;font-size: 14px\"><span style=\"font-family:宋体\">直播主题：梅兰芳的三重密码</span></span></p><p style=\"font-family: 微软雅黑, Tahoma;white-space: normal;widows: auto;line-height: 29px;background-color: white\"><span style=\"font-family:宋体\"><span style=\"line-height: 16px;font-size: 14px\">直播</span><span style=\"line-height: 16px;font-size: 14px\">时间：<span xml:lang=\"EN-US\">2017</span>年<span xml:lang=\"EN-US\">1</span>月<span xml:lang=\"EN-US\">20</span>日（周五）<span xml:lang=\"EN-US\">19:00-21:00</span></span></span></p><p style=\"font-family: 微软雅黑, Tahoma;white-space: normal;widows: auto;line-height: 29px;background-color: white\"><span style=\"font-family:宋体\"><span style=\"line-height: 16px;font-size: 14px\">主 讲 人：魏海敏&nbsp;&nbsp;</span><span style=\"font-size:3px\"><span style=\"font-family: 宋体; font-size: medium; line-height: 29px;  widows: auto; background-color: rgb(255, 255, 255);\">京剧表演艺术家</span></span></span></p><p style=\"font-family: 微软雅黑, Tahoma;white-space: normal;widows: auto;line-height: 29px;background-color: white\"><span style=\"line-height: 16px;font-family: 宋体\">主办单位：上海东方艺术中心管理有限公司</span></p><p style=\"font-family: 微软雅黑, Tahoma;white-space: normal;widows: auto;line-height: 29px;background-color: white\"><span style=\"line-height: 16px;font-family: 宋体\">协办单位：季风书园</span></p><p style=\"font-family: 微软雅黑, Tahoma;line-height: 16px;white-space: normal;widows: auto;background-color: white\"><span style=\"font-size: 14px\"><span style=\"font-family:宋体\">主讲人介绍：魏海敏，京剧表演艺术家。“梅派传人“，梅葆玖先生的大弟子，并曾受教于陈永玲、童芷苓先生。魏海敏成长于台湾，毕业后即成为台湾京剧的第一女主角。<span xml:lang=\"EN-US\">20</span>世纪<span xml:lang=\"EN-US\">90</span>年代初，已荣膺台湾最高文艺奖以及“亚洲杰出艺人奖”，曾数次献艺于林肯艺术中心。<span xml:lang=\"EN-US\">1991</span>年，海峡两岸严冻初融，魏海敏即赴北京拜师梅葆玖先生，成为第三代“梅（兰芳）派”大弟子。此后十余年，潜心精进，深得梅派精髓，先后摘得中国戏剧梅花奖、上海白玉兰戏剧表演艺术奖，是观众和内行交口公认的“梅门大师姐”。</span></span></p><p style=\"font-family: 微软雅黑, Tahoma;white-space: normal;widows: auto;line-height: 29px;background-color: white\"><span style=\"font-family:宋体\"><span style=\"line-height: 16px;font-size: 14px\">擅长《贵妃醉酒》《霸王别姬》《穆桂英挂帅》《生死恨》等剧目，她的代表作、由张爱玲同名小说改编的《金锁记》被视为京剧新编剧目的翘</span><span style=\"line-height: 16px;font-size: 14px\">楚之作，评论家称她为</span><span style=\"max-width: 100%;box-sizing: border-box !important\"><span style=\"font-size:3px\"><span style=\"font-family: 宋体; font-size: medium; line-height: 29px;  background-color: rgb(255, 255, 255);\">“京剧界自童芷苓以降的演技第一人”。</span></span></span></span></p><p style=\"font-family: 微软雅黑, Tahoma;line-height: 16px;white-space: normal;widows: auto;background-color: rgb(255, 255, 255)\"><span style=\"font-family: 宋体\">【参与直播】</span></p><p style=\"font-family: 微软雅黑, Tahoma;white-space: normal;widows: auto;line-height: 29px;background-color: white\"><span style=\"line-height: 16px;font-family: 宋体\">参与互动评论：请下载超星学习通，首页右上角输入邀请码<span xml:lang=\"EN-US\">“sq5832”</span></span></p><p style=\"font-family: 微软雅黑, Tahoma;white-space: normal;widows: auto;line-height: 29px;background-color: white\"><span style=\"line-height: 16px;font-family: 宋体\">往期视频回看、订阅直播预告：请在首页右上角输入邀请码<span xml:lang=\"EN-US\">“by2494”</span></span></p><p><br/></p>";
//        String ss = "<p><span style=\"font-size: 16px;\">测试课程直播1.17测试课程直播1.17测试课程直播1.17测试课程直播1.17测试课程直播1.17测试课程直播1.17测试课程直播1.17测试课程直播1.17测试课程直播1.17测试课程直播1.17测试课程直播1.17</span></p><p><br/></p><p><span style=\"font-size: 16px;\">测试课程直播1.17测试课程直播1.17测试课程直播1.17测试课程直播1.17</span></p>";
        System.out.println(System.currentTimeMillis());

//        for (int i = 0; i < 1000; i++) {
            String dest = getTextWithP(ss, 10,200);
//            System.out.println(i);
//        }

        System.out.println(System.currentTimeMillis());
        System.out.println(dest);
//        String dd="<p style=\"font-family: 微软雅黑, Tahoma;white-space: normal;widows: auto;line-height: 29px;background-color: white\"><span style=\"line-height: 16px;font-size: 14px\"><span style=\"font-family:宋体\">【超星讲座直播<span xml:lang=\"EN-US\">|</span>第<span xml:lang=\"EN-US\">28</span>期】</span></span>\n";
//
//
//        System.out.println( findPAndCut(dd,"<p"));

//        String ee = "<span style=\"line-height: 16px;font-size: 14px\"><span style=\"font-family:宋体\">【超星讲座直播<span xml:lang=\"EN-US\">|</span>第<span xml:lang=\"EN-US\">28</span>期】</span></span>\n";
//
//        System.out.println( ee.replaceAll("</span>", ""));
//        System.out.println( findPAndCut(ee,"<span"));

    }
}
