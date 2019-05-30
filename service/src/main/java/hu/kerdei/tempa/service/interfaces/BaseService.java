package hu.kerdei.tempa.service.interfaces;

import java.util.List;

public interface BaseService<T> {
	
	List<T> getAll() throws Exception;

	T getById(Long id) throws Exception;

	void removeById(Long id) throws Exception;
}
