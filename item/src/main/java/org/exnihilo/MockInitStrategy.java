package org.exnihilo;

import java.util.Date;
import java.util.Random;

import org.exnihilo.Item.model.Administrador;
import org.exnihilo.Item.model.ItemSys;
import org.exnihilo.Item.model.Nodo;
import org.exnihilo.Item.model.WorkFlow;
import org.exnihilo.Item.repositories.RepositoryLocator;
import org.exnihilo.Item.repositories.impl.mock.EquipoRepositoryImpl;
import org.exnihilo.Item.repositories.impl.mock.EstadoRepositoryImpl;
import org.exnihilo.Item.repositories.impl.mock.ItemSysRepositoryImpl;
import org.exnihilo.Item.repositories.impl.mock.ItemTypeRepositoryImpl;
import org.exnihilo.Item.repositories.impl.mock.ItensRepositoryImpl;
import org.exnihilo.Item.repositories.impl.mock.ProyectosRepositoryImpl;
import org.exnihilo.Item.repositories.impl.mock.PuestoRepositoryImpl;
import org.exnihilo.Item.repositories.impl.mock.UsuarioRepositoryImpl;
import org.exnihilo.Item.repositories.impl.mock.WorkFlowRepositoryImpl;
import org.exnihilo.Item.services.ServiceLocator;
import org.exnihilo.Item.services.mock.EquipoServiceImpl;
import org.exnihilo.Item.services.mock.EstadoServiceImpl;
import org.exnihilo.Item.services.mock.ItemServiceImpl;
import org.exnihilo.Item.services.mock.ItemTypeServiceImpl;
import org.exnihilo.Item.services.mock.ProyectoServiceImpl;
import org.exnihilo.Item.services.mock.PuestoServiceImpl;
import org.exnihilo.Item.services.mock.UserServiceImpl;
import org.exnihilo.Item.services.mock.WorkFlowServicesImpl;
import org.exnihilo.Item.util.DTOFactory;
import org.exnihilo.Item.util.EquipoDTO;
import org.exnihilo.Item.util.IDGenerator;
import org.exnihilo.Item.util.ItemDTO;
import org.exnihilo.Item.util.ItemTypeDTO;
import org.exnihilo.Item.util.MiembroEquipoDTO;
import org.exnihilo.Item.util.NodoDTO;
import org.exnihilo.Item.util.ProyectoDTO;
import org.exnihilo.Item.util.PuestoDTO;
import org.exnihilo.Item.util.WorkFlowDTO;

public class MockInitStrategy extends InitStrategy {

	private static ItemSys mItem;

	public MockInitStrategy() {
		MockInitStrategy.mItem = new ItemSys();
	}

	public void initModel() {
		Administrador mAdm = new Administrador();

		mAdm.setEmail("adm@nihil.com");
		mAdm.setNombre("Adm");
		mAdm.setOid(IDGenerator.getId());
		mAdm.setTelefono("666 6666613");
		mAdm.setPassword("adm");
		mAdm.setVersion(0);

		mItem.getUsuarios().add(mAdm);

		// Puesto
		PuestoDTO nSecretaria = DTOFactory.getInstance().createPuestoDTO(
				"Secretaria");
		nSecretaria = ServiceLocator.getInstance().getPuestoService()
				.addPuesto(nSecretaria);

		PuestoDTO nOperador = DTOFactory.getInstance().createPuestoDTO(
				"Operador");
		nOperador = ServiceLocator.getInstance().getPuestoService()
				.addPuesto(nOperador);

		PuestoDTO nProgramador = DTOFactory.getInstance().createPuestoDTO(
				"Programador");
		nProgramador = ServiceLocator.getInstance().getPuestoService()
				.addPuesto(nProgramador);

		PuestoDTO nAnalista = DTOFactory.getInstance().createPuestoDTO(
				"Analista");
		nAnalista = ServiceLocator.getInstance().getPuestoService()
				.addPuesto(nAnalista);

		PuestoDTO nPM = DTOFactory.getInstance().createPuestoDTO(
				"Project Manager");
		nPM = ServiceLocator.getInstance().getPuestoService().addPuesto(nPM);

		PuestoDTO nHelpDesk = DTOFactory.getInstance().createPuestoDTO(
				"Soporte Help Desk");
		nHelpDesk = ServiceLocator.getInstance().getPuestoService()
				.addPuesto(nHelpDesk);

		PuestoDTO nAnalistaInfra = DTOFactory.getInstance().createPuestoDTO(
				"Analista Infra");
		nAnalistaInfra = ServiceLocator.getInstance().getPuestoService()
				.addPuesto(nAnalistaInfra);

		// Miembros
		MiembroEquipoDTO mMarc = DTOFactory.getInstance().createMiembroDTO(
				"Marc Alcantara", "m1@company.com", nAnalista, null);
		ServiceLocator.getInstance().getEquipoService().addMiembro(mMarc);

		MiembroEquipoDTO mAlo = DTOFactory.getInstance().createMiembroDTO(
				"Aloisio Mercadante", "m2@company.com", nPM, null);
		mAlo.setAdm(true);
		ServiceLocator.getInstance().getEquipoService().addMiembro(mAlo);

		MiembroEquipoDTO mUbi = DTOFactory.getInstance().createMiembroDTO(
				"Ubirajara Lins", "m3@company.com", nProgramador, null);
		ServiceLocator.getInstance().getEquipoService().addMiembro(mUbi);

		MiembroEquipoDTO mJose = DTOFactory.getInstance().createMiembroDTO(
				"Jose Perez", "m4@company.com", nAnalistaInfra, null);
		ServiceLocator.getInstance().getEquipoService().addMiembro(mJose);

		MiembroEquipoDTO mJuan = DTOFactory.getInstance().createMiembroDTO(
				"Juan", "m5@company.com", nHelpDesk, null);
		ServiceLocator.getInstance().getEquipoService().addMiembro(mJuan);

		// Equipo

		EquipoDTO eManut = DTOFactory.getInstance().createEquipoDTO(
				"Manutencion software");
		eManut.getMiembros().add(mJose);
		eManut.getMiembros().add(mJuan);
		eManut.getMiembros().add(mUbi);
		eManut.getMiembros().add(mAlo);
		eManut.getMiembros().add(mMarc);
		eManut.setResponsable(mAlo);

		eManut.setProyecto(new ProyectoDTO());
		eManut = ServiceLocator.getInstance().getEquipoService()
				.addEquipo(eManut);

		EquipoDTO eDesa = DTOFactory.getInstance().createEquipoDTO(
				"Desarrollo software");
		eDesa.getMiembros().add(mJose);
		eDesa.getMiembros().add(mJuan);
		eDesa.getMiembros().add(mUbi);
		eDesa.getMiembros().add(mAlo);
		eDesa.getMiembros().add(mMarc);
		eDesa.setResponsable(mAlo);

		eDesa.setProyecto(new ProyectoDTO());
		eDesa = ServiceLocator.getInstance().getEquipoService()
				.addEquipo(eDesa);

		EquipoDTO eBugFix = DTOFactory.getInstance().createEquipoDTO(
				"Reporte de BUG");
		eBugFix.getMiembros().add(mJose);
		eBugFix.getMiembros().add(mJuan);
		eBugFix.getMiembros().add(mUbi);
		eBugFix.getMiembros().add(mAlo);
		eBugFix.getMiembros().add(mMarc);
		eBugFix.setResponsable(mAlo);

		eBugFix.setProyecto(new ProyectoDTO());
		eBugFix = ServiceLocator.getInstance().getEquipoService()
				.addEquipo(eBugFix);

		// 4 - pop up the work flow master
		WorkFlow mworkflow1 = new WorkFlow();
		mworkflow1.setOid(IDGenerator.getId());
		mworkflow1.setName("Reporte de BUG");

		Nodo mcreado = new Nodo();
		mcreado.setOid(IDGenerator.getId());
		mcreado.setName("Creado");

		Nodo mDesarrollo = new Nodo();
		mDesarrollo.setOid(IDGenerator.getId());
		mDesarrollo.setName("Desarrollo");
		mcreado.getProxEstado().add(mDesarrollo);

		Nodo mValidacion = new Nodo();
		mValidacion.setOid(IDGenerator.getId());
		mValidacion.setName("Validacion");
		mValidacion.getProxEstado().add(mDesarrollo);
		mDesarrollo.getProxEstado().add(mValidacion);

		Nodo mTerminado = new Nodo();
		mTerminado.setOid(IDGenerator.getId());
		mTerminado.setName("Terminado");
		mValidacion.getProxEstado().add(mTerminado);

		mworkflow1.getNodos().add(mcreado);
		mworkflow1.getNodos().add(mDesarrollo);
		mworkflow1.getNodos().add(mValidacion);
		mworkflow1.getNodos().add(mTerminado);

		mItem.getWorkflows().add(mworkflow1);

		// tipo item

		WorkFlowDTO dtoWrkflw1 = DTOFactory.getInstance().createWorkflowDTO(
				"reporte de bug");
		dtoWrkflw1.setOid(mworkflow1.getOid());
		ItemTypeDTO BugReport = DTOFactory.getInstance().createItemTypeDTO(
				"Reporte de Bug", "Reporte de Bug", dtoWrkflw1);
		ServiceLocator.getInstance().getItemTypeService()
				.addItemType(BugReport);

		// Proyectos

		ProyectoDTO mLogistica = DTOFactory.getInstance().createProyectoDTO(
				"Proyecto de Logistica", eDesa);
		ProyectoDTO mPub = DTOFactory.getInstance().createProyectoDTO(
				"Proyecto de Publicidad", eDesa);

		mLogistica = ServiceLocator.getInstance().getProyectoService()
				.addProyecto(mLogistica);
		mPub = ServiceLocator.getInstance().getProyectoService()
				.addProyecto(mPub);

		ProyectoDTO minfraPub = DTOFactory.getInstance().createProyectoDTO(
				"Infra para Proyecto de Publicidad", eManut);
		ProyectoDTO minfraLog = DTOFactory.getInstance().createProyectoDTO(
				"Proyecto de Logistica", eManut);

		ServiceLocator.getInstance().getProyectoService()
				.addProyecto(minfraPub);
		ServiceLocator.getInstance().getProyectoService()
				.addProyecto(minfraLog);

		ProyectoDTO mbugFixPub = DTOFactory.getInstance().createProyectoDTO(
				"Bug fix para Proyecto de Publicidad", eBugFix);
		ProyectoDTO mbugFixLog = DTOFactory.getInstance().createProyectoDTO(
				"Bug fix para para Proyecto de Logistica", eBugFix);

		mbugFixPub = ServiceLocator.getInstance().getProyectoService()
				.addProyecto(mbugFixPub);
		mbugFixLog = ServiceLocator.getInstance().getProyectoService()
				.addProyecto(mbugFixLog);

		// Creating another state(node) calling from the service

		NodoDTO newEstado = new NodoDTO();
		WorkFlowDTO workflow = new WorkFlowDTO();

		newEstado.setName("Verificacion");
		workflow.setOid(mworkflow1.getOid());

		newEstado = ServiceLocator.getInstance().getEstadosService()
				.addEstado(newEstado, workflow);

		// creating a new workflow using the new state

		WorkFlowDTO wrkfw2 = DTOFactory.getInstance().createWorkflowDTO(
				"Ciclo de desarrollo");
		wrkfw2 = ServiceLocator.getInstance().getWorkflowService()
				.addWorkFlow(wrkfw2);

		ItemTypeDTO tyDesa = DTOFactory.getInstance().createItemTypeDTO(
				"Tarea para desarrollo de software", "Desa", wrkfw2);

		tyDesa.setTitulo("Tarea para desarrollo de software");
		ServiceLocator.getInstance().getItemTypeService().addItemType(tyDesa);

		NodoDTO nEnAnalisis = DTOFactory.getInstance().createNodoDTO(
				"En analisis");
		nEnAnalisis = ServiceLocator.getInstance().getEstadosService()
				.addEstado(nEnAnalisis, wrkfw2);

		NodoDTO nEnAproAnalisis = DTOFactory.getInstance().createNodoDTO(
				"En aprobacion analisis");
		nEnAproAnalisis = ServiceLocator.getInstance().getEstadosService()
				.addEstado(nEnAproAnalisis, wrkfw2);

		nEnAnalisis.getProxEstado().add(nEnAproAnalisis);
		ServiceLocator.getInstance().getEstadosService()
				.addProxEstado(wrkfw2, nEnAnalisis);

		NodoDTO nEndesarrollo = DTOFactory.getInstance().createNodoDTO(
				"En desarrollo (En oprogramacion)");
		nEndesarrollo = ServiceLocator.getInstance().getEstadosService()
				.addEstado(nEndesarrollo, wrkfw2);
		NodoDTO nEnCertificcion = DTOFactory.getInstance().createNodoDTO(
				"En Certificacion si cubre el diseno");
		nEnCertificcion = ServiceLocator.getInstance().getEstadosService()
				.addEstado(nEnCertificcion, wrkfw2);
		NodoDTO nEnTesting = DTOFactory.getInstance().createNodoDTO(
				"En etapa de testing");
		nEnTesting = ServiceLocator.getInstance().getEstadosService()
				.addEstado(nEnTesting, wrkfw2);
		NodoDTO nNoCertif = DTOFactory.getInstance().createNodoDTO(
				"Con error de certificacion");
		nNoCertif = ServiceLocator.getInstance().getEstadosService()
				.addEstado(nNoCertif, wrkfw2);

		nEnAproAnalisis.getProxEstado().add(nEndesarrollo);
		ServiceLocator.getInstance().getEstadosService()
				.addProxEstado(wrkfw2, nEnAproAnalisis);

		nEndesarrollo.getProxEstado().add(nEnCertificcion);
		ServiceLocator.getInstance().getEstadosService()
				.addProxEstado(wrkfw2, nEndesarrollo);

		nEnCertificcion.getProxEstado().add(nEnTesting);
		nEnCertificcion.getProxEstado().add(nNoCertif);
		ServiceLocator.getInstance().getEstadosService()
				.addProxEstado(wrkfw2, nEnCertificcion);

		nNoCertif.getProxEstado().add(nEndesarrollo);
		ServiceLocator.getInstance().getEstadosService()
				.addProxEstado(wrkfw2, nNoCertif);

		NodoDTO nErrorEnTesting = DTOFactory.getInstance().createNodoDTO(
				"Con error de certificacion");
		nErrorEnTesting = ServiceLocator.getInstance().getEstadosService()
				.addEstado(nErrorEnTesting, wrkfw2);

		nEnTesting.getProxEstado().add(nErrorEnTesting);
		ServiceLocator.getInstance().getEstadosService()
				.addProxEstado(wrkfw2, nEnTesting);

		nErrorEnTesting.getProxEstado().add(nEndesarrollo);
		ServiceLocator.getInstance().getEstadosService()
				.addProxEstado(wrkfw2, nErrorEnTesting);

		NodoDTO nDelivering = DTOFactory.getInstance().createNodoDTO(
				"En configuracion para deploy");
		nDelivering = ServiceLocator.getInstance().getEstadosService()
				.addEstado(nDelivering, wrkfw2);

		nEnTesting.getProxEstado().add(nDelivering);
		nEnTesting = ServiceLocator.getInstance().getEstadosService()
				.addEstado(nEnTesting, wrkfw2);

		NodoDTO nEntregue = DTOFactory.getInstance().createNodoDTO(
				"Entregue al cliente");
		nEntregue = ServiceLocator.getInstance().getEstadosService()
				.addEstado(nEntregue, wrkfw2);

		NodoDTO nErrorEntrega = DTOFactory.getInstance().createNodoDTO(
				"Usuario no aprobo la entrega");
		nErrorEntrega = ServiceLocator.getInstance().getEstadosService()
				.addEstado(nErrorEntrega, wrkfw2);

		nErrorEntrega.getProxEstado().add(nEnAnalisis);
		ServiceLocator.getInstance().getEstadosService()
				.addProxEstado(wrkfw2, nErrorEntrega);

		// creating itens

		Random rand = new Random();

		// 3 mi itens proyecto logistica de desarrollo
		for (int i = 1; i <= 500; i++) {

			ItemDTO _nItem = DTOFactory.getInstance().createItemDTO(
					(new Date()),
					"titulo item #" + i,
					"descripcion descripcion item #" + i,
					mLogistica.getEquipo().getMiembros()
							.get(rand.nextInt(mLogistica.getEquipo() // Agarra
																		// un
																		// miembro
																		// aleatorio
																		// del
																		// equipo
									.getMiembros().size() - 1)), mLogistica,
					tyDesa);
			_nItem = ServiceLocator.getInstance().getItemService()
					.addItem(_nItem);

		}

		// 3 mi itens proyecto logistica de desarrollo
		for (int i = 1; i <= 500; i++) {

			ItemDTO _nItem = DTOFactory.getInstance().createItemDTO(
					(new Date()),
					"titulo item #" + i,
					"descripcion item #" + i,
					mPub.getEquipo().getMiembros()
							.get(rand.nextInt(mPub.getEquipo() // Agarra
																// un
																// miembro
																// aleatorio
																// del
																// equipo
									.getMiembros().size() - 1)), mPub, tyDesa);
			_nItem = ServiceLocator.getInstance().getItemService()
					.addItem(_nItem);

		}

	}

	public void initRepositories() {

		RepositoryLocator.getInstance().setEquipoRepository(
				new EquipoRepositoryImpl(mItem));
		RepositoryLocator.getInstance().setEstadoRepository(
				new EstadoRepositoryImpl(mItem));
		RepositoryLocator.getInstance().setItemSysRepository(
				new ItemSysRepositoryImpl(mItem));
		RepositoryLocator.getInstance().setItemTypeRepository(
				new ItemTypeRepositoryImpl(mItem));
		RepositoryLocator.getInstance().setProyectosSoftware(
				new ProyectosRepositoryImpl(mItem));
		RepositoryLocator.getInstance().setPuestoRepository(
				new PuestoRepositoryImpl(mItem));
		RepositoryLocator.getInstance().setWorkFlowRepository(
				new WorkFlowRepositoryImpl(mItem));
		RepositoryLocator.getInstance().set_usuarioRepository(
				new UsuarioRepositoryImpl(mItem));
		RepositoryLocator.getInstance().set_itensRepository(
				new ItensRepositoryImpl(mItem));

	}

	public void initServices() {

		ServiceLocator.getInstance().setEquipoService(
				new EquipoServiceImpl(RepositoryLocator.getInstance()
						.getItemSysRepository()));
		ServiceLocator.getInstance().setEstadosService(
				new EstadoServiceImpl(RepositoryLocator.getInstance()
						.getItemSysRepository()));
		ServiceLocator.getInstance().setItemService(
				new ItemServiceImpl(RepositoryLocator.getInstance()
						.getItemSysRepository()));
		ServiceLocator.getInstance().setItemTypeService(
				new ItemTypeServiceImpl(RepositoryLocator.getInstance()
						.getItemSysRepository()));
		ServiceLocator.getInstance().setProyectoService(
				new ProyectoServiceImpl(RepositoryLocator.getInstance()
						.getItemSysRepository()));
		ServiceLocator.getInstance().setPuestoService(
				new PuestoServiceImpl(RepositoryLocator.getInstance()
						.getItemSysRepository()));
		ServiceLocator.getInstance().setWorkflowService(
				new WorkFlowServicesImpl(RepositoryLocator.getInstance()
						.getItemSysRepository()));
		ServiceLocator.getInstance().setUserService(
				new UserServiceImpl(RepositoryLocator.getInstance()
						.getItemSysRepository()));

	}
}
