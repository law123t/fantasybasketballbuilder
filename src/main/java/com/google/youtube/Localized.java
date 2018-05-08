package com.google.youtube;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Localized{

	@JsonProperty("description")
	private String description;

	@JsonProperty("title")
	private String title;

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	@Override
 	public String toString(){
		return 
			"Localized{" + 
			"description = '" + description + '\'' + 
			",title = '" + title + '\'' + 
			"}";
		}
}