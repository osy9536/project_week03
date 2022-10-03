package com.sparta.project_week03.repository;

import java.time.LocalDateTime;

public interface BoardMappingFour {
    LocalDateTime getCreatedAt();
    LocalDateTime getModifiedAt();
    Long getId();
    String getTitle();
    String getuserName();
    String getcontent();
}
