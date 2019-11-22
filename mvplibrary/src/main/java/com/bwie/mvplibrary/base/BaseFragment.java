package com.bwie.mvplibrary.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bwie.mvplibrary.app.App;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/5
 * @Description:
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements IBaseView {

    protected P fpresenter;
    private Unbinder bind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         //绑定布局
        View view = inflater.inflate ( bindLayout (),container,false );
        bind = ButterKnife.bind ( this, view );
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated ( savedInstanceState );
        fpresenter = setPresenter ();
        if (fpresenter!=null){
            fpresenter.attachView ( this );
        }
        initView ();
        initData ();
    }

    protected abstract int bindLayout();
    protected abstract P setPresenter();
    protected void initView(){}
    protected void initData(){}

    @Override
    public void onDestroyView() {
        super.onDestroyView ();
        //解绑butterKnife
        bind.unbind ();
    }

    @Override
    public void onDestroy() {
        super.onDestroy ();
        if (fpresenter!=null){
            fpresenter.detachView ();
        }
    }

    public boolean hasNetwork() {
        return false;
    }

    //无网提醒
    public void showNoNetTip() {
        Toast.makeText(context(), "无网，请检查网络", Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context context() {
        return getContext ()==null ? App.getsContent ():getContext ();
    }


}
