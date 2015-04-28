import java.util.*;

public class Sorts
{
  public void bubbleSort(int[] list)
  {
    for(int i = 0; i < list.length-1; i++)
    {
      for(int q = 0; q < list.length-1-i; q++)
      {
        if(list[q] > list[q+1])
        {
          int temp = list[q+1];
          list[q+1] = list[q];
          list[q] = temp;
        }
      }
    }
  }

  public void selectionSort(int[] list)
  {
    int flag, temp;
    for (int outer = 0; outer < list.length - 1; outer++)
    {
      flag = outer;  
      for (int inner = outer + 1; inner < list.length; inner++)
        if (list[inner] < list[flag])
          flag = inner;
      //swap list[outer] & list[flag]
      temp = list[outer];
      list[outer] = list[flag];
      list[flag] = temp;
    }
  }

  public void insertionSort(int[] list)
  {
    for (int outer = 1; outer < list.length; outer++)
    {
      int position = outer;
      int key = list[position];
      // Shift larger values to the right
      while (position > 0 && list[position - 1] > key)
      {
        list[position] = list[position - 1];
        position--;
      }
      list[position] = key;
    }
  }

  private void merge(int[] a, int first, int mid, int last)
  {
    int[] tempMergArr = new int[a.length];
    for (int i = first; i <= last; i++) {
            tempMergArr[i] = a[i];
        }
        int i = first;
        int j = mid + 1;
        int k = first;

        while (i <= mid && j <= last) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                a[k] = tempMergArr[i];
                i++;
            } else {
                a[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            a[k] = tempMergArr[i];
            k++;
            i++;
        }
  }

  public void mergeSort(int[] a, int first, int last)
  {
     if(first < last)
     {
        int mid = first + (last - first) / 2;
        mergeSort(a, first, mid);
        mergeSort(a, mid+1, last);
        merge(a, first, mid, last);
     } 
  }
}

