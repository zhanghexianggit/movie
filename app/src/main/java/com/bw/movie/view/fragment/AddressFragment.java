package com.bw.movie.view.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.bean.CinemmaBean;
import com.bw.movie.bean.RegionBean;
import com.bw.movie.contract.AddressContract;
import com.bw.movie.presenter.AddressPresenter;
import com.bw.movie.view.adapter.CinemaRecycle;
import com.bw.movie.view.adapter.RegionRecycle;
import com.bwie.mvplibrary.base.BaseFragment;
import com.bwie.mvplibrary.base.BasePresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.http.FieldMap;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/13
 * @Description:
 */
public class AddressFragment extends BaseFragment<AddressPresenter> implements AddressContract.IMainView {
    @BindView(R.id.region_recycle)
    RecyclerView regionRecycle;
    @BindView(R.id.cinema_recycle)
    RecyclerView cinemaRecycle;

    @Override
    protected int bindLayout() {
        return R.layout.address_layout;
    }

    @Override
    protected AddressPresenter setPresenter() {
        return new AddressPresenter ();
    }

    @Override
    protected void initData() {
        super.initData ();
        fpresenter.region ();
        fpresenter.cinema ( String.valueOf ( 1 ) );
    }

    @Override
    public void success(RegionBean regionBean) {
        List<RegionBean.ResultBean> result = regionBean.getResult ();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager ( getActivity (), LinearLayoutManager.VERTICAL, false );
        regionRecycle.setLayoutManager ( linearLayoutManager );
        RegionRecycle regionRecycles = new RegionRecycle ( result, getActivity () );
        regionRecycle.setAdapter ( regionRecycles );

        regionRecycles.setRegionIds ( new RegionRecycle.RegionIds () {
            @Override
            public void data(int region) {
                fpresenter.cinema ( String.valueOf ( region ) );
            }
        } );
    }

    @Override
    public void success(CinemmaBean cinemmaBean) {
        List<CinemmaBean.ResultBean> result = cinemmaBean.getResult ();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager ( getActivity (), LinearLayoutManager.VERTICAL, false );
        cinemaRecycle.setLayoutManager ( linearLayoutManager );
        CinemaRecycle cinemaRecycles = new CinemaRecycle ( result, getActivity () );
        cinemaRecycle.setAdapter ( cinemaRecycles );
    }

    @Override
    public void fuliderror(String e) {
        Toast.makeText ( getActivity (), e, Toast.LENGTH_SHORT ).show ();
    }
}
