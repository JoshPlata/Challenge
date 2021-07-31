package com.josue.sample.Repository;

import com.josue.sample.Entity.GuestType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestTypeRepository extends JpaRepository<GuestType, Long> {
}
