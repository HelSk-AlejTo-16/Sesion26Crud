package mx.utng.session26.model.dao;

import java.util.List;

import mx.utng.session26.model.entity.Directivo;


public interface IDirectivoDao {
    List<Directivo> list();
    void save(Directivo directivo);
    Directivo getById(Long id);
    void delete(Long id);
}
