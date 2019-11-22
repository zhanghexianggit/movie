package com.bw.movie.model;

import com.bw.movie.api.IApiServcie;
import com.bw.movie.bean.ScreenHeIdBean;
import com.bw.movie.bean.ScreenSeatBean;
import com.bw.movie.bean.TicketsBean;
import com.bw.movie.contract.ScreenSeatContract;
import com.bwie.mvplibrary.utils.CommonObserver;
import com.bwie.mvplibrary.utils.CommonSchedulers;
import com.bwie.mvplibrary.utils.RetrofitManager;

import org.greenrobot.eventbus.Subscribe;

import java.util.Map;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/20
 * @Description:
 */
public class ScreenSeatModel implements ScreenSeatContract.IModel {

    private final IApiServcie iApiServcie;

    public ScreenSeatModel() {
        iApiServcie = RetrofitManager.getInstance ().create ( IApiServcie.class );
    }

    @Override
    public void seat(int hallId , final SeatCallBack callBack) {
        iApiServcie.seat (  hallId)
                .compose ( CommonSchedulers.<ScreenSeatBean>io2main () )
                .subscribe ( new CommonObserver<ScreenSeatBean> () {
                    @Override
                    public void onNext(ScreenSeatBean screenSeatBean) {
                        callBack.backData ( screenSeatBean );
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.fuliderror ( e.getMessage () );
                    }
                } );
    }

    @Override
    public void hillId(Map<String, Object> queryMap, final HillIdCallBack callBack) {
        iApiServcie.hillId ( queryMap).compose ( CommonSchedulers.<ScreenHeIdBean>io2main () )
                .subscribe ( new CommonObserver<ScreenHeIdBean> () {
                    @Override
                    public void onNext(ScreenHeIdBean screenHeIdBean) {
                        callBack.backData ( screenHeIdBean );
                    }

                    @Override
                    public void onError(Throwable e) {
                       callBack.fuliderror ( e.getMessage () );
                    }
                } );
    }

    @Override
    public void tickets(Map<String, Object> headerMap, Map<String, Object> queryMap, final TicketsCallBack callBack) {
        iApiServcie.tickets ( headerMap,queryMap )
                .compose ( CommonSchedulers.<TicketsBean>io2main () )
                .subscribe ( new CommonObserver<TicketsBean> () {
                    @Override
                    public void onNext(TicketsBean ticketsBean) {
                        callBack.backData ( ticketsBean );
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.fuliderror ( e.getMessage () );
                    }
                } );
    }
}
