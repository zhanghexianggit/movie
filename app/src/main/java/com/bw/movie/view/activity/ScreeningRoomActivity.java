package com.bw.movie.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.api.MainApplication;
import com.bw.movie.bean.DaoBean;
import com.bw.movie.bean.ScreenHeIdBean;
import com.bw.movie.bean.ScreenSeatBean;
import com.bw.movie.bean.TicketsBean;
import com.bw.movie.contract.ScreenSeatContract;
import com.bw.movie.presenter.ScreenSeatPresenter;
import com.bw.movie.view.adapter.ScreenChoseAdapter;
import com.bw.movie.view.adapter.ScreenNumRecycle;
import com.bwie.mvplibrary.base.BaseActivity;
import com.bwie.mvplibrary.utils.EncryptUtil;

import org.greenrobot.greendao.annotation.Id;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class ScreeningRoomActivity extends BaseActivity<ScreenSeatPresenter> implements ScreenSeatContract.IMainView {

    @BindView(R.id.screen_jc)
    JCVideoPlayer screenJc;
    @BindView(R.id.image_back)
    ImageView imageBack;
    @BindView(R.id.screen_movie_name)
    TextView screenMovieName;
    @BindView(R.id.screen_recycle)
    RecyclerView screenRecycle;
    @BindView(R.id.screen_time)
    TextView screenTime;
    @BindView(R.id.screen_number)
    RecyclerView screenNumber;
    @BindView(R.id.screen_price)
    TextView screenPrice;
    private int Pid;
    private String string = "";
    private double price = 0;

    @Override
    protected int bindLayout() {
        return R.layout.activity_screening_room;
    }

    @Override
    protected ScreenSeatPresenter setPresenter() {
        return new ScreenSeatPresenter ();
    }

    @Override
    protected void initData() {
        super.initData ();
        Intent intent = getIntent ();
        String movieId = intent.getStringExtra ( "movieId" );
        String imageUrl = intent.getStringExtra ( "imageUrl" );
        String videoUrl = intent.getStringExtra ( "videoUrl" );
        String regionId = intent.getStringExtra ( "regionId" );
        String name = intent.getStringExtra ( "name" );

        Glide.with ( this ).load ( imageUrl ).into ( screenJc.ivThumb );
        screenJc.setUp ( videoUrl, null );
        screenMovieName.setText ( name );

        Map<String,Object> hMap = new HashMap<> (  );
        hMap.put ( "movieId",movieId );
        hMap.put ( "cinemaId",regionId );
        presenter.hillId ( hMap );
    }

    @Override
    public void success(ScreenSeatBean screenSeatBean) {
        List<ScreenSeatBean.ResultBean> result = screenSeatBean.getResult ();
        GridLayoutManager gridLayoutManager = new GridLayoutManager ( this, 7 );
        screenRecycle.setLayoutManager ( gridLayoutManager );
        ScreenChoseAdapter screenChoseAdapter = new ScreenChoseAdapter ( result, ScreeningRoomActivity.this );
        screenRecycle.setAdapter ( screenChoseAdapter );

        screenChoseAdapter.setSetColor ( new ScreenChoseAdapter.SetColor () {
            @Override
            public void colorId(String seat) {
                if (string.length ()==0){
                    string += seat;
                }else {
                    string +=","+seat;
                }
                double v = string.length () + price;
                screenPrice.setText (String.valueOf ( v )  );
            }
        } );
    }

    @Override
    public void success(ScreenHeIdBean screenHeIdBean) {
        List<ScreenHeIdBean.ResultBean> result = screenHeIdBean.getResult ();
        screenTime.setText ( "选择影厅和时间("+result.size ()+")" );
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager ( this, LinearLayoutManager.HORIZONTAL, false );
        screenNumber.setLayoutManager ( linearLayoutManager );
        ScreenNumRecycle screenNumRecycle = new ScreenNumRecycle ( result, ScreeningRoomActivity.this );
        screenNumber.setAdapter ( screenNumRecycle );
        screenNumRecycle.setSetScreenHillId ( new ScreenNumRecycle.SetScreenHillId () {
            @Override
            public void setHillId(int hillId, double fare, int id) {
                presenter.seat ( hillId);
                price = fare;
                Pid = id;
            }
        } );
    }

    @Override
    public void success(TicketsBean ticketsBean) {
        Toast.makeText ( this, ticketsBean.getMessage (), Toast.LENGTH_SHORT ).show ();
    }

    @Override
    public void fuliderror(String e) {

    }

    @OnClick(R.id.screen_price)
    public void onViewClicked() {
        List<DaoBean> list = MainApplication.getDaosession ().getDaoBeanDao ().queryBuilder ().build ().list ();
        if (list.size ()==0){
            Toast.makeText ( this, "请先登录", Toast.LENGTH_SHORT ).show ();
            Intent intent = new Intent ( ScreeningRoomActivity.this, LoginActivity.class );
            startActivity ( intent );
        }else {
            String usserId = list.get ( 0 ).getUsserId ();
            String sessionId = list.get ( 0 ).getSessionId ();
            Map<String,Object> headerMap = new HashMap<> (  );
            headerMap.put ( "userId",usserId );
            headerMap.put ( "sessionId",sessionId );

            String sign = usserId+""+Pid+"movie";
            String encrypt = EncryptUtil.MD5 ( sign );

            Map<String,Object> queryMap = new HashMap<> (  );
            queryMap.put ( "scheduleId",Pid );
            queryMap.put ( "seat",string );
            queryMap.put ( "sign",encrypt );

            presenter.tickets ( headerMap,queryMap );
        }
    }
}
