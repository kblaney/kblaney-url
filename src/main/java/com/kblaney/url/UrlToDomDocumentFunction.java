package com.kblaney.url;

import com.kblaney.assertions.ArgAssert;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.apache.commons.io.IOUtils;
import org.w3c.dom.Document;
import org.w3c.tidy.Tidy;

/**
 * Reads from a {@code java.net.URL} to create an {@code org.w3c.dom.Document} with the contents of the URL.
 */
public final class UrlToDomDocumentFunction implements UrlFunction<Document>
{
  private static final int DEFAULT_MAX_NUM_DOWNLOAD_ATTEMPTS = 10;
  private final int maxNumDownloadAttempts;

  /**
   * Constructs a new instance that attempts to download 10 times.
   */
  public UrlToDomDocumentFunction()
  {
    this(DEFAULT_MAX_NUM_DOWNLOAD_ATTEMPTS);
  }

  /**
   * Constructs a new instance that attempts to download a specified maximum number of times.
   * 
   * @param maxNumDownloadAttempts the maximum number of download attempts, which must be positive
   */
  public UrlToDomDocumentFunction(final int maxNumDownloadAttempts)
  {
    this.maxNumDownloadAttempts = ArgAssert.assertGreaterThan(maxNumDownloadAttempts, 0, "maxNumDownloadAttempts");
  }

  @Override
  public Document convert(final URL url) throws IOException
  {
    ArgAssert.assertNotNull(url, "url");

    BufferedInputStream bufferedInputStream = null;
    try
    {
      final Tidy tidy = new Tidy();
      tidy.setXmlOut(true);
      tidy.setQuiet(true);
      tidy.setShowWarnings(false);
      bufferedInputStream = new BufferedInputStream(getInputStream(url));
      return tidy.parseDOM(bufferedInputStream, null);
    }
    finally
    {
      IOUtils.closeQuietly(bufferedInputStream);
    }
  }

  private InputStream getInputStream(final URL url) throws IOException
  {
    IOException ioException = null;
    int numAttempts = 0;
    while (numAttempts < maxNumDownloadAttempts)
    {
      try
      {
        return url.openStream();
      }
      catch (final IOException e)
      {
        ioException = e;
      }
      numAttempts++;
    }

    throw ioException;
  }
}
