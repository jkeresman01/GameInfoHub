package com.keresman.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public final class Review {

    private int reviewId;
    private int gameId;
    private BigDecimal score;
    private String reviewText;
    private String reviewer;
    private LocalDateTime reviewDate;

}
