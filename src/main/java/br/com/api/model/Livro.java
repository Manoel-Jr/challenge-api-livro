package br.com.api.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "livros")

public class Livro implements Serializable{

	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String livro;
	private String autor;
	private Long paginas;
	@Column(unique = true)
	private Long isbn;
	@JsonFormat(pattern = "dd-MM-yyyy")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate lancamento;
	private Long copias;
}
