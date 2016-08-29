package net.hujian.net.hujian.SimplecacheEngine;

/**
 * Created by hujian on 2016/8/29.
 */
public class PlaceQueryInformation {
    private String Country=null;
    /**
     *
     * @param country
     */
    public void setCountry(String country){
        this.Country=country;
    }
    /**
     *
     * @return
     */
    public String getCountry(){
        return this.Country;
    }
    private String Province=null;

    /**
     *
     * @param province
     */
    public void setProvince(String province){
        this.Province=province;
    }

    /**
     *
     * @return
     */
    public String getProvince(){
        return this.Province;
    }
    private String City=null;

    /**
     *
     * @param city
     */
    public void setCity(String city){
        this.City=city;
    }

    /**
     *
     * @return
     */
    public String getCity(){
        return this.City;
    }

    /**
     * very simple constructor
     */
    public PlaceQueryInformation(){
        this(null,null,null);
    }

    /**
     * for some reasons,you just need to set the city such as shanghai
     * @param city
     */
    public PlaceQueryInformation(String city){
        this("c","p",city);
    }
    /**
     * such as shanghai.
     * @param country
     * @param city
     */
    public PlaceQueryInformation(String country,String city){
        this(country,"p",city);
    }
    /**
     * the very powerful constructor
     * @param co country
     * @param pr province
     * @param ci city
     */
    public PlaceQueryInformation(String co,String pr,String ci){
        this.setCountry(co);
        this.setProvince(pr);
        this.setCity(ci);
    }
    @Override
    public String toString(){
        return this.Country+","+this.Province+","+this.City;
    }
}
