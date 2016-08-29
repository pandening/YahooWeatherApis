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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hujian on 2016/8/27.
 */
public class YahooWeatherEventSource {
    //this is the listener list,i will notify all when happen something
    //the listener care about
    private List<YahooWeatherListener> Listeners=new ArrayList<YahooWeatherListener>();
    /**
     * create the param
     */
    protected StringBuilder Params=null;

    /**
     * you can add a listener on this source by following api
     * @param listener the listener set param
     */
    public void setListenerOnYahooWeather(YahooWeatherListener listener) throws IOException{
        YahooWeatherLog.info(this.getClass().getName(),"register a listener ok.");
        Listeners.add(listener);
        this.execute();
    }


    /**
     * notify to the listeners,i am succeed!
     * @param weatherInformation the result information
     */
    protected void notifyListenerOnSuccessBackFromYahoo(YahooWeatherInformation weatherInformation){
        for(YahooWeatherListener listener:Listeners){
            YahooWeatherEvent event=new YahooWeatherEvent(this);
            event.setResult_Weather_Information(weatherInformation);
            listener.getYahooWeatherFromSite(event);
        }
    }

    /**
     * for now,i just don't like to implement the function
     * maybe i will write it soon~
     *
     * Append:add this handler for unknown error
     */
    protected  void notifyListenerUnknownWrong(){
        for(YahooWeatherListener listener:Listeners){
            listener.unknownWrongFromClient();
        }
    }

    /**
      *when you want to tell the listener something error happened
      *just call this function to notify error
      *this function is protected,so just can be used by me:(:
      * @param weatherInformation the weather information
     */
    protected void notifyListenerOnFailBackFromYahoo(YahooWeatherInformation weatherInformation){
        for(YahooWeatherListener listener:Listeners){
            YahooWeatherEvent event=new YahooWeatherEvent(this);
            event.setResult_Weather_Information(weatherInformation);
            listener.errorYahooWeatherResult(event);
        }
    }

    /**
     * please override this function to notify the listeners
     * on this event source.
     */
    public void execute() throws IOException{
        //ToDo...
    }

    /**
     *
     * @return the listeners list
     */
    public List<YahooWeatherListener> getListeners(){
        return this.Listeners;
    }
}
