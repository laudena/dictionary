package com.adpublishers.dictionary.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Entry {
    @Id
    private long id;
    private String title;
    private String file_name;
    private String translation;

    //constructor, getter, setter

    public Entry(long id, String title, String file_name, String translation) {
        this.id = id;
        this.title = title;
        this.file_name = file_name;
        this.translation = translation;
    }

    public Entry() {
    }

    @Override
    public String toString(){
        return String.format(
                "Entry[id=%d, title='%s', file='%s', trans='%s']",
                id, title, file_name, translation);
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public void setId(long id) {
        this.id = id;
    }
}
