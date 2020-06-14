package es.maquina1995.hsqldb.dominio.one2one;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import es.maquina1995.hsqldb.dominio.Persistible;

@Entity
@Table(name = "OFICIO")
public class Oficio implements Persistible<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3232464532349625196L;

	@Id
	@GeneratedValue(generator = "increment")
	@Column(name = "ID_OFICIO")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;

	@Column(name = "NOMBRE")
	private String nombre;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Oficio other = (Oficio) obj;
		return Objects.equals(nombre, other.nombre);
	}

}