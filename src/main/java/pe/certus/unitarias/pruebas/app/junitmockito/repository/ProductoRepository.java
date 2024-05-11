package pe.certus.unitarias.pruebas.app.junitmockito.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.certus.unitarias.pruebas.app.junitmockito.entity.ProductoEntity;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Long>
{
	Optional<ProductoEntity> findByNombre(String nombre);

}
