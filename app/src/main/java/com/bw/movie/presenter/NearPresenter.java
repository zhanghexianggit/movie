package com.bw.movie.presenter;

import com.bw.movie.bean.RecommendBean;
import com.bw.movie.contract.NearContract;
import com.bw.movie.model.NearModel;
import com.bwie.mvplibrary.base.BasePresenter;

import java.util.Map;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/14
 * @Description:附近影院
 */
public class NearPresenter extends BasePresenter<NearContract.IMainView> implements NearContract.IPresenter {

    private NearModel nearModel;

    @Override
    public void near( Map<String, String> queryMap) {
         nearModel.near (queryMap, new NearContract.IModel.NearCallBack () {
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
        nearModel = new NearModel ();
    }
}
