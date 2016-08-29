package net.hujian.net.hujian.SimplecacheEngine;

import net.hujian.yahooweather.api.YahooWeatherInformation;
import net.hujian.yahooweather.api.YahooWeatherLog;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hujian on 2016/8/29.
 * the store.
 */
public class Cache {
    /**
     * you should always invoke this instance
     */
    private static Cache _instance=null;
    /**
     * NOTICE:THE KEY WILL DIVIDE TO 2 CASES.
     * 1.STORE BY PLACE,THEN KEY =COUNTRY,PROVINCE,CITY
     * 2.STORE BY POSITION,THEN KEY=LAT,LONG
     */
    public  Map<Object,YahooWeatherInformation> CacheMap;

    /**
     * sorry,you can invoke this constructor
     */
    private Cache(){
        CacheMap=new HashMap<Object,YahooWeatherInformation>();
        YahooWeatherLog.info(this.getClass().getName(),"the first?the last!");
    }
    public static Cache getInstance(){
        if(_instance==null){
            _instance=new Cache();
        }
        return _instance;
    }
}
