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

import java.util.Comparator;
import java.util.*;

public class MergeSorter<T> implements Sorter<T> {
  @Override
  public void sort(T[] array, Comparator<T> comparator) {
    // TODO: implement merge sort
    if(array.length > 1) {
      Object[] left = new Object[array.length / 2];
      Object[] right = new Object[array.length - array.length / 2];
      for(int i = 0; i < array.length/2; i++) left[i] = array[i];
      for(int i = array.length / 2; i < array.length; i++) right[i - array.length / 2] = array[i];
      new MergeSorter<T>().sort((T[]) left, comparator);
      new MergeSorter<T>().sort((T[]) right, comparator);
      int pos1 = 0; int pos2 = 0;
      for(int i = 0; i < array.length; i++){
        if(pos1 == array.length / 2){
          array[i] = (T) right[pos2++];
          continue;
        }
        if(pos2 == array.length - array.length / 2){
          array[i] = (T) left[pos1++];
          continue;
        }
        if(comparator.compare((T) left[pos1], (T) right[pos2]) <= 0) array[i] = (T) left[pos1++];
        else array[i] = (T) right[pos2++];
      }
    }

  }
}
