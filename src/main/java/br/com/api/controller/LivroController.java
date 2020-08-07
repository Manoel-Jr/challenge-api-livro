package br.com.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.model.Livro;
import br.com.api.service.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	private LivroService servico;
	
	
	@GetMapping
	public ResponseEntity<List<Livro>> listaLivros(){
		List<Livro> listaL = servico.listarTodosLivros();
		return ResponseEntity.ok(listaL);
	}
	
	
	@PostMapping
	public ResponseEntity<Livro> salvarLivro(@Valid @RequestBody Livro livro){
		Livro livroSalvo = servico.salvarLivro(livro);
		return ResponseEntity.status(HttpStatus.CREATED).body(livroSalvo);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Livro> buscarLivro(@PathVariable Long id){
		Livro livro = servico.buscarPorId(id);
		return ResponseEntity.ok().body(livro);
	}
	
	
	@DeleteMapping(path = {"/{id}"})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarLivro(@PathVariable Long id) {
		servico.deletar(id);
	}
	
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Livro> atualizarDadosLivro(@PathVariable ("id") Long id, @RequestBody Livro livro){
		Livro livroAtualizado = servico.atualizardadosLivro(livro, id);
		return ResponseEntity.ok().body(livroAtualizado);
	}
		
}
