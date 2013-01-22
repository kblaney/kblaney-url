package com.kblaney.url;

import java.io.IOException;
import java.net.URL;
import org.w3c.dom.Document;

/**
 * Converts a {@code java.net.URL} to an {@code org.w3c.dom.Document} with the contents of the URL.
 */
public interface UrlToDomDocumentFunction
{
  /**
   * Gets the DOM document for a specified URL.
   * 
   * @param url the URL
   * 
   * @return the DOM document for the URL
   * 
   * @throws IOException if can't read from {@code url}
   */
  Document apply(URL url) throws IOException;
}
