package es.maquina1995.hsqldb.repository;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import es.maquina1995.hsqldb.configuration.ConfigurationSpring;
import es.maquina1995.hsqldb.configuration.LiquibaseConfig;
import es.maquina1995.hsqldb.dominio.Mago;
import es.maquina1995.hsqldb.dominio.TipoMagia;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ConfigurationSpring.class, LiquibaseConfig.class })
public class TipoMagiaRepositoryTest extends CrudRepositoryImplTest<Long, TipoMagia> {

    private TipoMagiaRepository cut;

    @Override
    public CrudRepository<Long, TipoMagia> getRepository() {
	return cut;
    }

    @Override
    public TipoMagia getInstanceDeTParaNuevo() {
	TipoMagia tipoMagia = new TipoMagia();
	tipoMagia.setNombre("Magia Roja");
	
	Mago mago = new Mago();
	mago.setNombre("Mago Rojo");
	
	tipoMagia.setMago(mago);
	
	return tipoMagia;
    }

    @Override
    public TipoMagia getInstanceDeTParaLectura() {
	TipoMagia tipoMagia = new TipoMagia();
	tipoMagia.setNombre("Magia Roja");
	
	Mago mago = new Mago();
	mago.setNombre("Mago Rojo");
	
	tipoMagia.setMago(mago);
	
	return tipoMagia;
    }

    @Override
    public boolean sonDatosIguales(TipoMagia tipoMagia1, TipoMagia tipoMagia2) {
	return tipoMagia1.equals(tipoMagia2);
    }

    @Override
    public Long getClavePrimariaNoExistente() {
	return Long.MAX_VALUE;
    }

    @Override
    public TipoMagia getInstanceDeTParaModificar(Long clave) {
	TipoMagia tipoMagia = new TipoMagia();

	tipoMagia.setId(clave);
	tipoMagia.setNombre("Magia Roja");
	
	Mago mago = new Mago();
	mago.setId(clave);
	mago.setNombre("Mago Rojo");
	
	tipoMagia.setMago(mago);
	
	return tipoMagia;
    }

    @Autowired
    public void setTipoMagiaRepository(TipoMagiaRepository sut) {
	this.cut = sut;
    }
}    
   