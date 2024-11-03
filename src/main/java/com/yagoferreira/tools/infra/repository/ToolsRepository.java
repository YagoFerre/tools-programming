package com.yagoferreira.tools.infra.repository;

import com.yagoferreira.tools.infra.entity.ToolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToolsRepository extends JpaRepository<ToolEntity, Long> {

    List<ToolEntity> findByTagsContaining(String tag);

}
