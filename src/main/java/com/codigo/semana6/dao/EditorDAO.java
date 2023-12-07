package com.codigo.semana6.dao;

import com.codigo.semana6.entity.EditorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditorDAO extends JpaRepository<EditorEntity,Long> {
}
