package com.bw.movie.presenter;

import com.bw.movie.bean.ScreenHeIdBean;
import com.bw.movie.bean.ScreenSeatBean;
import com.bw.movie.bean.TicketsBean;
import com.bw.movie.contract.ScreenSeatContract;
import com.bw.movie.model.ScreenSeatModel;
import com.bwie.mvplibrary.base.BasePresenter;

import java.util.Map;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/20
 * @Description:
 */
public class ScreenSeatPresenter extends BasePresenter<ScreenSeatContract.IMainView> implements ScreenSeatContract.IPresenter {

    private ScreenSeatModel screenSeatModel;

    @Override
    public void seat(int hellId) {
       screenSeatModel.seat ( hellId, new ScreenSeatContract.IModel.SeatCallBack () {
           @Override
           public void backData(ScreenSeatBean screenSeatBean) {
               getView ().success ( screenSeatBean );
           }

           @Override
           public void fuliderror(String e) {
             getView ().fuliderror ( e );
           }
       } );
    }

    @Override
    public void hillId(Map<String, Object> queryMap) {
        screenSeatModel.hillId ( queryMap, new ScreenSeatContract.IModel.HillIdCallBack () {
            @Override
            public void backData(ScreenHeIdBean screenHeIdBean) {
                getView ().success ( screenHeIdBean );
            }

            @Override
            public void fuliderror(String e) {
                getView ().fuliderror ( e );
            }
        } );
    }

    @Override
    public void tickets(Map<String, Object> headerMap, Map<String, Object> queryMap) {
        screenSeatModel.tickets ( headerMap, queryMap, new ScreenSeatContract.IModel.TicketsCallBack () {
            @Override
            public void backData(TicketsBean ticketsBean) {
                getView ().success ( ticketsBean );
            }

            @Override
            public void fuliderror(String e) {
                getView ().fuliderror ( e );
            }
        } );
    }

    @Override
    protected void initModel() {
        screenSeatModel = new ScreenSeatModel ();
    }
}
