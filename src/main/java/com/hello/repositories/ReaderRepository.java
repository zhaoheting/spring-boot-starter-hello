package com.hello.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hello.entities.Reader;

public interface ReaderRepository extends JpaRepository<Reader,String> {
}
