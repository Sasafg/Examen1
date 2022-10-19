 
package PrimerExamen.exa.service;

import PrimerExamen.exa.entity.datos;
import PrimerExamen.exa.repository.categoriaRepository;
import java.util.List;

 
public interface IdatosService {
     public List<datosService> getAlldatosList();
    public datos getdatosByID(long id);
    public void savedatos(datos datos);
    public void delete(long id);
    
}
