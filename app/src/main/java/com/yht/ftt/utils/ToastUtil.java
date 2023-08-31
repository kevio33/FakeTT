package com.yht.ftt.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * @Description:封装Toast工具
 * @author: kevinyang
 * @date: 2023/8/6
 **/
public class ToastUtil {
    public static Toast toast;
    public static void showMsg(Context context, String msg){//传过来context和text内容
        if(toast == null){
            toast = Toast.makeText(context,msg, Toast.LENGTH_SHORT);//如果没有被调用，则初始化toast
        }else{
            toast.setText(msg);//否则只给他添加text
        }
        toast.show();
    }
}
