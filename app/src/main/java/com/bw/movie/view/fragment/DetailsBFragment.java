package com.bw.movie.view.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.bean.MovieDetailsBean;
import com.bwie.mvplibrary.base.BaseFragment;
import com.bwie.mvplibrary.base.BasePresenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;


/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/18
 * @Description:
 */
public class DetailsBFragment extends BaseFragment {


    @BindView(R.id.movie_playera)
    JCVideoPlayer moviePlayera;
    @BindView(R.id.movie_playerb)
    JCVideoPlayer moviePlayerb;
    @BindView(R.id.movie_playerc)
    JCVideoPlayer moviePlayerc;
    private String videoUrla;
    private String videoUrlb;
    private String videoUrlc;
    private String name;
    private String imageUrla;
    private String imageUrlb;
    private String imageUrlc;

    @Override
    protected int bindLayout() {
        return R.layout.details_b_layout;
    }

    @Override
    protected BasePresenter setPresenter() {
        return null;
    }

    @Override
    protected void initData() {
        super.initData ();


        EventBus.getDefault ().register ( this );
        moviePlayera.setUp ( videoUrla, null );
        Glide.with (getActivity ()).load ( imageUrla )
                .into ( moviePlayera.ivThumb );

        moviePlayerb.setUp ( videoUrlb, null );
        Glide.with ( getActivity () ).load ( imageUrlb )
                .into ( moviePlayerb.ivThumb );


        moviePlayerc.setUp ( videoUrlc, null );
        Glide.with ( getActivity () ).load ( imageUrlc )
                .into ( moviePlayerc.ivThumb );
    }

    @Subscribe(threadMode = ThreadMode.POSTING, sticky = true)
    public void onEvent(MovieDetailsBean movieDetailsBean) {
        MovieDetailsBean.ResultBean result = movieDetailsBean.getResult ();
        name = result.getName ();
        List<MovieDetailsBean.ResultBean.ShortFilmListBean> shortFilmList = result.getShortFilmList ();
        videoUrla = shortFilmList.get ( 0 ).getVideoUrl ();
        imageUrla = shortFilmList.get ( 0 ).getImageUrl ();

        videoUrlb = shortFilmList.get ( 1 ).getVideoUrl ();
        imageUrlb = shortFilmList.get ( 1 ).getImageUrl ();

        videoUrlc = shortFilmList.get ( 2 ).getVideoUrl ();
        imageUrlc = shortFilmList.get ( 2 ).getImageUrl ();
    }

    @Override
    public void onPause() {
        super.onPause ();
        JCVideoPlayer.releaseAllVideos ();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView ();
        EventBus.getDefault ().unregister ( this );
        JCVideoPlayer.releaseAllVideos ();
    }

}
