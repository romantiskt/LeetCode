package com.rolan.leetcode;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.rolan.leetcode.tasks.Chapter203;

/**
 * Created by wangyang on 2019-06-05.18:05
 */
public interface IEngine {
    Context context = null;

    void doMath();

    String getQuestion();

    default void showResultDialog(String content) {
        Activity activity = App.activities.firstElement();
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        View inflate = View.inflate(activity, R.layout.dialog_container, null);
        TextView textView = inflate.findViewById(R.id.tv_content);
        textView.setText(content);
        builder.setView(inflate);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    default void showResultDialg(String solution,String input,String output){
        StringBuffer buffer = new StringBuffer();
        buffer.append("【题干】: ");
        buffer.append(solution);
        buffer.append("\n");
        buffer.append("\n");
        buffer.append(String.format("【输入】: %s\n", input));
        buffer.append("\n");
        buffer.append(String.format("【输出】: %s\n", output));
        showResultDialog(buffer.toString());
    }

    default String intArrayToStr(int[] arr){
        StringBuffer buffer=new StringBuffer();
        int pos=0;
        while (pos<arr.length){
            if(pos+1==arr.length){
                buffer.append(arr[pos++]);
            }else {
                buffer.append(String.format("%d、", arr[pos++]));
            }
        }
        return buffer.toString();
    }

    default String charArrayToStr(char[] arr){
        StringBuffer buffer=new StringBuffer();
        int pos=0;
        while (pos<arr.length){
            if(pos+1==arr.length){
                buffer.append(arr[pos++]);
            }else {
                buffer.append(String.format("%c、", arr[pos++]));
            }
        }
        return buffer.toString();
    }


}
