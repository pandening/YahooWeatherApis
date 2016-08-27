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

/**
 * Created by hujian on 2016/8/27.
 */
public class YahooWeatherLog {
    private static boolean isSetup=false;
    //set up the logger
    public static void setLogger(boolean is){
        isSetup=is;
    }
    //info
    public static void info(String tag,String msg){
        if(isSetup){
            System.out.println("[info@" + tag + "_" + (new Date())+"]"+msg);
        }
    }
    //debug
    public static void debug(String tag,String msg){
        if(isSetup){
            System.out.println("[debug@" + tag + "_" + (new Date())+"]"+msg);
        }
    }
    //error
    public static void error(String tag,String msg){
        if(isSetup){
            System.out.println("[error@" + tag + "_" + (new Date())+"]"+msg);
        }
    }
}
