package com.bw.movie.model;

import android.telecom.Call;

import com.bw.movie.api.IApiServcie;
import com.bw.movie.bean.CinemmaBean;
import com.bw.movie.bean.RegionBean;
import com.bw.movie.contract.AddressContract;
import com.bwie.mvplibrary.utils.CommonObserver;
import com.bwie.mvplibrary.utils.CommonSchedulers;
import com.bwie.mvplibrary.utils.RetrofitManager;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/13
 * @Description:查询地区
 */
public class AddressModel implements AddressContract.IModel {

    private final IApiServcie iApiServcie;

    public AddressModel() {
        iApiServcie = RetrofitManager.getInstance ().create ( IApiServcie.class );
    }

    @Override
    public void region(final RegionCallBack callBack) {
        iApiServcie.region ().compose ( CommonSchedulers.<RegionBean>io2main () )
                .subscribe ( new CommonObserver<RegionBean> () {
                    @Override
                    public void onNext(RegionBean regionBean) {
                        callBack.backData ( regionBean );
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.fuliderror ( e.getMessage () );
                    }
                } );
    }

    @Override
    public void cinema(String regions, final CinemCallBack cinemCallBack) {
        iApiServcie.cinema ( regions ).compose ( CommonSchedulers.<CinemmaBean>io2main () )
                .subscribe ( new CommonObserver<CinemmaBean> () {
                    @Override
                    public void onNext(CinemmaBean cinemmaBean) {
                        cinemCallBack.backData ( cinemmaBean );
                    }

                    @Override
                    public void onError(Throwable e) {
                        cinemCallBack.fuliderror ( e.getMessage () );
                    }
                } );
    }
}
