package maquina1995.hibernate.repository.one2many;

import org.springframework.stereotype.Repository;

import maquina1995.hibernate.dominio.one2many.InvocacionSuprema;
import maquina1995.hibernate.repository.CrudRepositoryImpl;

@Repository
public class InvocacionSupremaRepositoryImpl extends CrudRepositoryImpl<Long, InvocacionSuprema>
		implements InvocacionSupremaRepository {

	@Override
	public Class<InvocacionSuprema> getClassDeT() {
		return InvocacionSuprema.class;
	}
}