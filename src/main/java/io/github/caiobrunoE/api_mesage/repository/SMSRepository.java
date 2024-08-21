package io.github.caiobrunoE.api_mesage.repository;

import io.github.caiobrunoE.api_mesage.domain.SMSRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SMSRepository extends MongoRepository<SMSRequest, String> {
}
