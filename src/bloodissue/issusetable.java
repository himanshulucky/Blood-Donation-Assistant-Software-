package bloodissue;

public class issusetable {
	public String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	public String getBgroup() {
		return bgroup;
	}
	public void setBgroup(String bgroup) {
		this.bgroup = bgroup;
	}
	public String getDoi() {
		return doi;
	}
	public void setDoi(String doi) {
		this.doi = doi;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getNoofunits() {
		return noofunits;
	}
	public void setNoofunits(String noofunits) {
		this.noofunits = noofunits;
	}
	public String mobile;
	public String hospital;
	public String bgroup;
	public String doi;
	public String purpose;
	public String noofunits;
	public issusetable(String name, String mobile, String hospital, String bgroup, String doi, String purpose,
			String noofunits) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.hospital = hospital;
		this.bgroup = bgroup;
		this.doi = doi;
		this.purpose = purpose;
		this.noofunits = noofunits;
	}
	
	
}
