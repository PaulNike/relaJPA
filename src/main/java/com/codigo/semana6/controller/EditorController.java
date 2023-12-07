package com.codigo.semana6.controller;

import com.codigo.semana6.entity.EditorEntity;
import com.codigo.semana6.service.EditorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/editor")
public class EditorController {

    private final EditorService editorService;

    public EditorController(EditorService editorService) {
        this.editorService = editorService;
    }

    @GetMapping
    public List<EditorEntity> listarEditores() {
        List<EditorEntity> editores = editorService.obtenerTodos();
        return editores;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EditorEntity> obtenerEditorPorId(@PathVariable Long id) throws Exception {
        EditorEntity editor = editorService.obtenerEditorPorId(id);
        return ResponseEntity.ok(editor);
    }

    @PostMapping
    public ResponseEntity<EditorEntity> crearEditor(@RequestBody EditorEntity editor) {
        EditorEntity nuevoEditor = editorService.crearEditor(editor);
        return new ResponseEntity<>(nuevoEditor, HttpStatus.CREATED);
    }

}
