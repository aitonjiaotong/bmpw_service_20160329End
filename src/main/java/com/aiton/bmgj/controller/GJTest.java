package com.aiton.bmgj.controller;

/**
 * Created by user on 2016/3/9.
 */
public class GJTest {

        //用于参考判断区间的字节码获取值
        private static char[] chartable =
                {
                        '啊', '芭', '擦', '搭', '蛾', '发', '噶', '哈', '哈',
                        '击', '喀', '垃', '妈', '拿', '哦', '啪', '期', '然',
                        '撒', '塌', '塌', '塌', '挖', '昔', '压', '匝', '座'
                };
        //用于返回的值数组
        private static char[] alphatable =
                {
                        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',

                        'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
                };

        //汉子字节码对应数值区间
        private static int[] tablechar = new int[27];



        //初始化标准区间对应的相应字节码数值
        static{
            for(int i = 0 ; i < chartable.length;i++){
                tablechar[i] = ChineseToCode(chartable[i]);
            }
        }




        //获取相应汉子对应的字节码数值
        public static int ChineseToCode(char chinese){
            int code = 0;
            try {
                String a = "";
                a+=chinese;
                byte[] bytes = a.getBytes("GB2312");	//获取字节码
                code = (bytes[0] << 8 & 0xff00) + (bytes[1] &
                        0xff);	//最终字节码对应的数值code的算法
            } catch (Exception e) {
                // TODO: handle exception
            }
            return code;
        }





        //
        public static char CodeToEng(int code){
            int currentindex = 0;
            try {
                for(int i = 0 ; i < 26 ; i++){
                    if(code < tablechar[0]){
                        return 0;
                    }
                    if(code > tablechar[26]){
                        return 0;
                    }
                    int j = i+1;
                    if(code > tablechar[i] && code <= tablechar[j]){
                        //为T的情况
                        if(tablechar[i] == tablechar[i-1] && tablechar[i] == tablechar[i-2]){
                            i = i-2;
                        }
                        //为H的情况
                        if(tablechar[i] == tablechar[i-1]){
                            i = i-1;
                        }
                        currentindex = i;
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return alphatable[currentindex];
        }









        public static void main(String[] args) {

        }
}

