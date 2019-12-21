package com.capgemini.forestmanagementsystem.dao;

import com.capgemini.forestmanagementsystem.dto.ProductDetailsDto;

public interface ProductDao {

	public boolean addProduct();

	public boolean deleteProduct();

	public boolean modifyProduct();

	public void viewAllProduct();

	public void viewParticularProduct();



}
