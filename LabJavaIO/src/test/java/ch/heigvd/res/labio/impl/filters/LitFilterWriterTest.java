package ch.heigvd.res.labio.impl.filters;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author Olivier Liechti
 */
public class LitFilterWriterTest {

  @Test
  public void itShouldWorkWhenWritingAString() throws IOException {
    String line = "hello wor1d";
    StringWriter stringWriter = new StringWriter();
    LitFilterWriter writer = new LitFilterWriter(stringWriter);
    writer.write(line);
    assertEquals("h3110 w0r1d", stringWriter.toString());
  }

  @Test
  public void itShouldWorkWhenWritingPartOfAString() throws IOException {
    String line = "hello wor1d";
    StringWriter stringWriter = new StringWriter();
    LitFilterWriter writer = new LitFilterWriter(stringWriter);
    writer.write(line, 3, 5);
    assertEquals("10 w0", stringWriter.toString());
  }

  @Test
  public void itShouldWorkWhenWritingACharArray() throws IOException {
    String line = "hello world";
    StringWriter stringWriter = new StringWriter();
    LitFilterWriter writer = new LitFilterWriter(stringWriter);
    char[] chars = new char[line.length()];
    line.getChars(0, line.length(), chars, 0);
    writer.write(chars);
    assertEquals("h3110 w0r1d", stringWriter.toString());
  }

  @Test
  public void itShouldWorkWhenWritingPartOfACharArray() throws IOException {
    String line = "hello world";
    StringWriter stringWriter = new StringWriter();
    LitFilterWriter writer = new LitFilterWriter(stringWriter);
    char[] chars = new char[line.length()];
    line.getChars(0, line.length() - 1, chars, 0);
    writer.write(chars, 3, 5);
    assertEquals("10 w0", stringWriter.toString());
  }

  @Test
  public void itShouldWorkWhenWritingASingleChar() throws IOException {
    String line = "hello world";
    StringWriter stringWriter = new StringWriter();
    LitFilterWriter writer = new LitFilterWriter(stringWriter);
    for (int i = 0; i < line.length(); i++) {
      writer.write(line.charAt(i));
    }
    assertEquals("h3110 w0r1d", stringWriter.toString());
  }

}
