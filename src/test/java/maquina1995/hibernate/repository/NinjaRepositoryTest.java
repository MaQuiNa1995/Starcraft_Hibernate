package maquina1995.hibernate.repository;

import org.springframework.beans.factory.annotation.Autowired;

import maquina1995.hibernate.dominio.one2one.Ninja;
import maquina1995.hibernate.dominio.one2one.Ninjutsu;
import maquina1995.hibernate.repository.CrudRepository;
import maquina1995.hibernate.repository.one2one.NinjaRepository;

public class NinjaRepositoryTest extends CrudRepositoryImplTest<Long, Ninja> {

	@Autowired
	private NinjaRepository cut;

	@Override
	public CrudRepository<Long, Ninja> getRepository() {
		return cut;
	}

	@Override
	public Ninja getInstanceDeT() {
		Ninja ninja = new Ninja();
		ninja.setNombre("Ninja Sepulcrador");

		Ninjutsu ninjutsu = new Ninjutsu();
		ninjutsu.setNombre("Última pesadilla");

		ninja.setNinjutsu(ninjutsu);
		return ninja;
	}

	@Override
	public boolean sonDatosIguales(Ninja ninja1, Ninja ninja2) {
		return ninja1.equals(ninja2);
	}

	@Override
	public Long getClavePrimariaNoExistente() {
		return Long.MAX_VALUE;
	}

	@Override
	public Ninja getInstanceDeTParaModificar(Long clave) {
		Ninja ninja = super.getInstanceDeTParaModificar(clave);

		ninja.getNinjutsu().setNombre("Puño Sombrío");

		return ninja;
	}

}