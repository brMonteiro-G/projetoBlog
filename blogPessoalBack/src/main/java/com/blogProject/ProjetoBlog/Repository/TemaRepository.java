package com.blogProject.ProjetoBlog.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogProject.ProjetoBlog.Model.Tema;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Long> {

	public List<Tema> findAllByGrupoContainingIgnoreCase(String grupo);

}
