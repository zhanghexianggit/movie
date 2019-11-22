package com.bw.movie.presenter;

import com.bw.movie.bean.MovieDetailsBean;
import com.bw.movie.contract.MovieDetalisContract;
import com.bw.movie.model.MovieDetailsModel;
import com.bwie.mvplibrary.base.BasePresenter;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/15
 * @Description:
 */
public class MovieDetailsPresenter extends BasePresenter<MovieDetalisContract.IMainView> implements MovieDetalisContract.IPresenter  {

    private MovieDetailsModel movieDetailsModel;

    @Override
    public void details(int id) {
        movieDetailsModel.details ( id, new MovieDetalisContract.IModel.DetailsCallBack () {
            @Override
            public void backData(MovieDetailsBean movieDetailsBean) {
                getView ().success ( movieDetailsBean );
            }

            @Override
            public void fuliderror(String e) {
                getView ().fuliderror ( e );
            }
        } );
    }

    @Override
    protected void initModel() {
        movieDetailsModel = new MovieDetailsModel ();

    }
}
