package com.bw.movie.view.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.bean.RecommendBean;
import com.bw.movie.contract.NearContract;
import com.bw.movie.presenter.NearPresenter;
import com.bw.movie.view.adapter.RecommendXRecycle;
import com.bwie.mvplibrary.base.BaseFragment;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/13
 * @Description:附近影院
 */
public class FuingFragment extends BaseFragment<NearPresenter> implements NearContract.IMainView {
    @BindView(R.id.near_xrecycle)
    XRecyclerView nearXrecycle;
    private Map<String, String> headerMap;
    private Map<String, String> queryMap;
    private int page = 1;
    private List<RecommendBean.ResultBean> result;

    @Override
    protected int bindLayout() {
        return R.layout.fu_jin_layout;
    }

    @Override
    protected NearPresenter setPresenter() {
        return new NearPresenter ();
    }

    @Override
    protected void initData() {
        super.initData ();
        getMap ( page );

        nearXrecycle.setLoadingMoreEnabled ( true );
        nearXrecycle.setPullRefreshEnabled ( true );

        nearXrecycle.setLoadingListener ( new XRecyclerView.LoadingListener () {
            @Override
            public void onRefresh() {
                page=1;
                getMap ( page );
                result.clear ();
                fpresenter.near ( queryMap );
                result.addAll ( result );
                nearXrecycle.refreshComplete ();
            }

            @Override
            public void onLoadMore() {
                page++;
                getMap ( page );
                fpresenter.near ( queryMap );
                nearXrecycle.loadMoreComplete ();
            }
        } );
    }

    @Override
    public void success(RecommendBean recommendBean) {
        result = recommendBean.getResult ();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager ( getActivity (), LinearLayoutManager.VERTICAL, false );
        nearXrecycle.setLayoutManager ( linearLayoutManager );
        RecommendXRecycle recommendXRecycle = new RecommendXRecycle ( result, getActivity () );
        nearXrecycle.setAdapter ( recommendXRecycle );
    }

    @Override
    public void fuliderror(String e) {
        Toast.makeText ( getActivity (), e, Toast.LENGTH_SHORT ).show ();
    }

    public void getMap(int page){
//        headerMap = new HashMap<> ();
//        headerMap.put ( "userId", "" );
//        headerMap.put ( "sessionId", "" );
        queryMap = new HashMap<> ();
//        queryMap.put ( "longitude", "" );
//        queryMap.put ( "latitude", "" );
        queryMap.put ( "page", String.valueOf ( page ) );
        queryMap.put ( "count", "7" );
        fpresenter.near ( queryMap );
    }
}
