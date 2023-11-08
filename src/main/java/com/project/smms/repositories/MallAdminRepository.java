package com.project.smms.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.smms.entity.MallAdmin;
import org.springframework.stereotype.Repository;

@Repository
public interface MallAdminRepository extends JpaRepository<MallAdmin, Serializable>{
}
