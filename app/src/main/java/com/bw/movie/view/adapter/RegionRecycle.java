package com.bw.movie.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.RegionBean;

import java.util.List;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/5
 * @Description:
 */
public class RegionRecycle extends RecyclerView.Adapter {
    private List<RegionBean.ResultBean> result;
    private Context context;

    public RegionRecycle(List<RegionBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from ( context ).inflate ( R.layout.address_item_layout, viewGroup, false );
        return new RViewHolder ( view );
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
       if (viewHolder instanceof RViewHolder){
           RViewHolder cViewHolder = (RViewHolder) viewHolder;
           String name = result.get ( i ).getRegionName ();
           cViewHolder.address.setText ( name );

           cViewHolder.itemView.setOnClickListener ( new View.OnClickListener () {
               @Override
               public void onClick(View v) {
                   int regionId = result.get ( i ).getRegionId ();
                   regionIds.data ( regionId );
               }
           } );
       }
    }

    @Override
    public int getItemCount() {
        return result.size ();
    }

    public class RViewHolder extends RecyclerView.ViewHolder {

        private final TextView address;

        public RViewHolder(@NonNull View itemView) {
            super ( itemView );
            address = itemView.findViewById ( R.id.address );
        }
    }

    private RegionIds regionIds;

    public void setRegionIds(RegionIds regionIds) {
        this.regionIds = regionIds;
    }

    public interface RegionIds{
        void data(int region);
    }

}
