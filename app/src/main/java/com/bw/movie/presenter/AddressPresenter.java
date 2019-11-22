package com.bw.movie.presenter;

import com.bw.movie.bean.CinemmaBean;
import com.bw.movie.bean.RegionBean;
import com.bw.movie.contract.AddressContract;
import com.bw.movie.model.AddressModel;
import com.bwie.mvplibrary.app.Constant;
import com.bwie.mvplibrary.base.BasePresenter;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/13
 * @Description:
 */
public class AddressPresenter extends BasePresenter<AddressContract.IMainView> implements AddressContract.IPresenter {

    private AddressModel addressModel;

    @Override
    public void region() {
        addressModel.region ( new AddressContract.IModel.RegionCallBack () {
            @Override
            public void backData(RegionBean regionBean) {
                if (isViewAttached ()&&regionBean.getStatus ().equals ( Constant.SUCCESS_CODE )){
                    getView ().success ( regionBean );
                }
            }

            @Override
            public void fuliderror(String e) {
                getView ().fuliderror ( e );
            }
        } );
    }

    @Override
    public void cinema(String regions) {
        addressModel.cinema ( regions, new AddressContract.IModel.CinemCallBack () {
            @Override
            public void backData(CinemmaBean cinemmaBean) {
                if (isViewAttached ()&&cinemmaBean.getStatus ().equals ( Constant.SUCCESS_CODE )){
                    getView ().success ( cinemmaBean );
                }
            }

            @Override
            public void fuliderror(String e) {
                  getView ().fuliderror ( e );
            }
        } );
    }

    @Override
    protected void initModel() {
        addressModel = new AddressModel ();
    }
}
