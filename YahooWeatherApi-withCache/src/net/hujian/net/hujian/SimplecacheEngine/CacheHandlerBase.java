package net.hujian.net.hujian.SimplecacheEngine;

import net.hujian.yahooweather.api.YahooWeatherLog;

/**
 * Created by hujian on 2016/8/29.
 * you should extends this base class so that you can
 * control the whole cache.
 */
public class CacheHandlerBase {
    /**
     * the default fresh time will set 1h
     */
    private int refreshTime=1000*60*60;

    /**
     * set the fresh time
     * @param time (the time units is mills)
     */
    public void setRefreshTime(int time){
        this.refreshTime=time;
    }

    /**
     * get the current fresh time
     * @return
     */
    public int getRefreshTime(){
        return this.refreshTime;
    }

    /**
     * this is not so bad to tell you that you should offer a time to set up the
     * cache.BUT YOU ALSO CAN NOT IGNORE THIS,THEN THE DEFAULT TIME WILL BE 1H
     * @param setTime (mills)
     */
    public CacheHandlerBase(int setTime){
        this.refreshTime=setTime;
    }

    /**
     * if you think you do not need to reset the fresh time,go ahead
     * with this constructor
     */
    public CacheHandlerBase(){
        YahooWeatherLog.info(this.getClass().getName(),"the default fresh time will be:"+this.refreshTime+" ms");
    }
}
