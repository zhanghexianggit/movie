package com.bw.movie.contract;

import com.bw.movie.bean.BannerBean;
import com.bw.movie.bean.ComingSoonBean;
import com.bw.movie.bean.HotMovieBean;
import com.bw.movie.bean.ReleaseBean;
import com.bwie.mvplibrary.base.IBaseView;

import java.util.Map;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/12
 * @Description:
 */
public interface CinemaContract {
    interface IMainView extends IBaseView {
        void success(BannerBean bannerBean);
        void success(ReleaseBean releaseBean);
        void success(ComingSoonBean comingSoonBean);
        void success(HotMovieBean hotMovieBean);
        void fuliderror(String e);
    }

    interface IModel{
        void banner(CinemaCallBack cinemaCallBack);
        void release(int page,int count,ReleaseCallBack callBack);
        void coming(int page,int count,ComingCallBack callBack);
        void hot(int page,int count,HotCallBack callBack);

        interface CinemaCallBack{
            void backData(BannerBean bannerBean);
            void fuliderror(String e);
        }
        interface ReleaseCallBack{
            void backData(ReleaseBean releaseBean);
            void fuliderror(String e);
        }
        interface ComingCallBack{
            void backData(ComingSoonBean comingSoonBean);
            void fuliderror(String e);
        }
        interface HotCallBack{
            void backData(HotMovieBean hotMovieBean);
            void fuliderror(String e);
        }
    }

    interface IPresenter{
        void banner();
        void release(int page,int count);
        void coming(int page,int count);
        void hot(int page,int count);
    }
}
