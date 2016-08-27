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

import java.util.Date;
import java.util.EventObject;

/**
 * Created by hujian on 2016/8/27.
 */
public class YahooWeatherEvent extends EventObject{
    /**
     * sometimes,you should need the time information
     */
    private Date InvokeTime=null;

    private YahooWeatherInformation Result_Weather_Information;

    /**
     * you also need to offer a name for the event object
     */
    private String EventName=null;

    /**
     * Constructor
     * @param eventName the event name
     */
    public YahooWeatherEvent(String eventName){
        //i don't know what's it!
        super(eventName);
        this.EventName=eventName;
        //get the time
        this.InvokeTime=new Date();
        Result_Weather_Information=new YahooWeatherInformation();
    }

    /**
     * another simple constructor
     */
    public YahooWeatherEvent(){
        super(null);
        this.InvokeTime=new Date();
        this.EventName=this.getClass().getName();
        Result_Weather_Information=new YahooWeatherInformation();
    }

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public YahooWeatherEvent(Object source) {
        super(source);
    }

    /**
     * set the weather information
     * @param info
     */
    public void setResult_Weather_Information(YahooWeatherInformation info){
        this.Result_Weather_Information=info;
    }

    /**
     * get the result information
     * @return
     */
    public YahooWeatherInformation getResult_Weather_Information(){
        return this.Result_Weather_Information;
    }
}
