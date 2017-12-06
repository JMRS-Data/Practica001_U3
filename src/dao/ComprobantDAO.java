package dao;

import java.util.List;

import model.Comprobant;

public interface ComprobantDAO {
	void createComprobant(Comprobant comprobant);
	Comprobant readComprobant(Long id);
	List<Comprobant> readAllComprobants();
	void updateComprobant(Comprobant comprobant);
	void deleteComprobant(Long id);
}
