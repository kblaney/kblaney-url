package com.kblaney.xml;

import org.junit.Test;

public final class JtidyUrlToDomDocumentFunctionTest
{
  @Test(expected = IllegalArgumentException.class)
  public void constructor_ZeroMaxNumDownloadAttempts()
  {
    new JtidyUrlToDomDocumentFunction(0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructor_NegativeMaxNumDownloadAttempts()
  {
    new JtidyUrlToDomDocumentFunction(-1);
  }

  @Test
  public void constructor_PositiveMaxNumDownloadAttempts()
  {
    new JtidyUrlToDomDocumentFunction(2);
  }
}
