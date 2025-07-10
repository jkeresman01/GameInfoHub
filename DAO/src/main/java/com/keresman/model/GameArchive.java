package com.keresman.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "gamearhive")
@XmlAccessorType(XmlAccessType.FIELD)
public final class GameArchive {

  @XmlElementWrapper
  @XmlElement(name = "game")
  private List<Game> games;

  public GameArchive() {}

  public GameArchive(List<Game> games) {}

  public List<Game> getGames() {
    return new ArrayList<>(games);
  }

  public void setGames(List<Game> games) {
    this.games = games;
  }
}
