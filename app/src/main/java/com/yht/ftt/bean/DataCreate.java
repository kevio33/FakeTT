package com.yht.ftt.bean;

import com.yht.ftt.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: kevinyang
 * @date: 2023/8/6
 **/
public class DataCreate {
    private List datas = new ArrayList<VideoBean>();
    private List userList = new ArrayList<VideoBean.UserBean>();

    public void initData(){
        VideoBean videoBean_1 = new VideoBean();
        videoBean_1.setVideoId(0);
        videoBean_1.setVideoRes(R.raw.video1);
        videoBean_1.setCoverRes(R.mipmap.cover1);
        videoBean_1.setContent("#街坊 #颜值打分 给自己颜值打100分的女生集合");
        videoBean_1.setDistance(7.9f);
        videoBean_1.setLiked(true);
        videoBean_1.setFocused(false);
        videoBean_1.setLikeCount(226823);
        videoBean_1.setCommentCount(3480);
        videoBean_1.setShareCount(4252);


        VideoBean.UserBean userBean_1 = new VideoBean().new UserBean();
        userBean_1.uid = 1;

    }

}
