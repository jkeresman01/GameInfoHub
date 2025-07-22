package com.keresman.factory;

import java.io.InputStream;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;

public class ParserFactory {

  private ParserFactory() {
    // Suppresses default constructor, ensuring non-instantiability.
  }

  public static XMLEventReader createStaxParser(InputStream inputStream) throws XMLStreamException {
    return XMLInputFactory.newInstance().createXMLEventReader(inputStream);
  }
}
