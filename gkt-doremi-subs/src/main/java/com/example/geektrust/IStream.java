package com.example.geektrust;

public interface IStream {
	Integer getOffset();

	String streamName();

	void setRenewal(String renewal);

	String getRenewal();

	Integer getCost();
}
