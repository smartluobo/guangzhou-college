package com.guangzhou.college.common.utils;

public class ValidateUtils {


    //分数校验是否在100分以内
    public static boolean scoreIntervalValidate(Integer score){
        if(score <=100 && score >=0){
            return true;
        }else{
            return false;
        }
    }


}
