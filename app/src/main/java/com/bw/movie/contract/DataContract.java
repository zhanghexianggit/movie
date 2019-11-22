package com.bw.movie.contract;

import com.bw.movie.bean.CinemasInfoByRegionBean;
import com.bw.movie.bean.DataBean;
import com.bw.movie.bean.RegionBean;
import com.bwie.mvplibrary.base.IBaseView;

import java.util.Map;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/19
 * @Description:
 */
public interface DataContract {
    interface IMainView extends IBaseView {
        void success(DataBean dataBean);
        void success(RegionBean regionBean);
        void success(CinemasInfoByRegionBean cinemasInfoByRegionBean);
        void fuliderror(String e);

    }

    interface IModel{
        void data(RegionCallBack callBack);
        void cinemasinfobyregion(Map<String,Object> queryMap, CRegionCallBack callBack);
        void cinemasinfobydate( Map<String,Object> queryMap,CDataCallBack callBack);
        void cinemasinfobyprice( Map<String,Object> queryMap,CPrcieCallBack callBack);


        interface RegionCallBack{
            void backData(DataBean dataBean);
            void fuliderror(String e);
        }

        interface CRegionCallBack{
            void backData(CinemasInfoByRegionBean cinemasInfoByRegionBean);
            void fuliderror(String e);
        }
        interface CDataCallBack{
            void backData(CinemasInfoByRegionBean cinemasInfoByDateBean);
            void fuliderror(String e);
        }
        interface CPrcieCallBack{
            void backData(CinemasInfoByRegionBean cinemasInfoByPriceBean);
            void fuliderror(String e);
        }

    }

    interface IPresenter{
        void data();
        void region();
        void cinemasinfobyregion( Map<String,Object> queryMap);
        void cinemasinfobydate( Map<String,Object> queryMap);
        void cinemasinfobyprice( Map<String,Object> queryMap);
    }
}
