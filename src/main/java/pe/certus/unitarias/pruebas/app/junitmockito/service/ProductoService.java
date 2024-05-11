package pe.certus.unitarias.pruebas.app.junitmockito.service;

import java.util.List;
import java.util.Optional;

import pe.certus.unitarias.pruebas.app.junitmockito.entity.ProductoEntity;

public interface ProductoService 
{
	public ProductoEntity guardar(ProductoEntity productoEntity);
	
	public ProductoEntity actualizar(ProductoEntity productoEntity);
	
	public void eliminar(Long id);
	
	public List<ProductoEntity> listar();
	
	public Optional<ProductoEntity> buscarPorId(Long id);
	

}
