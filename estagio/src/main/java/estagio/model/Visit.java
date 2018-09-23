package estagio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VISITS_IP")
public class Visit {
	
	@Id
    @GeneratedValue
    @Column(name = "VISIT_ID")
	private Long id;
	
	@Column(name = "VISIT_IP")
	private String ip;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Visit(String ip) {
		super();
		this.ip = ip;
	}
	
	
	
	

}
