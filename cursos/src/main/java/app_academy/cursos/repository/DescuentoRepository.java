package app_academy.cursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app_academy.cursos.model.descuento;

@Repository
public interface DescuentoRepository  extends JpaRepository<descuento, Integer>{
    descuento getById(int id);
}
