package com.bw.movie.contract;

import com.bw.movie.bean.CinemmaBean;
import com.bw.movie.bean.RegionBean;
import com.bw.movie.bean.RegisterBean;
import com.bwie.mvplibrary.base.IBaseView;

import java.util.Map;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/13
 * @Description:
 */
public interface AddressContract {
    interface IMainView extends IBaseView {
        void success(RegionBean regionBean);
        void success(CinemmaBean cinemmaBean);
        void fuliderror(String e);

    }


    interface IModel{
        void region(RegionCallBack callBack);
        void cinema(String regions, CinemCallBack cinemCallBack);

        interface RegionCallBack{
            void backData(RegionBean regionBean);

            void fuliderror(String e);
        }
        interface CinemCallBack{
            void backData(CinemmaBean cinemmaBean);
            void fuliderror(String e);
        }

    }

    interface IPresenter{
        void region();
        void cinema(String regions);
    }
}
