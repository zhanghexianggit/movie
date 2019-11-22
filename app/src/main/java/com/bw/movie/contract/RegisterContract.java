package com.bw.movie.contract;

import com.bw.movie.bean.RegisterBean;
import com.bwie.mvplibrary.base.IBaseView;

import java.util.Map;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/11
 * @Description:
 */
public interface RegisterContract {

    interface IMainView extends IBaseView {
        void success(RegisterBean registerBean);
        void fuliderror(String e);

    }


    interface IModel{
        void register(Map<String, Object> map, LoginCallBack callBack);
        void email(String map, LoginCallBack callBack);

        interface LoginCallBack{
            void backData(RegisterBean registerBean);
            void fuliderror(String e);
        }
    }

    interface IPresenter{
        void login(Map<String, Object> map);
        void email(String map);
    }
}
