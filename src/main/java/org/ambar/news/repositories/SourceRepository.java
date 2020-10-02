package org.ambar.news.repositories;

import org.ambar.news.models.Source;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SourceRepository extends JpaRepository<Source, String> {
}
