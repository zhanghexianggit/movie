package com.bw.movie.presenter;

import com.bw.movie.bean.TICketBean;
import com.bw.movie.contract.TicKetsContract;
import com.bw.movie.model.TickModel;
import com.bwie.mvplibrary.base.BasePresenter;

import java.util.Map;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/21
 * @Description:
 */
public class TickPresenter extends BasePresenter<TicKetsContract.IMainView> implements TicKetsContract.IPresenter {

    private TickModel tickModel;

    @Override
    public void qticke(Map<String, Object> headerMap,Map<String, Object> queryMap) {
        tickModel.qticke ( headerMap,queryMap,new TicKetsContract.IModel.TickCallBack () {
            @Override
            public void backData(TICketBean tiCketBean) {
                getView ().success ( tiCketBean );
            }

            @Override
            public void fuliderror(String e) {
               getView ().fuliderror ( e );
            }
        } );
    }

    @Override
    protected void initModel() {
        tickModel = new TickModel ();
    }
}
