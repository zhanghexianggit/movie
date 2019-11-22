package com.bw.movie.bean;

import java.util.List;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/15
 * @Description:
 */
public class MovieDetailsBean {

    /**
     * result : {"commentNum":15,"duration":"137分钟","imageUrl":"http://172.17.8.100/images/movie/stills/xbyz/xbyz1.jpg","movieActor":[{"name":"姜文","photo":"http://172.17.8.100/images/movie/actor/xbyz/jiangwen.jpg","role":"蓝青峰"},{"name":"彭于晏","photo":"http://172.17.8.100/images/movie/actor/xbyz/pengyuyan.jpg","role":"李天然"},{"name":"廖凡","photo":"http://172.17.8.100/images/movie/actor/xbyz/liaofan.jpg","role":"朱潜龙"},{"name":"周韵","photo":"http://172.17.8.100/images/movie/actor/xbyz/zhouyun.jpg","role":"关巧红"},{"name":"许晴","photo":"http://172.17.8.100/images/movie/actor/xbyz/xuqing.jpg","role":"唐凤仪"}],"movieDirector":[{"name":"姜文","photo":"http://172.17.8.100/images/movie/director/xbyz/1.jpg"}],"movieId":5,"movieType":"动作 / 喜剧 / 剧情","name":"邪不压正","placeOrigin":"中国","posterList":["http://172.17.8.100/images/movie/stills/xbyz/xbyz1.jpg","http://172.17.8.100/images/movie/stills/xbyz/xbyz2.jpg","http://172.17.8.100/images/movie/stills/xbyz/xbyz3.jpg","http://172.17.8.100/images/movie/stills/xbyz/xbyz4.jpg","http://172.17.8.100/images/movie/stills/xbyz/xbyz5.jpg","http://172.17.8.100/images/movie/stills/xbyz/xbyz6.jpg"],"releaseTime":1594569600000,"score":8.8,"shortFilmList":[{"imageUrl":"http://172.17.8.100/images/movie/stills/xbyz/xbyz3.jpg","videoUrl":"http://172.17.8.100/video/movie/xbyz/xbyz1.ts"},{"imageUrl":"http://172.17.8.100/images/movie/stills/xbyz/xbyz2.jpg","videoUrl":"http://172.17.8.100/video/movie/xbyz/xbyz2.ts"},{"imageUrl":"http://172.17.8.100/images/movie/stills/xbyz/xbyz4.jpg","videoUrl":"http://172.17.8.100/video/movie/xbyz/xbyz3.ts"}],"summary":"北洋年间，北京以北。习武少年李天然（彭于晏 饰）目睹师兄朱潜龙（廖凡 饰）勾结日本特务根本一郎，杀害师父全家。李天然侥幸从枪下逃脱，被美国医生亨德勒救下。李天然伤愈后，赴美学医多年，并同时接受特工训练。1937年初，李天然突然受命回国。\u201c七七事变\u201d前夜，北平，这座国际间谍之城，华洋混杂，山头林立。每时每刻充满诱惑与杀机。一心复仇的李天然，并不知道自己被卷入了一场阴谋，亦搅乱了一盘棋局。彼时彼刻，如","whetherFollow":2}
     * message : 查询成功
     * status : 0000
     */

    private ResultBean result;
    private String message;
    private String status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class ResultBean {
        /**
         * commentNum : 15
         * duration : 137分钟
         * imageUrl : http://172.17.8.100/images/movie/stills/xbyz/xbyz1.jpg
         * movieActor : [{"name":"姜文","photo":"http://172.17.8.100/images/movie/actor/xbyz/jiangwen.jpg","role":"蓝青峰"},{"name":"彭于晏","photo":"http://172.17.8.100/images/movie/actor/xbyz/pengyuyan.jpg","role":"李天然"},{"name":"廖凡","photo":"http://172.17.8.100/images/movie/actor/xbyz/liaofan.jpg","role":"朱潜龙"},{"name":"周韵","photo":"http://172.17.8.100/images/movie/actor/xbyz/zhouyun.jpg","role":"关巧红"},{"name":"许晴","photo":"http://172.17.8.100/images/movie/actor/xbyz/xuqing.jpg","role":"唐凤仪"}]
         * movieDirector : [{"name":"姜文","photo":"http://172.17.8.100/images/movie/director/xbyz/1.jpg"}]
         * movieId : 5
         * movieType : 动作 / 喜剧 / 剧情
         * name : 邪不压正
         * placeOrigin : 中国
         * posterList : ["http://172.17.8.100/images/movie/stills/xbyz/xbyz1.jpg","http://172.17.8.100/images/movie/stills/xbyz/xbyz2.jpg","http://172.17.8.100/images/movie/stills/xbyz/xbyz3.jpg","http://172.17.8.100/images/movie/stills/xbyz/xbyz4.jpg","http://172.17.8.100/images/movie/stills/xbyz/xbyz5.jpg","http://172.17.8.100/images/movie/stills/xbyz/xbyz6.jpg"]
         * releaseTime : 1594569600000
         * score : 8.8
         * shortFilmList : [{"imageUrl":"http://172.17.8.100/images/movie/stills/xbyz/xbyz3.jpg","videoUrl":"http://172.17.8.100/video/movie/xbyz/xbyz1.ts"},{"imageUrl":"http://172.17.8.100/images/movie/stills/xbyz/xbyz2.jpg","videoUrl":"http://172.17.8.100/video/movie/xbyz/xbyz2.ts"},{"imageUrl":"http://172.17.8.100/images/movie/stills/xbyz/xbyz4.jpg","videoUrl":"http://172.17.8.100/video/movie/xbyz/xbyz3.ts"}]
         * summary : 北洋年间，北京以北。习武少年李天然（彭于晏 饰）目睹师兄朱潜龙（廖凡 饰）勾结日本特务根本一郎，杀害师父全家。李天然侥幸从枪下逃脱，被美国医生亨德勒救下。李天然伤愈后，赴美学医多年，并同时接受特工训练。1937年初，李天然突然受命回国。“七七事变”前夜，北平，这座国际间谍之城，华洋混杂，山头林立。每时每刻充满诱惑与杀机。一心复仇的李天然，并不知道自己被卷入了一场阴谋，亦搅乱了一盘棋局。彼时彼刻，如
         * whetherFollow : 2
         */

        private int commentNum;
        private String duration;
        private String imageUrl;
        private int movieId;
        private String movieType;
        private String name;
        private String placeOrigin;
        private long releaseTime;
        private double score;
        private String summary;
        private int whetherFollow;
        private List<MovieActorBean> movieActor;
        private List<MovieDirectorBean> movieDirector;
        private List<String> posterList;
        private List<ShortFilmListBean> shortFilmList;

        public int getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(int commentNum) {
            this.commentNum = commentNum;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public int getMovieId() {
            return movieId;
        }

        public void setMovieId(int movieId) {
            this.movieId = movieId;
        }

        public String getMovieType() {
            return movieType;
        }

        public void setMovieType(String movieType) {
            this.movieType = movieType;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPlaceOrigin() {
            return placeOrigin;
        }

        public void setPlaceOrigin(String placeOrigin) {
            this.placeOrigin = placeOrigin;
        }

        public long getReleaseTime() {
            return releaseTime;
        }

        public void setReleaseTime(long releaseTime) {
            this.releaseTime = releaseTime;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public int getWhetherFollow() {
            return whetherFollow;
        }

        public void setWhetherFollow(int whetherFollow) {
            this.whetherFollow = whetherFollow;
        }

        public List<MovieActorBean> getMovieActor() {
            return movieActor;
        }

        public void setMovieActor(List<MovieActorBean> movieActor) {
            this.movieActor = movieActor;
        }

        public List<MovieDirectorBean> getMovieDirector() {
            return movieDirector;
        }

        public void setMovieDirector(List<MovieDirectorBean> movieDirector) {
            this.movieDirector = movieDirector;
        }

        public List<String> getPosterList() {
            return posterList;
        }

        public void setPosterList(List<String> posterList) {
            this.posterList = posterList;
        }

        public List<ShortFilmListBean> getShortFilmList() {
            return shortFilmList;
        }

        public void setShortFilmList(List<ShortFilmListBean> shortFilmList) {
            this.shortFilmList = shortFilmList;
        }

        public static class MovieActorBean {
            /**
             * name : 姜文
             * photo : http://172.17.8.100/images/movie/actor/xbyz/jiangwen.jpg
             * role : 蓝青峰
             */

            private String name;
            private String photo;
            private String role;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public String getRole() {
                return role;
            }

            public void setRole(String role) {
                this.role = role;
            }
        }

        public static class MovieDirectorBean {
            /**
             * name : 姜文
             * photo : http://172.17.8.100/images/movie/director/xbyz/1.jpg
             */

            private String name;
            private String photo;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }
        }

        public static class ShortFilmListBean {
            /**
             * imageUrl : http://172.17.8.100/images/movie/stills/xbyz/xbyz3.jpg
             * videoUrl : http://172.17.8.100/video/movie/xbyz/xbyz1.ts
             */

            private String imageUrl;
            private String videoUrl;

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getVideoUrl() {
                return videoUrl;
            }

            public void setVideoUrl(String videoUrl) {
                this.videoUrl = videoUrl;
            }
        }
    }
}
