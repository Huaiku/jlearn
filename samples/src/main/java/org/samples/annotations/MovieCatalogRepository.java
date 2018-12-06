package org.samples.annotations;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class MovieCatalogRepository implements BasicRepository{
	public String getCatalog() {
		return "Catalog..";
	}
}
