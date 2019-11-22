package com.bw.movie.contract;

import com.bw.movie.bean.CinemmaBean;
import com.bw.movie.bean.MovieDetailsBean;
import com.bw.movie.bean.RegionBean;
import com.bwie.mvplibrary.base.IBaseView;

import java.util.Map;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/15
 * @Description:
 */
public interface MovieDetalisContract {
    interface IMainView extends IBaseView {
        void success(MovieDetailsBean movieDetailsBean);

        void fuliderror(String e);

    }


    interface IModel{
        void details(int id,DetailsCallBack callBack);

        interface DetailsCallBack{
            void backData(MovieDetailsBean movieDetailsBean);
            void fuliderror(String e);
        }
    }

    interface IPresenter{
        void details(int id);
    }
}
