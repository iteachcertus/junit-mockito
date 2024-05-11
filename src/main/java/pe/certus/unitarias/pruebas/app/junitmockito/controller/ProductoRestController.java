package pe.certus.unitarias.pruebas.app.junitmockito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pe.certus.unitarias.pruebas.app.junitmockito.entity.ProductoEntity;
import pe.certus.unitarias.pruebas.app.junitmockito.service.ProductoService;

@RequestMapping("/productos")
@RestController
public class ProductoRestController 
{
	@Autowired
	private ProductoService productoService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProductoEntity guardar(@RequestBody ProductoEntity productoEntiy)
	{
		return productoService.guardar(productoEntiy);
		
	}
	
	/*
	public ProductoEntity actualizar(ProductoEntity productoEntity);
	
	public void eliminar(Long id);
	
	public List<ProductoEntity> listar();
	
	public Optional<ProductoEntity> buscarPorId(Long id);
*/
}
