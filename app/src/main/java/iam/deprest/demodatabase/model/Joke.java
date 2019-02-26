package iam.deprest.demodatabase.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;
import java.util.Date;

@Entity
public class Joke implements Serializable { //serializable om tussen schermen te communiceren (bv om naar detailscherm te gaan)

    @PrimaryKey
    private long id;
    private String jokeText;
    private Date publishDate; //date uit util nemen!!!     !!CONVERTER NODIG, om datum om te zetten naar iets wat room verstaat

    //room gebruikt enkel de default constructor, andere mag room negeren, maar kunnen wij wel in code gebruiken
    public Joke() {
    }

    @Ignore //anders krijgen we een warning van room. Met @ignore zal Room deze constructor negeren, maar wij kunnen die constructor dan nog gebruiken
    public Joke(String jokeText, Date publishDate) {
        this.jokeText = jokeText;
        this.publishDate = publishDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJokeText() {
        return jokeText;
    }

    public void setJokeText(String jokeText) {
        this.jokeText = jokeText;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
}
