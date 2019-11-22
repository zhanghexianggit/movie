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
import com.bw.movie.bean.CinemasInfoByRegionBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/20
 * @Description:
 */
public class ChoseMovieAdapter extends XRecyclerView.Adapter {
    private Context context;
    List<CinemasInfoByRegionBean.ResultBean> result;

    public ChoseMovieAdapter(Context context) {
        this.context = context;
    }

    public void getResult(List<CinemasInfoByRegionBean.ResultBean> result){
        if (result!=null){
            this.result = result;
        }
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context)
                .inflate( R.layout.item_recommed, viewGroup, false);
        return new MovieViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
       if (viewHolder instanceof MovieViewHolder){
           MovieViewHolder movieViewHolder = (MovieViewHolder) viewHolder;
           movieViewHolder.imagView.setImageURI(result.get(i).getLogo ());
           movieViewHolder.textName.setText(result.get(i).getAddress ());
           movieViewHolder.textScore.setText(result.get(i).getName ());
           double price = result.get ( i ).getPrice ();
           if (price==0){
               movieViewHolder.textPrice.setVisibility ( View.GONE );
           }else {
               movieViewHolder.textPrice.setText(result.get(i).getPrice ()+"元");
           }



           movieViewHolder.linLayout.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   areaView.onCurress(result.get(i).getCinemaId ());
               }
           });
       }
    }

    @Override
    public int getItemCount() {
        return result.size ();
    }


    public class MovieViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imag_view)
        SimpleDraweeView imagView;
        @BindView(R.id.text_score)
        TextView textScore;
        @BindView(R.id.text_name)
        TextView textName;
        @BindView(R.id.text_price)
        TextView textPrice;
        @BindView(R.id.lin_layout)
        LinearLayout linLayout;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

    public void setAreaView(AreaView areaView) {
        this.areaView = areaView;
    }

    AreaView areaView;

    public interface AreaView {
        void onCurress(int id);
    }
}
