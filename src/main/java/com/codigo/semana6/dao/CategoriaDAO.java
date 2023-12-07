package com.codigo.semana6.dao;

import com.codigo.semana6.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaDAO extends JpaRepository<CategoriaEntity,Long> {
}
