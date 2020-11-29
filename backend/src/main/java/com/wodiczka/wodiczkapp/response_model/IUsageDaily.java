package com.wodiczka.wodiczkapp.response_model;

import java.time.LocalDateTime;

public interface IUsageDaily {
    LocalDateTime getLocatDateTime();
    Integer getTotalDayLiters();
}
