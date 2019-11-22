package com.bw.movie.contract;

import com.bw.movie.bean.RecommendBean;
import com.bw.movie.bean.RegisterBean;
import com.bwie.mvplibrary.base.IBaseView;

import java.util.Map;

import retrofit2.http.QueryMap;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/13
 * @Description:
 */
public interface RecommenContract {
    interface IMainView extends IBaseView {
        void success(RecommendBean recommendBean);
        void fuliderror(String e);

    }


    interface IModel{
        void recommn(Map<String,String> headerMap,Map<String,String> queryMap,RecommnCallBack callBack );


        interface RecommnCallBack{
            void backData(RecommendBean recommendBean);
            void fuliderror(String e);
        }
    }

    interface IPresenter{
        void recommn(Map<String,String> headerMap,Map<String,String> queryMap);

    }
}
