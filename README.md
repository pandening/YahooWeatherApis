YahooWeatherApis
====================
A Simple,Simple,Yahoo Weather Api.    
#what is it?
  This ia a yahoo weather api engine for java,you can get the weather information from yahoo   
  by this little library(just like library,i do not think this is a java library).you can also    
  use this engine in your android project to get the weather info.    
  And this is a very simple engine,you can read the source code to understand the connection of   
  classs.   
####1.the Aim of this library is to simply the programming for getting weather information.   
####2.the another of this library is to get more weather information.   
  so,if you want to get much weather information and just want to use a interface to get the whole     
  what you want.you can clone it,and use it.    
#how to use it?   
  this is the key question i am care about.simple,just simple,there are 2 ways to set up your app   
  with this library:  
##one way is just like this 
```
//YahooWeather yh=new YahooWeather("chian","yunnan","kunming");
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
```
##another way to set up :
```
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
```
so,are you ready to use this little ,simple 'library' in your project?
Developer
======================
HuJian(nankai university,computer science) E-mail:<1425124481@qq.com>

update information
======================
##2016/8/29
  update the library,add a another library with a simple Cache.so,if you need the cache for your    
  app,just use the new version lib.or,just choose the old version(stable).
###how to set up my app with the new library?
  there is a another demo for this lib for you to learn<https://github.com/pandening/YahooWeatherApis/blob/master/YahooWeatherApi-withCache/src/net/hujian/yahoo/weather/api/example/ExampleForThisYahooApi.java>,it's easy to use ,too.    
  or,you can just see below codes to work your demo out.
```
 YahooWeatherCacheHandler cache=new YahooWeatherCacheHandler(true,1000,1000);
        /**
         * the way to use this library~
         */
        //source
        YahooWeather yh=new YahooWeather(cache,"china","yunnan","kunming");
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
        /**
         * you also can use this code to query by this engine~
         */
        YahooWeather yho=new YahooWeather(cache,"China","Yunnan","Kunming");
        try {
            yho.setListenerOnYahooWeather(new YahooWeatherListener() {
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
```
  for more detials of this new version,just check the source code in new folder.

License
==================
```
Copyright 2016 HuJian

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
 
