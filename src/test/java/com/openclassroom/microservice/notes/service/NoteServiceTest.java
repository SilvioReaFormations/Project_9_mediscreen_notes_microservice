package com.openclassroom.microservice.notes.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

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
		
	}
	
	
	
	
	
	
	
	
	
	
}
