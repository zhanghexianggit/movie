package com.bw.movie.api;


import com.bw.movie.bean.BannerBean;
import com.bw.movie.bean.CinemasInfoByRegionBean;
import com.bw.movie.bean.CinemmaBean;
import com.bw.movie.bean.ComingSoonBean;
import com.bw.movie.bean.DataBean;
import com.bw.movie.bean.HotMovieBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.MovieCommentBean;
import com.bw.movie.bean.MovieDetailsBean;
import com.bw.movie.bean.RecommendBean;
import com.bw.movie.bean.RegionBean;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.bean.ReleaseBean;
import com.bw.movie.bean.ScreenHeIdBean;
import com.bw.movie.bean.ScreenSeatBean;
import com.bw.movie.bean.TICketBean;
import com.bw.movie.bean.TicketsBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/11
 * @Description:
 */
public interface IApiServcie {
    //登录
    @FormUrlEncoded
    @POST("movieApi/user/v2/login")
    Observable<LoginBean> login(@FieldMap Map<String, Object> map);
    //注册
    @FormUrlEncoded
    @POST("movieApi/user/v2/register")
    Observable<RegisterBean> register(@FieldMap Map<String, Object> map);
    //获取验证码
    @FormUrlEncoded
    @POST("movieApi/user/v2/sendOutEmailCode")
    Observable<RegisterBean> email(@Field("email") String email);
    //首页bannner图展示
    @GET("movieApi/tool/v2/banner")
    Observable<BannerBean> banner();
    //正在热映
    @GET("movieApi/movie/v2/findReleaseMovieList")
    Observable<ReleaseBean> release(@Query ( "page" ) int page,@Query ( "count" )int count);
    //即将上映
    @GET("movieApi/movie/v2/findComingSoonMovieList")
    Observable<ComingSoonBean> coming(@Query ( "page" ) int page,@Query ( "count" )int count);
    //热门电影
    @GET("movieApi/movie/v2/findHotMovieList")
    Observable<HotMovieBean> hotmovie(@Query ( "page" ) int page,@Query ( "count" )int count);
    //地区列表
    @GET("movieApi/tool/v2/findRegionList")
    Observable<RegionBean> region();
    //根据区域查询影院
    @GET("movieApi/cinema/v2/findCinemaByRegion")
    Observable<CinemmaBean> cinema(@Query ( "regionId" ) String region);
    //推荐影院
    @GET("movieApi/cinema/v1/findRecommendCinemas")
    Observable<RecommendBean> recommend(@HeaderMap Map<String,String> headerMap, @QueryMap Map<String,String> queryMap);
    //附近影院
    @GET("movieApi/cinema/v1/findNearbyCinemas")
    Observable<RecommendBean> near(@QueryMap Map<String,String> queryMap);
    //电影详情
    @GET("movieApi/movie/v2/findMoviesDetail")
    Observable<MovieDetailsBean> details(@Query ( "movieId" ) int id);
    //根据电影id查询影评
    @GET("movieApi/movie/v2/findAllMovieComment")
    Observable<MovieCommentBean> moviecomment(@QueryMap Map<String,Object> queryMap);
    //电影排期
    @GET("movieApi/tool/v2/findDateList")
    Observable<DataBean> data();
    //根据电影id,区域id 查询播放影院信息
    @GET("movieApi/movie/v2/findCinemasInfoByRegion")
    Observable<CinemasInfoByRegionBean> cinemasinfobyregion(@QueryMap Map<String,Object> queryMap);
    //根据电影id，时间 查询播放影院信息
    @GET("movieApi/movie/v2/findCinemasInfoByDate")
    Observable<CinemasInfoByRegionBean> cinemasinfobydate(@QueryMap Map<String,Object> queryMap);
    //根据电影价格查询播放影院信息
    @GET("movieApi/movie/v2/findCinemasInfoByPrice")
    Observable<CinemasInfoByRegionBean> cinemasinfobyprice(@QueryMap Map<String,Object> queryMap);
    //根据电影ID和影院ID查询电影排期列表
    @GET("movieApi/movie/v2/findMovieSchedule")
    Observable<ScreenHeIdBean> hillId(@QueryMap Map<String,Object> queryMap);
    //根据影厅id 查询座位信息
    @GET("movieApi/movie/v2/findSeatInfo")
    Observable<ScreenSeatBean> seat(@Query ( "hallId" ) int hallId);
    //购票下单
    @FormUrlEncoded
    @POST("movieApi/movie/v2/verify/buyMovieTickets")
    Observable<TicketsBean> tickets(@HeaderMap Map<String,Object> headerMap,@FieldMap Map<String,Object> queryMap);
    //购票记录
    @GET("movieApi/user/v2/verify/findUserBuyTicketRecord")
    Observable<TICketBean>  qticke(@HeaderMap Map<String,Object> headerMap,@QueryMap Map<String,Object> queryMap);

}
