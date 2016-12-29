package ua.com.Web_Shop.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.Web_Shop.entity.City;

public interface CityDao  extends JpaRepository<City, Integer>{
	
	@Query("select distinct c from City c left join fetch  c.streets ct")
	List<City> findCityWithStreets();
	
	@Query("select  c from City c left join c.streets ct where c.id =:id")
	City findCityWithstreets(@Param("id")int id);



	


}
