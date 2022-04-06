package shopnoithat.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shopnoithat.DTO.ProductsDTO;
import shopnoithat.Entity.Catogorys;
import shopnoithat.Entity.Slides;

@Service
public interface IHomeService {
	@Autowired
	public List<Slides> GetDataSlide();
	public List<Catogorys> GetDataCatogorys();
	public List<ProductsDTO> GetDataProducts();
	public List<ProductsDTO> GetAllProducts();
	public List<ProductsDTO> GetSearchProducts(String name);
}
