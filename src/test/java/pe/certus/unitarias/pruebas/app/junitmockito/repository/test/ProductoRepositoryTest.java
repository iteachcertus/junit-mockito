package pe.certus.unitarias.pruebas.app.junitmockito.repository.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import pe.certus.unitarias.pruebas.app.junitmockito.entity.ProductoEntity;
import pe.certus.unitarias.pruebas.app.junitmockito.repository.ProductoRepository;

@DataJpaTest
public class ProductoRepositoryTest 
{
	@Autowired
	private ProductoRepository productoRepository;
	
	
	private ProductoEntity productoEntity;
	
	@BeforeEach
	void setUp()
	{
		productoEntity =  new ProductoEntity();
		productoEntity.setNombre("Televisor LG 50'");
		productoEntity.setPrecio(3500.00);
		productoEntity.setCantidad(10);
		
	}
	
	@Test
	void guardarProductoTest()
	{
		//given : Configuración de mi objeto Producto
		ProductoEntity productoEntity = new ProductoEntity();
		productoEntity.setNombre("Televisor Samsumg 50'");
		productoEntity.setPrecio(2500.00);
		productoEntity.setCantidad(3);
		
		//when: comprobamos el comportamiento a probar
		ProductoEntity productoGuardar = productoRepository.save(productoEntity);
		
		//then (verificar la salida)
		assertThat(productoGuardar).isNotNull();
		assertThat(productoGuardar.getId()).isGreaterThan(0);
		
		
	}
	
	@DisplayName("Pruebas para listar productos")
	@Test
	void listarProductosTest()
	{
		//given
		ProductoEntity producto3 = new ProductoEntity();
		producto3.setNombre("Laptop HP");
		producto3.setPrecio(4500.00);
		producto3.setCantidad(5);
		
		productoRepository.save(producto3);
		productoRepository.save(productoEntity);
		
		
		//when
		List<ProductoEntity> listarProductos = productoRepository.findAll();
		
		//then
		assertThat(listarProductos).isNotNull();
		assertThat(listarProductos.size()).isEqualTo(2);

	}
	

}
