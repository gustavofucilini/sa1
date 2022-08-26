package gust.com.sa1.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import gust.com.sa1.validation.AoAlterar;
import gust.com.sa1.validation.AoInserir;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true, value = {"hibernateLazyInitializer", "handler"})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "Colaborador")
@Table(name = "colaboradores")
public class Colaborador {
	
	@Id
	@Column(name = "codigo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull(message = "O código do colaborador deve ser obrigatório", groups = AoAlterar.class)
	@Null(message = "O código do colaborador deve ser nulo", groups = AoInserir.class)
	@EqualsAndHashCode.Include
	private Integer codigo;
	
	@Column(name = "nm_completo")
	@NotEmpty(message = "O nome completo do colaborador é obrigatório")
	@Size(min=2, max = 50, message = "O tamanho do nome completo do colaborador deve estar entre 2 e 50 caracteres")
	private String nomeCompleto;
	
	@Column(name = "cpf")
	@NotEmpty(message = "O cpf do colaborador é obrigatório")
	@Size(min = 14, max = 14, message = "O tamanho do cpf do colaborador deve ser 14 caracteres")
	@Pattern(regexp = "(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)", message = "O formato do CPF deve ser 'NNN.NNN.NNN-NN'")
	private String cpf;
	
	@Column(name = "rg")
	@NotEmpty(message = "O rg do colaborador é obrigatório")
	@Size(min = 10, max = 10, message = "O tamanho do rg do colaborador deve possuir 10 caracteres")
	@Pattern(regexp = "(^\\d{2}\\x2E\\d{3}\\x2E\\d{3}$)", message = "O formato do RG deve ser 'NN.NNN.NNN'")
	private String rg;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "codigo_usuario")
	@NotNull(message = "O usuário do colaborador deve ser obrigatório")
	private Usuario usuario;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "codigo_cargo")
	@NotNull(message = "O cargo do colaborador deve ser obrigatório")
	private Cargo cargo;
	
}
