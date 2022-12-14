package com.example.demo.DemoController;

import com.example.demo.DemoEntity.estudianteEntity;
import com.example.demo.DemoServices.estudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.module.ResolutionException;
import java.util.List;

@RestController
@RequestMapping("/estudiante") //-> LA CLASE SE LLAMA estudianteController EL @REQUES... LO CAMBIA A  "//estudiante"
public class estudianteController {
    @Autowired
    private estudianteRepository estRepo;//estudianteRepository ->referencia a la clase a usar estRepo->nombre de la variable
    @GetMapping //-> PRIMER USO GET
    public List<estudianteEntity> obtenerEstudiante (){
        return (List <estudianteEntity>) estRepo.findAll();
    }
    @PostMapping //-> SEGUNDO USO
    public void agregarEstudiante (@RequestBody estudianteEntity estEn) {
        estRepo.save(estEn);
    }
    @PutMapping //-> TERCER USO
    public void actualizarEstudiante (@RequestBody estudianteEntity estEn) {
        estRepo.save(estEn);
    }
    @DeleteMapping//->CUARTO USO
    public void eliminarEstudiante(@RequestBody estudianteEntity estEn){estRepo.deleteById(estEn.getIdestudiante());}

    @GetMapping("/{id}")
    public ResponseEntity<estudianteEntity> obtenerEstudintePorID(@PathVariable("id") Integer  idEntity){
        estudianteEntity estuEntity = estRepo.findById(idEntity)
                .orElseThrow(() -> new ResolutionException("No existe el estudiante"));
        return ResponseEntity.ok(estuEntity);
    }


    //**PUT
    @PutMapping("/{id}")
    public void modificarEstudianteUnico(@PathVariable("id")Integer  id , @RequestBody estudianteEntity estEn) {
        estRepo.save (estEn);
        estEn.setIdestudiante(id);
    }
    @DeleteMapping("/{id}")
    public void eliminarEstudiante(@PathVariable("id")Integer  id){
        estRepo.deleteById(id);
    }
}
