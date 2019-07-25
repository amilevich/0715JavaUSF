package com.revature.nick.events;

import javax.json.JsonArray;
import javax.json.JsonObject;

public class Event
{
	private String type;
	
	private String message;
	
	private JsonObject data;
	
	private JsonArray dataSet;
	
	public Event(String type, String message)
	{
		this.type = type;
		this.message = message;
		this.data = null;
		this.dataSet = null;
	}
	
	public Event(String type, String message, JsonObject data)
	{
		this.type = type;
		this.message = message;
		this.data = data;
		this.dataSet = null;
	}
	
	public Event(String type, String message, JsonArray dataSet)
	{
		this.type = type;
		this.message = message;
		this.dataSet = dataSet;
		this.data = null;
	}

	public JsonObject getData()
	{
		return data;
	}

	public void setData(JsonObject data)
	{
		this.data = data;
	}

	public JsonArray getDataSet()
	{
		return dataSet;
	}

	public void setDataSet(JsonArray dataSet)
	{
		this.dataSet = dataSet;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}
}
