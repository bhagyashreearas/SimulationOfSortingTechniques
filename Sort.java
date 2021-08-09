/**
 * This is Sort class which includes various types of sorting techniques
 *
 * @author Bhagyashree Aras
 * @version 1.0
 */
public class Sort
{
    /**
     * Bubble Sort
     *
     * @param arr array of values
     * @return sorted array
     */
    public double[] bubbleSort(double arr[])
    {
        // Time complexity: average O(n^2), best O(n)
        // Space complexity: O(1)
        double[] newArray = new double[arr.length];
        for(int i = 0; i < arr.length; i++)
        {
            newArray[i] = arr[i];
        }
        for(int i = 0; i <= newArray.length - 2; i++)
        {
            for(int j = 0; j <= (newArray.length- 2 - i); j++)
            {
                if(newArray[j + 1] < newArray[j]) {
                    double temp = newArray[j];
                    newArray[j] = newArray[j + 1];
                    newArray[j + 1] = temp;
                }
            }
        }
        return newArray;
    }

    /**
     * Selection Sort
     *
     * @param arr Array of values
     * @return sorted array
     */
    public double[] selectionSort(double arr[])
    {
        // Time complexity: O(n^2)
        // Space complexity: O(1)
        double[] newArray = new double[arr.length];
        for(int i = 0; i < arr.length; i++)
        {
            newArray[i] = arr[i];
        }
        for(int i = 0; i <= newArray.length - 2; i++)
        {
            int min = i;
            for(int j = i + 1; j <= newArray.length - 1; j++)
            {
                if(newArray[min] > arr[j]) {
                    min = j;
                }
            }

            double temp = newArray[min];
            newArray[min] = newArray[i];
            newArray[i] = temp;
        }
        return newArray;
    }

    /**
     * Merge Sort
     *
     * @param arr array of values
     * @return sorted array
     */
    public double[] mergeSort(double[] arr)
    {
        // Time complexity: O(n*log(n))
        // Space complexity: O(n)
        double[] newArray = new double[arr.length];
        for(int i = 0; i < arr.length; i++)
        {
            newArray[i] = arr[i];
        }
        int start = 0;
        int end = newArray.length - 1;
        return mergeHelper(newArray, start, end);
    }

    /**
     * mergeHelper is a helper function to merge sort
     *
     * @param array Array of values
     * @param start start index
     * @param end end index
     * @return sorted array
     */
    private double[] mergeHelper(double[] array, int start, int end)
    {
        if (start == end)
            return null;

        int mid = (start + end)/2;
        mergeHelper(array, start, mid);
        mergeHelper(array, mid+1, end);
        array = merge(array, start, mid, end);
        return array;
    }

    /**
     * merge is function to merge arrays
     *
     * @param array array values
     * @param start start index
     * @param mid   mid index
     * @param end   end index
     * @return sorted array
     */
    private double[] merge(double[] array, int start,
                                           int mid, int end)
    {
        int i = start;
        int j = mid+1;
        double[] temp = new double[end - start + 1];
        int k = 0;

        while (i <= mid && j <= end)
        {
            if (array[i] > array[j])
            {
                temp[k] = array[j];
                j++;
            }
            else
            {
                temp[k] = array[i];
                i++;
            }
            k++;
        }

        while (i <= mid)
        {
            temp[k] = array[i];
            i++;
            k++;
        }

        while (j <= end)
        {
            temp[k] = array[j];
            j++;
            k++;
        }
        // transferring values to original array
        int m = start;
        for (int t = 0; t < k; t++)
        {
            array[m] = temp[t];
            m++;
        }
        return array;
    }

    /**
     * Insertion sort
     *
     * @param arr array of values
     * @return sorted array
     */
    public double[] insertionSort(double[] arr)
    {
        // Time complexity: average O(n^2), best O(n)
        // Space complexity: O(1)
        double[] newArray = new double[arr.length];
        for(int i = 0; i < arr.length; i++)
        {
            newArray[i] = arr[i];
        }

        for (int i = 1; i < newArray.length; i++)
        {
            double min = newArray[i];
            int j = i - 1;

            while (j >= 0 && newArray[j] > min)
            {
                newArray[j + 1] = newArray[j--];
            }
            newArray[j + 1] = min;
        }
        return newArray;
    }

    public void quickSort(double[] arr, int left, int right)
    {
        // Time complexity: average O(n*log(n)),worst O(n^2)
        // Space complexity: O(log(n))
        if (left < right)
        {
            int pivotIndex = partition(arr, left, right);
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }

    private int partition(double[] arr, int start, int end)
    {
        int pivotIndex = choosePivot(start, end);
        double pivot = arr[pivotIndex];
        swap(arr,pivotIndex,end);
        int index = start;
        for (int i = start; i < end; i++)
        {
            if (arr[i] - pivot < 0)
            {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, index, end);
        return index;

    }

    /**
     * choosePivot will find pivot
     *
     * @param start
     * @param end
     * @return
     */
    private static int choosePivot(int start, int end)
    {
        return (int) (start + (end - start + 1) * Math.random());
    }

    /**
     * The swap will swap the values in array.
     * @param arr
     * @param i index of value1
     * @param j index of value2
     */
    private void swap(double[] arr, int i, int j)
    {
        if (i >= 0 && j >= 0 && i < arr.length && j < arr.length)
        {
            double temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}

