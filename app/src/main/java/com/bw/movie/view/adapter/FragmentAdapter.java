package com.bw.movie.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/11
 * @Description:
 */
public class FragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;

    public FragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super ( fm );
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentList.get ( i );
    }

    @Override
    public int getCount() {
        return fragmentList.size ();
    }
}
