package iam.deprest.demodatabase.model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface JokeDao {

    @Insert
    void insertJoke(Joke newJoke);

    @Delete
    void deleteJoke(Joke badJoke);

    @Update
    void updateJoke(Joke changedJoke);

    @Query("SELECT * FROM Joke") //zelf een query schrijven voor een findAll methode, want die bestaat standaard nog niet
    List<Joke> findAllJokes();

    @Query("SELECT * FROM Joke WHERE id = :id") // : wil zeggen dat je het uit je parameters haalt (van hieronder)
    Joke selectJokeById (long id);
}
