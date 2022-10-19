/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PrimerExamen.exa.controller;


import PrimerExamen.exa.entity.categoria;
import PrimerExamen.exa.entity.datos;
import PrimerExamen.exa.service.IcategoriaService;
import PrimerExamen.exa.service.IdatosService;
import PrimerExamen.exa.service.categoriaService;
import PrimerExamen.exa.service.datosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class controlador{
    
    @Autowired
    private IcategoriaService CateService;
    
    @Autowired
    private IdatosService DatoService;

    @GetMapping("/datos")
//   endpoint
//    El index es irrelevante
//    Recibe un objeto de tipo model, este se encarga de pasar la información del back al front

    public String index(Model model){
        //Se usa para retornar la lista de personas
        List<datos> listaList = datosService.getAlldatos();     
        model.addAttribute("titulo", "Tabla");       
        model.addAttribute("datos", listaList);
        return "datos";
    }
    
    @GetMapping("/categoria")
    public String crear(Model model){
        List<categoria> listaCate = categoriaService.Lista();
        model.addAttribute("categoria", new categoria());
        model.addAttribute("datos", listaCate);
        return "crear";
    }
    
    //Se usa para agregar información
    @PostMapping("/save")
    //@ModelAttribute se usa para especificar que el objeto de tipo persona viene del frontend
    public String guardardato(@ModelAttribute datos Dato){
        datosService.savedatos(Dato);
        return  "redirect:/datos";
    }
    
    //Cuando se le pasa el id se va a buscar para editarlo
    @GetMapping("/editdatos/{id}")
    //@PathVariable indica que ese parametro varia
    public String editardatos(@PathVariable("id") Long id, Model model){      
        categoria Cate= categoriaService.getcategoriaByID(id);
        List<datos> lista = datosService.Lista();
        //Sustituye en el html 
        model.addAttribute("categoria", categoria);
        model.addAttribute("datos", dato);
        //regresa a crear
        return "crear";
    }
    
    @GetMapping("/delete/{id}")
    public String eliminardatos(@PathVariable("id") Long iddatos){
        datosService.delete(iddatos);
        return "redirect:/persona";
    }
}

