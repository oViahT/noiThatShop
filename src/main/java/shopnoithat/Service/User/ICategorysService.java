package shopnoithat.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import shopnoithat.DTO.ProductsDTO;

@Service
public interface ICategorysService {
	public List<ProductsDTO> GetAllProductsByID(int id);
	public List<ProductsDTO> GetDataProductsPaginate(int id, int start, int end);
}
