package com.bw.movie.presenter;

import com.bw.movie.bean.LoginBean;
import com.bw.movie.contract.LoginContract;
import com.bw.movie.model.LoginModel;
import com.bwie.mvplibrary.base.BasePresenter;

import java.util.Map;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/11
 * @Description:
 */
public class LoginPresenter extends BasePresenter<LoginContract.IMainView> implements LoginContract.IPresenter {

    private LoginModel loginModel;

    @Override
    protected void initModel() {
        loginModel = new LoginModel ();
    }

    @Override
    public void login(Map<String, Object> map) {
        loginModel.login ( map, new LoginContract.IModel.LoginCallBack () {
            @Override
            public void backData(LoginBean loginBean) {
                getView ().success(loginBean);
            }

            @Override
            public void fuliderror(String e) {
               getView ().fuliderror ( e );
            }
        } );
    }
}
