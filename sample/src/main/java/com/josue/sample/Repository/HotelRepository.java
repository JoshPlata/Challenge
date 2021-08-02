package com.josue.sample.Repository;

import com.josue.sample.Entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    @Query(nativeQuery = true, value = "UPDATE hotel SET description = ?1 , name = ?2 , stars = ?3 WHERE id = ?4")
    void updateHotel(String description, String name, int stars, Long id);
}
