package com.bw.movie.model;

import com.bw.movie.api.IApiServcie;
import com.bw.movie.bean.RecommendBean;
import com.bw.movie.contract.RecommenContract;
import com.bwie.mvplibrary.utils.CommonObserver;
import com.bwie.mvplibrary.utils.CommonSchedulers;
import com.bwie.mvplibrary.utils.RetrofitManager;

import java.util.Map;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/13
 * @Description:推荐影院
 */
public class RecomModel implements RecommenContract.IModel {

    private final IApiServcie iApiServcie;

    public RecomModel() {
        iApiServcie = RetrofitManager.getInstance ().create ( IApiServcie.class );
    }

    @Override
    public void recommn(Map<String, String> headerMap, Map<String, String> queryMap, final RecommnCallBack callBack) {
        iApiServcie.recommend ( headerMap,queryMap )
                .compose ( CommonSchedulers.<RecommendBean>io2main () )
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
