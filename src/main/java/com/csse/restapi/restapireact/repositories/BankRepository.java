package com.csse.restapi.restapireact.repositories;

import com.csse.restapi.restapireact.entities.Bank;
import com.csse.restapi.restapireact.entities.PublicationReports;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {
}
