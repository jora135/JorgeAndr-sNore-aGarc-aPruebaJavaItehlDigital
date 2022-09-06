package app_academy.cursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app_academy.cursos.model.modalidad;

@Repository
public interface ModalidadRepository  extends JpaRepository<modalidad, Integer>{
    modalidad getById(int id);
}

