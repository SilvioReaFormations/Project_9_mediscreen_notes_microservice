package com.openclassroom.microservice.notes.service;

import java.util.List;
import java.util.Optional;

import com.openclassroom.microservice.notes.model.Note;
import com.openclassroom.microservice.notes.repository.NoteDTO;

public interface NoteService
{
	public List<NoteDTO>readAllNotes(Integer id);
	public Optional<NoteDTO> read(String id);
	public Note create(Integer id, NoteDTO noteDTO);
	public Note update(String id, NoteDTO noteDTO);
	public void delete (String id);
	
	
}
