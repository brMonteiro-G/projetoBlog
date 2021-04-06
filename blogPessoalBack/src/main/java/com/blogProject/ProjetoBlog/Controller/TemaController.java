package com.blogProject.ProjetoBlog.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogProject.ProjetoBlog.Model.Tema;
import com.blogProject.ProjetoBlog.Repository.TemaRepository;

@RestController
@RequestMapping("/tema")
@CrossOrigin("*")
public class TemaController {

	private @Autowired TemaRepository repository;
	
	@GetMapping
	public  ResponseEntity<List<Tema>> getAllTema(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{grupo}")
	public ResponseEntity<List<Tema>> findByGrupo(@PathVariable String grupo){
		return ResponseEntity.ok(repository.findAllByGrupoContainingIgnoreCase(grupo));
	}
	
	@GetMapping("/grupo/{id}")
	public ResponseEntity<Optional<Tema>> findById(@PathVariable Long id){
		return ResponseEntity.ok(repository.findById(id));
	}
	/*public ResponseEntity<Tema> findById(@PathVariable Long id){
		return repository.findById(id).map(ret -> ResponseEntity.ok(ret)).orElse(ResponseEntity.notFound().build());}
	*/
	
	@PostMapping
	public ResponseEntity<Tema> postTema(@Valid @RequestBody Tema tema){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema));
	}
	
	@PutMapping
	public ResponseEntity<Tema> putTema(@Valid @RequestBody Tema tema){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(tema));
	}
	
	@DeleteMapping("/{id}")
	public void deleteTema(@PathVariable Long id) {
	repository.deleteById(id);
	}
	
	
	
	
	

	
	
}
