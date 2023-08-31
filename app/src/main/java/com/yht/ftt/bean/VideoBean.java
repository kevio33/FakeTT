package com.yht.ftt.bean;

/**
 * @Description:
 * @author: kevinyang
 * @date: 2023/8/6
 **/
public class VideoBean {

    private int videoId;
    /** 视频播放资源  */
    private int videoRes;
    /** 封面图片资源  */
    private int coverRes;
    /** 视频文案内容  */
    private String content;
    /*作者*/
    private UserBean userBean;
    /*是否点赞*/
    private boolean isLiked;

    /** 与视频发布距离  */
    private float distance = 0f;

    /** 是否已关注  */
    private boolean isFocused = false;

    /** 点赞数  */
    private int likeCount = 0;

    /** 评论数  */
    private int commentCount = 0;

    /** 转发数  */
    private int shareCount = 0;

    class UserBean{
        public int uid = 0;
        public String nickName;
        public int head = 0;

        /** 座右铭  */
        public String sign = "";

        /** 是否已关注  */
        public boolean isFocused = false;

        /** 获赞数量  */
        public int subCount = 0;

        /** 关注数量  */
        public int focusCount = 0;

        /** 粉丝数量  */
        public int fansCount = 0;

        /** 作品数量  */
        public int workCount = 0;

        /** 动态数量  */
        public int dynamicCount = 0;

        /** 喜欢数量  */
        public int  likeCount = 0;



    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public int getVideoRes() {
        return videoRes;
    }

    public void setVideoRes(int videoRes) {
        this.videoRes = videoRes;
    }

    public int getCoverRes() {
        return coverRes;
    }

    public void setCoverRes(int coverRes) {
        this.coverRes = coverRes;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public boolean isFocused() {
        return isFocused;
    }

    public void setFocused(boolean focused) {
        isFocused = focused;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getShareCount() {
        return shareCount;
    }

    public void setShareCount(int shareCount) {
        this.shareCount = shareCount;
    }


    public VideoBean(){

    };
    public VideoBean(int videoId, int videoRes, int coverRes, String content, UserBean userBean, boolean isLiked, float distance, boolean isFocused, int likeCount, int commentCount, int shareCount) {
        this.videoId = videoId;
        this.videoRes = videoRes;
        this.coverRes = coverRes;
        this.content = content;
        this.userBean = userBean;
        this.isLiked = isLiked;
        this.distance = distance;
        this.isFocused = isFocused;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
        this.shareCount = shareCount;
    }
}
