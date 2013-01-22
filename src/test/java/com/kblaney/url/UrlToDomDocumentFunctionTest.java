package com.kblaney.url;

import org.junit.Test;

public final class UrlToDomDocumentFunctionTest
{
  @Test(expected = IllegalArgumentException.class)
  public void constructor_ZeroMaxNumDownloadAttempts()
  {
    new UrlToDomDocumentFunction(0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructor_NegativeMaxNumDownloadAttempts()
  {
    new UrlToDomDocumentFunction(-1);
  }

  @Test
  public void constructor_PositiveMaxNumDownloadAttempts()
  {
    new UrlToDomDocumentFunction(2);
  }
}
