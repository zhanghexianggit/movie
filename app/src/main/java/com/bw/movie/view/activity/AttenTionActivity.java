package com.bw.movie.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bw.movie.R;
import com.bwie.mvplibrary.base.BaseActivity;
import com.bwie.mvplibrary.base.BasePresenter;

public class AttenTionActivity extends BaseActivity {

    @Override
    protected int bindLayout() {
        return R.layout.activity_atten_tion;
    }

    @Override
    protected BasePresenter setPresenter() {
        return null;
    }
}
