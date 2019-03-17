package ch.heigvd.res.labio.impl.filters;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

/**
 *
 * @author Olivier Liechti
 */
public class LitFilterWriter extends FilterWriter {

  public LitFilterWriter(Writer wrappedWriter) {
    super(wrappedWriter);
  }

  @Override
  public void write(String str, int off, int len) throws IOException {
    for(int i = off; i < len + off; i++){
      write(str.charAt(i));
    }
    // throw new UnsupportedOperationException("The student has not implemented this method yet.");
  }

  @Override
  public void write(char[] cbuf, int off, int len) throws IOException {
    for(int i = off; i < len + off; i++){
      write(cbuf[i]);
    }
  }

  @Override
  public void write(int c) throws IOException {
    switch(c){
      case 'e' :
      case 'E' : super.write('3'); break;
      case 'a' :
      case 'A' : super.write('4'); break;
      case 'l' :
      case 'L' : super.write('1'); break;
      case 'o' :
      case 'O' : super.write('0'); break;
      default : super.write(c);
    }
  }
}
