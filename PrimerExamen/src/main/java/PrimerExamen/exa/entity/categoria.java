 
package PrimerExamen.exa.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/*Esta clase debe hacer referencia a las tablas de la base de datos y se encarga de traer la tabla como objetos*/

//patrón decorador, permite modificar el comportamiento en el tiempo de ejecución*//
@Entity
@Table(name = "categoria")
public class categoria implements Serializable{
        
    @Id
    // linea para incrementar autoincrementa de manera automatica el ID para no tener que hacerlo manualmente
  
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; //id de la tabla
    private String categoria; //columna cate

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    }

    