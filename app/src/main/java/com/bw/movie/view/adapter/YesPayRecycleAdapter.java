package com.bw.movie.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.TICketBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.text.SimpleDateFormat;
import java.util.List;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/22
 * @Description:
 */
public class YesPayRecycleAdapter extends XRecyclerView.Adapter {
    List<TICketBean.ResultBean> result;
    private Context context;

    public YesPayRecycleAdapter(List<TICketBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from ( context ).inflate ( R.layout.yes_pay_item_layout, viewGroup, false );
        return new BPayViewHolder ( view );
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
          if (viewHolder instanceof BPayViewHolder){
              BPayViewHolder bPayViewHolder = (BPayViewHolder) viewHolder;
              String imageUrl = result.get ( i ).imageUrl;
              long createTime = result.get ( i ).createTime;
              SimpleDateFormat simpleDateFormat = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss" );
              String format = simpleDateFormat.format ( createTime );
              String movieName = result.get ( i ).movieName;
              String orderId = result.get ( i ).orderId;

              bPayViewHolder.movie_simple.setImageURI ( imageUrl );
              bPayViewHolder.movie_order.setText ( orderId );
              bPayViewHolder.movie_mname.setText ( movieName );
              bPayViewHolder.order_time.setText ( format );

          }
    }

    @Override
    public int getItemCount() {
        return result.size ();
    }

    public class BPayViewHolder extends XRecyclerView.ViewHolder {

        private final TextView movie_order;
        private final TextView order_time;
        private final SimpleDraweeView movie_simple;
        private final TextView order_xiang;
        private final TextView movie_mname;

        public BPayViewHolder(@NonNull View itemView) {
            super ( itemView );
            movie_simple = itemView.findViewById ( R.id.movie_simple );
            movie_order = itemView.findViewById ( R.id.movie_order );
            order_time = itemView.findViewById ( R.id.order_time );
            order_xiang = itemView.findViewById ( R.id.order_xiang );
            movie_mname = itemView.findViewById ( R.id.movie_mname );

        }
    }
}
