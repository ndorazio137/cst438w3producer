package cst438.domain;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

// Helper class.
public class TimeAndTemp {
   public double temp;
   public long time;
   public int timezone;
   public String adjustedTime;
   public String adjustedTemp;

   public TimeAndTemp(double temp, long time, int timezone) {
      this.temp = temp;
      this.time = time;
      this.timezone = timezone;
   }

   public String adjustTime(TimeAndTemp timeAndTemp) {
      SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
      TimeZone tz = TimeZone.getTimeZone("UTC");
      tz.setRawOffset(timeAndTemp.timezone * 1000);
      sdf.setTimeZone(tz);
      Date date = new Date(timeAndTemp.time * 1000);
      return sdf.format(date);
   }

   public String adjustTempToFahrenheit(TimeAndTemp timeAndTemp) {
      String tempString = String.valueOf(getTempInFahrenheit(temp)) + " " + getFahrenheitSymbol();
      return tempString;
   }

   public String adjustTempToCelsius(TimeAndTemp timeAndTemp) {
      String tempString = String.valueOf(temp - 273.15) + " " + getCelsiusSymbol();
      return tempString;
   }

   public double getTemp() {
      return temp;
   }

   public long getTime() {
      return time;
   }

   public int getTimezone() {
      return timezone;
   }

   public String getAdjustedTime() {
      return adjustedTime;
   }

   public String getAdjustedTemp() {
      return adjustedTemp;
   }

   public void setTemp(double temp) {
      this.temp = temp;
   }

   public void setTime(long time) {
      this.time = time;
   }

   public void setTimezone(int timezone){
      this.timezone = timezone;
   }

   public void setAdjustedTime(String adjustedTime) {
      this.adjustedTime = adjustedTime;
   }

   public void setAdjustedTemp(String adjustedTemp) {
      this.adjustedTemp = adjustedTemp;
   }

   private double getTempInFahrenheit(double temp) {
      double fahrenheit = (temp - 273.15) * 9.0/5.0 + 32.0;
      DecimalFormat format = new DecimalFormat("#.00");
      return new Double(format.format(fahrenheit));
   }
   
   private static String getFahrenheitSymbol() {
      String symbol = "\u2109";
      return symbol;
   }

   private static String getCelsiusSymbol() {
      String symbol = "\u2103";
      return symbol;
   }

   @Override
   public String toString() {
      return "TimeAndTemp [temp=" + temp + ", time=" + time + ", timezone="
            + timezone + "]";
   }
}