package com.haihong.liuyao.lyapp;

import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by lichanghong on 5/30/16.
 */
public class GuaManager {
    String[] _guaNames;
    TreeMap<String, String> _guaTreeNames;
    TreeMap<String, String> _tiangans;
    TreeMap<String, String> _dizhis;
    String[] dizhis;

    String[] gua1;
    String[] gua21;
    String[] gua41;
    String[] gua61;
    String[] gua2;
    String[] gua22;
    String[] gua42;
    String[] gua62;
    String[] gua3;
    String[] gua23;
    String[] gua43;
    String[] gua63;
    String[] gua4;
    String[] gua24;
    String[] gua44;
    String[] gua64;
    String[] gua5;
    String[] gua25;
    String[] gua45;
    String[] gua6;
    String[] gua26;
    String[] gua46;
    String[] gua7;
    String[] gua27;
    String[] gua47;
    ArrayList<String[]> arrs;
    String[] gua8;
    String[] gua28;
    String[] gua48;
    String[] gua9;
    String[] gua29;
    String[] gua49;
    ArrayList<String[]> wuxings; //五行
    String[] gua10;
    String[] gua30;
    String[] gua50;
    String[] gua11;
    String[] gua31;
    String[] gua51;
    String[] gua12;
    String[] gua32;
    String[] gua52;
    String[] gua13;
    String[] gua33;
    String[] gua53;
    String[] gua14;
    String[] gua34;
    String[] gua54;
    String[] gua15;
    String[] gua35;
    String[] gua55;
    String[] gua16;
    String[] gua36;
    String[] gua56;
    String[] gua17;
    String[] gua37;
    String[] gua57;
    String[] gua18;
    String[] gua38;
    String[] gua58;
    String[] gua19;
    String[] gua39;
    String[] gua59;
    String[] gua20;
    String[] gua40;
    String[] gua60;

    public int chargeGuaWithYao(boolean isyang0, boolean isyang1,
                                boolean isyang2, boolean isyang3,
                                boolean isyang4, boolean isyang5) {
        //找出与第一爻相同的所有卦
        ArrayList<String[]> oneYaoArr = new ArrayList();
        for (String[] arr : arrs) {
            if (isyang0) {
                if(Integer.parseInt(arr[0]) == 1){
                    oneYaoArr.add(arr);
                }
            }
            else{
                if(Integer.parseInt(arr[0]) == 0){
                    oneYaoArr.add(arr);
                }
            }
        }

        //找出与第二爻相同的所有卦
        ArrayList<String[]> twoYaoArr = new ArrayList();
        for (String[] arr : oneYaoArr) {
            if (isyang1) {
                if(Integer.parseInt(arr[1]) == 1){
                    twoYaoArr.add(arr);
                }
            }
            else{
                if(Integer.parseInt(arr[1]) == 0){
                    twoYaoArr.add(arr);
                }
            }
        }

        //找出与第三爻相同的所有卦
        ArrayList<String[]> threeYaoArr = new ArrayList();
        for (String[] arr : twoYaoArr) {
            if (isyang2) {
                if(Integer.parseInt(arr[2]) == 1){
                    threeYaoArr.add(arr);
                }
            }
            else{
                if(Integer.parseInt(arr[2]) == 0){
                    threeYaoArr.add(arr);
                }
            }
        }

        //找出与第四爻相同的所有卦
        ArrayList<String[]> fourYaoArr = new ArrayList();
        for (String[] arr : threeYaoArr) {
            if (isyang3) {
                if(Integer.parseInt(arr[3]) == 1){
                    fourYaoArr.add(arr);
                }
            }
            else{
                if(Integer.parseInt(arr[3]) == 0){
                    fourYaoArr.add(arr);
                }
            }
        }
        //找出与第五爻相同的所有卦
        ArrayList<String[]> fiveYaoArr = new ArrayList();
        for (String[] arr : fourYaoArr) {
            if (isyang4) {
                if(Integer.parseInt(arr[4]) == 1){
                    fiveYaoArr.add(arr);
                }
            }
            else{
                if(Integer.parseInt(arr[4]) == 0){
                    fiveYaoArr.add(arr);
                }
            }
        }
        //找出与第六爻相同的所有卦
        ArrayList<String[]> sixYaoArr = new ArrayList();
        for (String[] arr : fiveYaoArr) {
            if (isyang5) {
                if(Integer.parseInt(arr[5]) == 1){
                    sixYaoArr.add(arr);
                }
            }
            else{
                if(Integer.parseInt(arr[5]) == 0){
                    sixYaoArr.add(arr);
                }
            }
        }
        String[] guaArr=sixYaoArr.get(0);
        int GuaIndex = Integer.parseInt(guaArr[guaArr.length-1]);
        int index = GuaIndex-1;
        return index;
    }


    public String[] liushenArrWithDay(String day) //六神
    {
        String[] result = new String[]{};
        String tiangan = day.substring(0, 1);
        if (tiangan.equals("甲") || tiangan.equals("乙"))
        {
            result = new String[]{"龙","雀","勾","蛇","虎","武"};
        }
        if (tiangan.equals("丙") || tiangan.equals("丁"))
        {
            result = new String[]{"雀","勾","蛇","虎","武","龙"};
        }
        if (tiangan.equals("戊"))
        {
            result = new String[]{"勾","蛇","虎","武","龙","雀"};
        }
        if (tiangan.equals("己"))
        {
            result = new String[]{"蛇","虎","武","龙","雀","勾"};
        }
        if (tiangan.equals("庚") || tiangan.equals("辛"))
        {
            result = new String[]{"虎","武","龙","雀","陈","蛇"};
        }
        if (tiangan.equals("壬") || tiangan.equals("癸"))
        {
            result = new String[]{"武","龙","雀","陈","蛇","虎"};
        }
            Log.e("errortiangan",result[0]);
        return result;
    }
    public String kongwuWithDay(String day)
    {
        String gan = day.substring(0,1);
        String zhi = day.substring(1,2);
        String tianganindex = _tiangans.get(gan);
        String dizhiindex = _dizhis.get(zhi);

        int index = (11-Integer.parseInt(tianganindex)+ Integer.parseInt(dizhiindex))%12;
        String dizhikong2 = dizhis[index];
        String dizhikong = dizhis[index-1];
        return  dizhikong+dizhikong2+" 空";
    }


    private static GuaManager ourInstance = new GuaManager();

    public static GuaManager getInstance() {
        return ourInstance;
    }

    private GuaManager() {
        _guaNames = new String[]{"乾为天", "坤为地", "水雷屯", "山水蒙", "水天需", "天水讼", "地水师",
                "水地比", "风天小畜", "天泽履", "地天泰", "天地否", "天火同人", "火天大有", "地山谦"
                , "雷地豫", "泽雷随", "山风蛊", "地泽临", "风地观", "火雷噬嗑", "山火贲", "山地剥", "地雷复", "天雷无妄",
                "山天大畜", "山雷颐", "泽风大过", "坎为水", "离为火", "泽山咸", "雷风恒", "天山遁", "雷天大壮", "火地晋",
                "地火明夷", "风火家人", "火泽睽", "水山蹇", "雷水解", "山泽损", "风雷益", "泽天夬", "天风姤", "泽地萃", "地风升",
                "泽水困", "水风井", "泽火革", "火风鼎", "震为雷", "艮为山", "风山渐", "雷泽归妹", "雷火丰", "火山旅", "巽为风",
                "兑为泽", "风水涣", "水泽节", "风泽中孚", "雷山小过", "水火既济", "火水未济"
        };

        _guaTreeNames = new TreeMap<String, String>();
        _guaTreeNames.put("乾为天", "乾金");
        _guaTreeNames.put("坤为地", "坤土");
        _guaTreeNames.put("水雷屯", "坎水");
        _guaTreeNames.put("山水蒙", "离火");
        _guaTreeNames.put("水天需", "坤土");
        _guaTreeNames.put("天水讼", "离火");
        _guaTreeNames.put("地水师", "坎水");
        _guaTreeNames.put("水地比", "坤土");
        _guaTreeNames.put("风天小畜", "巽木");
        _guaTreeNames.put("天泽履", "艮土");
        _guaTreeNames.put("地天泰", "坤土");
        _guaTreeNames.put("天地否", "乾金");
        _guaTreeNames.put("天火同人", "离火");
        _guaTreeNames.put("火天大有", "乾金");
        _guaTreeNames.put("地山谦", "兑金");
        _guaTreeNames.put("天火同人", "离火");
        _guaTreeNames.put("天火同人", "离火");
        _guaTreeNames.put("雷地豫", "震木");
        _guaTreeNames.put("泽雷随", "震木");
        _guaTreeNames.put("山风蛊", "巽木");
        _guaTreeNames.put("地泽临", "坤土");
        _guaTreeNames.put("风地观", "乾金");
        _guaTreeNames.put("火雷噬嗑", "巽木");
        _guaTreeNames.put("山火贲", "艮土");
        _guaTreeNames.put("山地剥", "乾金");
        _guaTreeNames.put("地雷复", "坤土");
        _guaTreeNames.put("天雷无妄", "巽木");
        _guaTreeNames.put("山天大畜", "艮土");
        _guaTreeNames.put("山雷颐", "巽木");
        _guaTreeNames.put("泽风大过", "震木");
        _guaTreeNames.put("坎为水", "坎水");
        _guaTreeNames.put("离为火", "离火");
        _guaTreeNames.put("泽山咸", "兑金");
        _guaTreeNames.put("雷风恒", "震木");
        _guaTreeNames.put("天山遁", "乾金");
        _guaTreeNames.put("雷天大壮", "坤土");
        _guaTreeNames.put("火地晋", "乾金");
        _guaTreeNames.put("地火明夷", "坎水");
        _guaTreeNames.put("风火家人", "巽木");
        _guaTreeNames.put("火泽睽", "艮土");
        _guaTreeNames.put("水山蹇", "兑金");
        _guaTreeNames.put("雷水解", "震木");
        _guaTreeNames.put("山泽损", "艮土");
        _guaTreeNames.put("风雷益", "巽木");
        _guaTreeNames.put("泽天夬", "坤土");
        _guaTreeNames.put("天风姤", "乾金");
        _guaTreeNames.put("泽地萃", "兑金");
        _guaTreeNames.put("地风升", "震木");
        _guaTreeNames.put("泽水困", "兑金");
        _guaTreeNames.put("水风井", "震木");
        _guaTreeNames.put("泽火革", "坎水");
        _guaTreeNames.put("火风鼎", "离火");
        _guaTreeNames.put("震为雷", "震木");
        _guaTreeNames.put("艮为山", "艮土");
        _guaTreeNames.put("风山渐", "艮土");
        _guaTreeNames.put("雷泽归妹", "兑金");
        _guaTreeNames.put("雷火丰", "坎水");
        _guaTreeNames.put("火山旅", "离火");
        _guaTreeNames.put("巽为风", "巽木");
        _guaTreeNames.put("兑为泽", "兑金");
        _guaTreeNames.put("风水涣", "离火");
        _guaTreeNames.put("水泽节", "坎水");
        _guaTreeNames.put("风泽中孚", "艮土");
        _guaTreeNames.put("雷山小过", "兑金");
        _guaTreeNames.put("水火既济", "坎水");
        _guaTreeNames.put("火水未济", "离火");

        wuxings = new ArrayList<>();
        wuxings.add(new String[]{"父戌土", "兄申金", "官午火", "父辰土", "才寅木", "子子水", "6", "3"}); //乾)
        wuxings.add(new String[]{"子酉金", "才亥水", "兄丑土", "官卯木", "父巳火", "兄未土", "6", "3"}); //坤
        wuxings.add(new String[]{"兄子水", "官戌土", "父申金", "官辰土", "子寅木", "兄子水", "2", "5"}); //水雷屯
        wuxings.add(new String[]{"父寅木", "官子水", "子戌土", "兄午火", "子辰土", "父寅木", "4", "1"}); //山水蒙
        wuxings.add(new String[]{"才子水", "兄戌土", "子申金", "兄辰土", "官寅木", "才子水", "4", "1"}); //水天需
        wuxings.add(new String[]{"子戌土", "才申金", "兄午火", "兄午火", "子辰土", "父寅木", "4", "1"}); //天水讼
        wuxings.add(new String[]{"父酉金", "兄亥水", "官丑土", "才午火", "官辰土", "子寅木", "3", "6"}); // 地水师
        wuxings.add(new String[]{"才子水", "兄戌土", "子申金", "官卯木", "父巳火", "兄未土", "3", "6"}); //水地比
        wuxings.add(new String[]{"兄卯木", "子巳火", "才未土", "才辰土", "兄寅木", "父子水", "1", "4"}); //风天小畜
        wuxings.add(new String[]{"兄戌土", "子申金", "父午火", "兄丑土", "官卯木", "父巳火", "5", "2"}); //天泽履
        wuxings.add(new String[]{"子酉金", "才亥水", "兄丑土", "兄辰土", "官寅木", "才子水", "3", "6"}); //地天泰
        wuxings.add(new String[]{"父戌土", "兄申金", "官午火", "才卯木", "官巳火", "父未土", "3", "6"}); //天地否
        wuxings.add(new String[]{"子戌土", "才申金", "兄午火", "官亥水", "子丑土", "父卯木", "3", "6"}); //天火同人
        wuxings.add(new String[]{"官巳火", "父未土", "兄酉金", "父辰土", "才寅木", "子子水", "3", "6"}); //火天大有
        wuxings.add(new String[]{"兄酉金", "子亥水", "父丑土", "兄申金", "官午火", "父辰土", "5", "2"}); //地山谦
        wuxings.add(new String[]{"才戌土", "官申金", "子午火", "兄卯木", "子巳火", "才未土", "1", "4"}); //雷地豫
        wuxings.add(new String[]{"才未土", "官酉金", "父亥水", "才辰土", "兄寅木", "父子水", "3", "6"}); //泽雷随
        wuxings.add(new String[]{"兄寅木", "父子水", "才戌土", "官酉金", "父亥水", "才丑土", "3", "6"}); //山风蛊
        wuxings.add(new String[]{"子酉金", "才亥水", "兄丑土", "兄丑土", "官卯木", "父巳火", "2", "5"}); //地泽临
        wuxings.add(new String[]{"才卯木", "官巳火", "父未土", "才卯木", "官巳火", "父未土", "4", "1"}); //风地观
        wuxings.add(new String[]{"子巳火", "才未土", "官酉金", "才辰土", "兄寅木", "父子水", "5", "2"}); //火雷噬嗑
        wuxings.add(new String[]{"官寅木", "才子水", "兄戌土", "才亥水", "兄丑土", "官卯木", "1", "4"}); //山火贲
        wuxings.add(new String[]{"才寅木", "子子水", "父戌土", "才卯木", "官巳火", "父未土", "5", "2"}); //山地剥
        wuxings.add(new String[]{"子酉金", "才亥水", "兄丑土", "兄辰土", "官寅木", "才子水", "1", "4"}); //地雷复
        wuxings.add(new String[]{"才戌土", "官申金", "子午火", "才辰土", "兄寅木", "父子水", "4", "1"}); //天雷无妄
        wuxings.add(new String[]{"官寅木", "才子水", "兄戌土", "兄辰土", "官寅木", "才子水", "2", "5"}); //山天大蓄
        wuxings.add(new String[]{"兄寅木", "父子水", "才戌土", "才辰土", "兄寅木", "父子水", "4", "1"}); //山雷颐
        wuxings.add(new String[]{"才未土", "官酉金", "父亥水", "官申金", "父亥水", "才丑土", "4", "1"}); //泽风大过
        wuxings.add(new String[]{"兄子水", "官戌土", "父申金", "才午火", "官辰土", "子寅木", "6", "3"}); //坎
        wuxings.add(new String[]{"兄巳火", "子未土", "才酉金", "官亥水", "子丑土", "父卯木", "6", "3"}); //离
        wuxings.add(new String[]{"父未土", "兄酉金", "子亥水", "兄申金", "官午火", "父辰土", "3", "6"}); //泽山咸
        wuxings.add(new String[]{"才戌土", "官申金", "子午火", "官酉金", "父亥水", "才丑土", "3", "6"}); //雷风恒
        wuxings.add(new String[]{"父戌土", "兄申金", "官午火", "兄申金", "官午火", "父辰土", "2", "5"}); //天山遁
        wuxings.add(new String[]{"兄戌土", "子申金", "父午火", "兄辰土", "官寅木", "才子水", "4", "1"}); //雷天大壮
        wuxings.add(new String[]{"官巳火", "父未土", "兄酉金", "才卯木", "官巳火", "父未土", "4", "1"}); //火地晋
        wuxings.add(new String[]{"父酉金", "兄亥水", "官丑土", "兄亥水", "官丑土", "子卯木", "4", "1"}); //地火明夷
        wuxings.add(new String[]{"兄卯木", "子巳火", "才未土", "父亥水", "才丑土", "兄卯木", "2", "5"}); //风火家人
        wuxings.add(new String[]{"父巳火", "兄未土", "子酉金", "兄丑土", "官卯木", "父巳火", "4", "1"}); //火泽睽
        wuxings.add(new String[]{"子子水", "父戌土", "兄申金", "兄申金", "官午火", "父辰土", "4", "1"}); //水山蹇
        wuxings.add(new String[]{"才戌土", "官申金", "子午火", "子午火", "才辰土", "兄寅木", "2", "5"}); //雷水解
        wuxings.add(new String[]{"官寅木", "才子水", "兄戌土", "兄丑土", "官卯木", "父巳火", "3", "6"}); //山泽损
        wuxings.add(new String[]{"兄卯木", "子巳火", "才未土", "才辰土", "兄寅木", "父子水", "3", "6"}); //风雷益
        wuxings.add(new String[]{"兄未土", "子酉金", "才亥水", "兄辰土", "官寅木", "才子水", "5", "2"}); //泽天夬
        wuxings.add(new String[]{"父戌土", "兄申金", "官午火", "兄酉金", "子亥水", "父丑土", "1", "4"}); //天风姤
        wuxings.add(new String[]{"父未土", "兄酉金", "子亥水", "才卯木", "官巳火", "父未土", "2", "5"}); //泽地萃
        wuxings.add(new String[]{"官酉金", "父亥水", "才丑土", "官酉金", "父亥水", "才丑土", "4", "1"}); //地风升
        wuxings.add(new String[]{"父未土", "兄酉金", "子亥水", "官午火", "父辰土", "才寅木", "1", "4"}); //泽水困
        wuxings.add(new String[]{"父子水", "才戌土", "官申金", "官申金", "父亥水", "才丑土", "5", "2"}); //水风井
        wuxings.add(new String[]{"官未土", "父酉金", "兄亥水", "兄亥水", "官丑土", "子卯木", "4", "1"}); //泽火革
        wuxings.add(new String[]{"兄巳火", "子未土", "才酉金", "才酉金", "官亥水", "子丑土", "2", "5"}); //火风鼎
        wuxings.add(new String[]{"才戌土", "官申金", "子午火", "才辰土", "兄寅木", "父子水", "6", "3"}); //震
        wuxings.add(new String[]{"官寅木", "才子水", "兄戌土", "子申金", "父午火", "兄辰土", "6", "3"}); //艮
        wuxings.add(new String[]{"官卯木", "父巳火", "兄未土", "子申金", "父午火", "兄辰土", "3", "6"}); //风山渐
        wuxings.add(new String[]{"父戌土", "兄申金", "官午火", "父丑土", "才卯木", "官巳火", "3", "6"}); //雷泽归妹
        wuxings.add(new String[]{"官戌土", "父申金", "才午火", "兄亥水", "官丑土", "子卯木", "5", "2"}); //雷火丰
        wuxings.add(new String[]{"兄巳火", "子未土", "才酉金", "才申金", "兄午火", "子辰土", "1", "4"}); //火山旅
        wuxings.add(new String[]{"兄卯木", "子巳火", "才未土", "官酉金", "父巳火", "才丑土", "6", "3"}); //巽
        wuxings.add(new String[]{"父未土", "兄酉金", "子亥水", "父丑土", "才卯木", "官巳火", "6", "3"}); //兑
        wuxings.add(new String[]{"父卯木", "兄巳火", "子未土", "兄午火", "子辰土", "父寅木", "5", "2"}); //风水涣
        wuxings.add(new String[]{"兄子水", "官戌土", "父申金", "官丑土", "子卯木", "才巳火", "1", "4"}); //水泽节
        wuxings.add(new String[]{"官卯木", "父巳火", "兄未土", "兄丑土", "官卯木", "父巳火", "4", "1"}); //风泽中孚
        wuxings.add(new String[]{"父戌土", "兄申金", "官午火", "兄申金", "官午火", "父辰土", "4", "1"}); //雷山小过
        wuxings.add(new String[]{"兄子水", "官戌土", "父申金", "兄亥水", "官丑土", "子卯木", "3", "6"}); //水火既济
        wuxings.add(new String[]{"兄巳火", "子未土", "才酉金", "兄午火", "子辰土", "父寅木", "3", "6"}); //火水未济

        gua1 = new String[]{"1", "1", "1", "1", "1", "1", "1"};
        gua2 = new String[]{"0", "0", "0", "0", "0", "0", "2"};
        gua3 = new String[]{"0", "1", "0", "0", "0", "1", "3"};
        gua4 = new String[]{"1", "0", "0", "0", "1", "0", "4"};
        gua5 = new String[]{"0", "1", "0", "1", "1", "1", "5"};
        gua6 = new String[]{"1", "1", "1", "0", "1", "0", "6"};
        gua7 = new String[]{"0", "0", "0", "0", "1", "0", "7"};
        gua8 = new String[]{"0", "1", "0", "0", "0", "0", "8"};
        gua9 = new String[]{"1", "1", "0", "1", "1", "1", "9"};
        gua10 = new String[]{"1", "1", "1", "0", "1", "1", "10"};
        gua11 = new String[]{"0", "0", "0", "1", "1", "1", "11"};
        gua12 = new String[]{"1", "1", "1", "0", "0", "0", "12"};
        gua13 = new String[]{"1", "1", "1", "1", "0", "1", "13"};
        gua14 = new String[]{"1", "0", "1", "1", "1", "1", "14"};
        gua15 = new String[]{"0", "0", "0", "1", "0", "0", "15"};
        gua16 = new String[]{"0", "0", "1", "0", "0", "0", "16"};
        gua17 = new String[]{"0", "1", "1", "0", "0", "1", "17"};
        gua18 = new String[]{"1", "0", "0", "1", "1", "0", "18"};
        gua19 = new String[]{"0", "0", "0", "0", "1", "1", "19"};
        gua20 = new String[]{"1", "1", "0", "0", "0", "0", "20"};
        gua21 = new String[]{"1", "0", "1", "0", "0", "1", "21"};
        gua22 = new String[]{"1", "0", "0", "1", "0", "1", "22"};
        gua23 = new String[]{"1", "0", "0", "0", "0", "0", "23"};
        gua24 = new String[]{"0", "0", "0", "0", "0", "1", "24"};
        gua25 = new String[]{"1", "1", "1", "0", "0", "1", "25"};
        gua26 = new String[]{"1", "0", "0", "1", "1", "1", "26"};
        gua27 = new String[]{"1", "0", "0", "0", "0", "1", "27"};
        gua28 = new String[]{"0", "1", "1", "1", "1", "0", "28"};
        gua29 = new String[]{"0", "1", "0", "0", "1", "0", "29"};
        gua30 = new String[]{"1", "0", "1", "1", "0", "1", "30"};
        gua31 = new String[]{"0", "1", "1", "1", "0", "0", "31"};
        gua32 = new String[]{"0", "0", "1", "1", "1", "0", "32"};
        gua33 = new String[]{"1", "1", "1", "1", "0", "0", "33"};
        gua34 = new String[]{"0", "0", "1", "1", "1", "1", "34"};
        gua35 = new String[]{"1", "0", "1", "0", "0", "0", "35"};
        gua36 = new String[]{"0", "0", "0", "1", "0", "1", "36"};
        gua37 = new String[]{"1", "1", "0", "1", "0", "1", "37"};
        gua38 = new String[]{"1", "0", "1", "0", "1", "1", "38"};
        gua39 = new String[]{"0", "1", "0", "1", "0", "0", "39"};
        gua40 = new String[]{"0", "0", "1", "0", "1", "0", "40"};
        gua41 = new String[]{"1", "0", "0", "0", "1", "1", "41"};
        gua42 = new String[]{"1", "1", "0", "0", "0", "1", "42"};
        gua43 = new String[]{"0", "1", "1", "1", "1", "1", "43"};
        gua44 = new String[]{"1", "1", "1", "1", "1", "0", "44"};
        gua45 = new String[]{"0", "1", "1", "0", "0", "0", "45"};
        gua46 = new String[]{"0", "0", "0", "1", "1", "0", "46"};
        gua47 = new String[]{"0", "1", "1", "0", "1", "0", "47"};
        gua48 = new String[]{"0", "1", "0", "1", "1", "0", "48"};
        gua49 = new String[]{"0", "1", "1", "1", "0", "1", "49"};
        gua50 = new String[]{"1", "0", "1", "1", "1", "0", "50"};
        gua51 = new String[]{"0", "0", "1", "0", "0", "1", "51"};
        gua52 = new String[]{"1", "0", "0", "1", "0", "0", "52"};
        gua53 = new String[]{"1", "1", "0", "1", "0", "0", "53"};
        gua54 = new String[]{"0", "0", "1", "0", "1", "1", "54"};
        gua55 = new String[]{"0", "0", "1", "1", "0", "1", "55"};
        gua56 = new String[]{"1", "0", "1", "1", "0", "0", "56"};
        gua57 = new String[]{"1", "1", "0", "1", "1", "0", "57"};
        gua58 = new String[]{"0", "1", "1", "0", "1", "1", "58"};
        gua59 = new String[]{"1", "1", "0", "0", "1", "0", "59"};
        gua60 = new String[]{"0", "1", "0", "0", "1", "1", "60"};
        gua61 = new String[]{"1", "1", "0", "0", "1", "1", "61"};
        gua62 = new String[]{"0", "0", "1", "1", "0", "0", "62"};
        gua63 = new String[]{"0", "1", "0", "1", "0", "1", "63"};
        gua64 = new String[]{"1", "0", "1", "0", "1", "0", "64"};

        arrs = new ArrayList<>();
        arrs.add(gua1);
        arrs.add(gua2);
        arrs.add(gua3);
        arrs.add(gua4);
        arrs.add(gua5);
        arrs.add(gua6);
        arrs.add(gua7);
        arrs.add(gua8);
        arrs.add(gua9);
        arrs.add(gua10);
        arrs.add(gua11);
        arrs.add(gua12);
        arrs.add(gua13);
        arrs.add(gua14);
        arrs.add(gua15);
        arrs.add(gua16);
        arrs.add(gua17);
        arrs.add(gua18);
        arrs.add(gua19);
        arrs.add(gua20);
        arrs.add(gua21);
        arrs.add(gua22);
        arrs.add(gua23);
        arrs.add(gua24);
        arrs.add(gua25);
        arrs.add(gua26);
        arrs.add(gua27);
        arrs.add(gua28);
        arrs.add(gua29);
        arrs.add(gua30);
        arrs.add(gua31);
        arrs.add(gua32);
        arrs.add(gua33);
        arrs.add(gua34);
        arrs.add(gua35);
        arrs.add(gua36);
        arrs.add(gua37);
        arrs.add(gua38);
        arrs.add(gua39);
        arrs.add(gua40);
        arrs.add(gua41);
        arrs.add(gua42);
        arrs.add(gua43);
        arrs.add(gua44);
        arrs.add(gua45);
        arrs.add(gua46);
        arrs.add(gua47);
        arrs.add(gua48);
        arrs.add(gua49);
        arrs.add(gua50);
        arrs.add(gua51);
        arrs.add(gua52);
        arrs.add(gua53);
        arrs.add(gua54);
        arrs.add(gua55);
        arrs.add(gua56);
        arrs.add(gua57);
        arrs.add(gua58);
        arrs.add(gua59);
        arrs.add(gua60);
        arrs.add(gua61);
        arrs.add(gua62);
        arrs.add(gua63);
        arrs.add(gua64);

        _tiangans = new TreeMap<String, String>();
        _tiangans.put("甲", "0");
        _tiangans.put("乙", "1");
        _tiangans.put("丙", "2");
        _tiangans.put("丁", "3");
        _tiangans.put("戊", "4");
        _tiangans.put("己", "5");
        _tiangans.put("庚", "6");
        _tiangans.put("辛", "7");
        _tiangans.put("壬", "8");
        _tiangans.put("癸", "9");

        _dizhis = new TreeMap<String, String>();
        _dizhis.put("子", "0");
        _dizhis.put("丑", "1");
        _dizhis.put("寅", "2");
        _dizhis.put("卯", "3");
        _dizhis.put("辰", "4");
        _dizhis.put("巳", "5");
        _dizhis.put("午", "6");
        _dizhis.put("未", "7");
        _dizhis.put("申", "8");
        _dizhis.put("酉", "9");
        _dizhis.put("戌", "10");
        _dizhis.put("亥", "11");
        dizhis=new String[]{"子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥"};

    }
}
