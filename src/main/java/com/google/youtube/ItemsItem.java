package com.google.youtube;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class ItemsItem{

	@JsonProperty("snippet")
	private Snippet snippet;

	@JsonProperty("kind")
	private String kind;

	@JsonProperty("etag")
	private String etag;

	@JsonProperty("id")
	private String id;

	public void setSnippet(Snippet snippet){
		this.snippet = snippet;
	}

	public Snippet getSnippet(){
		return snippet;
	}

	public void setKind(String kind){
		this.kind = kind;
	}

	public String getKind(){
		return kind;
	}

	public void setEtag(String etag){
		this.etag = etag;
	}

	public String getEtag(){
		return etag;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"ItemsItem{" + 
			"snippet = '" + snippet + '\'' + 
			",kind = '" + kind + '\'' + 
			",etag = '" + etag + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}