package apidiasfestivo.apidiasfestivos.core.interfaces.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apidiasfestivo.apidiasfestivos.core.dominio.festivo;

@Repository
public interface festivoRepositorio extends JpaRepository<festivo,Integer> {
    
}
