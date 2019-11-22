package com.bw.movie.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.api.MainApplication;
import com.bw.movie.bean.DaoBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.contract.LoginContract;
import com.bw.movie.database.DaoSession;
import com.bw.movie.presenter.LoginPresenter;
import com.bwie.mvplibrary.app.Constant;
import com.bwie.mvplibrary.base.BaseActivity;
import com.bwie.mvplibrary.utils.EncryptUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.IMainView {

    @BindView(R.id.user_emal)
    EditText userEmal;
    @BindView(R.id.user_pwd)
    EditText userPwd;
    @BindView(R.id.toRegister)
    TextView toRegister;
    @BindView(R.id.login)
    Button login;

    private Map<String,Object> map;

    @Override
    protected int bindLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected LoginPresenter setPresenter() {
        return new LoginPresenter ();

    }

    @Override
    protected void initData() {
        super.initData ();
        setTranslucent(this);
        setColor ( this, Color.WHITE );
    }

    @Override
    public void success(LoginBean loginBean) {
        Toast.makeText ( this, loginBean.getMessage (), Toast.LENGTH_SHORT ).show ();
        LoginBean.ResultBean result = loginBean.getResult ();
        if (loginBean.getStatus ().equals ( Constant.SUCCESS_CODE )){
            int userId = result.getUserId ();
            String sessionId = result.getSessionId ();
            DaoSession daosession = MainApplication.getDaosession ();
            DaoBean daoBean = new DaoBean ();
            daoBean.setUsserId ( String.valueOf ( userId ) );
            daoBean.setSessionId ( sessionId );
            daosession.getDaoBeanDao ().deleteAll ();
            daosession.getDaoBeanDao ().insert ( daoBean );
            EventBus.getDefault ().postSticky ( result );
            finish ();
        }
    }
    @Override
    public void fuliderror(String e) {
        Toast.makeText ( this, e, Toast.LENGTH_SHORT ).show ();
    }


    @OnClick({R.id.toRegister, R.id.login})
    public void onViewClicked(View view) {
        switch (view.getId ()) {
            case R.id.toRegister:
                Intent intent = new Intent ( LoginActivity.this,RegisterActivity.class );
                startActivity ( intent );
                break;
            case R.id.login:
                getMap ();
                presenter.login ( map );
                break;
        }
    }

    public void getMap(){
        String email = userEmal.getText ().toString ();
        String pwd = userPwd.getText ().toString ();
        if (email.equals ( "" )||pwd.equals ( "" )){
            Toast.makeText ( this, "账号或密码为空...", Toast.LENGTH_SHORT ).show ();
            return;
        }
        String encrypt = EncryptUtil.encrypt ( pwd );
        Log.d ( "pwd",encrypt );
        map = new HashMap<> (  );
        map.put ( "email",email );
        map.put ( "pwd",encrypt );
    }
}
