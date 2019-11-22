package com.bw.movie.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.bean.ComingSoonBean;
import com.bw.movie.view.activity.MovieDetailActivity;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * date:2019/10/10
 * author:张贺祥
 * function:即将上映电影
 */
public class SoonMovieAdapter extends XRecyclerView.Adapter<SoonMovieAdapter.SoonViewHolder> {
    List<ComingSoonBean.ResultBean> resultBeans;
    private Context context;

    public SoonMovieAdapter(List<ComingSoonBean.ResultBean> resultBeans, Context context) {
        this.resultBeans = resultBeans;
        this.context = context;

    }

    @NonNull
    @Override
    public SoonViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context)
                .inflate(R.layout.item_sook, viewGroup, false);
        return new SoonViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull final SoonViewHolder soonViewHolder, final int i) {
        Glide.with(soonViewHolder.itemView.getContext())
                .load(resultBeans.get(i).getImageUrl ())
                .error(R.mipmap.ic_launcher)
                .into(soonViewHolder.imagSoon);
        soonViewHolder.textMoviename.setText(resultBeans.get(i).getName ());
        soonViewHolder.textNum.setText(resultBeans.get(i).getWantSeeNum ()+"人想看");
        final long releaseTime = resultBeans.get(i).getReleaseTime ();
        SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
        String format = sdf.format(releaseTime);
        soonViewHolder.textSooktime.setText(format+"上映");
        soonViewHolder.bitYuyue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (iview!=null) {
                    iview.onCurr(resultBeans.get(i).getMovieId ());
                    soonViewHolder.bitYuyue.setVisibility(View.GONE);
                    soonViewHolder.bitYiyuyue.setVisibility(View.VISIBLE);
                }
            }
        });
        soonViewHolder.imagSoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent ( context, MovieDetailActivity.class );
                int movieId = resultBeans.get ( i ).getMovieId ();
                intent.putExtra ( "movieId",String.valueOf ( movieId ) );
                context.startActivity ( intent );
            }
        });

    }

    @Override
    public int getItemCount() {
        return resultBeans==null?0:resultBeans.size();
    }

    public class SoonViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imag_soon)
        ImageView imagSoon;
        @BindView(R.id.text_moviename)
        TextView textMoviename;
        @BindView(R.id.text_sooktime)
        TextView textSooktime;
        @BindView(R.id.text_num)
        TextView textNum;
        @BindView(R.id.bit_yuyue)
        Button bitYuyue;
        @BindView(R.id.bit_yiyuyue)
        Button bitYiyuyue;
        public SoonViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    public void setIview(Iview iview) {
        this.iview = iview;
    }

    private Iview iview;
    public interface Iview{
        void onCurr(int i);
    }


}
