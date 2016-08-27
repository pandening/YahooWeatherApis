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

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hujian on 2016/8/27.
 * this class will get the weather information xml document
 */
public class XMLParseEngine {
    /**
     * the jsoup xml document object
     */
    private Document XMLobject=null;
    /**
     * the errors
     */
    StringBuilder ErrorBuffer=null;

    /**
     * the constructor,i don't have too much time to offer many constructors
     * so,please use this constructor to get a instance of this class.
     * @param xml
     */
    public XMLParseEngine(Document xml){
        this.XMLobject=xml;
        ErrorBuffer=new StringBuilder();
        YahooWeatherLog.info(this.getClass().getName(),"get the document ok,start to parse it!");
    }

    /**
     * ok,give me the xml object,i will give you the result yahoo weather information
     * @return the result weather information
     */
    public  YahooWeatherInformation parse(){
        /**
         * this is the result weather information object
         */
        YahooWeatherInformation yahooResult=new YahooWeatherInformation();
        yahooResult.setAtmosphere_pressure(this.getAtmosphere_pressure());
        yahooResult.setCity(this.getCity());
        yahooResult.setCountry(this.getCountry());
        yahooResult.setCurrent_temperature(this.getCurrent_temperature());
        yahooResult.setCurrent_temperature_builder_time(this.getCurrent_temperature_builder_time());
        yahooResult.setCurrent_weather_status(this.getCurrent_weather_status());
        yahooResult.setDescription(this.getDescription());
        yahooResult.setForecast_information_list(this.getForecast_information_list());
        yahooResult.setGps_lat(this.getGps_lat());
        yahooResult.setGps_long(this.getGps_long());
        yahooResult.setHumidity(this.getHumidity());
        yahooResult.setImage_height(this.getImage_height());
        yahooResult.setImage_url(this.getImage_url());
        yahooResult.setImage_width(this.getImage_width());
        yahooResult.setLanguage(this.getLanguage());
        yahooResult.setLastBuildDate(this.getLastBuildDate());
        yahooResult.setLink(this.getLink());
        yahooResult.setPubDate(this.getPubDate());
        yahooResult.setRegion(this.getRegion());
        yahooResult.setSunrise_time(this.getSunrise_time());
        yahooResult.setSunset_time(this.getSunset_time());
        yahooResult.setTitle(this.getTitle());
        yahooResult.setTtl(this.getTtl());
        yahooResult.setVisibility(this.getVisibility());
        yahooResult.setWeed_chill(this.getWeed_chill());
        yahooResult.setWeed_direction(this.getWeed_direction());
        yahooResult.setWeed_speed(this.getWeed_speed());
        yahooResult.setYweather_units_distance(this.getYweather_units_distance());
        yahooResult.setYweather_units_pressure(this.getYweather_units_pressure());
        yahooResult.setYweather_units_speed(this.getYweather_units_speed());
        yahooResult.setYweather_units_temperature(this.getYweather_units_temperature());
        /**
         * ok,return this stupid result:<
         */
        return yahooResult;
    }
    /**
     * get the tmp units
     * @return
     */
    private String getYweather_units_temperature(){
        Elements elements=XMLobject.getElementsByTag("yweather:units");
        String result=null;
        for(Element ele:elements){
            if((result=ele.attr("temperature"))!=null){
                break;
            }
        }
        return result;
    }
    /**
     * get
     * @return
     */
    public String getYweather_units_speed(){
        Elements elements=XMLobject.getElementsByTag("yweather:units");
        String result=null;
        for(Element ele:elements){
            if((result=ele.attr("speed"))!=null){
                break;
            }
        }
        return result;
    }
    /**
     *
     * @return
     */
    public String getYweather_units_pressure(){
        Elements elements=XMLobject.getElementsByTag("yweather:units");
        String result=null;
        for(Element ele:elements){
            if((result=ele.attr("pressure"))!=null){
                break;
            }
        }
        return result;
    }
    /**
     *
     * @return
     */
    public String getYweather_units_distance(){
        Elements elements=XMLobject.getElementsByTag("yweather:units");
        String result=null;
        for(Element ele:elements){
            if((result=ele.attr("distance"))!=null){
                break;
            }
        }
        return result;
    }
    /**
     *
     * @return
     */
    public String getTitle(){
        return null;
    }
    /**
     *
     * @return
     */
    public String getLink(){
        return null;
    }
    /**
     *
     * @return
     */
    public String getDescription(){
        return null;
    }
    /**
     *
     * @return
     */
    public String getLanguage(){
        return XMLobject.select("language").text();
    }
    /**
     *
     * @return
     */
    public String getLastBuildDate(){
        return XMLobject.select("lastbuilddate").text();
    }
    /**
     *
     * @return
     */
    public String getTtl(){
        return XMLobject.select("ttl").text();
    }
    /**
     *
     * @return
     */
    public String getRegion(){
        Elements elements=XMLobject.getElementsByTag("yweather:location");
        String result=null;
        for(Element ele:elements){
            if((result=ele.attr("region"))!=null){
                break;
            }
        }
        return result;
    }
    /**
     *
     * @return
     */
    public String getCountry(){
        Elements elements=XMLobject.getElementsByTag("yweather:location");
        String result=null;
        for(Element ele:elements){
            if((result=ele.attr("country"))!=null){
                break;
            }
        }
        return result;
    }
    /**
     *
     * @return
     */
    public String getCity(){
        Elements elements=XMLobject.getElementsByTag("yweather:location");
        String result=null;
        for(Element ele:elements){
            if((result=ele.attr("city"))!=null){
                break;
            }
        }
        return result;
    }
    /**
     *
     * @return
     */
    public String getWeed_speed(){
        Elements elements=XMLobject.getElementsByTag("yweather:wind");
        String result=null;
        for(Element ele:elements){
            if((result=ele.attr("speed"))!=null){
                break;
            }
        }
        return result;
    }
    /**
     *
     * @return
     */
    public String getWeed_direction(){
        Elements elements=XMLobject.getElementsByTag("yweather:wind");
        String result=null;
        for(Element ele:elements){
            if((result=ele.attr("direction"))!=null){
                break;
            }
        }
        return result;
    }
    /**
     *
     * @return
     */
    public  String getWeed_chill(){
        Elements elements=XMLobject.getElementsByTag("yweather:wind");
        String result=null;
        for(Element ele:elements){
            if((result=ele.attr("chill"))!=null){
                break;
            }
        }
        return result;
    }
    /**
     *
     * @return
     */
    public String getAtmosphere_pressure(){
        Elements elements=XMLobject.getElementsByTag("yweather:atmosphere");
        String result=null;
        for(Element ele:elements){
            if((result=ele.attr("pressure"))!=null){
                break;
            }
        }
        return result;
    }
    /**
     *
     * @return
     */
    public String getVisibility(){
        Elements elements=XMLobject.getElementsByTag("yweather:atmosphere");
        String result=null;
        for(Element ele:elements){
            if((result=ele.attr("visibility"))!=null){
                break;
            }
        }
        return result;
    }
    /**
     *
     * @return
     */
    public String getHumidity(){
        Elements elements=XMLobject.getElementsByTag("yweather:atmosphere");
        String result=null;
        for(Element ele:elements){
            if((result=ele.attr("humidity"))!=null){
                break;
            }
        }
        return result;
    }
    /**
     *
     * @return
     */
    public String getSunset_time(){
        Elements elements=XMLobject.getElementsByTag("yweather:astronomy");
        String result=null;
        for(Element ele:elements){
            if((result=ele.attr("sunset"))!=null){
                break;
            }
        }
        return result;
    }
    /**
     *
     * @return
     */
    public String getSunrise_time(){
        Elements elements=XMLobject.getElementsByTag("yweather:astronomy");
        String result=null;
        for(Element ele:elements){
            if((result=ele.attr("sunrise"))!=null){
                break;
            }
        }
        return result;
    }
    /**
     *
     * @return
     */
    public String getImage_width(){
        return XMLobject.select("width").text();
    }
    /**
     *
     * @return
     */
    public String getImage_height(){
        return XMLobject.select("height").text();
    }
    /**
     *
     * @return
     */
    public String getImage_url(){
        return XMLobject.select("url").text();
    }
    /**
     *
     * @return
     */
    public String getGps_lat(){
        Elements elements=XMLobject.getElementsByTag("geo:lat");
        return XMLobject.getElementsByTag("geo:lat").text();
    }
    /**
     *
     * @return
     */
    public String getGps_long(){
        Elements elements=XMLobject.getElementsByTag("item");
        return XMLobject.getElementsByTag("geo:long").text();
    }
    /**
     *
     * @return
     */
    public String getPubDate(){
        return XMLobject.select("pubdate").text();
    }
    /**
     *
     * @return
     */
    public String getCurrent_weather_status(){
        Elements elements=XMLobject.getElementsByTag("yweather:condition");
        String result=null;
        for(Element ele:elements){
            if((result=ele.attr("text"))!=null){
                break;
            }
        }
        return result;
    }
    /**
     *
     * @return
     */
    public String getCurrent_temperature_builder_time(){
        Elements elements=XMLobject.getElementsByTag("yweather:condition");
        String result=null;
        for(Element ele:elements){
            if((result=ele.attr("date"))!=null){
                break;
            }
        }
        return result;
    }
    /**
     *
     * @return
     */
    public String getCurrent_temperature(){
        Elements elements=XMLobject.getElementsByTag("yweather:condition");
        String result=null;
        for(Element ele:elements){
            if((result=ele.attr("temp"))!=null){
                break;
            }
        }
        return result;
    }
    /**
     * oh,the variable just offer the api for getting!no setting
     * so,you should assign the forecast by getting.
     * and get the result also by getting.
     * @return return the list of forecast.
     */
    public List<ForeCastWeatherInformation> getForecast_information_list(){
        List<ForeCastWeatherInformation> result=new ArrayList<ForeCastWeatherInformation>();
        ForeCastWeatherInformation item=new ForeCastWeatherInformation();
        Elements elements=XMLobject.getElementsByTag("yweather:forecast");
        for(Element ele:elements){
            item.setForecast_date(ele.attr("date"));
            item.setForecast_day(ele.attr("day"));
            item.setHigh_temperature(ele.attr("high"));
            item.setLow_temperature(ele.attr("low"));
            item.setForecast_weather_status(ele.attr("text"));
            result.add(item);
            /**
             * again,just re-malloc
             */
            item=new ForeCastWeatherInformation();
        }
        return result;
    }
    /**
     *
     * @return
     */
    public ErrorInformation getError_information(){
        /**
         * it's very 'nice' to do not DO a error handler for this project!
         * BUT I WILL ADD THE ERROR HANDEL ONE DAY,OR YOU CAN DO THAT FRO ME!
         *
         * add:this is a simple error handler by append!
         */
        ErrorInformation err=new ErrorInformation(ErrorBuffer.toString());
        return err;
    }

}
