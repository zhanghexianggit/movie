package com.bw.movie.model;

import com.bw.movie.api.IApiServcie;
import com.bw.movie.bean.RecommendBean;
import com.bw.movie.contract.NearContract;
import com.bwie.mvplibrary.utils.CommonObserver;
import com.bwie.mvplibrary.utils.CommonSchedulers;
import com.bwie.mvplibrary.utils.RetrofitManager;

import java.util.Map;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/14
 * @Description:附近影院
 */
public class NearModel implements NearContract.IModel {

    private final IApiServcie iApiServcie;

    public NearModel() {
        iApiServcie = RetrofitManager.getInstance ().create ( IApiServcie.class );
    }

    @Override
    public void near(Map<String, String> queryMap, final NearCallBack callBack) {
        iApiServcie.near (queryMap ).compose ( CommonSchedulers.<RecommendBean>io2main () )
                .subscribe ( new CommonObserver<RecommendBean> () {
                    @Override
                    public void onNext(RecommendBean recommendBean) {
                        callBack.backData ( recommendBean );
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.fuliderror ( e.getMessage () );
                    }
                } );
    }
}
