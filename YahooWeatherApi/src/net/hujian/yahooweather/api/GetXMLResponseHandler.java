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

import java.io.IOException;

/**
 * Created by hujian on 2016/8/27.
 * this class is the worker.
 * you should give me the query information to query yahoo's database
 * then return a xml doc.
 */
public class GetXMLResponseHandler {
    /**
     * the country
     */
    private static String setCountry=null;
    /**
     * the province
     */
    private static String setProvince=null;
    /**
     * the city
     */
    private static String setCity=null;
    /**
     * the lat
     */
    private static Double setLat=null;
    /**
     * the long
     */
    private static Double setLong=null;

    /**
     * so,please you can choose this constructor to get a instance of this class
     * @param country
     * @param province
     * @param city
     */
    public GetXMLResponseHandler(String country,String province,String city){
        setCountry=country;
        setProvince=province;
        setCity=city;
        setLat=null;
        setLong=null;
    }

    /**
     * query by (lat,long)
     * @param Lat
     * @param Long
     */
    public GetXMLResponseHandler(Double Lat,Double Long){
        setCountry=null;
        setProvince=null;
        setCity=null;
        setLat=Lat;
        setLong=Long;
    }
    /**
     * query by place name such as (china,yunnan,kunming) etc.
     * @param country your country
     * @param province the province
     * @param city the city
     * @return the result xml document.
     */
    public static Document queryByPlaceName(String country,String province,String city)
    throws IOException{
        if(country==null||province==null||city==null){
            YahooWeatherLog.error("GetXMLResponseHandler","get (country,province,city)from param fail.");
            if(setCountry==null||setProvince==null||setCity==null){
                YahooWeatherLog.error("GetXMLResponseHandler","get (country,province,city)from constructor fail.");
                return null;
            }
        }else{
            if(setCountry==null||setProvince==null||setCity==null){
                YahooWeatherLog.error("GetXMLResponseHandler","get (country,province,city)from constructor fail.");
                setCountry=country;
                setProvince=province;
                setCity=city;
            }
        }
        //ok,i can get the xml result from yahoo.
        YahooWeatherLog.info("GetXMLResponseHandler","get the place info=>"+setCountry+","+setProvince+","+setCity);
        return YahooWeatherQueryEngine.getByPlace(setCountry,setProvince,setCity);
    }

    /**
     * you also can search by your position (lat,long)
     * @param Lat the lat value
     * @param Long the long value
     * @return the result xml document.
     */
    public static Document queryByLatLong(Double Lat,Double Long)
    throws IOException{
        if(Lat==null||Long==null){
            YahooWeatherLog.error("GetXMLResponseHandler","get (lat,long)from param fail.");
            if(setLat==null||setLong==null){
                YahooWeatherLog.error("GetXMLResponseHandler","get (lat,long)from constructor fail.");
                return null;
            }
        }else{
            if(setLat==null||setLong==null){
                YahooWeatherLog.error("GetXMLResponseHandler","get (lat,long)from constructor fail.");
                setLat=Lat;
                setLong=Long;
            }
        }
        //ok,start to get the response from yahoo
        YahooWeatherLog.info("GetXMLResponseHandler","get the position info=>["+setLat+","+setLong+"]");
        return YahooWeatherQueryEngine.getByPosition(setLat,setLong);
    }
}
