package com.bw.movie.model;

import com.bw.movie.api.IApiServcie;
import com.bw.movie.bean.TICketBean;
import com.bw.movie.contract.TicKetsContract;
import com.bwie.mvplibrary.utils.CommonObserver;
import com.bwie.mvplibrary.utils.CommonSchedulers;
import com.bwie.mvplibrary.utils.RetrofitManager;

import java.util.Map;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/21
 * @Description:
 */
public class TickModel implements TicKetsContract.IModel {

    private final IApiServcie iApiServcie;

    public TickModel() {
        iApiServcie = RetrofitManager.getInstance ().create ( IApiServcie.class );
    }


    @Override
    public void qticke(Map<String, Object> headerMap, Map<String, Object> queryMap, final TickCallBack callBack) {
        iApiServcie.qticke ( headerMap,queryMap ).compose ( CommonSchedulers.<TICketBean>io2main () )
                .subscribe ( new CommonObserver<TICketBean> () {
                    @Override
                    public void onNext(TICketBean tiCketBean) {
                        callBack.backData ( tiCketBean );
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.fuliderror ( e.getMessage () );
                    }
                } );
    }
}
