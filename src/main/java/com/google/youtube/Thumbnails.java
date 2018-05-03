package com.google.youtube;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Thumbnails{

	@JsonIgnore
	@JsonProperty("standard")
	private Standard standard;

	@JsonIgnore
	@JsonProperty("default")
	private JsonMemberDefault jsonMemberDefault;

	@JsonIgnore
	@JsonProperty("high")
	private High high;

	@JsonIgnore
	@JsonProperty("medium")
	private Medium medium;

	public void setStandard(Standard standard){
		this.standard = standard;
	}

	public Standard getStandard(){
		return standard;
	}

	public void setJsonMemberDefault(JsonMemberDefault jsonMemberDefault){
		this.jsonMemberDefault = jsonMemberDefault;
	}

	public JsonMemberDefault getJsonMemberDefault(){
		return jsonMemberDefault;
	}

	public void setHigh(High high){
		this.high = high;
	}

	public High getHigh(){
		return high;
	}

	public void setMedium(Medium medium){
		this.medium = medium;
	}

	public Medium getMedium(){
		return medium;
	}

	@Override
 	public String toString(){
		return 
			"Thumbnails{" + 
			"standard = '" + standard + '\'' + 
			",default = '" + jsonMemberDefault + '\'' + 
			",high = '" + high + '\'' + 
			",medium = '" + medium + '\'' + 
			"}";
		}
}