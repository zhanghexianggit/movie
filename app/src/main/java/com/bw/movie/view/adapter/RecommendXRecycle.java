package com.bw.movie.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.bw.movie.R;
import com.bw.movie.bean.RecommendBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/5
 * @Description:
 */
public class RecommendXRecycle extends RecyclerView.Adapter {
    private List<RecommendBean.ResultBean> result;
    private Context context;

    public RecommendXRecycle(List<RecommendBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from ( context ).inflate ( R.layout.recommend_item_layout, viewGroup, false );
        return new XViewHolder ( view );
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
      if (viewHolder instanceof XViewHolder){
          XViewHolder xViewHolder = (XViewHolder) viewHolder;
          String address = result.get ( i ).getAddress ();
          String logo = result.get ( i ).getLogo ();
          String name = result.get ( i ).getName ();
          xViewHolder.image.setImageURI ( logo );
          xViewHolder.addres.setText ( address );
          xViewHolder.name.setText ( name );
      }
    }

    @Override
    public int getItemCount() {
        return result.size ();
    }

    public class XViewHolder extends XRecyclerView.ViewHolder {

        private final SimpleDraweeView image;
        private final TextView name;
        private final TextView addres;

        public XViewHolder(@NonNull View itemView) {
            super ( itemView );
            image = itemView.findViewById ( R.id.image );
            name = itemView.findViewById ( R.id.name );
            addres = itemView.findViewById ( R.id.addres );
        }
    }
}
