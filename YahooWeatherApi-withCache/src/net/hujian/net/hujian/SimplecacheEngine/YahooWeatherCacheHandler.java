package net.hujian.net.hujian.SimplecacheEngine;

import net.hujian.yahooweather.api.YahooWeatherInformation;
import net.hujian.yahooweather.api.YahooWeatherLog;

import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by hujian on 2016/8/29.
 * this is the true worker class.
 */
public class YahooWeatherCacheHandler extends CacheHandlerBase implements CacheBase {
    private int     cacheSize=1024;
    private int     freshTime=this.freshTime;
    private static Long    storeTime=1000*60*60L;
    private  static Cache   CacheInstance=null;
    private Timer   freshTimer=null;
    private boolean setUP=false;
    public void setSetUPStatus(boolean is){
        this.setUP=is;
    }
    public boolean getSetUpStatus(){
        return this.setUP;
    }
    /**
     * this is the  powerful constructor of this class.you should
     * offer the total information.
     * @param isSetUp set up/shut down the cache
     * @param CacheSz the cache size.(not bytes.just the size of map's element)
     * @param fTime the fresh time
     */
    public YahooWeatherCacheHandler(boolean isSetUp,int CacheSz,int fTime){
        super(fTime);
        this.cacheSize=CacheSz;
        this.freshTime=fTime;
        CacheInstance=Cache.getInstance();
        this.setUP=isSetUp;
        freshTimer=new Timer();
        freshTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                int del=refreshCache();
                YahooWeatherLog.info(this.getClass().getName(),"refresh cache,delete data:"+del);
            }
        },this.freshTime,this.freshTime);
    }

    /**
     * simple constructor,total default.
     */
    public YahooWeatherCacheHandler(){
        super();
        CacheInstance=Cache.getInstance();
        freshTimer=new Timer();
        freshTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                int del=refreshCache();
                YahooWeatherLog.info(this.getClass().getName(),"refresh cache,delete data:"+del);
            }
        },this.freshTime,this.freshTime);
    }
    /**
     * so,you should override this function.but the user will do not permission to
     * invoke this api.
     * @return how many old items were deleted.
     */
    protected static int refreshCache(){
        /**
         * first,get the current time.
         */
        Long current=System.currentTimeMillis();
        int num=0;
        Iterator<Object> itr=CacheInstance.CacheMap.keySet().iterator();
        YahooWeatherLog.info("refresh","old map size:"+CacheInstance.CacheMap.size());
        while(itr.hasNext()){
            Object cur=itr.next();
            if(CacheInstance.CacheMap.get(cur).getPutTimeMills()-current>=storeTime){
                CacheInstance.CacheMap.remove(cur);
                num++;
            }
        }
        return num;
    }
    @Override
    public void reSetCacheSize(int newSize) {
        int oldSz=this.CacheInstance.CacheMap.size();
        if(newSize==oldSz){
            YahooWeatherLog.info(this.getClass().getName(),"old==new");
            return;
        }else if(newSize>oldSz){
            this.cacheSize=newSize;
            YahooWeatherLog.info(this.getClass().getName(),"new size set with no data lost.");
        }else{
            this.cacheSize=newSize;
            YahooWeatherLog.info(this.getClass().getName(),"new size set with lost "+(oldSz-newSize)+" data(s)");
            Iterator<Object> itr=this.CacheInstance.CacheMap.keySet().iterator();
            while(this.CacheInstance.CacheMap.size()>newSize){
                this.CacheInstance.CacheMap.remove(itr.next());
                YahooWeatherLog.info(this.getClass().getName(),"remove an item from cache.");
            }
        }
    }

    @Override
    public int getCacheSize() {
        return this.cacheSize;
    }

    @Override
    public YahooWeatherInformation lookupByPlace(PlaceQueryInformation query) {
        YahooWeatherLog.info(this.getClass().getName(),"query string:"+query.toString());
        if(CacheInstance.CacheMap.get(query.toString())==null){
            YahooWeatherLog.info(this.getClass().getName(),"can not query the info from cache");
        }
        return  this.CacheInstance.CacheMap.get(query.toString());
    }

    /**
     * in some reason,not use-able now
     * @param query query info
     * @return
     */
    @Override
    public YahooWeatherInformation lookupByPosition(PositionQueryInformation query) {
        YahooWeatherLog.info(this.getClass().getName(),"query string:"+query.toString());
        return  this.CacheInstance.CacheMap.get(query.toString());
    }

    @Override
    public void put(YahooWeatherInformation info) {
        /**
         * i need to create the key.
         */
        StringBuilder key=new StringBuilder();
        key.append(info.getCountry()+",");
        key.append(info.getRegion()+",");
        key.append(info.getCity());
        String k=key.toString().replace(" ","");
        info.setPutTimeMills(System.currentTimeMillis());
        if(info.getCountry()==null||info.getCity()==null||info.getRegion()==null){
            YahooWeatherLog.error(this.getClass().getName(),"can not store this info:"+k);
            return;
        }else{
            if(this.CacheInstance.CacheMap.size()<=this.cacheSize) {
                this.CacheInstance.CacheMap.put(k,info);
                YahooWeatherLog.info(this.getClass().getName(), "store an info ok:" + k);
            }else{
                YahooWeatherLog.info(this.getClass().getName(),"cache full!");
            }
        }
    }

    @Override
    public void clear() {
        this.CacheInstance.CacheMap.clear();
        YahooWeatherLog.info(this.getClass().getName(),"clear done,the size as:"+this.CacheInstance.CacheMap.size());
    }
    /**
     * i want to traversal whole map
     */
    public void TraversalWholeMap(){
        YahooWeatherLog.info(this.getClass().getName(),"...........traversal whole map(size="
                +CacheInstance.CacheMap.size()+")........");
        for(Map.Entry<Object,YahooWeatherInformation> info: this.CacheInstance.CacheMap.entrySet()){
            System.out.println("key:" + info.getKey() + " ->putTime:" + info.getValue().getPutTimeMills());
        }
    }
}
