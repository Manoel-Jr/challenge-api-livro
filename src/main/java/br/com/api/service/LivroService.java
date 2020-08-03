package br.com.api.service;

import java.util.List;

import br.com.api.model.Livro;

public interface LivroService {

	List<Livro> listarTodosLivros();
	Livro buscarPorId(Long id);
	void deletar(Long id);
	Livro salvarLivro(Livro livro);
	Livro atualizardadosLivro(Livro livro, Long id);
}
