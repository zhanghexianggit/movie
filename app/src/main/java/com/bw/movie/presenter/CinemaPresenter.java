package com.bw.movie.presenter;

import com.bw.movie.bean.BannerBean;
import com.bw.movie.bean.ComingSoonBean;
import com.bw.movie.bean.HotMovieBean;
import com.bw.movie.bean.ReleaseBean;
import com.bw.movie.contract.CinemaContract;
import com.bw.movie.model.CinemaModel;
import com.bwie.mvplibrary.app.Constant;
import com.bwie.mvplibrary.base.BasePresenter;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/12
 * @Description:
 */
public class CinemaPresenter extends BasePresenter<CinemaContract.IMainView> implements CinemaContract.IPresenter {

    private CinemaModel cinemaModel;
    @Override
    protected void initModel() {
        cinemaModel = new CinemaModel ();
    }

    @Override
    public void banner() {
        cinemaModel.banner ( new CinemaContract.IModel.CinemaCallBack () {
            @Override
            public void backData(BannerBean bannerBean) {
                if (isViewAttached ()&&bannerBean.getStatus ().equals ( Constant.SUCCESS_CODE )){
                    getView ().success ( bannerBean );
                }

            }

            @Override
            public void fuliderror(String e) {
                getView ().fuliderror ( e );
            }
        } );

    }

    @Override
    public void release(int page, int count) {
        cinemaModel.release ( page, count, new CinemaContract.IModel.ReleaseCallBack () {
            @Override
            public void backData(ReleaseBean releaseBean) {
                if (isViewAttached ()&&releaseBean.getStatus ().equals ( Constant.SUCCESS_CODE )){
                    getView ().success ( releaseBean );
                }
            }

            @Override
            public void fuliderror(String e) {
                getView ().fuliderror ( e );
            }
        } );
    }

    @Override
    public void coming(int page, int count) {
       cinemaModel.coming ( page, count, new CinemaContract.IModel.ComingCallBack () {
           @Override
           public void backData(ComingSoonBean comingSoonBean) {
               if (isViewAttached ()&&comingSoonBean.getStatus ().equals ( Constant.SUCCESS_CODE )){
                   getView ().success ( comingSoonBean );
               }
           }

           @Override
           public void fuliderror(String e) {
                 getView ().fuliderror ( e );
           }
       } );
    }

    @Override
    public void hot(int page, int count) {
        cinemaModel.hot ( page, count, new CinemaContract.IModel.HotCallBack () {
            @Override
            public void backData(HotMovieBean hotMovieBean) {
                if (isViewAttached ()&&hotMovieBean.getStatus ().equals ( Constant.SUCCESS_CODE )){
                    getView ().success ( hotMovieBean );
                }
            }

            @Override
            public void fuliderror(String e) {
                getView ().fuliderror ( e );
            }
        } );
    }
}
