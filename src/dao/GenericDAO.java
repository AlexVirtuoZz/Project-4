package dao;

import java.util.List;

interface GenericDAO<E> {
	void create(E e);
	boolean update(E e);
	boolean delete(int id);
	E read(int id);
	List<E> findAll();
}
