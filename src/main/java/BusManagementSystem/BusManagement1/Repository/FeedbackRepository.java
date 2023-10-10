package BusManagementSystem.BusManagement1.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import BusManagementSystem.BusManagement1.Model.Feedback;
@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

}
