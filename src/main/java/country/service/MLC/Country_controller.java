package country.service.MLC;

import AddResponse.AddResponse;
import Bean.Country;
import Country_servies.Country_Services;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Country_controller {
    Country_Services cs=new Country_Services();
    @GetMapping("/getcountries")
    public List<Country> getCountries(){

        return cs.getAllCountries();
    }
    @GetMapping("/getcountries/{id}")
    public ResponseEntity<Country> getCountriesByID(@PathVariable(value = "id") int id){
       try{
        Country country=cs.getCountrybyID(id);
        return new ResponseEntity<Country>(country, HttpStatus.OK);

        }
           catch(Exception E){

               return new ResponseEntity<Country>( HttpStatus.NOT_FOUND);

        }
    }

    @GetMapping("/getcountries/countryName")
    public ResponseEntity<Country> getCountriesByName(@RequestParam String countryName){
        try {
            Country country = cs.getCountrybyName(countryName);
            return new ResponseEntity<Country>(country, HttpStatus.OK);
        }
        catch (Exception E){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }


    }
    @PostMapping("/addcountry")
    public Country addcountry( @RequestBody Country contry) {
        return cs.addCountry(contry);

    }
    @PutMapping("/updatecountry")
    public ResponseEntity<Country> updatecountry(@PathVariable(value = "id") int id, @RequestBody Country contry) {
       try {
           Country exitingcontry = cs.getCountrybyID(id);
           String con = contry.getCountryName();
           String CP = contry.getCountryCapital();
           exitingcontry.setCountryName(con);
           exitingcontry.setCountryCapital(CP);
           Country updated = cs.updateCountry(exitingcontry);
           return new ResponseEntity<Country>(updated, HttpStatus.OK);
       }
       catch (Exception e){
           return new ResponseEntity<Country>(HttpStatus.NOT_FOUND);
       }


    }
    @DeleteMapping("/deletecountry/{id}")
    public AddResponse deletcountry(@PathVariable(value = "id")int id){
      return   cs.DeleteCountry(id);
    }



}
