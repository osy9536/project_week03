package com.sparta.project_week03.repository;

import com.sparta.project_week03.domain.Timestamped;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

public interface BoardMapping {
    LocalDateTime getCreatedAt();
    LocalDateTime getModifiedAt();
    Long getId();
    String getTitle();
    String getuserName();
}
