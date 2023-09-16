package entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "brands")
public class Brand {
	@Id
	@Column(name = "brand_id")
	private int id;
	@Column(name = "brand_name", columnDefinition = "nvarchar(255)")
	private String name;

	@OneToMany(mappedBy = "brand")
	List<Product> products;

	Brand() {}
}
