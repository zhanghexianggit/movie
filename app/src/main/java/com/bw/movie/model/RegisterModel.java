package com.bw.movie.model;

import com.bw.movie.api.IApiServcie;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.contract.RegisterContract;
import com.bwie.mvplibrary.utils.CommonObserver;
import com.bwie.mvplibrary.utils.CommonSchedulers;
import com.bwie.mvplibrary.utils.RetrofitManager;

import java.util.Map;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/11
 * @Description:注册
 */
public class RegisterModel implements RegisterContract.IModel {

    private final IApiServcie iApiServcie;

    public RegisterModel() {
        iApiServcie = RetrofitManager.getInstance ().create ( IApiServcie.class );
    }


    @Override
    public void register(Map<String, Object> map, final LoginCallBack callBack) {
        iApiServcie.register ( map )
                .compose ( CommonSchedulers.<RegisterBean>io2main () )
                .subscribe ( new CommonObserver<RegisterBean> () {
                    @Override
                    public void onNext(RegisterBean registerBean) {
                        callBack.backData ( registerBean );
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.fuliderror ( e.getMessage () );
                    }
                } );

    }

    @Override
    public void email(String map, final LoginCallBack callBack) {
        iApiServcie.email ( map )
                .compose ( CommonSchedulers.<RegisterBean>io2main () )
                .subscribe ( new CommonObserver<RegisterBean> () {
                    @Override
                    public void onNext(RegisterBean registerBean) {
                        callBack.backData ( registerBean );
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.fuliderror ( e.getMessage () );
                    }
                } );
    }
}
