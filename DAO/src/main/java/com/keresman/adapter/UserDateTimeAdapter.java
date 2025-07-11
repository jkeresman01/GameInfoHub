package com.keresman.adapter;

import com.keresman.model.User;
import java.time.LocalDateTime;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class UserDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {

  @Override
  public LocalDateTime unmarshal(String text) throws Exception {
    return LocalDateTime.parse(text, User.DATE_FORMATTER);
  }

  @Override
  public String marshal(LocalDateTime localDateTime) throws Exception {
    return localDateTime.format(User.DATE_FORMATTER);
  }
}
