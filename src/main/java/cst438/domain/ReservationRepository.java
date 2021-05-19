package cst438.domain;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
   @Query("select m from Reservation m order by email, cityName desc")
   List<Reservation> findAllReservationsOrderByEmailCityNameDesc();
}