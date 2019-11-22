package com.bw.movie.view.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.bw.movie.R;
import com.bw.movie.bean.ScreenSeatBean;

import java.util.List;

import retrofit2.http.GET;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/21
 * @Description:
 */
public class ScreenChoseAdapter extends RecyclerView.Adapter {
    List<ScreenSeatBean.ResultBean> result;
    private Context context;

    public ScreenChoseAdapter(List<ScreenSeatBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from ( context ).inflate ( R.layout.screen_checkbox_layout, viewGroup, false );
        return new CViewHolder ( view );
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
         if (viewHolder instanceof CViewHolder){
             final CViewHolder cViewHolder = (CViewHolder) viewHolder;
             int status = result.get ( i ).getStatus ();
             final String row = result.get ( i ).getRow ();
             final String seat = result.get ( i ).getSeat ();
             if (status==2){
                cViewHolder.screen_box.setEnabled ( false );
                cViewHolder.screen_box.setBackgroundResource ( R.drawable.screen_checkboxy );
             }
             cViewHolder.screen_box.setOnClickListener ( new View.OnClickListener () {
                 @Override
                 public void onClick(View v) {
                     boolean checked = cViewHolder.screen_box.isChecked ();
                     setColor.colorId ( row+"-"+seat );
                     if (checked==true){
                         cViewHolder.screen_box.setBackgroundResource ( R.drawable.screen_checkboxd );
                     }else {
                         cViewHolder.screen_box.setBackgroundResource ( R.drawable.screen_checkbox );
                     }
                 }
             } );
         }
    }

    @Override
    public int getItemCount() {
        return result.size ();
    }

    public class CViewHolder extends RecyclerView.ViewHolder {

        private final CheckBox screen_box;

        public CViewHolder(@NonNull View itemView) {
            super ( itemView );
            screen_box = itemView.findViewById ( R.id.screen_box );
        }
    }

    private SetColor setColor;

    public void setSetColor(SetColor setColor) {
        this.setColor = setColor;
    }

    public interface SetColor{
        void colorId(String seat);
    }
}
