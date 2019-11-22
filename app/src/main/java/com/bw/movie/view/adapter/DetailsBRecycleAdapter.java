package com.bw.movie.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.MovieDetailsBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/18
 * @Description:
 */
public class DetailsBRecycleAdapter extends RecyclerView.Adapter {
    private List<MovieDetailsBean.ResultBean.MovieActorBean> movieActors;
    private Context context;

    public DetailsBRecycleAdapter(List<MovieDetailsBean.ResultBean.MovieActorBean> movieActors, Context context) {
        this.movieActors = movieActors;
        this.context = context;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from ( context ).inflate ( R.layout.details_grad_layout, viewGroup, false );
        return new BViewHolder ( inflate );
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
         if (viewHolder instanceof BViewHolder){
             BViewHolder bViewHolder = (BViewHolder) viewHolder;
             String photo = movieActors.get ( i ).getPhoto ();
             String name = movieActors.get ( i ).getName ();
             String role = movieActors.get ( i ).getRole ();
             bViewHolder.actor_image.setImageURI ( photo );
             bViewHolder.actor_name.setText ( name );
             bViewHolder.actor_yan.setText ( "饰："+role );
         }
    }

    @Override
    public int getItemCount() {
        return movieActors.size ();
    }

    public class BViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView actor_image;
        private final TextView actor_name;
        private final TextView actor_yan;

        public BViewHolder(@NonNull View itemView) {
            super ( itemView );
            actor_image = itemView.findViewById ( R.id.actor_image );
            actor_name = itemView.findViewById ( R.id.actor_name );
            actor_yan = itemView.findViewById ( R.id.actor_yan );
        }
    }
}
