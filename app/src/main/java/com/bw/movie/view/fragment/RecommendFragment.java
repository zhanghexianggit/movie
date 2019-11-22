package com.bw.movie.view.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.bean.RecommendBean;
import com.bw.movie.contract.RecommenContract;
import com.bw.movie.presenter.RecommePresenter;
import com.bw.movie.view.adapter.RecommendXRecycle;
import com.bwie.mvplibrary.base.BaseFragment;
import com.bwie.mvplibrary.base.BasePresenter;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/13
 * @Description:推荐影院
 */
public class RecommendFragment extends BaseFragment<RecommePresenter> implements RecommenContract.IMainView {
    @BindView(R.id.recommend_xrecycle)
    XRecyclerView recommendXrecycle;
    private Map<String, String> headerMap;
    private Map<String, String> queryMap;
    private int page = 1;
    private List<RecommendBean.ResultBean> result;

    @Override
    protected int bindLayout() {
        return R.layout.recommend_layout;
    }

    @Override
    protected RecommePresenter setPresenter() {
        return new RecommePresenter ();
    }

    @Override
    protected void initData() {
        super.initData ();
        getMap (page);

        recommendXrecycle.setPullRefreshEnabled ( true );
        recommendXrecycle.setLoadingMoreEnabled ( true );

        recommendXrecycle.setLoadingListener ( new XRecyclerView.LoadingListener () {
            @Override
            public void onRefresh() {
                result.clear ();
                page=1;
                getMap ( page );
                fpresenter.recommn ( headerMap,queryMap );
                result.addAll ( result );
                recommendXrecycle.refreshComplete ();
            }

            @Override
            public void onLoadMore() {
                 page++;
                 getMap ( page );
                 fpresenter.recommn ( headerMap,queryMap );
                 result.addAll ( result );
                 recommendXrecycle.loadMoreComplete ();
            }
        } );


    }

    @Override
    public void success(RecommendBean recommendBean) {
        result = recommendBean.getResult ();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager ( getActivity (), LinearLayoutManager.VERTICAL, false );
        recommendXrecycle.setLayoutManager ( linearLayoutManager );
        RecommendXRecycle recommendXRecycles = new RecommendXRecycle ( result, getActivity () );
        recommendXrecycle.setAdapter ( recommendXRecycles );
    }

    @Override
    public void fuliderror(String e) {
        Toast.makeText ( getActivity (), e, Toast.LENGTH_SHORT ).show ();
    }

    public void getMap(int page){
        headerMap = new HashMap<> (  );
        headerMap.put ( "userId","0" );
        headerMap.put ( "sessionId","" );
        queryMap = new HashMap<> (  );
        queryMap.put ( "page",String.valueOf ( page ) );
        queryMap.put ( "count","7" );
        fpresenter.recommn ( headerMap, queryMap );
    }
}
