package com.bw.movie.view.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.movie.R;
import com.bw.movie.bean.MovieCommentBean;
import com.bw.movie.bean.MovieDetailsBean;
import com.bw.movie.contract.MovieCommentContract;
import com.bw.movie.presenter.MovieCommentPresenter;
import com.bw.movie.view.adapter.DetailsItemAdapter;
import com.bwie.mvplibrary.app.App;
import com.bwie.mvplibrary.base.BaseFragment;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/18
 * @Description:
 */
public class DetailsDFragment extends BaseFragment<MovieCommentPresenter> implements MovieCommentContract.IMainView {

    @BindView(R.id.details_xrecycle)
    XRecyclerView detailsXrecycle;
    private Map<String, Object> queryMap;
    private int page = 1;
    private int movieId;

    @Override
    protected int bindLayout() {
        return R.layout.details_d_layout;
    }

    @Override
    protected MovieCommentPresenter setPresenter() {
        return new MovieCommentPresenter ();
    }

    @Override
    public void success(MovieCommentBean movieCommentBean) {
        List<MovieCommentBean.ResultBean> result = movieCommentBean.getResult ();
        Log.d ( "DetailsDFragment:","DetailsDFragment:"+result.size ());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager ( getActivity (), LinearLayoutManager.VERTICAL, false );
        detailsXrecycle.setLayoutManager ( linearLayoutManager );
        DetailsItemAdapter detailsItemAdapter = new DetailsItemAdapter ( result, getActivity () );
        detailsXrecycle.setAdapter ( detailsItemAdapter );
    }

    @Override
    public void fuliderror(String e) {
        Log.d ( "DetailsDFragment:","DetailsDFragment:"+e);
    }

    @Override
    protected void initData() {
        super.initData ();
        EventBus.getDefault ().register ( this );
    }

    @Subscribe(threadMode = ThreadMode.POSTING, sticky = true)
    public void onEvent(MovieDetailsBean movieDetailsBean) {
        MovieDetailsBean.ResultBean result = movieDetailsBean.getResult ();
        movieId = result.getMovieId ();
        getMap ( page, movieId );
        fpresenter.moviecomment ( queryMap );
    }


    public void getMap(int page, int movieId) {
        queryMap = new HashMap<> ();
        queryMap.put ( "movieId", movieId );
        queryMap.put ( "page", page );
        queryMap.put ( "count", 7 );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView ();
        EventBus.getDefault ().unregister (this );
    }
}
