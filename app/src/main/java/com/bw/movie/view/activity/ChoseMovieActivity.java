package com.bw.movie.view.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.bean.CinemasInfoByRegionBean;
import com.bw.movie.bean.DataBean;
import com.bw.movie.bean.MovieDetailsBean;
import com.bw.movie.bean.RegionBean;
import com.bw.movie.contract.DataContract;
import com.bw.movie.presenter.DataPresenter;
import com.bw.movie.view.adapter.ChoseMovieAdapter;
import com.bwie.mvplibrary.base.BaseActivity;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class ChoseMovieActivity extends BaseActivity<DataPresenter> implements DataContract.IMainView {


    @BindView(R.id.player)
    JCVideoPlayer player;
    @BindView(R.id.movie_namese)
    TextView movieNamese;
    @BindView(R.id.movie_time)
    TextView movieTime;
    @BindView(R.id.movie_fen)
    TextView movieFen;
    @BindView(R.id.movie_directer)
    TextView movieDirecter;
    @BindView(R.id.addres)
    Button addres;
    @BindView(R.id.image_addres)
    ImageView imageAddres;
    @BindView(R.id.dates)
    Button dates;
    @BindView(R.id.image_dates)
    ImageView imageDates;
    @BindView(R.id.prices)
    Button prices;
    @BindView(R.id.image_prices)
    ImageView imagePrices;
    @BindView(R.id.chose_movie_recycle)
    XRecyclerView choseMovieRecycle;
    private String videoUrl;
    private String imageUrl;
    private String namea;
    private String nameb;
    private String duration;
    private double score;
    private String name;
    private int page = 1;
    private Map<String, Object> queryMapA;
    private Map<String, Object> queryMapB;
    private Map<String, Object> queryMapC;
    private int movieId;

    private String date;
    private int regionId;
    private ChoseMovieAdapter choseMovieAdapter;

    @Override
    protected int bindLayout() {
        return R.layout.activity_chose_movie;
    }

    @Override
    protected DataPresenter setPresenter() {
        return new DataPresenter ();
    }

    @Override
    protected void initData() {
        super.initData ();
        presenter.region ();
        presenter.data ();
        EventBus.getDefault ().register ( this );
        Glide.with ( this ).load ( imageUrl )
                .into ( player.ivThumb );
        player.setUp ( videoUrl, null );
        movieNamese.setText ( name );
        movieTime.setText ( duration );
        movieFen.setText ( score + "分" );
        movieDirecter.setText ( namea + " " + nameb );

    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEvent(MovieDetailsBean movieDetailsBean) {
        MovieDetailsBean.ResultBean result = movieDetailsBean.getResult ();
        List<MovieDetailsBean.ResultBean.ShortFilmListBean> shortFilmList = result.getShortFilmList ();
        videoUrl = shortFilmList.get ( 0 ).getVideoUrl ();
        imageUrl = shortFilmList.get ( 0 ).getImageUrl ();
        name = result.getName ();
        movieId = result.getMovieId ();
        List<MovieDetailsBean.ResultBean.MovieActorBean> movieActor = result.getMovieActor ();
        namea = movieActor.get ( 0 ).getName ();
        nameb = movieActor.get ( 1 ).getName ();
        duration = result.getDuration ();
        score = result.getScore ();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy ();
        EventBus.getDefault ().unregister ( this );
    }

    @Override
    public void success(DataBean dataBean) {
        date = dataBean.getResult ().get ( 0 );
    }

    @Override
    public void success(RegionBean regionBean) {
        regionId = regionBean.getResult ().get ( 0 ).getRegionId ();
        getAMap ( page,movieId,regionId );
        presenter.cinemasinfobyregion ( queryMapA );
    }

    @Override
    public void success(CinemasInfoByRegionBean cinemasInfoByRegionBean) {
        List<CinemasInfoByRegionBean.ResultBean> result = cinemasInfoByRegionBean.getResult ();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager ( this, LinearLayoutManager.VERTICAL, false );
        choseMovieRecycle.setLayoutManager ( linearLayoutManager );
        choseMovieAdapter = new ChoseMovieAdapter (ChoseMovieActivity.this );
        choseMovieAdapter.getResult ( result );
        choseMovieRecycle.setAdapter ( choseMovieAdapter );
        choseMovieAdapter.notifyDataSetChanged ();

        choseMovieAdapter.setAreaView ( new ChoseMovieAdapter.AreaView () {
            @Override
            public void onCurress(int id) {
                Intent intent = new Intent ( ChoseMovieActivity.this, ScreeningRoomActivity.class );
                intent.putExtra ( "movieId",String.valueOf ( movieId ) );
                intent.putExtra ( "imageUrl",imageUrl );
                intent.putExtra ( "videoUrl",videoUrl );
                intent.putExtra ( "regionId",String.valueOf ( id ) );
                intent.putExtra ( "name",name );
                startActivity ( intent );
            }
        } );
    }


    @Override
    public void fuliderror(String e) {
        Log.d ( "ChoseMovieActivity" ,e);
    }

    @OnClick({R.id.addres, R.id.image_addres, R.id.dates, R.id.image_dates, R.id.prices, R.id.image_prices})
    public void onViewClicked(View view) {
        switch (view.getId ()) {
            case R.id.addres:
                getAMap ( page,movieId,regionId );
                presenter.cinemasinfobyregion ( queryMapA );
                break;
            case R.id.image_addres:
                break;
            case R.id.dates:
                getBMap ( page,movieId,date );
                presenter.cinemasinfobydate ( queryMapB );
                break;
            case R.id.image_dates:
                break;
            case R.id.prices:
                getCMap ( page,movieId );
                presenter.cinemasinfobyprice ( queryMapC );
                break;
            case R.id.image_prices:
                break;
        }
    }

    public void getAMap(int page,int movieId,int regionId){
        queryMapA = new HashMap<> (  );
        queryMapA.put ( "movieId",movieId );
        queryMapA.put ( "regionId",regionId );
        queryMapA.put ( "page",page );
        queryMapA.put ( "count",5 );
    }

    public void getBMap(int page,int movieId,String date){
        queryMapB = new HashMap<> (  );
        queryMapB.put ( "movieId",movieId );
        queryMapB.put ( "date",date );
        queryMapB.put ( "page",page );
        queryMapB.put ( "count",5 );
    }

    public void getCMap(int page,int movieId){
        queryMapC = new HashMap<> (  );
        queryMapC.put ( "movieId",movieId );
        queryMapC.put ( "page",page );
        queryMapC.put ( "count",5 );
    }
}
