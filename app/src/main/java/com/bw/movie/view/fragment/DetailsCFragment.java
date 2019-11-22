package com.bw.movie.view.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.MovieDetailsBean;
import com.bw.movie.view.activity.PosterListAdapter;
import com.bwie.mvplibrary.base.BaseFragment;
import com.bwie.mvplibrary.base.BasePresenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/18
 * @Description:
 */
public class DetailsCFragment extends BaseFragment {
    @BindView(R.id.posterList)
    RecyclerView posterList;
    @Override
    protected int bindLayout() {
        return R.layout.details_c_layout;
    }

    @Override
    protected BasePresenter setPresenter() {
        return null;
    }

    @Override
    protected void initData() {
        super.initData ();
        EventBus.getDefault ().register ( this );

    }

    @Subscribe(threadMode = ThreadMode.POSTING, sticky = true)
    public void onEvent(MovieDetailsBean movieDetailsBean) {
        MovieDetailsBean.ResultBean result = movieDetailsBean.getResult ();
        List<String> posterLists = result.getPosterList ();
        GridLayoutManager gridLayoutManager = new GridLayoutManager ( getActivity (), 3 );
        posterList.setLayoutManager ( gridLayoutManager );
        PosterListAdapter posterListAdapter = new PosterListAdapter ( posterLists, getActivity () );
        posterList.setAdapter ( posterListAdapter );

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView ();
        EventBus.getDefault ().unregister ( this );
    }
}
