package com.kblaney.url;

import java.io.IOException;
import java.net.URL;

/**
 * Converts from a {@code java.net.URL} into another type.
 * 
 * @param <T> the type of object to create from the URL
 */
public interface UrlFunction<T>
{
  /**
   * Converts a specified URL.
   * 
   * @param url the URL
   * 
   * @return the object created by converting the URL
   * 
   * @throws IOException if can't convert {@code url}
   */
  T convert(URL url) throws IOException;
}
