package com.bw.movie.view.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.movie.R;
import com.bw.movie.view.adapter.FragmentAdapter;
import com.bwie.mvplibrary.base.BaseFragment;
import com.bwie.mvplibrary.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/11
 * @Description:
 */
public class MovieFragment extends BaseFragment {
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.pager)
    ViewPager pager;

    @Override
    protected int bindLayout() {
        return R.layout.movie_layout;
    }

    @Override
    protected BasePresenter setPresenter() {
        return null;
    }

    @Override
    protected void initData() {
        super.initData ();

        List<Fragment> fragmentList = new ArrayList<> (  );
        fragmentList.add ( new RecommendFragment () );
        fragmentList.add ( new FuingFragment () );
        fragmentList.add ( new AddressFragment () );
        FragmentAdapter fragmentAdapter = new FragmentAdapter ( getChildFragmentManager (), fragmentList );
        pager.setAdapter ( fragmentAdapter );

        for (int i = 0; i < 3; i++) {
            tab.addTab ( tab.newTab () );
        }

        tab.setupWithViewPager ( pager );

        tab.getTabAt ( 0 ).setText ( "推荐影院" );
        tab.getTabAt ( 1 ).setText ( "附近影院" );
        tab.getTabAt ( 2 ).setText ( "海淀区" );
    }
}
