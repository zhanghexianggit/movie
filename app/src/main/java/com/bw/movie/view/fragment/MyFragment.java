package com.bw.movie.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.view.activity.LoginActivity;
import com.bw.movie.view.activity.SettingActivity;
import com.bw.movie.view.activity.TicKetSActivity;
import com.bwie.mvplibrary.base.BaseFragment;
import com.bwie.mvplibrary.base.BasePresenter;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/11
 * @Description:
 */
public class MyFragment extends BaseFragment {

    @BindView(R.id.user_image)
    SimpleDraweeView userImage;
    @BindView(R.id.to_login)
    TextView login;
    @BindView(R.id.r1)
    RelativeLayout r1;
    @BindView(R.id.r2)
    RelativeLayout r2;
    @BindView(R.id.to_set)
    LinearLayout toSet;
    @BindView(R.id.to_tick)
    LinearLayout toTick;
    Unbinder unbinder;

    @Override
    protected int bindLayout() {
        return R.layout.my_layout;
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

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEvent(LoginBean.ResultBean result) {
        String headPic = result.getUserInfo ().getHeadPic ();
        String nickName = result.getUserInfo ().getNickName ();
        userImage.setImageURI ( headPic );
        login.setText ( nickName );
    }
    @OnClick({R.id.user_image, R.id.to_login, R.id.r1, R.id.r2, R.id.to_tick, R.id.to_set})
    public void onViewClicked(View view) {
        switch (view.getId ()) {
            case R.id.user_image:
                break;
            case R.id.to_login:
                Intent intenta = new Intent ( getActivity (), LoginActivity.class );
                startActivity ( intenta );
                break;

            case R.id.r1:
                break;
            case R.id.r2:
                break;
            case R.id.to_tick:
                Intent initentb = new Intent ( getActivity (), TicKetSActivity.class );
                startActivity ( initentb );
                break;
            case R.id.to_set:
                Intent initentc = new Intent ( getActivity (), SettingActivity.class );
                startActivity ( initentc );
                break;
        }
    }

//    @OnClick({R.id.user_image, R.id.to_login, R.id.to_set})
//    public void onViewClicked(View view) {
//        switch (view.getId ()) {
//            case R.id.user_image:
//
//                break;
//            case R.id.to_login:
//                Intent intent = new Intent ( getActivity (), LoginActivity.class );
//                startActivity ( intent );
//                break;
//            case R.id.to_set:
//                Intent initents = new Intent ( getActivity (), SettingActivity.class );
//                startActivity ( initents );
//                break;
//        }


    @Override
    public void onDestroyView() {
        super.onDestroyView ();
        EventBus.getDefault ().unregister ( this );
    }


}
