package com.styshak.service.impl;


import com.styshak.dao.GenreDAO;
import com.styshak.entities.Genre;
import com.styshak.service.GenreService;
import com.styshak.utils.CurrentLocale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

	@Autowired
	private CurrentLocale locale;
	@Autowired
	private GenreDAO genreDAO;

	private static final String ALL_BOOKS_RU = "Все книги";
	private static final String ALL_BOOKS_EN = "All books";

	private Comparator<Genre> RuNameComparator () {
		return (o1, o2) -> {
			if(o1.getName().equals(ALL_BOOKS_RU)) return -1;
			if(o2.getName().equals(ALL_BOOKS_RU)) return 1;
			return o1.getName().compareTo(o2.getName());
		};
	}

	private Comparator<Genre> EnNameComparator () {
		return (o1, o2) -> {
			if(o1.getName_en().equals(ALL_BOOKS_EN)) return -1;
			if(o2.getName_en().equals(ALL_BOOKS_EN)) return 1;
			return o1.getName_en().compareTo(o2.getName_en());
		};
	}

	@Transactional
	@Override
	public List<Genre> getGenres() {
		List<Genre> list = genreDAO.getGenres();
		if(locale.getLocaleCode().equals("ru")) {
			list.sort(RuNameComparator());
		} else {
			list.sort(EnNameComparator());
		}
		return list;
	}
}
