 
package PrimerExamen.exa.service;


import PrimerExamen.exa.entity.datos;
import PrimerExamen.exa.repository.datosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

    @Service 
    public abstract class datosService implements IdatosService{ 
      
    @Autowired
    private datosRepository datoRepository;
       
    @Override
    public List<datos> getAlldatos() {
        return (List<datos>) datoRepository.findAll();
    }

    @Override
    public datos getdatosByID(long id) {
         return datoRepository.findById(id).orElse(null);
    }

    @Override
    public void savedatos(datos datos) {
        return datoRepository.save(datos);
    }

    @Override
    public void delete(long id) {
        return datoRepository.deleteById(id);
       
    }
   
    }