package com.garfield.teststream.util;

import java.util.Comparator;
import java.util.Map.Entry;

/**
 * @author pjk
 * @date 2019-06-24 14:28
 * @since
 */
public class ComparatorUtil {

  public static Comparator<Entry<String, Integer>> valueComparator() {
    //map按value排序
    Comparator<Entry<String, Integer>> valueComparator = new Comparator<Entry<String, Integer>>() {
      @Override
      public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
        //倒序
        return -o1.getValue().compareTo(o2.getValue());
      }
    };
    return valueComparator;
  }
}
