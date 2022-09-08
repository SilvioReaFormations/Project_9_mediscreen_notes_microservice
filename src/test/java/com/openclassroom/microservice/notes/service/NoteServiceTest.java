package com.openclassroom.microservice.notes.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.openclassroom.microservice.notes.model.Note;
import com.openclassroom.microservice.notes.repository.NoteDTO;
import com.openclassroom.microservice.notes.repository.NoteRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class NoteServiceTest
{

	@InjectMocks
	NoteServiceImpl noteImpl;
	
	@Mock
	NoteRepository noteRepo;
	
	
	NoteDTO noteDtoTest = new NoteDTO(
			"id patientNote", "My new patientNote", 1);
	
	
	@Test
	public void readAllNotesMethodTest()
	{
		List<Note> list = new ArrayList<>();
		Note note = new Note (1, "My new patientNote");
		note.setId("id");
		list.add(note);
	
		when(noteRepo.findByPatientId(1)).thenReturn(list);
		
		List<NoteDTO> noteDTOList = noteImpl.readAllNotes(1);
		
		assertEquals(noteDTOList.get(0).getPatientNote(), note.getPatientNote());
		
		
	}
	
	@Test
	public void createPatientMethodTest()
	{
		Note newNoteTest = noteImpl.create(1, noteDtoTest);
		assertEquals(1, newNoteTest.getPatientId());
		assertEquals("My new patientNote", newNoteTest.getPatientNote());
	
	}
	
	@Test
	public void updatePatientMethodTest()
	{
		Note newNoteTest = new Note();
		when(noteRepo.findById("id patientNote")).thenReturn(Optional.of(newNoteTest));
		
		noteImpl.update("id patientNote", noteDtoTest);
		
		assertEquals("My new patientNote", newNoteTest.getPatientNote());
		
		
	}
	
	@Test
	public void readPatientMethodTest()
	{
		Note newNoteTest = new Note();
		newNoteTest.setId("this is the ID of the note");
		newNoteTest.setPatientNote("This is the text of the note");
		
		when(noteRepo.findById("this is the ID of the note")).thenReturn(Optional.of(newNoteTest));
		
		NoteDTO readNoteDTO = noteImpl.read("this is the ID of the note").get();
		
		assertEquals("This is the text of the note", readNoteDTO.getPatientNote());
		
	}
	
	@Test
	public void deletePatientMethodTest()
	{
		Note note = new Note (1, "My new patientNote");
		
		note.setId("id");
		noteImpl.delete("id");
		noteRepo.delete(note);
		verify(noteRepo).delete(note);
	}
	
	
	
	
	
	
	
	
	
	
}
