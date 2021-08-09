import java.io.*;
/**
 * This is ReadFile class which is responsible for reading the data from file
 *
 * @author Bhagyashree Aras
 * @version 1.0
 */
public class ReadFile
{
    /**
     * The read data file will read the data and store in array
     *
     * @param value number of values to be read
     * @param filename name of the file
     * @return array of values
     */
    public double[] readData(int value, String filename)
    {
        double[] array = new double[value];
        try (LineNumberReader reader =
                     new LineNumberReader(new FileReader(filename)))
        {
            Double line = Double.parseDouble(reader.readLine());
            array[0] = line;
            for(int i = 1; i < value; i++)
            {
                line = Double.parseDouble(reader.readLine());
                array[i] = line;
            }
            if(line == null)
            {
                System.out.println("File ends!");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return array;
    }

}
