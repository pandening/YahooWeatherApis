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
package net.hujian.yahoo.weather.api.example;

import net.hujian.yahooweather.api.*;
import java.io.IOException;

/**
 * Created by Administrator on 2016/8/27.
 */
public class ExampleForThisYahooApi {
    public static void main(String[] args){
        //set up the logger
        YahooWeatherLog.setLogger(true);
        /**
         * the way to use this library~
         */
        //source
        //YahooWeather yh=new YahooWeather("chian","yunnan","kunming");
        /*
        YahooWeather yh=new YahooWeather("40","90");
        YahooWeatherListener ls=new YahooWeatherListener() {
            @Override
            public void getYahooWeatherFromSite(YahooWeatherEvent event) {
                System.out.println("Show the Result.");
               //just show the information
                ShowTotalInformation.ShowWeatherInformation(event.getResult_Weather_Information());
            }
            @Override
            public void errorYahooWeatherResult(YahooWeatherEvent event) {
               System.out.println("Error:" + event.getResult_Weather_Information().
                       getError_information().getErrorInformation());
            }

            @Override
            public void unknownWrongFromClient() {
                System.out.println("Unknown Error~");
            }
        };
        try {
            yh.setListenerOnYahooWeather(ls);
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        /**
         * you also can use this code to query by this engine~
         */
        //YahooWeather yh=new YahooWeather("chian","yunnan","kunming");
        YahooWeather yhh=new YahooWeather("40","70");
        try {
            yhh.setListenerOnYahooWeather(new YahooWeatherListener() {
                @Override
                public void getYahooWeatherFromSite(YahooWeatherEvent event) {
                    System.out.println("Show the Result.");
                    //just show the information
                    ShowTotalInformation.ShowWeatherInformation(event.getResult_Weather_Information());
                }

                @Override
                public void errorYahooWeatherResult(YahooWeatherEvent event) {
                    System.out.println("Error:" + event.getResult_Weather_Information().
                            getError_information().getErrorInformation());
                }

                @Override
                public void unknownWrongFromClient() {
                    System.out.println("Unknown Error~");
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
