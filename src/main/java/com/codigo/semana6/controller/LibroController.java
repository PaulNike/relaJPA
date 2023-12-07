package com.codigo.semana6.controller;

import com.codigo.semana6.entity.LibroEntity;
import com.codigo.semana6.service.LibroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {
    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    public List<LibroEntity> listarLibros() {
        List<LibroEntity> libros = libroService.obtenerTodos();
        return libros;
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroEntity> obtenerLibroPorId(@PathVariable Long id) throws Exception {
        LibroEntity libro = libroService.obtenerLibroPorId(id);
        return ResponseEntity.ok(libro);
    }

    @PostMapping
    public ResponseEntity<LibroEntity> crearLibro(@RequestBody LibroEntity libro) {
        LibroEntity nuevoLibro = libroService.crearLibro(libro);
        return new ResponseEntity<>(nuevoLibro, HttpStatus.CREATED);
    }
}
