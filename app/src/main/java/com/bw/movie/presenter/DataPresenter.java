package com.bw.movie.presenter;

import com.bw.movie.bean.CinemasInfoByRegionBean;
import com.bw.movie.bean.DataBean;
import com.bw.movie.bean.RegionBean;
import com.bw.movie.contract.AddressContract;
import com.bw.movie.contract.DataContract;
import com.bw.movie.model.AddressModel;
import com.bw.movie.model.DataModel;
import com.bwie.mvplibrary.base.BasePresenter;

import java.util.Map;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/20
 * @Description:
 */
public class DataPresenter extends BasePresenter<DataContract.IMainView> implements DataContract.IPresenter {

    private DataModel dataModel;
    private AddressModel addressModel;

    @Override
    public void data() {
        dataModel.data ( new DataContract.IModel.RegionCallBack () {
            @Override
            public void backData(DataBean dataBean) {
                getView ().success ( dataBean );
            }

            @Override
            public void fuliderror(String e) {
               getView ().fuliderror ( e );
            }
        } );
    }

    @Override
    public void region() {
        addressModel.region ( new AddressContract.IModel.RegionCallBack () {
            @Override
            public void backData(RegionBean regionBean) {
                getView ().success ( regionBean );
            }

            @Override
            public void fuliderror(String e) {
                getView ().fuliderror ( e );
            }
        } );
    }

    @Override
    public void cinemasinfobyregion(Map<String, Object> queryMap) {
        dataModel.cinemasinfobyregion ( queryMap, new DataContract.IModel.CRegionCallBack () {
            @Override
            public void backData(CinemasInfoByRegionBean cinemasInfoByRegionBean) {
                getView ().success ( cinemasInfoByRegionBean );
            }

            @Override
            public void fuliderror(String e) {
                getView ().fuliderror ( e );
            }
        } );
    }

    @Override
    public void cinemasinfobydate(Map<String, Object> queryMap) {
        dataModel.cinemasinfobydate ( queryMap, new DataContract.IModel.CDataCallBack () {
            @Override
            public void backData(CinemasInfoByRegionBean cinemasInfoByRegionBean) {
                getView ().success ( cinemasInfoByRegionBean );
            }

            @Override
            public void fuliderror(String e) {
                getView ().fuliderror ( e );
            }
        } );
    }

    @Override
    public void cinemasinfobyprice(Map<String, Object> queryMap) {
         dataModel.cinemasinfobyprice ( queryMap, new DataContract.IModel.CPrcieCallBack () {
             @Override
             public void backData(CinemasInfoByRegionBean cinemasInfoByRegionBean) {
                 getView ().success ( cinemasInfoByRegionBean );
             }

             @Override
             public void fuliderror(String e) {
                 getView ().fuliderror ( e );
             }
         } );
    }

    @Override
    protected void initModel() {
        dataModel = new DataModel ();
        addressModel = new AddressModel ();
    }
}
