package com.bw.movie.model;

import com.bw.movie.api.IApiServcie;
import com.bw.movie.bean.MovieDetailsBean;
import com.bw.movie.contract.MovieDetalisContract;
import com.bwie.mvplibrary.utils.CommonObserver;
import com.bwie.mvplibrary.utils.CommonSchedulers;
import com.bwie.mvplibrary.utils.RetrofitManager;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/15
 * @Description:
 */
public class MovieDetailsModel implements MovieDetalisContract.IModel {

    private final IApiServcie iApiServcie;

    public MovieDetailsModel() {
        iApiServcie = RetrofitManager.getInstance ().create ( IApiServcie.class );
    }

    @Override
    public void details(int id, final DetailsCallBack callBack) {
         iApiServcie.details ( id ).compose ( CommonSchedulers.<MovieDetailsBean>io2main () )
                 .subscribe ( new CommonObserver<MovieDetailsBean> () {
                     @Override
                     public void onNext(MovieDetailsBean movieDetailsBean) {
                         callBack.backData ( movieDetailsBean );
                     }

                     @Override
                     public void onError(Throwable e) {
                         callBack.fuliderror ( e.getMessage () );
                     }
                 } );
    }
}
