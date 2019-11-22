package com.bw.movie.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.MovieDetailsBean;
import com.bw.movie.contract.MovieDetalisContract;
import com.bw.movie.presenter.MovieDetailsPresenter;
import com.bw.movie.view.adapter.FragmentAdapter;
import com.bw.movie.view.fragment.DetailsAFragment;
import com.bw.movie.view.fragment.DetailsBFragment;
import com.bw.movie.view.fragment.DetailsCFragment;
import com.bw.movie.view.fragment.DetailsDFragment;
import com.bwie.mvplibrary.base.BaseActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MovieDetailActivity extends BaseActivity<MovieDetailsPresenter> implements MovieDetalisContract.IMainView {

    @BindView(R.id.movie_image)
    SimpleDraweeView movieImage;
    @BindView(R.id.laysde)
    LinearLayout laysde;
    @BindView(R.id.details_mark)
    TextView detailsMark;
    @BindView(R.id.details_critic)
    TextView detailsCritic;
    @BindView(R.id.details_name)
    TextView detailsName;
    @BindView(R.id.details_type)
    TextView detailsType;
    @BindView(R.id.details_date)
    TextView detailsDate;
    @BindView(R.id.image_guanzhu)
    ImageView imageGuanzhu;
    @BindView(R.id.text_guanzhu)
    TextView textGuanzhu;
    @BindView(R.id.details_tab)
    TabLayout detailsTab;
    @BindView(R.id.details_pager)
    ViewPager detailsPager;
    @BindView(R.id.btn_reviews)
    Button btnReviews;
    @BindView(R.id.btn_seat)
    Button btnSeat;


    @Override
    public void success(MovieDetailsBean movieDetailsBean) {
        movieImage.setImageURI ( movieDetailsBean.getResult ().getImageUrl () );
        detailsName.setText ( movieDetailsBean.getResult ().getName () );
        detailsType.setText ( movieDetailsBean.getResult ().getMovieType () );

        long releaseTime = movieDetailsBean.getResult ().getReleaseTime ();
        SimpleDateFormat dateFormat = new SimpleDateFormat ( "yyyy-MM-dd" );
        String format = dateFormat.format ( releaseTime );

        detailsDate.setText ( format );
        detailsMark.setText ( "评分 " + movieDetailsBean.getResult ().getScore () );
        detailsCritic.setText ( "评论 " + movieDetailsBean.getResult ().getCommentNum () + "万条" );

        EventBus.getDefault ().postSticky ( movieDetailsBean );
    }

    @Override
    public void fuliderror(String e) {

    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_movie_detail;
    }

    @Override
    protected MovieDetailsPresenter setPresenter() {
        return new MovieDetailsPresenter ();
    }

    @Override
    protected void initData() {
        super.initData ();
        Intent intent = getIntent ();
        String movieId = intent.getStringExtra ( "movieId" );
        presenter.details ( Integer.parseInt ( movieId ) );

        List<Fragment> fragmentList = new ArrayList<> ();
        fragmentList.add ( new DetailsAFragment () );
        fragmentList.add ( new DetailsBFragment () );
        fragmentList.add ( new DetailsCFragment () );
        fragmentList.add ( new DetailsDFragment () );

        FragmentAdapter fragmentAdapter = new FragmentAdapter ( getSupportFragmentManager (), fragmentList );
        detailsPager.setAdapter ( fragmentAdapter );

        for (int i = 0; i < 4; i++) {
            detailsTab.addTab ( detailsTab.newTab () );
        }

        detailsTab.setupWithViewPager ( detailsPager );

        detailsTab.getTabAt ( 0 ).setText ( "介绍" );
        detailsTab.getTabAt ( 1 ).setText ( "预告" );
        detailsTab.getTabAt ( 2 ).setText ( "剧照" );
        detailsTab.getTabAt ( 3 ).setText ( "影评" );
    }

    @OnClick({R.id.image_guanzhu, R.id.btn_reviews, R.id.btn_seat})
    public void onViewClicked(View view) {
        switch (view.getId ()) {
            case R.id.image_guanzhu:
                String string = textGuanzhu.getText ().toString ();
                if (string.equals ( "关注" )){
                    imageGuanzhu.setImageDrawable(getResources().getDrawable(R.mipmap.emptyhearta));
                    textGuanzhu.setText ( "已关注" );
                }else if (string.equals ( "已关注" )){
                    imageGuanzhu.setImageDrawable ( getResources ().getDrawable ( R.mipmap.emptyheart ) );
                    textGuanzhu.setText ( "关注" );
                }
                break;
            case R.id.btn_reviews:
                break;
            case R.id.btn_seat:
                Intent intent = new Intent ( MovieDetailActivity.this, ChoseMovieActivity.class );
                startActivity ( intent );
                break;
        }
    }
}
