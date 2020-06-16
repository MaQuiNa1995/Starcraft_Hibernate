package es.maquina1995.hsqldb.dominio.many2many;

import java.util.Objects;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import es.maquina1995.hsqldb.dominio.AbstractEntidadSimple;

/**
 * Clase que extiende de {@link AbstractEntidadSimple} para obtener sus
 * atributos si queremos sobreescribir el nombre de algun campo de esta clase
 * debemos usar el {@link AttributeOverride}
 * 
 * @author MaQuiNa1995
 *
 */
@Entity
@Table(name = "ARMA")
@AttributeOverride(name = "id", column = @Column(name = "ID_ARMA"))
public class Arma extends AbstractEntidadSimple<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6700596794802380718L;

	/**
	 * Esta clase es la parte dominante de la relación
	 * <p>
	 * Usamos Set porque es mas eficiente , cuando se tratan con relaciones
	 * many2many con listas las operaciones que se hacen al eliminar eliminan todos
	 * los objetos y luego los vuelve a insertar
	 * <p>
	 * https://vladmihalcea.com/the-best-way-to-use-the-manytomany-annotation-with-jpa-and-hibernate/
	 * <p>
	 * <li>ARMAS_TIENEN_CALIDADES - nombre de la tabla intermedia</li>
	 * <li>FK_ARMA - nombre de la columna de la tabla intermedia que hace referencia
	 * a este objeto {@link Arma}</li>
	 * <li>FK_CALIDAD nombre de la columna de la tabla intermedia que referencia al
	 * objeto {@link Calidad}</li>
	 * 
	 * <li>ID_ARMA nombre de la columna id de la tabla {@link Calidad}</li>
	 * <li>ID_CALIDAD nombre de la columna id de la tabla {@link Calidad}</li>
	 */
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "ARMAS_TIENEN_CALIDADES", joinColumns = @JoinColumn(name = "FK_ARMA", referencedColumnName = "ID_ARMA"), inverseJoinColumns = @JoinColumn(name = "FK_CALIDAD", referencedColumnName = "ID_CALIDAD"))
	private Set<Calidad> calidades;

	public Set<Calidad> getCalidades() {
		return calidades;
	}

	public void setCalidades(Set<Calidad> calidades) {
		this.calidades = calidades;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(calidades);
		return result;
	}

	/**
	 * FIXME revisar porque da false si tiene lo mismo
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arma other = (Arma) obj;
		return Objects.equals(calidades, other.calidades);
	}

}
