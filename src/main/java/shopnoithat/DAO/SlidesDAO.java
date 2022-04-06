package shopnoithat.DAO;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import shopnoithat.Entity.MapperSlides;
import shopnoithat.Entity.Slides;

@Repository
public class SlidesDAO extends BaseDAO{
	
	// hien danh sach san pham de co the chay tren slides trang
	public List<Slides> GetDataSlide(){
		List<Slides> listSlides = new ArrayList<Slides>();
		String sql ="SELECT * FROM slide";
		listSlides = _jdbcTemplate.query(sql, new MapperSlides());
		
		return listSlides;
	}
}
