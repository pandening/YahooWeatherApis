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
 * also,if you want to expand this project.
 * such as offer the error information etc.
 * just use the instance of this class
 */
public class ErrorInformation{
    /**
     * this is the error information
     */
    private String errorInformation=null;

    /**
     *
     * @param err
     */
    public void setErrorInformation(String err){
        this.errorInformation=err;
    }
    /**
     *
     * @return
     */
    public String getErrorInformation(){
        return this.errorInformation;
    }
    /**
     * so,you should put a error str by constructor.or just set!
     * @param error
     */
    public ErrorInformation(String error){
        this.setErrorInformation(error);
    }
}
