package com.bw.movie.contract;

import com.bw.movie.bean.RegisterBean;
import com.bw.movie.bean.ScreenHeIdBean;
import com.bw.movie.bean.ScreenSeatBean;
import com.bw.movie.bean.TicketsBean;
import com.bwie.mvplibrary.base.IBaseView;

import java.util.Map;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/20
 * @Description:
 */
public interface ScreenSeatContract {
    interface IMainView extends IBaseView {
        void success(ScreenSeatBean screenSeatBean);
        void success(ScreenHeIdBean screenHeIdBean);
        void success(TicketsBean ticketsBean);
        void fuliderror(String e);

    }


    interface IModel{
        void seat(int hellId, SeatCallBack callBack);
        void hillId(Map<String,Object> queryMap,HillIdCallBack callBack);
        void tickets(Map<String,Object> headerMap,Map<String,Object> queryMap,TicketsCallBack callBack);

        interface SeatCallBack{
            void backData(ScreenSeatBean screenSeatBean);
            void fuliderror(String e);
        }

        interface HillIdCallBack{
            void backData(ScreenHeIdBean screenHeIdBean);
            void fuliderror(String e);
        }

        interface TicketsCallBack{
            void backData(TicketsBean ticketsBean);
            void fuliderror(String e);
        }
    }

    interface IPresenter{
        void seat(int hellId);
        void hillId(Map<String,Object> queryMap);
        void tickets(Map<String,Object> headerMap,Map<String,Object> queryMap);
    }
}
