package com.kblaney.url;

import com.kblaney.assertions.ArgAssert;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import org.apache.commons.io.IOUtils;

/**
 * Reads the contents of a URL into a string.
 */
public final class UrlToContentFunction implements UrlFunction<String>
{
  private final Charset charset;

  /**
   * Constructs a new reader that assumes that URL contents are encoded in US-ASCII.
   */
  public UrlToContentFunction()
  {
    this(Charset.forName("US-ASCII"));
  }

  /**
   * Constructs a new reader that uses a specified character set for URL contents.
   * 
   * @param charset the character set, which can't be null
   */
  public UrlToContentFunction(final Charset charset)
  {
    this.charset = ArgAssert.assertNotNull(charset, "charset");
  }

  /** {@inheritDoc} */
  public String convert(final URL url) throws IOException
  {
    ArgAssert.assertNotNull(url, "url");

    return IOUtils.toString(url.openStream(), charset);
  }
}
