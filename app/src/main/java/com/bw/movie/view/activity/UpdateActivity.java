package com.bw.movie.view.activity;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.servcie.DownloadIntentService;
import com.bwie.mvplibrary.base.BaseActivity;
import com.bwie.mvplibrary.base.BasePresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UpdateActivity extends BaseActivity {
    @BindView(R.id.update)
    Button update;
    private static final int DOWNLOADAPK_ID = 10;

    @Override
    protected int bindLayout() {
        return R.layout.activity_update;
    }

    @Override
    protected BasePresenter setPresenter() {
        return null;
    }


    @OnClick(R.id.update)
    public void onViewClicked() {
        if (isServiceRunning ( DownloadIntentService.class.getName () )) {
            Toast.makeText ( UpdateActivity.this, "正在下载", Toast.LENGTH_SHORT ).show ();
            return;
        }
        //String downloadUrl = http://sqdd.myapp.com/myapp/qqteam/tim/down/tim.apk;
        String downloadUrl = "/media/movie.apk";
        Intent intents = new Intent ( UpdateActivity.this, DownloadIntentService.class );
        Bundle bundle = new Bundle ();
        bundle.putString ( "download_url", downloadUrl );
        bundle.putInt ( "download_id", DOWNLOADAPK_ID );
        bundle.putString ( "download_file", downloadUrl.substring ( downloadUrl.lastIndexOf ( '/' ) + 1 ) );
        intents.putExtras ( bundle );
        startService ( intents );
    }

    private boolean isServiceRunning(String className) {
        boolean isRunning = false;
        ActivityManager activityManager = (ActivityManager) UpdateActivity.this
                .getSystemService ( Context.ACTIVITY_SERVICE );
        List<ActivityManager.RunningServiceInfo> serviceList = activityManager
                .getRunningServices ( Integer.MAX_VALUE );
        if (!(serviceList.size () > 0)) {
            return false;
        }
        for (int i = 0; i < serviceList.size (); i++) {
            if (serviceList.get ( i ).service.getClassName ().equals ( className ) == true) {
                isRunning = true;
                break;
            }
        }
        return isRunning;
    }

//    Intent intenta = new Intent ( UpdateActivity.this, DownloadIntentService.class );
//    //也就是取消订阅
//                if (!DownloadIntentService.compositeDisposable.isDisposed ()) {
//        int size = DownloadIntentService.compositeDisposable.size ();
//        Log.d ( "FirstFragment", size + "" );
//        if (DownloadIntentService.compositeDisposable.size () != 0) {
//            DownloadIntentService.compositeDisposable.clear ();
//        }
//    }
//    stopService ( intenta );
}
