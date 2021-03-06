package com.capgemini.forestmanagementsystem.dao;

import java.util.List;

import com.capgemini.forestmanagementsystem.dto.ProductDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;

public interface ProductDao {

	public boolean addProduct(ProductDetailsDto pdt )throws CustomExceptions ;

	public boolean deleteProduct(ProductDetailsDto pdt ) throws CustomExceptions ;

	public boolean modifyProduct(ProductDetailsDto pdt ) throws CustomExceptions;

	public List<ProductDetailsDto> viewAllProduct() throws CustomExceptions;


	ProductDetailsDto viewParticularProduct(ProductDetailsDto pdd) throws CustomExceptions;



}
