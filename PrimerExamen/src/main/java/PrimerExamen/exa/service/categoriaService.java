
package PrimerExamen.exa.service;

import PrimerExamen.exa.entity.categoria;
import PrimerExamen.exa.entity.datos;
import PrimerExamen.exa.repository.categoriaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public  class categoriaService implements IcategoriaService{
  
    @Autowired //deberia haber conexión entre los objetos Service y Repository
    private categoriaRepository CateRepository;

    @Override
    public List<categoria> Lista() {
        return (List<categoria>) CateRepository.findAll();
    }

}
    

