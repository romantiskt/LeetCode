package com.rolan.leetcode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.rolan.leetcode.easy.Chapter268;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_268})
    void click(View view) {
        int[] arr = {0,1, 2, 4, 5, 6};
        int result = Chapter268.doMath(arr);
        Log.d("wang", String.valueOf(result));
    }
}
