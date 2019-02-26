package iam.deprest.demodatabase.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;


@Database(version = 1, entities = {Joke.class}, exportSchema = false)
@TypeConverters({Converter.class})
public abstract class JokeDatabaseSingleton extends RoomDatabase {

    private static JokeDatabaseSingleton instance;

    public static JokeDatabaseSingleton getInstance(Context context) {
        if(instance == null){
            instance = createDatabase(context);
        }

        return instance;
    }

    private static JokeDatabaseSingleton createDatabase(Context context) {
        //databank aanmaken
        return Room.databaseBuilder(context, JokeDatabaseSingleton.class, "Jokes.db").allowMainThreadQueries().build();
    }

    public abstract JokeDao getJokeDAO();

}
