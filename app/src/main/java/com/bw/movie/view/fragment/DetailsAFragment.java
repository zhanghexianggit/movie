package com.bw.movie.view.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.MovieDetailsBean;
import com.bw.movie.view.adapter.DetailsARecycleAdapter;
import com.bw.movie.view.adapter.DetailsBRecycleAdapter;
import com.bwie.mvplibrary.base.BaseFragment;
import com.bwie.mvplibrary.base.BasePresenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/18
 * @Description:
 */
public class DetailsAFragment extends BaseFragment {

    @BindView(R.id.movie_jianjie)
    TextView movieJianjie;
    @BindView(R.id.movieDirector)
    TextView movieDirector;
    @BindView(R.id.movieDirector_recycle)
    RecyclerView movieDirectorRecycle;
    @BindView(R.id.movieActor)
    TextView movieActor;
    @BindView(R.id.movieActor_recycle)
    RecyclerView movieActorRecycle;
    private List<MovieDetailsBean.ResultBean.MovieDirectorBean> movieDirectors;
    private List<MovieDetailsBean.ResultBean.MovieActorBean> movieActors;

    @Override
    protected int bindLayout() {
        return R.layout.details_a_layout;
    }

    @Override
    protected BasePresenter setPresenter() {
        return null;
    }

    @Override
    protected void initData() {
        super.initData ();
        EventBus.getDefault ().register ( this );
    }

    @Subscribe(threadMode = ThreadMode.POSTING,sticky = true)
    public void onEvent(MovieDetailsBean movieDetailsBean){
        MovieDetailsBean.ResultBean result = movieDetailsBean.getResult ();
        //简介
        String summary = result.getSummary ();
        //导演人数
        movieDirectors = result.getMovieDirector ();
        //演员人数
        movieActors = result.getMovieActor ();
        movieJianjie.setText ( summary );
        movieDirector.setText ( "导演"+"("+ movieDirectors.size ()+")");
        movieActor.setText ( "演员"+"("+ movieActors.size ()+")");

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager ( getActivity (), LinearLayoutManager.HORIZONTAL, false );
        movieDirectorRecycle.setLayoutManager ( linearLayoutManager );
        DetailsARecycleAdapter detailsARecycleAdapter = new DetailsARecycleAdapter ( movieDirectors, getActivity () );
        movieDirectorRecycle.setAdapter ( detailsARecycleAdapter );

        GridLayoutManager gridLayoutManager = new GridLayoutManager ( getActivity (), 4 );
        movieActorRecycle.setLayoutManager ( gridLayoutManager );
        DetailsBRecycleAdapter detailsBRecycleAdapter = new DetailsBRecycleAdapter ( movieActors, getActivity () );
        movieActorRecycle.setAdapter ( detailsBRecycleAdapter );

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView ();
        EventBus.getDefault ().unregister ( this );
    }
}
