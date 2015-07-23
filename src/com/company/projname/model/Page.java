package com.company.projname.model;

import java.util.Date;

public class Page {
	
	private String row;
	private String domain;
	private Date date;
	private int plUrls;
	private int views;
	private int clicks;
	private float ctr;
	private float revenue;
	private float epc;
	private float rpm;
	private float percentFinalised;
	private float percentEstimate;
	private float percentForecast;
	private String Status;

	public Page() {

	}

	public Page(String row, String domain, Date date, int plUrrls, int views,
			int clicks, float ctr, float revenue, float epc, float rpm,
			float percentFinalised, float percentEstimate,
			float percentForecast, String status) {
		super();
		this.row = row;
		this.domain = domain;
		this.date = date;
		this.plUrls = plUrrls;
		this.views = views;
		this.clicks = clicks;
		this.ctr = ctr;
		this.revenue = revenue;
		this.epc = epc;
		this.rpm = rpm;
		this.percentFinalised = percentFinalised;
		this.percentEstimate = percentEstimate;
		this.percentForecast = percentForecast;
		Status = status;
	}

	public String getRow() {
		return row;
	}

	public void setRow(String row) {
		this.row = row;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getPlUrls() {
		return plUrls;
	}

	public void setPlUrls(int plUrrls) {
		this.plUrls = plUrrls;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public int getClicks() {
		return clicks;
	}

	public void setClicks(int clicks) {
		this.clicks = clicks;
	}

	public float getCtr() {
		return ctr;
	}

	public void setCtr(float ctr) {
		this.ctr = ctr;
	}

	public float getRevenue() {
		return revenue;
	}

	public void setRevenue(float revenue) {
		this.revenue = revenue;
	}

	public float getEpc() {
		return epc;
	}

	public void setEpc(float epc) {
		this.epc = epc;
	}

	public float getRpm() {
		return rpm;
	}

	public void setRpm(float rpm) {
		this.rpm = rpm;
	}

	public float getPercentFinalised() {
		return percentFinalised;
	}

	public void setPercentFinalised(float percentFinalised) {
		this.percentFinalised = percentFinalised;
	}

	public float getPercentEstimate() {
		return percentEstimate;
	}

	public void setPercentEstimate(float percentEstimate) {
		this.percentEstimate = percentEstimate;
	}

	public float getPercentForecast() {
		return percentForecast;
	}

	public void setPercentForecast(float percentForecast) {
		this.percentForecast = percentForecast;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	@Override
	public String toString() {
		return "Page [row=" + row + ", domain=" + domain + ", date=" + date
				+ ", plUrls=" + plUrls + ", views=" + views + ", clicks="
				+ clicks + ", ctr=" + ctr + ", revenue=" + revenue + ", epc="
				+ epc + ", rpm=" + rpm + ", percentFinalised="
				+ percentFinalised + ", percentEstimate=" + percentEstimate
				+ ", percentForecast=" + percentForecast + ", Status=" + Status
				+ "]";
	}

}
