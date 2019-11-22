package com.bw.movie.contract;

import com.bw.movie.bean.MovieCommentBean;
import com.bwie.mvplibrary.base.IBaseView;

import java.util.Map;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/19
 * @Description:
 */
public interface MovieCommentContract {
    interface IMainView extends IBaseView {
        void success(MovieCommentBean movieCommentBean);
        void fuliderror(String e);
    }

    interface IModel{
        void moviecomment(Map<String,Object> queryMap,CommentCallBack callBack);

        interface CommentCallBack{
            void backData(MovieCommentBean movieCommentBean);
            void fuliderror(String e);
        }
    }

    interface IPresenter{
        void moviecomment(Map<String,Object> queryMap);
    }
}
