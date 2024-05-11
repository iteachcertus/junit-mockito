package pe.certus.unitarias.pruebas.app.junitmockito.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import pe.certus.unitarias.pruebas.app.junitmockito.entity.ProductoEntity;
import pe.certus.unitarias.pruebas.app.junitmockito.repository.ProductoRepository;
import pe.certus.unitarias.pruebas.app.junitmockito.service.impl.ProductoServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class ProductoServiceTest 
{
	//Simular
	@Mock
	private ProductoRepository productoRepository;
	
	//Inyectar la simular
	@InjectMocks
	private ProductoServiceImpl productoService;
	
	private ProductoEntity productoEntity;
	
	@BeforeEach
	void setUp()
	{
		productoEntity =  new ProductoEntity();
		productoEntity.setNombre("Televisor LG 50'");
		productoEntity.setPrecio(3500.00);
		productoEntity.setCantidad(10);
		
	}
	
	
	@DisplayName("Guardar un producto mockeado desde el servicio")
	@Test
	void guardarProductoServiceTest()
	{
		//given
		given(productoRepository.save(productoEntity)).willReturn(productoEntity);
		//when
		ProductoEntity productoGuardado = productoService.guardar(productoEntity);
		//then
		assertThat(productoGuardado).isNotNull();
		
	}

}
