package com.adpublishers.dictionary.controller;


import java.util.List;
import java.util.Optional;

import com.adpublishers.dictionary.domain.model.Entry;
import com.adpublishers.dictionary.repository.EntryRepository;
import com.adpublishers.dictionary.domain.model.EntryTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entry")
public class EntryController {

    @Autowired
    private EntryRepository entryRepository;

    @GetMapping
    public List<Entry> findAllEntries() {
        return (List<Entry>) entryRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entry> findEntryById(@PathVariable(value = "id") long id) {
        Optional<Entry> entry = entryRepository.findById(id);

        if(entry.isPresent()) {
            return ResponseEntity.ok().body(entry.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/title/{title}")
    public List<EntryTitle> findEntryByTitle(@PathVariable(value = "title") String title) {
        return entryRepository.findTitleByTitleStartingWith(title);
    }

    @PostMapping
    public Entry saveEntry(@Validated @RequestBody Entry entry) {
        return entryRepository.save(entry);
    }
}


