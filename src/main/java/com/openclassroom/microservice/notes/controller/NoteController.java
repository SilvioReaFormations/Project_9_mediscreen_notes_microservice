package com.openclassroom.microservice.notes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.openclassroom.microservice.notes.model.Note;
import com.openclassroom.microservice.notes.repository.NoteDTO;
import com.openclassroom.microservice.notes.service.NoteService;

@RestController
public class NoteController
{
	@Autowired
	NoteService noteService;
	
	@GetMapping("/patient/read/{id}/notes")
	public List<NoteDTO> getAllNote(@PathVariable("id") Integer id)
	{
		return noteService.readAllNotes(id);
	}
	
	
	@PostMapping("patient/read/{id}/notes/add")
	public Note addNote(@PathVariable("id") Integer id, @RequestBody NoteDTO noteDTO)
	{
		return noteService.create(id, noteDTO);
	}
	
	
	@GetMapping("update/{id}")
	public Optional<NoteDTO> getNote (@PathVariable("id") String id )
	{
		return noteService.read(id);
	}
	
	
	@PostMapping("update/{id}")
	public Note updateNote(@PathVariable("id")String id, @RequestBody NoteDTO noteDTO)
	{
		return noteService.update(id, noteDTO);
	}
	
	
	@GetMapping("delete/{id}")
	public void deleteNote(@PathVariable("id")String id)
	{
		noteService.delete(id);
	}
	
}
