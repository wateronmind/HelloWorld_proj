package kr.spring.common.domain;

public class NationCityCommand {

	private String nc_cd;
	private String nc_nation;
	private String nc_city;
	
	public String getNc_cd() {
		return nc_cd;
	}
	public void setNc_cd(String nc_cd) {
		this.nc_cd = nc_cd;
	}
	public String getNc_nation() {
		return nc_nation;
	}
	public void setNc_nation(String nc_nation) {
		this.nc_nation = nc_nation;
	}
	public String getNc_city() {
		return nc_city;
	}
	public void setNc_city(String nc_city) {
		this.nc_city = nc_city;
	}

	@Override
	public String toString() {
		return "NationCityCommand [nc_cd=" + nc_cd + ", nc_nation=" + nc_nation + ", nc_city=" + nc_city + "]";
	}
}
