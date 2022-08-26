package gust.com.sa1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
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
@Entity(name = "Cargo")
@Table(name = "cargos")
public class Cargo {
	
	@Id
	@Column(name = "codigo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull(message = "O código do cargo deve ser obrigatório", groups = AoAlterar.class)
	@Null(message = "O código do cargo deve ser nulo", groups = AoInserir.class)
	@EqualsAndHashCode.Include
	private Integer codigo;
	
	@Column(name = "descricao")
	@NotEmpty(message = "A descrição do cargo é obrigatória")
	@Size(min=2, max = 100, message = "O tamanho da descrição do cargo deve estar entre 2 e 100 caracteres")
	private String descricao;
	
	@Column(name = "atribuicao")
	@Size(min=1, max = 500, message = "O tamanho da atribuição do cargo deve estar entre 1 e 500 caracteres")
	private String atribuicao;

}
