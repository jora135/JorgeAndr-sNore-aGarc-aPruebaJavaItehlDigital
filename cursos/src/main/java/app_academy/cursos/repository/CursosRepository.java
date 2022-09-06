package app_academy.cursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app_academy.cursos.model.Curso;

@Repository
public interface CursosRepository extends JpaRepository<Curso, Integer>{
    Curso getById(int id);
}

