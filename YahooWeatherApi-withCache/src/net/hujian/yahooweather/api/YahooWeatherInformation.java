/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.hujian.yahooweather.api;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hujian on 2016/8/27.
 * the yahoo weather information class,just the weather data structure
 */
public class YahooWeatherInformation {
    /**
     * the units of temperature
     */
    private String  yweather_units_temperature=null;

    /**
     * set tmp units
     * @param tmp
     */
    public void setYweather_units_temperature(String tmp){
        this.yweather_units_temperature=tmp;
    }

    /**
     * get the tmp units
     * @return
     */
    public String getYweather_units_temperature(){
        return this.yweather_units_temperature;
    }

    /**
     *the units of speed
     */
    private String  yweather_units_speed=null;

    /**
     * set
     * @param sd
     */
    public void setYweather_units_speed(String sd){
        this.yweather_units_speed=sd;
    }

    /**
     * get
     * @return
     */
    public String getYweather_units_speed(){
        return this.yweather_units_speed;
    }

    /**
     * the units of pressure
     */
    private String yweather_units_pressure=null;

    /**
     *
     * @param pre
     */
    public void setYweather_units_pressure(String pre){
        this.yweather_units_pressure=pre;
    }

    /**
     *
     * @return
     */
    public String getYweather_units_pressure(){
        return this.yweather_units_pressure;
    }
    /**
     * the units of distance
     */
    private String yweather_units_distance=null;

    /**
     *
     * @param dis
     */
    public void setYweather_units_distance(String dis){
        this.yweather_units_distance=dis;
    }

    /**
     *
     * @return
     */
    public String getYweather_units_distance(){
        return this.yweather_units_distance;
    }
    /**
     * the title(you can ignore it!)
     */
    private String title=null;

    /**
     *
     * @param t
     */
    public void setTitle(String t){
        this.title=t;
    }

    /**
     *
     * @return
     */
    public String getTitle(){
        return this.title;
    }
    /**
     * i also will parse the link for you >:<
     */
    private String link=null;

    /**
     *
     * @param lk
     */
    public void setLink(String lk){
        this.link=lk;
    }

    /**
     *
     * @return
     */
    public String getLink(){
        return this.link;
    }
    /**
     * the description
     */
    private String description=null;

    /**
     *
     * @param des
     */
    public void setDescription(String des){
        this.description=des;
    }

    /**
     *
     * @return
     */
    public String getDescription(){
        return this.description;
    }
    /**
     * the language
     */
    private String language=null;

    /**
     *
     * @param lg
     */
    public void setLanguage(String lg){
        this.language=lg;
    }

    /**
     *
     * @return
     */
    public String getLanguage(){
        return this.language;
    }
    /**
     * the last builder date
     */
    private String lastBuildDate=null;

    /**
     *
     * @param ld
     */
    public void setLastBuildDate(String ld){
        this.lastBuildDate=ld;
    }

    /**
     *
     * @return
     */
    public String getLastBuildDate(){
        return this.lastBuildDate;
    }
    /**
     * ttl(you can ignore it~)
     */
    private String ttl=null;

    /**
     *
     * @param tl
     */
    public void setTtl(String tl){
        this.ttl=tl;
    }

    /**
     *
     * @return
     */
    public String getTtl(){
        return this.ttl;
    }
    /**
     * location region
     */
    private String region=null;

    /**
     *
     * @param rg
     */
    public void setRegion(String rg){
        this.region=rg;
    }

    /**
     *
     * @return
     */
    public String getRegion(){
        return this.region;
    }
    /**
     * location country
     */
    private String country=null;

    /**
     *
     * @param cty
     */
    public void setCountry(String cty){
        this.country=cty;
    }

    /**
     *
     * @return
     */
    public String getCountry(){
        return this.country;
    }
    /**
     * the city
     */
    private String city=null;

    /**
     *
     * @param ct
     */
    public void setCity(String ct){
        this.city=ct;
    }

    /**
     *
     * @return
     */
    public String getCity(){
        return this.city;
    }
    /**
     * weed speed
     */
    private String weed_speed=null;

    /**
     *
     * @param ws
     */
    public void setWeed_speed(String ws){
        this.weed_speed=ws;
    }

    /**
     *
     * @return
     */
    public String getWeed_speed(){
        return this.weed_speed;
    }
    /**
     * weed direction
     */
    private String weed_direction=null;

    /**
     *
     * @param wd
     */
    public void setWeed_direction(String wd){
        this.weed_direction=wd;
    }

    /**
     *
     * @return
     */
    public String getWeed_direction(){
        return this.weed_direction;
    }
    /**
     * weed_chill
     */
    private String weed_chill=null;

    /**
     *
     * @param ch
     */
    public void setWeed_chill(String ch){
        this.weed_chill=ch;
    }

    /**
     *
     * @return
     */
    public  String getWeed_chill(){
        return this.weed_chill;
    }
    /**
     * atmosphere_pressure
     */
    private String atmosphere_pressure=null;

    /**
     *
     * @param pre
     */
    public void setAtmosphere_pressure(String pre){
        this.atmosphere_pressure=pre;
    }

    /**
     *
     * @return
     */
    public String getAtmosphere_pressure(){
        return this.atmosphere_pressure;
    }
    /**
     * visibility
     */
    private String visibility=null;

    /**
     *
     * @param vis
     */
    public void setVisibility(String vis){
        this.visibility=vis;
    }

    /**
     *
     * @return
     */
    public String getVisibility(){
        return this.visibility;
    }
    /**
     * humidity
     */
    private String humidity=null;

    /**
     *
     * @param hum
     */
    public void setHumidity(String hum){
        this.humidity=hum;
    }

    /**
     *
     * @return
     */
    public String getHumidity(){
        return this.humidity;
    }
    /**
     * sunset_time
     */
    private String sunset_time=null;

    /**
     *
     * @param st
     */
    public void setSunset_time(String st){
        this.sunset_time=st;
    }

    /**
     *
     * @return
     */
    public String getSunset_time(){
        return this.sunset_time;
    }
    /**
     * sunrise_time
     */
    private String sunrise_time=null;

    /**
     *
     * @param sr
     */
    public void setSunrise_time(String sr){
        this.sunrise_time=sr;
    }

    /**
     *
     * @return
     */
    public String getSunrise_time(){
        return this.sunrise_time;
    }
    /**
     * image width
     */
    private String image_width=null;

    /**
     *
     * @param wd
     */
    public void setImage_width(String wd){
        this.image_width=wd;
    }

    /**
     *
     * @return
     */
    public String getImage_width(){
        return this.image_width;
    }
    /**
     * image height
     */
    private String image_height=null;

    /**
     *
     * @param ht
     */
    public void setImage_height(String ht){
        this.image_height=ht;
    }

    /**
     *
     * @return
     */
    public String getImage_height(){
        return this.image_height;
    }
    /**
     * image url
     */
    private String image_url=null;

    /**
     *
     * @param url
     */
    public void setImage_url(String url){
        this.image_url=url;
    }

    /**
     *
     * @return
     */
    public String getImage_url(){
        return this.image_url;
    }
    /**
     * GPS_lat(double)
     */
    private String gps_lat=null;

    /**
     *
     * @param lat
     */
    public void setGps_lat(String lat){
        this.gps_lat=lat;
    }

    /**
     *
     * @return
     */
    public String getGps_lat(){
        return this.gps_lat;
    }
    /**
     * GPS_long(double)
     */
    private String gps_long=null;

    /**
     *
     * @param lg
     */
    public void setGps_long(String lg){
        this.gps_long=lg;
    }

    /**
     *
     * @return
     */
    public String getGps_long(){
        return this.gps_long;
    }
    /**
     * pubDAte,the current date
     */
    private String pubDate=null;

    /**
     *
     * @param pd
     */
    public void setPubDate(String pd){
        this.pubDate=pd;
    }

    /**
     *
     * @return
     */
    public String getPubDate(){
        return this.pubDate;
    }
    /**
     * current_weather_status
     */
    private String current_weather_status=null;

    /**
     *
     * @param st
     */
    public void setCurrent_weather_status(String st){
        this.current_weather_status=st;
    }

    /**
     *
     * @return
     */
    public String getCurrent_weather_status(){
        return this.current_weather_status;
    }
    /**
     * current_temperature_builder_time(just seem to current)
     */
    private String current_temperature_builder_time=null;

    /**
     *
     * @param ct
     */
    public void setCurrent_temperature_builder_time(String ct){
        this.current_temperature_builder_time=ct;
    }

    /**
     *
     * @return
     */
    public String getCurrent_temperature_builder_time(){
        return this.current_temperature_builder_time;
    }
    /**
     * current_temperature
     */
    private String current_temperature=null;

    /**
     *
     * @param ct
     */
    public void setCurrent_temperature(String ct){
        this.current_temperature=ct;
    }

    /**
     *
     * @return
     */
    public String getCurrent_temperature(){
        return this.current_temperature;
    }
    /**
     * the forecast weather information
     */
    private List<ForeCastWeatherInformation> forecast_information_list;

    /**
     * set the forecast info
     * @param forecast
     */
    public void setForecast_information_list(List<ForeCastWeatherInformation> forecast){
        this.forecast_information_list=forecast;
    }

    /**
     *
     * @return return the list of forecast.
     */
    public List<ForeCastWeatherInformation> getForecast_information_list(){
        return this.forecast_information_list;
    }

    /**
     * this is the error str,default is null
     */
    private ErrorInformation error_information;

    /**
     *
     * @return
     */
    public ErrorInformation getError_information(){
       return this.error_information;
    }

    /**
     * the constructor
     */
    public YahooWeatherInformation(){
        //get the forecast weather information list instance
        forecast_information_list=new ArrayList<ForeCastWeatherInformation>();
        error_information=new ErrorInformation(null);
        YahooWeatherLog.info(this.getClass().getName(),"init weather info done..");
    }
    /**
     * the put time mills
     */
    private Long putTimeMills=null;

    /**
     *
     * @param t
     */
    public void setPutTimeMills(Long t){
        this.putTimeMills=t;
    }

    /**
     *
     * @return
     */
    public Long getPutTimeMills(){
        return this.putTimeMills;
    }
}
