package com.mangoplate.control;

import com.mangoplate.dao.FoodStoreRepository;
import com.mangoplate.dto.FoodStore;
import com.mangoplate.exception.AddException;

public class FoodStoreControl {
	private FoodStoreRepository repository;

	public FoodStoreControl() {
		repository = new FoodStoreRepository();
	}

	public void add(FoodStore store) throws AddException {
		repository.insert(store);
	}

	public void modify(FoodStore store, String bNum) throws AddException {
		repository.update(store, bNum);
	}

	public void delete(String businessno) throws AddException {
		repository.delete(businessno);

	}
}