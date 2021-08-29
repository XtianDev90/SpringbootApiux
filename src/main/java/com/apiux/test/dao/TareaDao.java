package com.apiux.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apiux.test.model.Tarea;

public interface TareaDao extends JpaRepository<Tarea, Integer> {

}
