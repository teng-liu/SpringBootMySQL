package com.tamiconnectdb.TamiConnDB;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TamiRepos extends JpaRepository<Form, Integer> {



}
