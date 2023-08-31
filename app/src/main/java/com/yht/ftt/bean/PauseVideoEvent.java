package com.yht.ftt.bean;

/**
 * @Description:
 * @author: kevinyang
 * @date: 2023/8/6
 **/
public class PauseVideoEvent {
    private  boolean isPlayOrPause;
    public PauseVideoEvent(boolean isPlayOrPause){
        this.isPlayOrPause = isPlayOrPause;
    }
}
