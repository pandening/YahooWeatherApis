package net.hujian.net.hujian.SimplecacheEngine;

import net.hujian.yahooweather.api.YahooWeatherInformation;

/**
 * Created by hujian on 2016/8/29.
 * the cache base,i will define some api for user.
 * AND,THIS IS A INTERFACE.
 */
public interface CacheBase {
    /**
     * if you want to re-set the cache size,just call this api
     * NOTICE:if newsize<oldsize your data will lost
     * if new size>oldsize it's safe to do this
     * if newsize==oldsize just do nothing.
     * @param newSize
     */
    public void reSetCacheSize(int newSize);

    /**
     * get the current cache size
     * @return the current size
     */
    public int getCacheSize();

    /**hujian
     *
     * look up by place information
     * @param query the query info
     * @return the yahoo weather information.if return null,means no find in the cache
     */
    public YahooWeatherInformation lookupByPlace(PlaceQueryInformation query);

    /**
     * look up bu position
     * @param query query info
     * @return if return null,means no find in cache
     */
    public YahooWeatherInformation lookupByPosition(PositionQueryInformation query);

    /**
     * this function seem to be private,but in this interface,i will make it public.
     * but,you can not use the api without implement it by yourself.
     * @param info a yahoo weather information
     */
    public void put(YahooWeatherInformation info);

    /**
     * ok,let's goto start.
     */
    public void clear();
}
