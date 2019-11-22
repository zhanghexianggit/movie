package com.bw.movie.contract;

import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.TICketBean;
import com.bwie.mvplibrary.base.IBaseView;

import java.util.Map;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/21
 * @Description:
 */
public interface TicKetsContract {
    interface IMainView extends IBaseView {
        void success(TICketBean tiCketBean);
        void fuliderror(String e);
    }

    interface IModel{
        void qticke(Map<String, Object> headerMap,Map<String, Object> queryMap, TickCallBack callBack);

        interface TickCallBack{
            void backData(TICketBean tiCketBean);
            void fuliderror(String e);
        }
    }

    interface IPresenter{
        void qticke(Map<String, Object> headerMap,Map<String, Object> queryMap);
    }
}
