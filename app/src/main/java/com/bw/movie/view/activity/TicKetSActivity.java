package com.bw.movie.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bw.movie.R;
import com.bw.movie.view.adapter.FragmentAdapter;
import com.bw.movie.view.fragment.TickAFragment;
import com.bw.movie.view.fragment.TickBFragment;
import com.bwie.mvplibrary.base.BaseActivity;
import com.bwie.mvplibrary.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TicKetSActivity extends BaseActivity {

    @BindView(R.id.image_back)
    ImageView imageBack;
    @BindView(R.id.tick_pager)
    ViewPager tickPager;
    @BindView(R.id.dai_pay)
    Button daiPay;
    @BindView(R.id.yi_pay)
    Button yiPay;

    @Override
    protected int bindLayout() {
        return R.layout.activity_tic_ket_s;
    }

    @Override
    protected BasePresenter setPresenter() {
        return null;
    }

    @Override
    protected void initData() {
        super.initData ();
        List<Fragment> fragmentList = new ArrayList<> ();
        fragmentList.add ( new TickAFragment () );
        fragmentList.add ( new TickBFragment () );

        FragmentAdapter fragmentAdapter = new FragmentAdapter ( getSupportFragmentManager (), fragmentList );
        tickPager.setAdapter ( fragmentAdapter );

    }

    @OnClick({R.id.image_back, R.id.dai_pay, R.id.yi_pay})
    public void onViewClicked(View view) {
        switch (view.getId ()) {
            case R.id.image_back:
                break;
            case R.id.dai_pay:
                tickPager.setCurrentItem ( 0 );
                break;
            case R.id.yi_pay:
                tickPager.setCurrentItem ( 1 );
                break;
        }
    }
}
