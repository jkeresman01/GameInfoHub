package com.keresman.model;

import java.time.LocalDate;
import java.util.List;

public final class Game {

  private int gameId;
  private String title;
  private LocalDate releaseDate;
  private Developer developer;
  private String description;
  private String link;
  private List<Platform> platforms;
  private List<Genre> genres;
  private List<Review> reviews;
}
