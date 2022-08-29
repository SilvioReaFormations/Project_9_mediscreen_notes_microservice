package com.openclassroom.microservice.notes.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.openclassroom.microservice.notes.model.Note;

@Repository
public interface NoteRepository extends MongoRepository<Note, String>
{
	// Faire une requetes afin d'extraire les notes en fonction de l'ID du patient
	List<Note> findByPatientId(Integer patientId);
}
