package com.bw.movie.view.activity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.movie.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/18
 * @Description:
 */
public class PosterListAdapter extends RecyclerView.Adapter {
    private List<String> posterList;
    private Context context;

    public PosterListAdapter(List<String> posterList, Context context) {
        this.posterList = posterList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from ( context ).inflate ( R.layout.image_poster_layout, viewGroup, false );
        return new PViewHolder ( inflate );
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof PViewHolder){
            PViewHolder pViewHolder = (PViewHolder) viewHolder;
            String image = posterList.get ( i );
            pViewHolder.poster_image.setImageURI ( image );
        }
    }

    @Override
    public int getItemCount() {
        return posterList.size ();
    }

    public class PViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView poster_image;

        public PViewHolder(@NonNull View itemView) {
            super ( itemView );
            poster_image = itemView.findViewById ( R.id.poster_image );
        }
    }
}
