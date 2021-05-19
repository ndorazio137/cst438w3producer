package cst438.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import cst438.domain.CityInfo;
import cst438.service.CityService;

@RestController
public class CityRestController {
   
   @Autowired
   private CityService cityService;
   
   @GetMapping("/api/cities/{city}")
   public CityInfo getWeather(@PathVariable("city") String cityName) {
     
      // Get a CityInfo object from cityService checking the database.
      CityInfo cityInfo = cityService.getCityInfo(cityName);
      if (cityInfo == null) {
         // On error return 404 error.
         throw new ResponseStatusException(
               HttpStatus.NOT_FOUND, "The city " +cityName+ " not found.");
      } else {
         return cityInfo;
      }
   }
}
