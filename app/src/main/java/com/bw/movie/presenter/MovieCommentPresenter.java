package com.bw.movie.presenter;

import com.bw.movie.bean.MovieCommentBean;
import com.bw.movie.contract.MovieCommentContract;
import com.bw.movie.model.MovieCommentModel;
import com.bwie.mvplibrary.base.BasePresenter;

import java.util.Map;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/19
 * @Description:
 */
public class MovieCommentPresenter extends BasePresenter<MovieCommentContract.IMainView> implements MovieCommentContract.IPresenter {

    private MovieCommentModel movieCommentModel;

    @Override
    public void moviecomment(Map<String, Object> queryMap) {
        movieCommentModel.moviecomment ( queryMap, new MovieCommentContract.IModel.CommentCallBack () {
            @Override
            public void backData(MovieCommentBean movieCommentBean) {
                getView ().success ( movieCommentBean );
            }

            @Override
            public void fuliderror(String e) {
               getView ().fuliderror ( e );
            }
        } );
    }

    @Override
    protected void initModel() {
        movieCommentModel = new MovieCommentModel ();
    }
}
