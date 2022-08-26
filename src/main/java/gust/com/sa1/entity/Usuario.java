package gust.com.sa1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import gust.com.sa1.entity.enums.Perfil;
import gust.com.sa1.validation.AoAlterar;
import gust.com.sa1.validation.AoInserir;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true, value = {"hibernateLazyInitializer", "handler"})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "usuario")
@Table(name = "usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull(message = "O código do usuário deve ser obrigatório", groups = AoAlterar.class)
	@Null(message = "O código do usuário deve ser nulo", groups = AoInserir.class)
	@Column(name = "codigo")
	@EqualsAndHashCode.Include
	private Integer codigo;
	
	@Column(name = "login")
	@NotEmpty(message = "O login do usuário é obrigatório")
	@Size(min = 2,max = 20, message = "O tamanho do login do usuário deve estar entre 2 e 20 caracteres")
	private String login;
	
	@Column(name = "senha")
	@NotEmpty(message = "A senha do usuário é obrigatória")
	@Size(min=2, max = 10, message = "A senha do usuário deve estar entre 2 e 10 caracteres")
	private String senha;
	
	@Column(name = "perfil")
	@NotNull(message = "O perfil do usuário não deve ser nulo")
	@Enumerated(EnumType.STRING)
	private Perfil perfil;
	
}
