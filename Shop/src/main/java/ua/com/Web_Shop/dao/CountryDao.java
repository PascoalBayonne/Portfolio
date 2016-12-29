package ua.com.Web_Shop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.Web_Shop.entity.Country;

public interface CountryDao extends JpaRepository<Country, Integer>{
	
	@Query("select distinct c from Country c left join fetch  c.cities ct")
	List<Country> findCountryWithCities();
	
	@Query("select  c from Country c left join c.cities ct where c.id =:id")
	Country findCountryWithCity(@Param("id") int id);
	
}
