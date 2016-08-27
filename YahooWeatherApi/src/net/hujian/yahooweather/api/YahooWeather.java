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
 */
public class YahooWeather extends YahooWeatherEventSource{

    /**
     * oh,this is very funny,the param is choose-able
     * BUT,THE PARAM'S NUM MUST BE 2 OR 3
     * 1.the param.size is 2,you want to query by position,so the params means [lat,long]
     * 2.the params.size is 3,you want to query by place,so the params means [country,province,city]
     * 3.if the size !=2&&!=3,just tell you wrong happen!
     * @param Args the params choose-able,2||3 size
     */
    public YahooWeather(String... Args){
        this.Params=new StringBuilder();
        /**
         * get the args
         */
        for(String arg:Args){
            this.Params.append(arg+",");
        }
        if(this.Params.toString().endsWith(",")){
            String newp=this.Params.toString();
            newp=newp.substring(0,newp.length()-1);
            this.Params=new StringBuilder(newp);
            YahooWeatherLog.info(this.getClass().getName(),"get the params:"+this.Params.toString());
        }else{
            this.notifyListenerUnknownWrong();
        }
        /*
        try {
            execute();
            YahooWeatherLog.info(this.getClass().getName(),"get the args like this=>"+Args.toString());
        } catch (IOException e) {
            e.printStackTrace();
            YahooWeatherLog.error(this.getClass().getName(),"get the args error!");
        }
        */
    }
    @Override
    public void execute() throws IOException{
        /**
         * this is the jsoup document object
         */
        Document Result=null;
        /**
         * xml parse engine instance
         */
        XMLParseEngine parseEngine=null;
        /**
         * the xml parse result(weather information).
         */
        YahooWeatherInformation WeatherResult=null;
        /**
         * the params
         */
        String params=this.Params.toString();
        /**
         * you want to query by position
         */
        if(params.split(",").length==2){
            YahooWeatherLog.info(this.getClass().getName(),"query by position....");
            Result=GetXMLResponseHandler.queryByLatLong(Double.parseDouble(params.split(",")[0]),
                    Double.parseDouble(params.split(",")[1]));
            parseEngine=new XMLParseEngine(Result);
            WeatherResult=parseEngine.parse();
            /**
             * wrong...
             */
            if(WeatherResult.getError_information().getErrorInformation()!=null){
                YahooWeatherLog.error(this.getClass().getName(),"Error when parse xml file from yahoo.");
                this.notifyListenerOnFailBackFromYahoo(WeatherResult);
            }else{
                YahooWeatherLog.error(this.getClass().getName(),"get the result succeed~");
                this.notifyListenerOnSuccessBackFromYahoo(WeatherResult);
            }
        }
        /**
         * you want to query by place name
         */
        else if(params.split(",").length==3){
            YahooWeatherLog.info(this.getClass().getName(),"query by place....");
            Result=GetXMLResponseHandler.queryByPlaceName(params.split(",")[0],
                    params.split(",")[1],params.split(",")[2]);
            parseEngine=new XMLParseEngine(Result);
            WeatherResult=parseEngine.parse();
            /**
             * wrong...
             */
            if(WeatherResult.getError_information().getErrorInformation()!=null){
                YahooWeatherLog.error(this.getClass().getName(),"Error when parse xml file from yahoo.");
                this.notifyListenerOnFailBackFromYahoo(WeatherResult);
            }else{
                YahooWeatherLog.error(this.getClass().getName(),"get the result succeed~");
                this.notifyListenerOnSuccessBackFromYahoo(WeatherResult);
            }
        }
        /**
         * error params
         */
        else{
            YahooWeatherLog.error(this.getClass().getName(),"Unknown Wrong when parse xml file from yahoo.");
            this.notifyListenerUnknownWrong();
        }
        /**
         * if you want to show the total information from yahoo,just use the following code
         */
        //TestResultHandler.ShowWeatherInformation(info);
    }
}
