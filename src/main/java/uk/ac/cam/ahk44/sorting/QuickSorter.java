/*
 * Copyright 2021 David Berry <dgb37@cam.ac.uk>, Amir Kadkhodaei
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.ac.cam.ahk44.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class QuickSorter<T> implements Sorter<T> {
  @Override
  public void sort(T[] array, Comparator<T> comparator) {
    // TODO: implement in-place quick sort without using temporary array
    go(array, comparator, 0, array.length);
  }
  public void go(T[] array, Comparator<T> comparator, int l, int r) {
    //System.out.println(l);
    //System.out.println(r);
    if(l < 0 || r == 0 || r == l || r == l + 1) return;
    int pos = l;
    for(int i = l; i < r; i++){
      if(comparator.compare(array[i], array[r - 1]) < 0){
        T temp = array[i];
        array[i] = array[pos];
        array[pos] = temp;
        pos++;
      }
    }
    T temp = array[r - 1];
    array[r - 1] = array[pos];
    array[pos] = temp;
    go(array, comparator, l, pos);
    go(array, comparator, pos + 1, r);
  }
}
