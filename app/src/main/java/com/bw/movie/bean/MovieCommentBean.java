package com.bw.movie.bean;

import java.util.List;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/18
 * @Description:
 */
public class MovieCommentBean {


    /**
     * result : [{"commentContent":"这是在陆路","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-11-15/20191115204216.png","commentId":2045,"commentTime":1572869453000,"commentUserId":13708,"commentUserName":"郭转晨","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":10},{"commentContent":"好的不能再好","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-10-25/20191025152747.jpg","commentId":1871,"commentTime":1572003462000,"commentUserId":13610,"commentUserName":"诺","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":5.5},{"commentContent":"好看","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":1754,"commentTime":1571626862000,"commentUserId":13665,"commentUserName":"123456789","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":5},{"commentContent":"027","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-09-23/20190923191522.unknown","commentId":879,"commentTime":1569377787000,"commentUserId":13643,"commentUserName":"������ҵ","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":3},{"commentContent":"�̼�","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":195,"commentTime":1569377416000,"commentUserId":13458,"commentUserName":"23","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":4.5},{"commentContent":"啊啊啊","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-09-17/20190917142448.jpeg","commentId":166,"commentTime":1569033578000,"commentUserId":13455,"commentUserName":"温文尔雅","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":0},{"commentContent":"444","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":162,"commentTime":1568987392000,"commentUserId":13578,"commentUserName":"清风","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":3}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * commentContent : 这是在陆路
         * commentHeadPic : http://172.17.8.100/images/movie/head_pic/2019-11-15/20191115204216.png
         * commentId : 2045
         * commentTime : 1572869453000
         * commentUserId : 13708
         * commentUserName : 郭转晨
         * greatNum : 0
         * isGreat : 0
         * replyHeadPic : []
         * replyNum : 0
         * score : 10
         */

        private String commentContent;
        private String commentHeadPic;
        private int commentId;
        private long commentTime;
        private int commentUserId;
        private String commentUserName;
        private int greatNum;
        private int isGreat;
        private int replyNum;
        private double score;
        private List<?> replyHeadPic;

        public String getCommentContent() {
            return commentContent;
        }

        public void setCommentContent(String commentContent) {
            this.commentContent = commentContent;
        }

        public String getCommentHeadPic() {
            return commentHeadPic;
        }

        public void setCommentHeadPic(String commentHeadPic) {
            this.commentHeadPic = commentHeadPic;
        }

        public int getCommentId() {
            return commentId;
        }

        public void setCommentId(int commentId) {
            this.commentId = commentId;
        }

        public long getCommentTime() {
            return commentTime;
        }

        public void setCommentTime(long commentTime) {
            this.commentTime = commentTime;
        }

        public int getCommentUserId() {
            return commentUserId;
        }

        public void setCommentUserId(int commentUserId) {
            this.commentUserId = commentUserId;
        }

        public String getCommentUserName() {
            return commentUserName;
        }

        public void setCommentUserName(String commentUserName) {
            this.commentUserName = commentUserName;
        }

        public int getGreatNum() {
            return greatNum;
        }

        public void setGreatNum(int greatNum) {
            this.greatNum = greatNum;
        }

        public int getIsGreat() {
            return isGreat;
        }

        public void setIsGreat(int isGreat) {
            this.isGreat = isGreat;
        }

        public int getReplyNum() {
            return replyNum;
        }

        public void setReplyNum(int replyNum) {
            this.replyNum = replyNum;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public List<?> getReplyHeadPic() {
            return replyHeadPic;
        }

        public void setReplyHeadPic(List<?> replyHeadPic) {
            this.replyHeadPic = replyHeadPic;
        }
    }
}
