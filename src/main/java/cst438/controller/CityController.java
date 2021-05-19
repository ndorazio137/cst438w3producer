package cst438.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cst438.domain.CityInfo;
import cst438.service.CityService;

@Controller
public class CityController {
   
   @Autowired
   private CityService cityService;
   
   @GetMapping("/cities/{city}")
   public String getCityInfo(@PathVariable("city") String cityName,
         Model model) {
      // Get a CityInfo object from cityService checking the database.
      CityInfo cityInfo = cityService.getCityInfo(cityName);
      
      // if no city object render 404 error page.
      if (cityInfo == null) {
         return "page_not_found";
      }
      
      // when city object exists render city.html page.
      model.addAttribute("cityInfoModel", cityInfo);
      return "city";
   }
   
   @PostMapping("/cities/reservation")
   public String createReservation(
      @RequestParam("city") String cityName,
      @RequestParam("level") String level,
      @RequestParam("email") String email, Model model) {
         model.addAttribute("city", cityName);
         model.addAttribute("level", level);
         model.addAttribute("email", email);
         cityService.requestReservation(cityName, level, email);
         return "request_reservation";
   }
}