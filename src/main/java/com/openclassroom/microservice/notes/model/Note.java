package com.openclassroom.microservice.notes.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "notes")
public class Note
{
	@Id
	private String id;
	private Integer patientId;
	private String patientNote;
	

	public Note(String patientNote)
	{
		super();
		this.patientNote = patientNote;
	}

	public Note(Integer patientId, String patientNote)
	{
		super();
		this.patientId = patientId;
		this.patientNote = patientNote;
	}

	public Integer getPatientId()
	{
		return patientId;
	}

	public void setPatientId(Integer patientId)
	{
		this.patientId = patientId;
	}

	public Note()
	{
		super();
	}

	public String getPatientNote()
	{
		return patientNote;
	}

	public void setPatientNote(String patientNote)
	{
		this.patientNote = patientNote;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}
	
	
	

}
