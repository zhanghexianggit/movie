package com.bw.movie.view.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.bean.BannerBean;
import com.bw.movie.bean.ComingSoonBean;
import com.bw.movie.bean.HotMovieBean;
import com.bw.movie.bean.ReleaseBean;
import com.bw.movie.contract.CinemaContract;
import com.bw.movie.presenter.CinemaPresenter;
import com.bw.movie.view.adapter.CinemaXRecycleAdapter;
import com.bw.movie.view.adapter.HotAdapter;
import com.bw.movie.view.adapter.SoonMovieAdapter;
import com.bw.movie.view.adapter.YMovieAdapter;
import com.bwie.mvplibrary.base.BaseFragment;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.entity.SimpleBannerInfo;

import java.util.AbstractList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/11
 * @Description:
 */
public class CinemaFragment extends BaseFragment<CinemaPresenter> implements CinemaContract.IMainView {
    @BindView(R.id.cinema_xRecycle)
    XRecyclerView cinemaXRecycle;
    private List<ReleaseBean.ResultBean> resulta;
    private List<ComingSoonBean.ResultBean> resultb;
    private List<HotMovieBean.ResultBean> resultc;
    private CinemaXRecycleAdapter cinemaXRecycleAdapter;

    @Override
    protected int bindLayout() {
        return R.layout.cinema_layout;
    }

    @Override
    protected CinemaPresenter setPresenter() {
        return new CinemaPresenter ();
    }

    @Override
    protected void initData() {
        super.initData ();
        fpresenter.banner ();
        fpresenter.release ( 1, 5 );
        fpresenter.coming ( 1, 5 );
        fpresenter.hot ( 1, 6 );

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager ( getActivity (), LinearLayoutManager.VERTICAL, false );
        cinemaXRecycle.setLayoutManager ( linearLayoutManager );
        cinemaXRecycleAdapter = new CinemaXRecycleAdapter (getActivity ());

        cinemaXRecycle.setPullRefreshEnabled ( false );
        cinemaXRecycle.setLoadingMoreEnabled ( false );
    }

    @Override
    public void success(BannerBean bannerBean) {
        final List<BannerBean.ResultBean> result = bannerBean.getResult ();
        View inflate = LinearLayout.inflate ( getActivity (), R.layout.xbanner_layout, null );
        XBanner xbanner = inflate.findViewById ( R.id.xbanner );
        xbanner.setBannerData ( R.layout.image_layout, new AbstractList<SimpleBannerInfo> () {
            @Override
            public int size() {
                return result.size ();
            }

            @Override
            public SimpleBannerInfo get(int index) {
                return null;
            }
        } );
        xbanner.loadImage ( new XBanner.XBannerAdapter () {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                String imageUrl = result.get ( position ).getImageUrl ();
                SimpleDraweeView fim = view.findViewById ( R.id.fim );
                AbstractDraweeController controller = Fresco.newDraweeControllerBuilder ()
                        .setUri ( imageUrl )
                        .setAutoPlayAnimations ( true )
                        .build ();
                fim.setController ( controller );
            }
        } );
        cinemaXRecycle.addHeaderView ( inflate );
    }

    @Override
    public void success(ReleaseBean releaseBean) {
        resulta = releaseBean.getResult ();
        cinemaXRecycleAdapter.getResultA ( resulta );
    }

    @Override
    public void success(ComingSoonBean comingSoonBean) {
        resultb = comingSoonBean.getResult ();
        cinemaXRecycleAdapter.getResultB ( resultb );
    }

    @Override
    public void success(HotMovieBean hotMovieBean) {
        resultc = hotMovieBean.getResult ();
        cinemaXRecycleAdapter.getResultC ( resultc );

        cinemaXRecycle.setAdapter ( cinemaXRecycleAdapter );
    }

    @Override
    public void fuliderror(String e) {
        Toast.makeText ( getActivity (), e, Toast.LENGTH_SHORT ).show ();
    }
}
