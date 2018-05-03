package com.google.youtube;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Snippet{

	@JsonIgnore
	@JsonProperty("publishedAt")
	private String publishedAt;

	@JsonIgnore
	@JsonProperty("localized")
	private Localized localized;

	@JsonIgnore
	@JsonProperty("description")
	private String description;

	@JsonIgnore
	@JsonProperty("title")
	private String title;

	@JsonIgnore
	@JsonProperty("thumbnails")
	private Thumbnails thumbnails;

	@JsonIgnore
	@JsonProperty("channelId")
	private String channelId;

	@JsonIgnore
	@JsonProperty("channelTitle")
	private String channelTitle;

	public void setPublishedAt(String publishedAt){
		this.publishedAt = publishedAt;
	}

	public String getPublishedAt(){
		return publishedAt;
	}

	public void setLocalized(Localized localized){
		this.localized = localized;
	}

	public Localized getLocalized(){
		return localized;
	}

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

	public void setThumbnails(Thumbnails thumbnails){
		this.thumbnails = thumbnails;
	}

	public Thumbnails getThumbnails(){
		return thumbnails;
	}

	public void setChannelId(String channelId){
		this.channelId = channelId;
	}

	public String getChannelId(){
		return channelId;
	}

	public void setChannelTitle(String channelTitle){
		this.channelTitle = channelTitle;
	}

	public String getChannelTitle(){
		return channelTitle;
	}

	@Override
 	public String toString(){
		return 
			"Snippet{" + 
			"publishedAt = '" + publishedAt + '\'' + 
			",localized = '" + localized + '\'' + 
			",description = '" + description + '\'' + 
			",title = '" + title + '\'' + 
			",thumbnails = '" + thumbnails + '\'' + 
			",channelId = '" + channelId + '\'' + 
			",channelTitle = '" + channelTitle + '\'' + 
			"}";
		}
}