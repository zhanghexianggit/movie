package com.bw.movie.model;

import com.bw.movie.api.IApiServcie;
import com.bw.movie.bean.BannerBean;
import com.bw.movie.bean.ComingSoonBean;
import com.bw.movie.bean.HotMovieBean;
import com.bw.movie.bean.ReleaseBean;
import com.bw.movie.contract.CinemaContract;
import com.bw.movie.contract.LoginContract;
import com.bwie.mvplibrary.utils.CommonObserver;
import com.bwie.mvplibrary.utils.CommonSchedulers;
import com.bwie.mvplibrary.utils.RetrofitManager;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/12
 * @Description:
 */
public class CinemaModel implements CinemaContract.IModel {

    private final IApiServcie iApiServcie;

    public CinemaModel() {
        iApiServcie = RetrofitManager.getInstance ().create ( IApiServcie.class );
    }

    //首页bannner图展示
    @Override
    public void banner(final CinemaCallBack cinemaCallBack) {
        iApiServcie.banner ().compose ( CommonSchedulers.<BannerBean>io2main () )
                .subscribe ( new CommonObserver<BannerBean> () {
                    @Override
                    public void onNext(BannerBean bannerBean) {
                        cinemaCallBack.backData ( bannerBean );
                    }

                    @Override
                    public void onError(Throwable e) {
                        cinemaCallBack.fuliderror ( e.getMessage () );
                    }
                } );
    }


    @Override
    public void release(int page, int count, final ReleaseCallBack callBack) {
       iApiServcie.release ( page,count ).compose ( CommonSchedulers.<ReleaseBean>io2main () )
               .subscribe ( new CommonObserver<ReleaseBean> () {
                   @Override
                   public void onNext(ReleaseBean releaseBean) {
                       callBack.backData ( releaseBean );
                   }

                   @Override
                   public void onError(Throwable e) {
                       callBack.fuliderror ( e.getMessage () );
                   }
               } );
    }

    @Override
    public void coming(int page, int count, final ComingCallBack callBack) {
        iApiServcie.coming ( page,count ).compose ( CommonSchedulers.<ComingSoonBean>io2main () )
                .subscribe ( new CommonObserver<ComingSoonBean> () {
                    @Override
                    public void onNext(ComingSoonBean comingSoonBean) {
                        callBack.backData ( comingSoonBean );
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.fuliderror ( e.getMessage () );
                    }
                } );
    }

    @Override
    public void hot(int page, int count, final HotCallBack callBack) {
       iApiServcie.hotmovie ( page,count ).compose ( CommonSchedulers.<HotMovieBean>io2main () )
               .subscribe ( new CommonObserver<HotMovieBean> () {
                   @Override
                   public void onNext(HotMovieBean hotMovieBean) {
                       callBack.backData ( hotMovieBean );
                   }

                   @Override
                   public void onError(Throwable e) {
                      callBack.fuliderror ( e.getMessage () );
                   }
               } );
    }


}
