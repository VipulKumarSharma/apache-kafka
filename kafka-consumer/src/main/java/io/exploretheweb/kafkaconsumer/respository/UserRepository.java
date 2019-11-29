package io.exploretheweb.kafkaconsumer.respository;

import io.exploretheweb.kafkaproducer.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
