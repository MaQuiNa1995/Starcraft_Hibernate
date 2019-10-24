package es.maquina1995.hsqldb.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import es.maquina1995.hsqldb.configuration.ConfigurationSpring;
import es.maquina1995.hsqldb.configuration.LiquibaseConfig;
import es.maquina1995.hsqldb.dominio.Base;
import es.maquina1995.hsqldb.repository.BaseRepository;
import es.maquina1995.hsqldb.service.BaseService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ConfigurationSpring.class, LiquibaseConfig.class })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class })
@Transactional
public class BaseServiceImplTest {

	private BaseService sut;
	private BaseRepository baseRepository;

	@Autowired
	public void setBaseRepository(BaseRepository baseRepository) {
		this.baseRepository = baseRepository;
	}

	@Autowired
	public void setBaseService(BaseService sut) {
		this.sut = sut;
	}

	@Test
	public void testAniadirBase() {
		Long idBase = sut.aniadirBase(10, "Vespeno", 5, 1);

		assertNotNull(idBase);
	}

	@Test
	public void testObtenerBase() {
		Long idBase = sut.aniadirBase(10, "Vespeno", 5, 1);

		Base base = sut.obtenerBase(idBase);

		assertNotNull(base.getId());
		assertTrue(base.getTipoMineral().equalsIgnoreCase("Vespeno"));
		assertTrue(base.getCantidadMineral() == 10);
		assertTrue(base.getTrabajadoresMaximo() == 5);
	}

	@Test
	public void testObtenerBases() {
		List<Base> bases = sut.obtenerBases();
		bases.forEach((base) -> {
			assertNotNull(base.getId());
		});
	}

	@Test
	public void testActualizarBase() {
		Long idBase = sut.aniadirBase(10, "Vespeno", 5, 1);

		Base base = sut.obtenerBase(idBase);
		base.setTipoMineral("Cristal");

		Base baseMod = sut.obtenerBase(idBase);

		assertTrue(baseMod.getTipoMineral().equalsIgnoreCase("Cristal"));
	}

	@Test
	public void testBorrarBase() {
		Long idBase = sut.aniadirBase(10, "Vespeno", 5, 1);

		sut.borrarBase(idBase);

		List<Base> bases = sut.obtenerBases();

		assertTrue(bases.isEmpty());
	}

	@Before
	public void setUp() throws Exception {
		limpiarBases();
	}

	private void limpiarBases() {
		List<Base> bases = sut.obtenerBases();
		bases.forEach((base) -> {
			baseRepository.delete(base);
		});
	}
}