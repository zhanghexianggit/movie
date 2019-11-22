package com.bw.movie.contract;

import com.bw.movie.bean.LoginBean;
import com.bwie.mvplibrary.base.IBaseView;

import java.util.Map;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/11
 * @Description:
 */
public interface LoginContract {

    interface IMainView extends IBaseView {
        void success(LoginBean loginBean);
        void fuliderror(String e);
    }

    interface IModel{
        void login(Map<String, Object> map, LoginCallBack callBack);

        interface LoginCallBack{
            void backData(LoginBean loginBean);
            void fuliderror(String e);
        }
    }

    interface IPresenter{
        void login(Map<String, Object> map);
    }
}
