package com.styshak.dao.impl;

import com.styshak.dao.GenreDAO;
import com.styshak.entities.Genre;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class GenreDAOImpl implements GenreDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Genre> getGenres() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Genre> cq = builder.createQuery(Genre.class);
		Root<Genre> root = cq.from(Genre.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}
}
