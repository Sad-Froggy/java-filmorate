package ru.yandex.practicum.filmorate.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.filmorate.exception.NotFoundException;
import ru.yandex.practicum.filmorate.model.Genre;
import ru.yandex.practicum.filmorate.storage.genre.GenreStorage;

import java.util.List;

@Service
public class GenreService {

    private final GenreStorage genreStorage;

    public GenreService(@Qualifier("genreDbStorage") GenreStorage genreStorage) {
        this.genreStorage = genreStorage;
    }

    public Genre get(long id) {
        return genreStorage.get(id);
    }

    public List<Genre> getAll() {
        return genreStorage.getAll();
    }

    public Genre create(Genre data) {
        return genreStorage.create(data);
    }

    public void delete(long id) {
        genreStorage.delete(id);
    }

    public Genre update(Genre data) {
        if (genreStorage.get(data.getId()) == null) {
            throw new NotFoundException("Жанр не найден");
        }
        return genreStorage.update(data);
    }

    public List<Genre> getGenresByFilm(long filmId) {
        return genreStorage.getGenresByFilm(filmId);
    }

    public void addFilmGenre(long filmId, long genreId) {
        genreStorage.addFilmGenre(filmId, genreId);
    }

    public void removeFilmGenre(long filmId, long genreId) {
        genreStorage.removeFilmGenre(filmId, genreId);
    }
}