package org.exnihilo.Item.util;

import java.util.Date;
import java.util.List;

public class DTOFactory {

	private static DTOFactory _minstance;

	public DTOFactory() {
		// TODO Auto-generated constructor stub
	}

	public static DTOFactory getInstance() {

		if (_minstance == null)
			_minstance = new DTOFactory();

		return _minstance;
	}
	
	public ItemDTO createItemDTO(Date fecha, String titulo, String descripcion,
			MiembroEquipoDTO asignado, ProyectoDTO proyecto,
			ItemTypeDTO itemType) {

		ItemDTO _item = new ItemDTO();

		_item.setFecha(fecha);
		_item.setTitulo(titulo);
		_item.setDescripcion(descripcion);
		_item.setAsignado(asignado);
		_item.setProyecto(proyecto);
		_item.setItemType(itemType);

		return _item;

	}
	
	public HistorialDTO createHistorial(Date fecha,String registro ){
		
		HistorialDTO uhist = new HistorialDTO();
		
		uhist.setFecha(fecha);
		uhist.setRegistro(registro);
		
		return uhist;
		
	}
	
	public UsuarioDTO createUserDTO(String email ,String pass,String nombre,String telefono, String Oid, int version	) {

		UsuarioDTO uDto = new UsuarioDTO();

		uDto.setEmail(email);
		uDto.setNombre(nombre);
		uDto.setPassword(pass);
		uDto.setTelefono(telefono);
		uDto.setOid(Oid);
		uDto.setVersion(version);

		return uDto;

	}

	public PuestoDTO createPuestoDTO(String name) {
		return (new PuestoDTO(name));

	}

	public MiembroEquipoDTO createMiembroDTO(String name, String email,
			PuestoDTO puesto, List<EquipoDTO> equipos) {

		MiembroEquipoDTO mMiembro = new MiembroEquipoDTO();

		mMiembro.setNombre(name);
		mMiembro.setEmail(email);
		mMiembro.setPuesto(puesto);
		mMiembro.setEquipos(equipos);

		return mMiembro;

	}
	
	public MiembroEquipoDTO createMiembroDTO(String OID, String name, String email,
			PuestoDTO puesto, List<EquipoDTO> equipos) {

		MiembroEquipoDTO mMiembro = new MiembroEquipoDTO();
		
		mMiembro.setOid(OID);
		mMiembro.setNombre(name);
		mMiembro.setEmail(email);
		mMiembro.setPuesto(puesto);
		mMiembro.setEquipos(equipos);

		return mMiembro;

	}

	public EquipoDTO createEquipoDTO(String Name) {

		EquipoDTO _equipo = new EquipoDTO();

		_equipo.setNombre(Name);

		return _equipo;

	}
	
	public EquipoDTO createEquipoDTO(String Oid,  String Name) {

		EquipoDTO _equipo = new EquipoDTO();

		_equipo.setNombre(Name);
		_equipo.setOid(Oid);

		return _equipo;

	}

	public WorkFlowDTO createWorkflowDTO(String name) {

		WorkFlowDTO workflow = new WorkFlowDTO();

		workflow.setName(name);

		return workflow;

	}
	
	public WorkFlowDTO createWorkflowDTO(String oid, String name) {

		WorkFlowDTO workflow = new WorkFlowDTO();

		workflow.setName(name);
		workflow.setOid(oid);

		return workflow;

	}

	public NodoDTO createNodoDTO(String name) {

		NodoDTO _nodo = new NodoDTO();

		_nodo.setName(name);

		return _nodo;

	}

	public NodoDTO createNodoDTO(String Oid, String name, List<NodoDTO> proxestado) {

		NodoDTO _nodo = new NodoDTO();
		
		_nodo.setOid(Oid);
		_nodo.setName(name);
		_nodo.setProxEstado(proxestado);

		return _nodo;

	}
	
	public ProyectoDTO createProyectoDTO(String nombre, EquipoDTO equipo) {

		ProyectoDTO _proj = new ProyectoDTO();

		_proj.setNombre(nombre);
		_proj.setEquipo(equipo);

		return _proj;
	}
	
	public ProyectoDTO createProyectoDTO(String oid, String nombre, EquipoDTO equipo) {

		ProyectoDTO _proj = new ProyectoDTO();
		
		_proj.setOid(oid);
		_proj.setNombre(nombre);
		_proj.setEquipo(equipo);

		return _proj;
	}

	public ItemTypeDTO createItemTypeDTO(String descripcion, String Titulo, WorkFlowDTO workflow) {

		ItemTypeDTO mitemTypeDTO = new ItemTypeDTO();
		mitemTypeDTO.setTitulo(Titulo);
		mitemTypeDTO.setDescripcion(descripcion);
		mitemTypeDTO.setWorkflow(workflow);

		return mitemTypeDTO;
	}

}
