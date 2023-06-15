package com.jags.ClubDeGolf.Controlador;

import com.jags.ClubDeGolf.Config.CloudinaryConfig;
import com.jags.ClubDeGolf.Config.GeneradorDeInformes;
import com.jags.ClubDeGolf.Modelo.Socio;
import com.jags.ClubDeGolf.Repositorio.RepositorioSocio;
import com.jags.ClubDeGolf.Servicios.ServicioSocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/socios")
public class ControladorSocio {

    @Autowired
    private ServicioSocio socioServicio;

    @Autowired
    private RepositorioSocio socioRepository;

    @GetMapping("/{id}")
    public Socio buscarPorID(@PathVariable String id) {
        Optional<Socio> socioOptional = socioServicio.buscarPorId(id);
        if (socioOptional.isPresent()) {
            Socio socio = socioOptional.get();
            return socio;
        }
        return null;
    }

    @PostMapping("/guardar")
    public ResponseEntity<Socio> guardar(@RequestBody Socio socio) {
        Socio socioGuardado = socioServicio.guardar(socio);
        return new ResponseEntity<>(socioGuardado, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Socio> leerRegistros() {
        return socioServicio.buscarTodos();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        if (socioServicio.buscarPorId(id).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        socioServicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Socio> actualizarSocio(@PathVariable("id") String id, @RequestBody Socio socioActualizado) {
        Socio socioExistente = socioRepository.findById(id).orElse(null);

        if (socioExistente == null) {
            return ResponseEntity.notFound().build();
        }

        socioExistente.setDni(socioActualizado.getDni());
        socioExistente.setNombre(socioActualizado.getNombre());
        socioExistente.setApellidos(socioActualizado.getApellidos());

        Socio socioActualizadoDB = socioRepository.save(socioExistente);

        return ResponseEntity.ok(socioActualizadoDB);
    }

    /*
    @GetMapping("/generateReport")
    public String generarInforme() {

        GeneradorDeInformes.informe_socio(socioServicio.buscarTodos());
        String enlace = CloudinaryConfig.subir_informe_socios("SociosClub.pdf");
        return enlace;

    }

     */
    @GetMapping("/generateReport")
    public ResponseEntity<?> generarInforme() {
        GeneradorDeInformes.informe_socio(socioServicio.buscarTodos());
        String enlace = CloudinaryConfig.subir_informe_socios("SociosClub.pdf");

        // Crear un objeto JSON con la propiedad "enlace"
        Map<String, String> response = new HashMap<>();
        response.put("enlace", enlace);

        // Devolver el objeto JSON en la respuesta con el código 200 (OK)
        return ResponseEntity.ok(response);
    }


}
