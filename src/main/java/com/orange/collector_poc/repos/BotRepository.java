package com.orange.collector_poc.repos;

import com.orange.collector_poc.models.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BotRepository  extends JpaRepository<Campaign,Long> {
}
