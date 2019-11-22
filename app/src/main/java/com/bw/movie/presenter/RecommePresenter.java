package com.bw.movie.presenter;

import com.bw.movie.bean.RecommendBean;
import com.bw.movie.contract.RecommenContract;
import com.bw.movie.model.RecomModel;
import com.bwie.mvplibrary.base.BasePresenter;

import java.util.Map;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/13
 * @Description:
 */
public class RecommePresenter extends BasePresenter<RecommenContract.IMainView> implements RecommenContract.IPresenter {

    private RecomModel recomModel;

    @Override
    public void recommn(Map<String,String> headerMap,Map<String,String> queryMap) {
        recomModel.recommn ( headerMap, queryMap, new RecommenContract.IModel.RecommnCallBack () {
            @Override
            public void backData(RecommendBean recommendBean) {
                getView ().success ( recommendBean );
            }

            @Override
            public void fuliderror(String e) {
               getView ().fuliderror ( e );
            }
        } );
    }

    @Override
    protected void initModel() {
        recomModel = new RecomModel ();
    }
}
