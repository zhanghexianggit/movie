package com.bw.movie.contract;

import com.bw.movie.bean.RecommendBean;
import com.bwie.mvplibrary.base.IBaseView;

import java.util.Map;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/14
 * @Description:
 */
public interface NearContract {
    interface IMainView extends IBaseView {
        void success(RecommendBean recommendBean);
        void fuliderror(String e);

    }


    interface IModel{
        void near(Map<String,String> queryMap,NearCallBack callBack );


        interface NearCallBack{
            void backData(RecommendBean recommendBean);
            void fuliderror(String e);
        }
    }

    interface IPresenter{
        void near(Map<String,String> queryMap);

    }
}
