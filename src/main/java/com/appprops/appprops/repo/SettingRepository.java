package com.appprops.appprops.repo;

import com.appprops.appprops.model.Setting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SettingRepository extends JpaRepository<Setting, Long> {
    List<Setting> findAll();
}
