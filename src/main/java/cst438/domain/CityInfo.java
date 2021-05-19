package cst438.domain;

// Helper class.
public class CityInfo {
   // Dependent on:
   private City city;
   private Country country;
   private TimeAndTemp timeAndTemp;
   
   public CityInfo(City city, Country country, TimeAndTemp timeAndTemp) {
      this.city = city;
      this.country = country;
      this.timeAndTemp = timeAndTemp;
   }

   public City getCity() {
      return city;
   }

   public Country getCountry() {
      return country;
   }

   public TimeAndTemp getTimeAndTemp() {
      return timeAndTemp;
   }
   
   public void setTimeAndTemp(TimeAndTemp timeAndTemp)
   {
      this.timeAndTemp = timeAndTemp;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      
      if (obj == null)
         return false;
      
      if (getClass() != obj.getClass())
         return false;
      
      CityInfo other = (CityInfo) obj;
      
      if (city == null) {
         if (other.city != null)
            return false;
      } else if (!city.equals(other.city))
         return false;
      
      if (country == null) {
         if (other.country != null)
            return false;
      } else if (!country.equals(other.country))
         return false;
      
      if (timeAndTemp == null) {
         if (other.timeAndTemp != null)
            return false;
      } else if (!timeAndTemp.equals(other.timeAndTemp))
         return false;
      
      return true;
   }

   @Override
   public String toString() {
      return "CityInfo [getCity()=" + getCity().toString() + ", getCountry()="
            + getCountry().toString() + ", getTimeAndTemp()=" + getTimeAndTemp().toString() + "]";
   }
}
