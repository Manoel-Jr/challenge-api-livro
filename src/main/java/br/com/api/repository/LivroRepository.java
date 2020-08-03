package br.com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

}
