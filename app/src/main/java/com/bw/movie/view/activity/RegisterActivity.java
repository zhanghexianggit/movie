package com.bw.movie.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.contract.RegisterContract;
import com.bw.movie.presenter.RegisterPresenter;
import com.bwie.mvplibrary.base.BaseActivity;
import com.bwie.mvplibrary.utils.EncryptUtil;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity<RegisterPresenter> implements RegisterContract.IMainView {

    @BindView(R.id.edit_name)
    EditText editName;
    @BindView(R.id.edit_email)
    EditText editEmail;
    @BindView(R.id.edit_pwd)
    EditText editPwd;
    @BindView(R.id.user_yz)
    EditText userYz;
    @BindView(R.id.get_yz)
    Button getYz;
    @BindView(R.id.to_login)
    TextView toLogin;
    @BindView(R.id.register)
    Button register;

    @Override
    protected int bindLayout() {
        return R.layout.activity_register;
    }

    @Override
    protected RegisterPresenter setPresenter() {
        return new RegisterPresenter ();
    }

    @Override
    protected void initData() {
        super.initData ();
        setTranslucent(this);
        setColor ( this, Color.WHITE );
    }

    @Override
    public void success(RegisterBean registerBean) {
        Toast.makeText ( this, registerBean.getMessage (), Toast.LENGTH_SHORT ).show ();
    }

    @Override
    public void fuliderror(String e) {
        Toast.makeText ( this, e, Toast.LENGTH_SHORT ).show ();
    }

    @OnClick({R.id.get_yz, R.id.to_login, R.id.register})
    public void onViewClicked(View view) {
        switch (view.getId ()) {
            case R.id.get_yz:
                String string = editEmail.getText ().toString ();
                presenter.email ( string );
                break;
            case R.id.to_login:
                Intent intent = new Intent ( RegisterActivity.this, LoginActivity.class );
                startActivity ( intent );
                finish ();
                break;
            case R.id.register:
                String email = editEmail.getText ().toString ();
                String name = editName.getText ().toString ();
                String pwd = editPwd.getText ().toString ();
                String code = userYz.getText ().toString ();
                String encrypt = EncryptUtil.encrypt ( pwd );
                Map<String,Object> map = new HashMap<> (  );
                map.put ( "nickName",name );
                map.put ( "pwd",encrypt );
                map.put ( "email",email );
                map.put ( "code",code );
                presenter.login ( map );
                break;
        }
    }

}
