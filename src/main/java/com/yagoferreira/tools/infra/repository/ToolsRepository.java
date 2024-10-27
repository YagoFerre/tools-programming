package com.yagoferreira.tools.infra.repository;

import com.yagoferreira.tools.infra.entity.Tools;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToolsRepository extends JpaRepository<Tools, Long> {

    List<Tools> findByTagsContaining(String tag);

}
