package com.bw.movie.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.api.MainApplication;
import com.bw.movie.bean.DaoBean;
import com.bw.movie.bean.TICketBean;
import com.bw.movie.contract.TicKetsContract;
import com.bw.movie.presenter.TickPresenter;
import com.bw.movie.view.activity.LoginActivity;
import com.bw.movie.view.adapter.NoPayRecycleAdapter;
import com.bwie.mvplibrary.base.BaseFragment;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/21
 * @Description:
 */
public class TickAFragment extends BaseFragment<TickPresenter> implements TicKetsContract.IMainView {
    @BindView(R.id.no_pay)
    XRecyclerView noPay;
    Unbinder unbinder;

    @Override
    protected int bindLayout() {
        return R.layout.tickes_a_layout;
    }

    @Override
    protected TickPresenter setPresenter() {
        return new TickPresenter ();
    }

    @Override
    protected void initData() {
        super.initData ();
        List<DaoBean> list = MainApplication.getDaosession ().getDaoBeanDao ().queryBuilder ().build ().list ();
        if (list.size ()==0){
            Toast.makeText ( getActivity (), "请先登录...", Toast.LENGTH_SHORT ).show ();
            Intent intent = new Intent ( getActivity (), LoginActivity.class );
            getActivity ().startActivity ( intent );
        }else {
            String usserId = list.get ( 0 ).getUsserId ();
            String sessionId = list.get ( 0 ).getSessionId ();

            Map<String, Object> headerMap = new HashMap<> ();
            headerMap.put ( "userId", usserId );
            headerMap.put ( "sessionId", sessionId );

            Map<String, Object> queryMap = new HashMap<> ();
            queryMap.put ( "page", 1 );
            queryMap.put ( "count", 7 );
            queryMap.put ( "status", 1 );

            fpresenter.qticke ( headerMap, queryMap );
        }

        noPay.setPullRefreshEnabled ( false );
        noPay.setLoadingMoreEnabled ( false );

    }

    @Override
    public void success(TICketBean tiCketBean) {
        List<TICketBean.ResultBean> result = tiCketBean.result;
        if (tiCketBean.status.equals ( "9999" )){
            Toast.makeText ( getActivity (), "请先登录...", Toast.LENGTH_SHORT ).show ();
            Intent intent = new Intent ( getActivity (), LoginActivity.class );
            getActivity ().startActivity ( intent );
        }else {
            if (result==null){
                return;
            }
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager ( getActivity (), LinearLayoutManager.VERTICAL, false );
            noPay.setLayoutManager ( linearLayoutManager );
            NoPayRecycleAdapter noPayRecycleAdapter = new NoPayRecycleAdapter ( result, getActivity () );
            noPay.setAdapter ( noPayRecycleAdapter );
        }



    }

    @Override
    public void fuliderror(String e) {

    }
}
