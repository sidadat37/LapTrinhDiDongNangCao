package com.cgm.hello_web_app.restful_api;


import java.sql.Connection;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



import com.cgm.hello_web_app.model.Product;
import com.cgm.hello_web_app.model.ProductDAO;


@Path("/products")
public class ApiProductService {

	@GET
	@Produces (MediaType.APPLICATION_JSON)
	public List<Product> getAllProduct_JSON(){
		List<Product> lst=  null;
		ProductDAO productDAO = new ProductDAO();
		lst = productDAO.getAllProducts();
		return lst;
	}
	
	
	
}
