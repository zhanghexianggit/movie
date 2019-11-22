package com.bw.movie.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.CinemmaBean;

import java.util.List;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/5
 * @Description:
 */
public class CinemaRecycle extends RecyclerView.Adapter {
    private List<CinemmaBean.ResultBean> result;
    private Context context;

    public CinemaRecycle(List<CinemmaBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from ( context ).inflate ( R.layout.address_item_layout, viewGroup, false );
        return new CViewHolder ( view );
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
       if (viewHolder instanceof CViewHolder){
           CViewHolder cViewHolder = (CViewHolder) viewHolder;
           String name = result.get ( i ).getName ();
           cViewHolder.address.setText ( name );

       }
    }

    @Override
    public int getItemCount() {
        return result.size ();
    }

    public class CViewHolder extends RecyclerView.ViewHolder {

        private final TextView address;

        public CViewHolder(@NonNull View itemView) {
            super ( itemView );
            address = itemView.findViewById ( R.id.address );
        }
    }
}
