package web.repository;
import org.springframework.data.repository.CrudRepository;
import web.model.Biblioteca;
public interface BibliotecaRepository extends CrudRepository<Biblioteca, String>{
	
	Biblioteca findById(long id);
}

