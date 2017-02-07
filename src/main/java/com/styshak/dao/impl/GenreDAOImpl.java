package com.styshak.dao.impl;

import com.styshak.dao.GenreDAO;
import com.styshak.entities.Genre;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class GenreDAOImpl implements GenreDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public List<Genre> getGenres() {
		List<Genre> list = sessionFactory.getCurrentSession().createCriteria(Genre.class).list();
		return list;
	}
}
