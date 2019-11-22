package com.bw.movie.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bw.movie.R;
import com.bw.movie.bean.ReleaseBean;
import com.bw.movie.view.activity.MovieDetailActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * date:2019/10/11
 * author:张贺祥
 * function:正在热映
 */
public class YMovieAdapter extends RecyclerView.Adapter<YMovieAdapter.MovieViewHolder> {
    List<ReleaseBean.ResultBean> resultBeanList;
    private Context context;

    public YMovieAdapter(List<ReleaseBean.ResultBean> resultBeanList, Context context) {
        this.resultBeanList = resultBeanList;
        this.context = context;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context)
                .inflate(R.layout.item_ymovie, viewGroup, false);
        return new MovieViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieViewHolder movieViewHolder, final int i) {
        Glide.with(movieViewHolder.itemView.getContext())
                .load(resultBeanList.get(i).getImageUrl ())
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                .error(R.mipmap.ic_launcher)
                .into(movieViewHolder.imagView);
        movieViewHolder.textName.setText(resultBeanList.get(i).getName ());
        movieViewHolder.textScore.setText(resultBeanList.get(i).getScore ()+"分");

        movieViewHolder.imagView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent ( context, MovieDetailActivity.class );
                int movieId = resultBeanList.get ( i ).getMovieId ();
                intent.putExtra ( "movieId",String.valueOf ( movieId ) );
                context.startActivity ( intent );
            }
        });
    }

    @Override
    public int getItemCount() {
        return resultBeanList == null ? 0 : resultBeanList.size();
    }


    public class MovieViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imag_view)
        ImageView imagView;
        @BindView(R.id.text_score)
        TextView textScore;
        @BindView(R.id.text_name)
        TextView textName;
        @BindView(R.id.bit_gaopiao)
        Button bitGaopiao;
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
    }
}
