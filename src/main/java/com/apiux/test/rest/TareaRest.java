package com.apiux.test.rest;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apiux.test.dao.TareaDao;
import com.apiux.test.model.Tarea;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/tareas")
public class TareaRest {

	@Autowired
	private TareaDao tareaDao;
	
	@ApiOperation(value = "Agrega una nueva Tarea.")
	@PostMapping(value="/agregar", consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Tarea> agregarTarea(@Validated @RequestBody Tarea tarea, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
	    }else {
	    	//Se envia la fecha de creacion actual
			Date fechaCreacion = new Date();
			tarea.setFechaCreacion(fechaCreacion);
			tareaDao.save(tarea);
			return new ResponseEntity<Tarea>(tarea,HttpStatus.OK); 
	    }
		
	}
	
	@ApiOperation(value = "Lista las tareas agregadas.")
	@GetMapping("/listar")
	public ResponseEntity<List<Tarea>> listarTarea(){
		return ResponseEntity.ok(tareaDao.findAll()); 
	}
	
	@ApiOperation(value = "Elimina una Tarea según el identificador.")
	@DeleteMapping("/eliminar")
	public ResponseEntity<?> eliminarTarea(@RequestBody Tarea tarea, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
	    }else {
	    	tareaDao.deleteById(tarea.getIdentificador());
	    	return ResponseEntity.ok(tarea.getIdentificador());
	    }
		
	}
	
	@ApiOperation(value = "Actualiza una Tarea ya agregada según su identificador.")
	@PutMapping("/actualizar")
	public ResponseEntity<Tarea> actualizarTarea(@Validated @RequestBody Tarea tarea, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
	    }else {
	    	//Se envia la fecha de creacion actual
			Date fechaCreacion = new Date();
			tarea.setFechaCreacion(fechaCreacion);
			tareaDao.save(tarea);
			return new ResponseEntity<Tarea>(tarea,HttpStatus.OK); 
	    }
		
	}
}
