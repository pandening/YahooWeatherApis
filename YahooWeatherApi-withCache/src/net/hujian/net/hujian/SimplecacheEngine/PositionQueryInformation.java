package net.hujian.net.hujian.SimplecacheEngine;

/**
 * Created by hujian on 2016/8/29.
 */
public class PositionQueryInformation {
    private String Lat=null;

    /**
     * set lat
     * @param la
     */
    public void setLat(String la){
        this.Lat=la;
    }

    /**
     * set long
     * @return
     */
    public String getLat(){
        return this.Lat;
    }
    private String Long=null;

    /**
     *
     * @param lo
     */
    public  void setLong(String lo){
        this.Long=lo;
    }

    /**
     *
     * @return
     */
    public String getLong(){
        return this.Long;
    }

    /**
     * this is the only constructor of this class
     * @param la lat info
     * @param lo long info
     */
    public PositionQueryInformation(String la,String lo){
        this.setLat(la);
        this.setLong(lo);
    }
    @Override
    public String toString(){
        return this.Lat+","+this.Long;
    }
}
