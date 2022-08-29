package com.openclassroom.microservice.notes.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassroom.microservice.notes.model.Note;
import com.openclassroom.microservice.notes.repository.NoteDTO;
import com.openclassroom.microservice.notes.repository.NoteRepository;

@Service
public class NoteServiceImpl implements NoteService
{
	
	@Autowired
	private NoteRepository noteRepo;

	@Override
	public List<NoteDTO> readAllNotes(Integer id)
	{
		List<Note> list = noteRepo.findByPatientId(id);
		List<NoteDTO> listDTO = new ArrayList<>();
		for (Note note : list)
		{
			listDTO.add( new NoteDTO(note.getId(), note.getPatientNote(), note.getPatientId()));
		}
		return listDTO;
	}
	

	@Override
	public Note create(Integer id, NoteDTO noteDTO)
	{
		Note newNote = new Note (noteDTO.getPatientNote());
		newNote.setPatientId(id);
		noteRepo.save(newNote);
		return newNote;
	}
	
	
	
	@Override
	public Optional<NoteDTO> read(String id)
	{
		Note note = noteRepo.findById(id).get();
		NoteDTO noteDTO = new NoteDTO(note.getId(), note.getPatientNote(), note.getPatientId());
		return Optional.of(noteDTO);
	}

	
	
	@Override
	public Note update(String id, NoteDTO noteDTO)
	{
		Note note = noteRepo.findById(id).get();
		note.setPatientNote(noteDTO.getPatientNote());
		noteRepo.save(note);	
		return note;
	}

	
	
	@Override
	public void delete(String id)
	{
		noteRepo.deleteById(id);
		
	}

}
