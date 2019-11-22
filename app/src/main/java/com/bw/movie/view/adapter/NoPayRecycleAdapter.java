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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/22
 * @Description:
 */
public class NoPayRecycleAdapter extends XRecyclerView.Adapter {
    List<TICketBean.ResultBean> result;
    private Context context;

    public NoPayRecycleAdapter(List<TICketBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from ( context ).inflate ( R.layout.no_pay_item_layout, viewGroup, false );
        return new APayViewHolder ( view );
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof APayViewHolder){
            APayViewHolder aPayViewHolder = (APayViewHolder) viewHolder;
            String imageUrl = result.get ( i ).imageUrl;
            long createTime = result.get ( i ).createTime;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss" );
            String format = simpleDateFormat.format ( createTime );
            String movieName = result.get ( i ).movieName;
            String orderId = result.get ( i ).orderId;

            aPayViewHolder.movie_simple.setImageURI ( imageUrl );
            aPayViewHolder.movie_order.setText ( orderId );
            aPayViewHolder.movie_mname.setText ( movieName );
            aPayViewHolder.order_time.setText ( format );

        }
    }

    @Override
    public int getItemCount() {
        return result.size ();
    }

    public class APayViewHolder extends XRecyclerView.ViewHolder {

        private final TextView movie_order;
        private final TextView order_time;
        private final TextView movie_mname;
        private final Button go_pay;
        private final SimpleDraweeView movie_simple;

        public APayViewHolder(@NonNull View itemView) {
            super ( itemView );
            movie_simple = itemView.findViewById ( R.id.movie_simple );
            movie_order = itemView.findViewById ( R.id.movie_order );
            order_time = itemView.findViewById ( R.id.order_time );
            movie_mname = itemView.findViewById ( R.id.movie_mname );
            go_pay = itemView.findViewById ( R.id.go_pay );
        }
    }
}
