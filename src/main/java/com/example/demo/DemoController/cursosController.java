package com.example.demo.DemoController;

import com.example.demo.DemoEntity.cursosEntity;
import com.example.demo.DemoServices.cursosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos") //-> LA CLASE SE LLAMA CURSOSCONTROLLER EL @REQUES... LO CAMBIA A  "/cursos"
public class cursosController {
    @Autowired
    private cursosRepository curRepo;//cursosRepository ->referencia a la clase a usar curRepo->nombre de la variable
    @GetMapping //-> PRIMER USO GET
    public List<cursosEntity> obtenerCurso (){
        return (List <cursosEntity>) curRepo.findAll();
    }
    @PostMapping //-> SEGUNDO USO
    public void agregarCursos (@RequestBody cursosEntity curEn){
        curRepo.save(curEn);
    }
    @PutMapping //-> TERCER USO
    public void actualizarCurso (@RequestBody cursosEntity curEn) {
        curRepo.save(curEn);
    }
    @DeleteMapping//->CUARTO USO
    public void eliminarCurso(@RequestBody cursosEntity curEn){
        curRepo.deleteById(curEn.getIdcursos());
    }
}
