package Country_servies;

import AddResponse.AddResponse;
import Bean.Country;
import country.service.MLC.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Country_Services {
    @Autowired(required = true)
    CountryRepository countryrep;


    public List<Country> getAllCountries() {

        return countryrep.findAll();


    }

    public Country getCountrybyID(int id) {
       return countryrep.findById(id).get();
    }

    public Country getCountrybyName(String countryName) {
    List <Country> contries=countryrep.findAll();
    Country con=null;
        for (Country contry:contries
             ) { if(contry.getCountryName().equals(countryName)){
                 con=contry;
        }

        }
        return con;


    }
    public Country addCountry(Country country) {
       country.setId(getmaxID());
       countryrep.save(country);
       return country;


    }
    public Country updateCountry(Country con) {
        countryrep.save(con);
        return con;

    }

    public AddResponse	DeleteCountry(int id) {

       countryrep.deleteById(id);
       AddResponse response=new AddResponse();
       response.setMsg("country deleted");
       response.setId(id);
       return response;
    }


    //Utility method to get max id

    public  int getmaxID() {

       return countryrep.findAll().size()+1;
    }







}

