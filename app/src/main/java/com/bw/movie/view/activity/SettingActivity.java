package com.bw.movie.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.bw.movie.R;
import com.bwie.mvplibrary.base.BaseActivity;
import com.bwie.mvplibrary.base.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingActivity extends BaseActivity {


    @BindView(R.id.to_update)
    RelativeLayout toUpdate;

    @Override
    protected int bindLayout() {
        return R.layout.activity_setting;
    }

    @Override
    protected BasePresenter setPresenter() {
        return null;
    }

    @Override
    protected void initData() {
        super.initData ();
        setTranslucent ( this );
        setColor ( this, Color.WHITE );
    }

    @OnClick(R.id.to_update)
    public void onViewClicked() {
        Intent intent = new Intent ( SettingActivity.this, UpdateActivity.class );
        startActivity ( intent );
    }
}
