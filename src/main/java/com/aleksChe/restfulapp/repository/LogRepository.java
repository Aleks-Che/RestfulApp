package com.aleksChe.restfulapp.repository;

import com.aleksChe.restfulapp.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log, Long> {
}
