package com.bw.movie.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.ComingSoonBean;
import com.bw.movie.bean.HotMovieBean;
import com.bw.movie.bean.ReleaseBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/14
 * @Description:
 */
public class CinemaXRecycleAdapter extends XRecyclerView.Adapter {
    private List<ReleaseBean.ResultBean> resulta;
    private List<ComingSoonBean.ResultBean> resultb;
    private List<HotMovieBean.ResultBean> resultc;
    private Context context;

    public CinemaXRecycleAdapter(Context context) {
        this.context = context;
    }

    public void getResultA(List<ReleaseBean.ResultBean> resulta){
        this.resulta = resulta;
    }

    public void getResultB(List<ComingSoonBean.ResultBean> resultb){
        this.resultb = resultb;
    }

    public void getResultC(List<HotMovieBean.ResultBean> resultc){
        this.resultc = resultc;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i==1){
            View inflate = LayoutInflater.from ( context ).inflate ( R.layout.cinema_item_a_layout, viewGroup, false );
            return new ViewHolderA ( inflate );
        }else if (i==2){
            View inflate = LayoutInflater.from ( context ).inflate ( R.layout.cinema_item_b_layout, viewGroup, false );
            return new ViewHolderB ( inflate );
        }else if (i==3){
            View inflate = LayoutInflater.from ( context ).inflate ( R.layout.cinema_item_c_layout, viewGroup, false );
            return new ViewHolderC ( inflate );
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        int itemViewType = getItemViewType ( i );
        if (itemViewType==1){
            if (viewHolder instanceof ViewHolderA){
                ViewHolderA viewHolderA = (ViewHolderA) viewHolder;
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager ( context, LinearLayoutManager.HORIZONTAL, false );
                viewHolderA.re_ying_xrecycel.setLayoutManager ( linearLayoutManager );
                YMovieAdapter yMovieAdapter = new YMovieAdapter ( resulta, context );
                viewHolderA.re_ying_xrecycel.setAdapter ( yMovieAdapter );
            }
        }else if (itemViewType==2){
            if (viewHolder instanceof ViewHolderB){
                ViewHolderB viewHolderB = (ViewHolderB) viewHolder;
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager ( context, LinearLayoutManager.VERTICAL, false );
                viewHolderB.shang_ying_xrecycel.setLayoutManager ( linearLayoutManager );
                SoonMovieAdapter soonMovieAdapter = new SoonMovieAdapter ( resultb, context );
                viewHolderB.shang_ying_xrecycel.setAdapter ( soonMovieAdapter );

            }
        }else if (itemViewType==3){
            if (viewHolder instanceof ViewHolderC){
                ViewHolderC viewHolderC = (ViewHolderC) viewHolder;
                String imageUrl = resultc.get ( 0 ).getImageUrl ();
                String name = resultc.get ( 0 ).getName ();
                double score = resultc.get ( 0 ).getScore ();
                viewHolderC.movie_name.setText ( name );
                viewHolderC.movie_ping.setText ( String.valueOf ( score ) + "分" );
                viewHolderC.shou_ye.setImageURI ( imageUrl );
                resultc.remove ( 0 );
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager ( context, LinearLayoutManager.HORIZONTAL, false );
                viewHolderC.re_men_xrecycel.setLayoutManager ( linearLayoutManager );
                HotAdapter hotAdapter = new HotAdapter ( resultc,context );
                viewHolderC.re_men_xrecycel.setAdapter ( hotAdapter );
            }
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return 1;
        }else if (position==1){
            return 2;
        }else if (position==2){
            return 3;
        }
        return super.getItemViewType ( position );
    }

    public class ViewHolderA extends XRecyclerView.ViewHolder {

        private final RecyclerView re_ying_xrecycel;

        public ViewHolderA(@NonNull View itemView) {
            super ( itemView );
            re_ying_xrecycel = itemView.findViewById ( R.id.re_ying_xrecycel );

        }
    }

    public class ViewHolderB extends XRecyclerView.ViewHolder {

        private final RecyclerView shang_ying_xrecycel;

        public ViewHolderB(@NonNull View itemView) {
            super ( itemView );
            shang_ying_xrecycel = itemView.findViewById ( R.id.shang_ying_xrecycel );
        }
    }

    public class ViewHolderC extends XRecyclerView.ViewHolder {

        private final RecyclerView re_men_xrecycel;
        private final SimpleDraweeView shou_ye;
        private final TextView movie_name;
        private final TextView movie_ping;
        private final Button buy_piao;

        public ViewHolderC(@NonNull View itemView) {
            super ( itemView );
            shou_ye = itemView.findViewById ( R.id.shou_ye );
            movie_name = itemView.findViewById ( R.id.movie_name );
            movie_ping = itemView.findViewById ( R.id.movie_ping );
            buy_piao = itemView.findViewById ( R.id.buy_piao );
            re_men_xrecycel = itemView.findViewById ( R.id.re_men_xrecycel );
        }
    }
}
