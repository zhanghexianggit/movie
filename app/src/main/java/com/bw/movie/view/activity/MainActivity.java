package com.bw.movie.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bw.movie.R;
import com.bwie.mvplibrary.base.BaseActivity;
import com.bwie.mvplibrary.base.BasePresenter;

public class MainActivity extends BaseActivity {

    @butterknife.BindView(R.id.go_home)
    ImageView goHome;

    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePresenter setPresenter() {
        return null;
    }

    @Override
    protected void initData() {
        super.initData ();
        setTranslucent(this);
        setColor ( this, Color.WHITE );
    }

    @butterknife.OnClick(R.id.go_home)
    public void onViewClicked() {
        Intent intent = new Intent ( MainActivity.this, HomeActivity.class );
        startActivity ( intent );
        finish ();
    }


}
