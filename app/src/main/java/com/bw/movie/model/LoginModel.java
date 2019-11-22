package com.bw.movie.model;

import com.bw.movie.api.IApiServcie;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.contract.LoginContract;
import com.bwie.mvplibrary.utils.CommonObserver;
import com.bwie.mvplibrary.utils.CommonSchedulers;
import com.bwie.mvplibrary.utils.RetrofitManager;

import java.util.Map;

import io.reactivex.Observable;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/11
 * @Description:登录
 */
public class LoginModel implements LoginContract.IModel {

    private final IApiServcie iApiServcie;

    public LoginModel() {
        iApiServcie = RetrofitManager.getInstance ().create ( IApiServcie.class );
    }

    @Override
    public void login(Map<String, Object> map, final LoginCallBack callBack) {
        Observable login = iApiServcie.login ( map );
        login.compose ( CommonSchedulers.io2main())
             .subscribe ( new CommonObserver<LoginBean> () {
                 @Override
                 public void onNext(LoginBean loginBean) {
                     callBack.backData ( loginBean );
                 }

                 @Override
                 public void onError(Throwable e) {
                     callBack.fuliderror ( e.getMessage () );
                 }
             } );
    }
}
