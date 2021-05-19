package cst438.service;

//********* Static imports ***************
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;
//******** Non-Static imports ***********
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import cst438.domain.City;
import cst438.domain.CityInfo;
import cst438.domain.CityRepository;
import cst438.domain.Country;
import cst438.domain.TimeAndTemp;

@WebMvcTest(CityServiceTest.class)
public class CityServiceTest {
   //*********MOCKBEANS*************
   @MockBean
   private CityRepository cityRepository;
   
   @MockBean
   private WeatherService weatherService;

   //*********TEST CASES***********
   @Test
   public void testNullCity() throws Exception {
      // Create an empty response array
      List<City> cities = new ArrayList<City>();
      
      // return the empty array on 
      given(cityRepository.findByName("TestCity")).willReturn(cities);
      
      // Create a CityService class with MockBeans for repositories
      CityService cityService = new CityService(cityRepository, weatherService);
      
      // Check that the expected value is null
      assertThat(cityService.getCityInfo("TestCity")).isEqualTo(null);
   }
   
   @Test
   public void testSingleCity() throws Exception {
      // Create test City
      Country country = new Country("TST", "Test Country");
      City city = new City(1, "TestCity", "DistrictTest", 300000, country);
      
      // Add city to cities list
      List<City> cities = new ArrayList<City>();
      cities.add(city);
      
      // Create Test weather
      TimeAndTemp timeAndTemp = new TimeAndTemp(284.78,1000000001,-14200);
      
      // Create Expected return value from CityService
      CityInfo expectedResult = new CityInfo(city, country, timeAndTemp);
      
      // Test return results of each dependency
      given(cityRepository.findByName("TestCity")).willReturn(cities);
      given(weatherService.getTempAndTime("TestCity")).willReturn(timeAndTemp);
      
      // Create a CityService class with MockBeans for repositories
      CityService cityService = new CityService(cityRepository, weatherService);
      
      // Check that the expected value is the original city
      assertThat(cityService.getCityInfo("TestCity")).isEqualTo(expectedResult);
   }
   
   @Test
   public void testCitiesList() throws Exception {
      // Create Cities with different names.
      Country country1 = new Country("TST", "Test Country");
      City city1 = new City(1, "TestCity", "DistrictTest", 300000, country1);
      Country country2 = new Country("TST", "Test Country");
      City city2 = new City(1, "TestCity2", "DistrictTest", 300000, country2);
      Country country3 = new Country("TST", "Test Country");
      City city3 = new City(1, "TestCity3", "DistrictTest", 300000, country3);
      
      // Add cities to cities list
      List<City> cities = new ArrayList<City>();
      cities.add(city1);
      cities.add(city2);
      cities.add(city3);
      
      // Create Test weather
      TimeAndTemp timeAndTemp = new TimeAndTemp(284.71,1000000001,-14201);
      
      // Create Expected return value from CityService
      CityInfo expectedResult = new CityInfo(city1, country1, timeAndTemp);
      
      // Test return results of each dependency
      given(cityRepository.findByName("TestCity")).willReturn(cities);
      given(weatherService.getTempAndTime("TestCity")).willReturn(timeAndTemp);
      
      // Create a CityService class with MockBeans for repositories
      CityService cityService = new CityService(cityRepository, weatherService);
      
      // Check that the expected value is the original city named "TestCIty"
      assertThat(cityService.getCityInfo("TestCity")).isEqualTo(expectedResult);
   }
   
   @Test
   public void testCitiesListWithDuplicates() throws Exception {
      // Create Cities all with the same name.
      Country country1 = new Country("TST", "Test Country1");
      City city1 = new City(1, "TestCity", "DistrictTest", 300000, country1);
      Country country2 = new Country("TST", "Test Country2");
      City city2 = new City(2, "TestCity", "DistrictTest", 400000, country2);
      Country country3 = new Country("TST", "Test Country3");
      City city3 = new City(3, "TestCity", "DistrictTest", 500000, country3);
      
      // Add cities to cities list
      List<City> cities = new ArrayList<City>();
      cities.add(city1);
      cities.add(city2);
      cities.add(city3);
      
      // Create Test weather
      TimeAndTemp timeAndTemp = new TimeAndTemp(284.71,1000000001,-14201);
      
      // Create Expected return value from CityService
      CityInfo expectedResult = new CityInfo(city1, country1, timeAndTemp);
      
      // Test return results of each dependency
      given(cityRepository.findByName("TestCity")).willReturn(cities);
      given(weatherService.getTempAndTime("TestCity")).willReturn(timeAndTemp);
      
      // Create a CityService class with MockBeans for repositories
      CityService cityService = new CityService(cityRepository, weatherService);
      
      // Check that the expected value is the first original city named in the list.
      assertThat(cityService.getCityInfo("TestCity")).isEqualTo(expectedResult);
   }
}
