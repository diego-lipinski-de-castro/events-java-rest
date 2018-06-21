package d2.api.events.repositories;

import d2.api.events.models.EventPromotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsPromotionsRepository extends JpaRepository<EventPromotion, Long> { }
