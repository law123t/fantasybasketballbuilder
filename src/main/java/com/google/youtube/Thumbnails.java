package com.google.youtube;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Thumbnails{

	@JsonProperty("standard")
	private Standard standard;

	@JsonProperty("default")
	private JsonMemberDefault jsonMemberDefault;

	@JsonProperty("high")
	private High high;

	@JsonProperty("medium")
	private Medium medium;

	@JsonProperty("maxres")
	private MaxRes maxres;

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

	public void setMaxRes(MaxRes maxres){
		this.maxres = maxres;
	}

	public MaxRes getMaxRes(){
		return maxres;
	}


	@Override
 	public String toString(){
		return 
			"Thumbnails{" + 
			"standard = '" + standard + '\'' + 
			",default = '" + jsonMemberDefault + '\'' + 
			",high = '" + high + '\'' + 
			",medium = '" + medium + '\'' +
					",maxres = '" + maxres + '\'' +
					"}";
		}
}