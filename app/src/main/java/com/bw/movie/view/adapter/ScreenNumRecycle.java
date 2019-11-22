package com.bw.movie.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.ScreenHeIdBean;

import java.util.List;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/21
 * @Description:
 */
public class ScreenNumRecycle extends RecyclerView.Adapter {
    List<ScreenHeIdBean.ResultBean> result;
    private Context context;

    public ScreenNumRecycle(List<ScreenHeIdBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from ( context ).inflate ( R.layout.screen_num_layout, viewGroup, false );
        return new NumViewHolder ( view );
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        if (viewHolder instanceof NumViewHolder){
            NumViewHolder numViewHolder = (NumViewHolder) viewHolder;
            String screeningHall = result.get ( i ).getScreeningHall ();
            String beginTime = result.get ( i ).getBeginTime ();
            String endTime = result.get ( i ).getEndTime ();
            numViewHolder.screeningHall.setText ( screeningHall );
            numViewHolder.beginTime.setText ( beginTime+"——"+endTime );

            numViewHolder.itemView.setOnClickListener ( new View.OnClickListener () {
                @Override
                public void onClick(View v) {
                    int id = result.get ( i ).getId ();
                    int hallId = result.get ( i ).getHallId ();
                    double fare = result.get ( i ).getFare ();
                    setScreenHillId.setHillId ( hallId,fare,id);
                }
            } );
        }

    }

    @Override
    public int getItemCount() {
        return result.size ();
    }


    public class NumViewHolder extends RecyclerView.ViewHolder {

        private final TextView screeningHall;
        private final TextView beginTime;

        public NumViewHolder(@NonNull View itemView) {
            super ( itemView );
            screeningHall = itemView.findViewById ( R.id.screeningHall );
            beginTime = itemView.findViewById ( R.id.beginTime );

        }
    }

    private SetScreenHillId setScreenHillId;

    public void setSetScreenHillId(SetScreenHillId setScreenHillId) {
        this.setScreenHillId = setScreenHillId;
    }

    public interface SetScreenHillId{
        void setHillId(int hillId,double prices,int id);
    }
}
