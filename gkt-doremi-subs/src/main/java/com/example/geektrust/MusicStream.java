package com.example.geektrust;

public class MusicStream implements IStream {
	private final IPlan plan;
	private final Integer offset = 0;
	private String renewalDate;

	MusicStream(IPlan plan) {
		this.plan = plan;
	}

	@Override
	public Integer getOffset() {
		// TODO Auto-generated method stub
		return offset;
	}

	@Override
	public String streamName() {
		// TODO Auto-generated method stub
		return "MUSIC";
	}

	@Override
	public void setRenewal(String renewal) {
		this.renewalDate = renewal;

	}

	@Override
	public String getRenewal() {
		// TODO Auto-generated method stub
		return renewalDate;
	}

	@Override
	public Integer getCost() {
		// TODO Auto-generated method stub
		return this.plan.cost();
	}

}
