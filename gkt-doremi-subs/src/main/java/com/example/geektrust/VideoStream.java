package com.example.geektrust;

public class VideoStream implements IStream {
	private final IPlan plan;
	private final Integer offset = 3;
	private String renewalDate;

	public VideoStream(IPlan plan) {
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
		return "VIDEO";
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
