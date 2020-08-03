package br.com.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.api.exception.Exception;
import br.com.api.model.Livro;
import br.com.api.repository.LivroRepository;


@Service
public class LivroServiceImpl implements LivroService{

	@Autowired
	private LivroRepository repository;
	
	
	@Override
	public List<Livro> listarTodosLivros() {
		List<Livro> livros = this.repository.findAll();
		if(livros.isEmpty()) {
			throw new Exception("Lista esta vazia");
		}
		return livros;
	}

	@Override
	public Livro buscarPorId(Long id) {
		Optional<Livro> livro = repository.findById(id);
		return livro.get();
	}

	@Override
	public void deletar(Long id) {
		if(id == null) {
			throw new EmptyResultDataAccessException(1);
		}
		repository.deleteById(id);
	}

	@Override
	public Livro salvarLivro(Livro livro) {
		Livro novolivro = repository.save(livro);
		return novolivro;
	}

	@Override
	public Livro atualizardadosLivro(Livro livro, Long id) {
		livro.setId(id);
		Livro livroAtualizado = repository.save(livro);
		return livroAtualizado;
	}

}
