package com.adpublishers.dictionary.repository;

import java.util.List;

import com.adpublishers.dictionary.domain.model.Entry;
import com.adpublishers.dictionary.domain.model.EntryTitle;
import org.springframework.data.repository.CrudRepository;

public interface EntryRepository extends CrudRepository<Entry, Long> {
    List<EntryTitle> findTitleByTitleStartingWith(String title);
}

