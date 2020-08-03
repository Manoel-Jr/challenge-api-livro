package br.com.api.exception.handler;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiError implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer code;
	private String message;
	private Date data;
}
