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
/**
 * Created by hujian on 2016/8/27.
 * i will open this class for user,you can use this api to debug(i wish you need not to do this :<).
 */
public class ShowTotalInformation {
    public static void ShowWeatherInformation(YahooWeatherInformation info){
        System.out.println("temperature units:" + info.getYweather_units_temperature());
        System.out.println("speed units:" + info.getYweather_units_speed());
        System.out.println("pressure units:"+info.getYweather_units_pressure());
        System.out.println("distance units:"+info.getYweather_units_distance());
        System.out.println("language:"+info.getLanguage());
        System.out.println("last build date:" + info.getLastBuildDate());
        System.out.println("TTL:" + info.getTtl());
        System.out.println("region:" + info.getRegion());
        System.out.println("country:" + info.getCountry());
        System.out.println("city:" + info.getCity());
        System.out.println("wind-chill:" + info.getWeed_chill());
        System.out.println("wind-direction:" + info.getWeed_direction());
        System.out.println("wind-speed:" + info.getWeed_speed());
        System.out.println("atmosphere-humidity:" + info.getHumidity());
        System.out.println("atmosphere-pressure:" + info.getAtmosphere_pressure());
        System.out.println("atmosphere-visibility:" + info.getVisibility());
        System.out.println("sunset:" + info.getSunset_time());
        System.out.println("sunrise:" + info.getSunrise_time());
        System.out.println("img-height/width:" + info.getImage_height() + "/" + info.getImage_width());
        System.out.println("img-url:" + info.getImage_url());
        System.out.println("lat/long:" + info.getGps_lat() + "/" + info.getGps_long());
        System.out.println("pubdate:" + info.getPubDate());
        System.out.println("current-temp-date:" + info.getCurrent_temperature_builder_time());
        System.out.println("current-temp:" + info.getCurrent_temperature()+" F");
        System.out.println("current-temp-status:" + info.getCurrent_weather_status());
        System.out.println("forecast information["+info.getForecast_information_list().size()+"]");
        for(ForeCastWeatherInformation i:info.getForecast_information_list()){
            System.out.println("["+i.getForecast_date()+" "+i.getForecast_day()+"] Low:"+i.getLow_temperature()+
            " High:"+i.getHigh_temperature()+" Status:"+i.getForecast_weather_status());
        }
    }
}
