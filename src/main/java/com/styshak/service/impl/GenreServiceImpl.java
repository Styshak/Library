package com.styshak.service.impl;


import com.styshak.dao.GenreDAO;
import com.styshak.entities.Genre;
import com.styshak.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

	@Autowired
	private GenreDAO genreDAO;

	@Transactional
	@Override
	public List<Genre> getGenres() {
		List<Genre> list = genreDAO.getGenres();
		list.sort((o1, o2) -> {
			if(o1.getName().equals("Все книги")) return -1;
			if(o2.getName().equals("Все книги")) return 1;
			return o1.getName().compareTo(o2.getName());
		});
		return list;
	}
}
