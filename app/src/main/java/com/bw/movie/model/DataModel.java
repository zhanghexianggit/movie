package com.bw.movie.model;

import com.bw.movie.api.IApiServcie;
import com.bw.movie.bean.CinemasInfoByRegionBean;
import com.bw.movie.bean.DataBean;
import com.bw.movie.contract.DataContract;
import com.bwie.mvplibrary.utils.CommonObserver;
import com.bwie.mvplibrary.utils.CommonSchedulers;
import com.bwie.mvplibrary.utils.RetrofitManager;

import java.util.Map;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/20
 * @Description:
 */
public class DataModel implements DataContract.IModel {

    private final IApiServcie iApiServcie;

    public DataModel() {
        iApiServcie = RetrofitManager.getInstance ().create ( IApiServcie.class );
    }

    @Override
    public void data(final RegionCallBack callBack) {
        iApiServcie.data ().compose ( CommonSchedulers.<DataBean>io2main () )
                .subscribe ( new CommonObserver<DataBean> () {
                    @Override
                    public void onNext(DataBean dataBean) {
                        callBack.backData ( dataBean );
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.fuliderror ( e.getMessage () );
                    }
                } );
    }

    @Override
    public void cinemasinfobyregion(Map<String, Object> queryMap, final CRegionCallBack callBack) {
        iApiServcie.cinemasinfobyregion ( queryMap )
                .compose ( CommonSchedulers.<CinemasInfoByRegionBean>io2main () )
                .subscribe ( new CommonObserver<CinemasInfoByRegionBean> () {
                    @Override
                    public void onNext(CinemasInfoByRegionBean cinemasInfoByRegionBean) {
                        callBack.backData ( cinemasInfoByRegionBean );
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.fuliderror ( e.getMessage () );
                    }
                } );
    }

    @Override
    public void cinemasinfobydate(Map<String, Object> queryMap, final CDataCallBack callBack) {
        iApiServcie.cinemasinfobydate ( queryMap )
                .compose ( CommonSchedulers.<CinemasInfoByRegionBean>io2main () )
                .subscribe ( new CommonObserver<CinemasInfoByRegionBean> () {

                    @Override
                    public void onNext(CinemasInfoByRegionBean cinemasInfoByDateBean) {
                        callBack.backData ( cinemasInfoByDateBean );
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.fuliderror ( e.getMessage () );
                    }
                } );
    }

    @Override
    public void cinemasinfobyprice(Map<String, Object> queryMap, final CPrcieCallBack callBack) {
        iApiServcie.cinemasinfobyprice ( queryMap )
                .compose ( CommonSchedulers.<CinemasInfoByRegionBean>io2main () )
                .subscribe ( new CommonObserver<CinemasInfoByRegionBean> () {
                    @Override
                    public void onNext(CinemasInfoByRegionBean cinemasInfoByRegionBean) {
                        callBack.backData ( cinemasInfoByRegionBean );
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.fuliderror ( e.getMessage () );
                    }
                } );
    }
}
