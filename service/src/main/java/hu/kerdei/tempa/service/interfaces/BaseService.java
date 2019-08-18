package hu.kerdei.tempa.service.interfaces;

import java.util.List;

public interface BaseService<T> {
	
	List<T> getAll();

	T getById(Long id);

	void removeById(Long id);
}
