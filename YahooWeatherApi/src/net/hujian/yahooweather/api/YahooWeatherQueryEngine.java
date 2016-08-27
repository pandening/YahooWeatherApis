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

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by hujian on 2016/8/27.
 * the query object
 */
public class YahooWeatherQueryEngine {
    /**
     * base query string (by place)
     */
    private static String placeQueryBase="https://query.yahooapis.com/v1/public/yql?q=" +
            "select%20*%20from%20weather.forecast%20where%20woeid%20in%20" +
            "(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22" +
            "(COUNTRY,PROVINCE,CITY)%22)";
    /**
     * base query string (by position)
     */
    private static String positionQueryBase="https://query.yahooapis.com/v1/public/yql?q=" +
            "select%20*%20from%20weather.forecast%20where%20woeid%20in%20" +
            "(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22" +
            "(LAT,LONG)%22)";

    /**
     * this is the real work function.
     * @param country
     * @param province
     * @param city
     * @return
     */
    public static Document getByPlace(String country,String province,String city)
    throws IOException{
        placeQueryBase=placeQueryBase.replace("COUNTRY",country);
        placeQueryBase=placeQueryBase.replace("PROVINCE",province);
        placeQueryBase=placeQueryBase.replace("CITY",city);
        YahooWeatherLog.info("YahooWeatherQueryEngine","QUERY:"+placeQueryBase);
        return Jsoup.connect(placeQueryBase).get();
    }
    /**
     * this is the real work function.
     * @param Lat
     * @param Long
     * @return
     * @throws IOException
     */
    public static Document getByPosition(Double Lat,Double Long)
    throws IOException{
        positionQueryBase=positionQueryBase.replace("LAT",Lat.toString());
        positionQueryBase=positionQueryBase.replace("LONG",Long.toString());
        YahooWeatherLog.info("YahooWeatherQueryEngine","QUERY:"+positionQueryBase);
        return Jsoup.connect(positionQueryBase).get();
    }
}
