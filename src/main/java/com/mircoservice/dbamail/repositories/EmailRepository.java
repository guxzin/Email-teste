package com.mircoservice.dbamail.repositories;

import com.mircoservice.dbamail.models.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<EmailModel, Long> {

}
