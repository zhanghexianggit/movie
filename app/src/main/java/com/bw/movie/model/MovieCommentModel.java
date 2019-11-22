package com.bw.movie.model;

import com.bw.movie.api.IApiServcie;
import com.bw.movie.bean.MovieCommentBean;
import com.bw.movie.contract.MovieCommentContract;
import com.bwie.mvplibrary.utils.CommonObserver;
import com.bwie.mvplibrary.utils.CommonSchedulers;
import com.bwie.mvplibrary.utils.RetrofitManager;

import java.util.Map;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/19
 * @Description:
 */
public class MovieCommentModel implements MovieCommentContract.IModel {

    private final IApiServcie iApiServcie;

    public MovieCommentModel() {
        iApiServcie = RetrofitManager.getInstance ().create ( IApiServcie.class );
    }


    @Override
    public void moviecomment(Map<String, Object> queryMap, final CommentCallBack callBack) {
        iApiServcie.moviecomment ( queryMap )
                   .compose ( CommonSchedulers.<MovieCommentBean>io2main () )
                   .subscribe ( new CommonObserver<MovieCommentBean> () {
                       @Override
                       public void onNext(MovieCommentBean movieCommentBean) {
                           callBack.backData ( movieCommentBean );
                       }

                       @Override
                       public void onError(Throwable e) {
                            callBack.fuliderror ( e.getMessage () );
                       }
                   } );
    }
}
