package estagio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SEARCHES")
public class Search {
	
	@Id
    @GeneratedValue
    @Column(name = "SEARCH_ID")	
	private Long id;
	
	@Column(name = "SEARCH")	
	private String search;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public Search(String search) {
		super();
		this.search = search;
	}
	
	
	

}
