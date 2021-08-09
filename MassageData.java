import java.util.Arrays;
/**
 * This is MassageData class which is responsible for modifying the data as
 * per degree of sortedness
 *
 * @author Bhagyashree Aras
 * @version 1.0
 */
public class MassageData
{
    /**
     * getInversionCount
     *
     * @param arrayLength length of array
     * @param degreeOfSortedness degree of sortedness
     * @return inversion count
     */
    public long getInversionCount(long arrayLength,
                                         int degreeOfSortedness)
    {
        long maxPossibleInversions = arrayLength * (arrayLength - 1) / 2;
        double degreeOfUnsortedness = (100 - degreeOfSortedness);
        long value = Math.round(degreeOfUnsortedness * maxPossibleInversions)/100;

        return value;
    }

    /**
     * inversionCount will calculate inversion count
     *
     * @param array values of array
     * @return inversion count
     */

    public long inversionCount(double[] array)
    {
        long inversionCount = 0;

        for(int i = 0 ; i < array.length ; i++)
        {
            for(int j = i + 1 ; j < array.length ; j++)
            {
                if (array[i] > array[j])
                {
                    inversionCount = inversionCount + 1;
                }
            }
        }

        return inversionCount;
    }

    /**
     * generateDegreeOfSortednessArray will generate a array of specific degree
     *
     * @param arr values of array
     * @param inversionCount inversion count
     * @return array of values with a specific degree
     */
    public double[] generateDegreeOfSortednessArray(double[] arr,
                                                           long inversionCount)
    {
        int n = arr.length;
        double[] copy = Arrays.copyOf(arr, n);
        Arrays.sort(copy);
        int m = (int) Math.floor((1 + Math.sqrt(1 + 8 * inversionCount)) / 2);
        for (int i = 0; i < m/2; i++)
        {
            double temp = copy[i];
            copy[i] = copy[m - 1 - i];
            copy[m - 1 - i] = temp;
        }

        inversionCount -= inversionCount(copy);
        if (inversionCount > 0)
        {
            boolean flag = true;
            for (int i = 0; i < n - m; i++)
            {
                for (int j = m; j < n - 1 - i; j++)
                {
                    if (copy[j+1] != copy[j])
                    {
                        double temp = copy[j];
                        copy[j] = copy[j+1];
                        copy[j+1] = temp;
                        inversionCount--;
                        if (inversionCount == 0)
                        {
                            flag = false;
                            break;
                        }
                    }
                }

                if (!flag)
                {
                    break;
                }
            }
        }

        if (inversionCount > 0)
        {
            boolean flag = true;
            for (int i = 0; i < n - m; i++)
            {
                for (int j = m + i; j > 0; j--)
                {
                    if (copy[j-1] != copy[j])
                    {
                        double temp = copy[j];
                        copy[j] = copy[j-1];
                        copy[j-1] = temp;
                        inversionCount--;
                        if (inversionCount == 0)
                        {
                            flag = false;
                            break;
                        }
                    }
                }

                if (!flag)
                {
                    break;
                }
            }
        }
        return copy;
    }
}

