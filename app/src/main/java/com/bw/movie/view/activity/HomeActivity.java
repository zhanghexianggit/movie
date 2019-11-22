package com.bw.movie.view.activity;


import android.graphics.Color;
import android.support.v4.app.Fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bw.movie.R;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.MovieCommentBean;
import com.bw.movie.view.adapter.FragmentAdapter;
import com.bw.movie.view.fragment.CinemaFragment;
import com.bw.movie.view.fragment.MovieFragment;
import com.bw.movie.view.fragment.MyFragment;
import com.bw.movie.view.weight.CustomViewPager;
import com.bwie.mvplibrary.base.BaseActivity;
import com.bwie.mvplibrary.base.BasePresenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.home_pager)
    CustomViewPager homePager;
    @BindView(R.id.yingpian)
    LinearLayout yingpian;
    @BindView(R.id.movie)
    LinearLayout movie;
    @BindView(R.id.relat_a)
    RelativeLayout relatA;
    @BindView(R.id.shapes)
    LinearLayout shapes;
    @BindView(R.id.cinema)
    LinearLayout cinema;
    @BindView(R.id.relat_b)
    RelativeLayout relatB;
    @BindView(R.id.my)
    LinearLayout my;
    @BindView(R.id.my_a)
    LinearLayout myA;
    @BindView(R.id.relat_c)
    RelativeLayout relatC;
    @Override
    protected int bindLayout() {
        return R.layout.activity_home;
    }

    @Override
    protected BasePresenter setPresenter() {
        return null;
    }

    @Override
    protected void initData() {
        super.initData ();
        List<Fragment> fragmentList = new ArrayList<> (  );
        fragmentList.add ( new CinemaFragment () );
        fragmentList.add ( new MovieFragment () );
        fragmentList.add ( new MyFragment () );
        FragmentAdapter fragmentAdapter = new FragmentAdapter ( getSupportFragmentManager (), fragmentList );
        homePager.setAdapter ( fragmentAdapter );
        homePager.setScanScroll ( false );
        setTranslucent(this);
        setColor ( this, Color.WHITE );

    }

    @OnClick({R.id.relat_a, R.id.relat_b, R.id.relat_c})
    public void onViewClicked(View view) {
        switch (view.getId ()) {
            case R.id.relat_a:
                yingpian.setVisibility ( View.VISIBLE );
                movie.setVisibility ( View.GONE );
                shapes.setVisibility ( View.GONE );
                cinema.setVisibility ( View.VISIBLE );
                my.setVisibility ( View.GONE );
                myA.setVisibility ( View.VISIBLE );
                homePager.setCurrentItem ( 0 );
                break;
            case R.id.relat_b:
                yingpian.setVisibility ( View.GONE );
                movie.setVisibility ( View.VISIBLE );
                shapes.setVisibility ( View.VISIBLE );
                cinema.setVisibility ( View.GONE );
                my.setVisibility ( View.GONE );
                myA.setVisibility ( View.VISIBLE );
                homePager.setCurrentItem ( 1 );
                break;
            case R.id.relat_c:
                yingpian.setVisibility ( View.GONE );
                movie.setVisibility ( View.VISIBLE );
                shapes.setVisibility ( View.GONE );
                cinema.setVisibility ( View.VISIBLE );
                my.setVisibility ( View.VISIBLE );
                myA.setVisibility ( View.GONE );
                homePager.setCurrentItem ( 2 );
                break;
        }
    }
}
