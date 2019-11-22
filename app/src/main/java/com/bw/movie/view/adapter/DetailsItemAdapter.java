package com.bw.movie.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.MovieCommentBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.text.SimpleDateFormat;
import java.util.List;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/19
 * @Description:影评适配器
 */
public class DetailsItemAdapter extends XRecyclerView.Adapter {
    private List<MovieCommentBean.ResultBean> resultBean;
    private Context context;

    public DetailsItemAdapter(List<MovieCommentBean.ResultBean> resultBean, Context context) {
        this.resultBean = resultBean;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from ( context ).inflate ( R.layout.details_ditem_layout, viewGroup, false );
        return new DViewHolder ( inflate );
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
          if (viewHolder instanceof DViewHolder){
              DViewHolder dViewHolder = (DViewHolder) viewHolder;
              String commentHeadPic = resultBean.get ( i ).getCommentHeadPic ();
              String commentUserName = resultBean.get ( i ).getCommentUserName ();
              String commentContent = resultBean.get ( i ).getCommentContent ();
              Long commentTime = resultBean.get ( i ).getCommentTime ();
              int greatNum = resultBean.get ( i ).getGreatNum ();
              int isGreat = resultBean.get ( i ).getIsGreat ();
              int replyNum = resultBean.get ( i ).getReplyNum ();

              dViewHolder.imag_view.setImageURI ( commentHeadPic );
              dViewHolder.text_cimema_name.setText ( commentUserName );
              SimpleDateFormat simpleDateFormat = new SimpleDateFormat ( "MM-dd" );
              String format = simpleDateFormat.format ( commentTime );
              dViewHolder.text_cimema_time.setText ( format );
              dViewHolder.text_cimema_pinlu.setText ( commentContent );
              dViewHolder.text_cinema_num_ran.setText ( String.valueOf ( greatNum ) );
              dViewHolder.text_cinema_num.setText ( "已有"+replyNum+"人评论");
          }
    }

    @Override
    public int getItemCount() {
        return resultBean.size ();
    }

    public class DViewHolder extends XRecyclerView.ViewHolder {

        private final SimpleDraweeView imag_view;
        private final TextView text_cimema_name;
        private final TextView text_cimema_time;
        private final TextView text_cimema_pinlu;
        private final ImageView imag_true;
        private final ImageView imag_false;
        private final TextView text_cinema_num_ran;
        private final TextView text_cinema_num;

        public DViewHolder(@NonNull View itemView) {
            super ( itemView );
            imag_view = itemView.findViewById ( R.id.imag_view );
            text_cimema_name = itemView.findViewById ( R.id.text_cimema_name );
            text_cimema_time = itemView.findViewById ( R.id.text_cimema_time );
            text_cimema_pinlu = itemView.findViewById ( R.id.text_cimema_pinlu );
            imag_true = itemView.findViewById ( R.id.imag_true );
            imag_false = itemView.findViewById ( R.id.imag_false );
            text_cinema_num_ran = itemView.findViewById ( R.id.text_cinema_num_ran );
            text_cinema_num = itemView.findViewById ( R.id.text_cinema_num );
        }
    }
}
