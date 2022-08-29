package com.openclassroom.microservice.notes.repository;

import java.io.Serializable;

public class NoteDTO implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String patientNote;
	private Integer patientId;
	
	



	public NoteDTO(String id, String patientNote, Integer patientId)
	{
		super();
		this.id = id;
		this.patientNote = patientNote;
		this.patientId = patientId;
	}



	public NoteDTO()
	{
		super();
	}

	
	
	
	public Integer getPatientId()
	{
		return patientId;
	}


	public void setPatientId(Integer patientId)
	{
		this.patientId = patientId;
	}
	

	public String getId()
	{
		return id;
	}


	public void setId(String id)
	{
		this.id = id;
	}


	public String getPatientNote()
	{
		return patientNote;
	}


	public void setPatientNote(String patientNote)
	{
		this.patientNote = patientNote;
	}
	
	
	
	

}
