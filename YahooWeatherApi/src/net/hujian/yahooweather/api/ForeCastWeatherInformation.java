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
 * the forecast weather information data structure
 */
class ForeCastWeatherInformation{
    /**
     * the weather status
     */
    private String forecast_weather_status;
    /**
     * the date
     */
    private String forecast_date;
    /**
     * the day
     */
    private String forecast_day;
    /**
     * low temperature
     */
    private String low_temperature;
    /**
     * the high temperature
     */
    private String high_temperature;

    /**
     * set the status
     * @param status weather status
     */
    public void setForecast_weather_status(String status){
        this.forecast_weather_status=status;
    }

    /**
     * get the weather status
     * @return the weather status
     */
    public String getForecast_weather_status(){
        return this.forecast_weather_status;
    }

    /**
     * set the date
     * @param date
     */
    public void setForecast_date(String date){
        this.forecast_date=date;
    }

    /**
     * get the forecast data
     * @return
     */
    public String getForecast_date(){
        return this.forecast_date;
    }

    /**
     * set the high temperature
     * @param high
     */
    public void setHigh_temperature(String high){
        this.high_temperature=high;
    }

    /**
     * get the high temperature
     * @return
     */
    public String getHigh_temperature(){
        return this.high_temperature;
    }

    /**
     * @param low
     */
    public void setLow_temperature(String low){
        this.low_temperature=low;
    }

    /**
     * get the low temperature of the day
     * @return
     */
    public String getLow_temperature(){
        return this.low_temperature;
    }

    /**
     *
     * @param dy
     */
    public void setForecast_day(String dy){
        this.forecast_day=dy;
    }

    /**
     *
     * @return
     */
    public String getForecast_day(){
        return this.forecast_day;
    }
}