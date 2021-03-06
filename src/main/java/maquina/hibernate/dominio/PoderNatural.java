package maquina.hibernate.dominio;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;

/**
 * Clase que extiende de {@link AbstractEntidadSimple} para obtener sus
 * atributos si queremos sobreescribir el nombre de algun campo de esta clase
 * debemos usar el {@link AttributeOverride}
 * 
 * @author MaQuiNa1995
 * 
 */
@Entity
@Table
@EqualsAndHashCode(callSuper = false)
@AttributeOverride(name = "id", column = @Column(name = "ID_PODER_NATURAL"))
public class PoderNatural extends AbstractEntidadSimple<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 776100012000395211L;

}
