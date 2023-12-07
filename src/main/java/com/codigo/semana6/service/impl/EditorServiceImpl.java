package com.codigo.semana6.service.impl;

import com.codigo.semana6.dao.EditorDAO;
import com.codigo.semana6.entity.EditorEntity;
import com.codigo.semana6.service.EditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EditorServiceImpl implements EditorService {
    @Autowired
    private EditorDAO editorDAO;

    @Override
    public List<EditorEntity> obtenerTodos() {
        return editorDAO.findAll();
    }

    @Override
    public EditorEntity obtenerEditorPorId(Long id) throws Exception {
        Optional<EditorEntity> editor = editorDAO.findById(id);
        if(editor.isPresent()){
            return editor.get();
        }else{
            throw new Exception("No existe el Editor");
        }
    }

    @Override
    public EditorEntity crearEditor(EditorEntity editor) {
        return editorDAO.save(editor);
    }
}
