package com.bw.movie.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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
public class DetailsARecycleAdapter extends RecyclerView.Adapter {
    private List<MovieDetailsBean.ResultBean.MovieDirectorBean> movieDirectors;
    private Context context;

    public DetailsARecycleAdapter(List<MovieDetailsBean.ResultBean.MovieDirectorBean> movieDirectors, Context context) {
        this.movieDirectors = movieDirectors;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from ( context ).inflate ( R.layout.details_item_layout, viewGroup, false );
        return new AViewHolder ( inflate );
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
           if (viewHolder instanceof AViewHolder){
               AViewHolder aViewHolder = (AViewHolder) viewHolder;
               String photo = movieDirectors.get ( i ).getPhoto ();
               String name = movieDirectors.get ( i ).getName ();

               aViewHolder.directro_image.setImageURI ( photo );
               aViewHolder.directro_name.setText ( name );
           }
    }

    @Override
    public int getItemCount() {
        return movieDirectors.size ();
    }

    public class AViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView directro_image;
        private final TextView directro_name;

        public AViewHolder(@NonNull View itemView) {
            super ( itemView );
            directro_image = itemView.findViewById ( R.id.directro_image );
            directro_name = itemView.findViewById ( R.id.directro_name );
        }
    }
}
