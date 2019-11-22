package com.bw.movie.presenter;

import com.bw.movie.bean.RegisterBean;
import com.bw.movie.contract.RegisterContract;
import com.bw.movie.model.RegisterModel;
import com.bwie.mvplibrary.base.BasePresenter;

import java.util.Map;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/11
 * @Description:
 */
public class RegisterPresenter extends BasePresenter<RegisterContract.IMainView> implements RegisterContract.IPresenter {

    private RegisterModel registerModel;
    @Override
    protected void initModel() {
        registerModel = new RegisterModel ();
    }

    @Override
    public void login(Map<String, Object> map) {
        registerModel.register ( map, new RegisterContract.IModel.LoginCallBack () {
            @Override
            public void backData(RegisterBean registerBean) {
                getView ().success ( registerBean );
            }

            @Override
            public void fuliderror(String e) {
                getView ().fuliderror ( e );
            }
        } );
    }

    @Override
    public void email(String map) {
        registerModel.email ( map, new RegisterContract.IModel.LoginCallBack () {
            @Override
            public void backData(RegisterBean registerBean) {
                getView ().success ( registerBean );
            }

            @Override
            public void fuliderror(String e) {
                getView ().fuliderror ( e );
            }
        } );
    }
}
