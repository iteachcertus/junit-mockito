package pe.certus.unitarias.pruebas.app.junitmockito.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.certus.unitarias.pruebas.app.junitmockito.entity.ProductoEntity;
import pe.certus.unitarias.pruebas.app.junitmockito.repository.ProductoRepository;
import pe.certus.unitarias.pruebas.app.junitmockito.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService
{
	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public ProductoEntity guardar(ProductoEntity productoEntity) {
		//Optional<ProductoEntity> produtoExiste = productoRepository.findByNombre(productoEntity.toString().get)
		return productoRepository.save(productoEntity);
	}

	@Override
	public ProductoEntity actualizar(ProductoEntity productoEntity) {
		return productoRepository.save(productoEntity);
	}

	@Override
	public void eliminar(Long id) {
		productoRepository.deleteById(id);
		
	}

	@Override
	public List<ProductoEntity> listar() {
		return productoRepository.findAll();
	}

	@Override
	public Optional<ProductoEntity> buscarPorId(Long id) {
		return productoRepository.findById(id);
	}

}
