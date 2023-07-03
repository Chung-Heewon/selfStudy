package com.mangoplate.control;

import com.mangoplate.dto.Menu;
import com.mangoplate.dao.MenuRepository;
import com.mangoplate.exception.AddException;

public class MenuControl {
	private MenuRepository repository;
	public MenuControl() {
		repository = new MenuRepository();
//		Menu menu = new Menu();
	}
	public void add(Menu menu) throws AddException {
		repository.add(menu);
	}	
	public void update(Menu menu) throws AddException {
		repository.update(menu);
	}
	public void delete(Menu menu) throws AddException {
		repository.delete(menu);
	}
	public void search(Menu menu) throws AddException {
		repository.search(menu);
	}
}
