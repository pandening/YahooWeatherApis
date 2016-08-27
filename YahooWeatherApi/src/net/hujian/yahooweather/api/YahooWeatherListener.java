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

import java.util.EventListener;

/**
 * Created by hujian on 2016/8/27.
 * this is the yahoo weather  listener interface.
 */
public interface YahooWeatherListener extends EventListener{
    /**
     * so,you need to implement this process when you want to get the
     * result.
     * @param event the get event.so,just start to parse the data to get.
     */
    public void getYahooWeatherFromSite(YahooWeatherEvent event);

    /**
     * ok,this interface function will tell you when something error
     * such as no-network etc.
     * @param event the source event happen
     */
    public void errorYahooWeatherResult(YahooWeatherEvent event);

    /**
     * i want to do more thing
     */
    public void unknownWrongFromClient();
}
