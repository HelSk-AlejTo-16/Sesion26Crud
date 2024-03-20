package mx.utng.session26.model.service;

import mx.utng.session26.model.entity.Directivo;
import java.util.List;

public interface IDirectivoService {
    List<Directivo> list();
    void save(Directivo directivo);
    Directivo getById(Long id);
    void delete(Long id);
}
