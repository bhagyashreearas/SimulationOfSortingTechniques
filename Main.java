import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.math.RoundingMode;
import java.text.DecimalFormat;
/**
 * This is main class from where simulations will run
 *
 * @author Bhagyashree Aras
 * @version 1.0
 */
public class Main
{
    private static DecimalFormat decimalFormat = new DecimalFormat("#.###");
    private static final long MEGABYTE = 1024L * 1024L;
    private static final int MAX = 5;
    private static final int CONVERTSEC = 1000;

    /**
     * The main method will execute the whole program
     * @param args
     */
    public static void main(String[] args)
    {
        Sort sort = new Sort();
        Random rand = new Random();
        ReadFile readFile = new ReadFile();
        int[] array = {40000, 80000, 120000, 160000, 200000};
        String[] filename = {"weather.txt", "consumer.txt"};
        MassageData massageData = new MassageData();
        Runtime runtime = Runtime.getRuntime();

        runForSyntheticDataSet1(array, sort, rand, massageData, runtime);
        runForSyntheticDataSet2(array, sort, rand, massageData, runtime);
        runForRealDataSet3(array, sort, readFile, filename, massageData,
            runtime);
        runForRealDataSet4(array, sort, readFile, filename, massageData,
           runtime);


    }

    /**
     * runForRealDataSet4 is function to run simulations on dataset4
     * @param array
     * @param sort
     * @param readFile
     * @param filename
     * @param massageData
     * @param runtime
     */
    private static void runForRealDataSet4(int[] array, Sort sort,
                                           ReadFile readFile, String[] filename,
                                           MassageData massageData, Runtime runtime)
    {

        System.out.println("...................................");
        System.out.println("Simulation for Real dataset2: ");
        System.out.println("...................................");

        for (int m = 0; m < array.length; m++)
        {
            double[] dataSet4;
            dataSet4 = readFile.readData(array[m], filename[1]);

            bubbleSortSimulation(dataSet4, sort, array, m, runtime);
            insertionSortSimulation(dataSet4,sort,array,m, runtime);
            mergeSortSimulation(dataSet4,sort,array,m, runtime);
            selectionSortSimulation(dataSet4,sort,array,m, runtime);
            quickSortSimulation(dataSet4,sort,array,m, runtime);
            degreeOfSortedness(dataSet4,sort,array,m, massageData, runtime);
            System.out.println("\n********************************");
            System.out.println("********************************");

        }

    }

    /**
     * runForRealDataSet3 is function to run simulations on dataset3
     * @param array
     * @param sort
     * @param readFile
     * @param filename
     * @param massageData
     * @param runtime
     */
    private static void runForRealDataSet3(int[] array,
                                           Sort sort,
                                           ReadFile readFile,
                                           String[] filename,
                                           MassageData massageData, Runtime runtime)
    {
        System.out.println("...................................");
        System.out.println("Simulation for Real dataset1: ");
        System.out.println("...................................");

        for (int m = 0; m < array.length; m++)
        {
            double[] dataSet3;
            dataSet3 = readFile.readData(array[m], filename[0]);

            bubbleSortSimulation(dataSet3, sort, array, m, runtime);
            insertionSortSimulation(dataSet3,sort,array,m, runtime);
            mergeSortSimulation(dataSet3,sort,array,m, runtime);
            selectionSortSimulation(dataSet3,sort,array,m, runtime);
            quickSortSimulation(dataSet3,sort,array,m,runtime);
            degreeOfSortedness(dataSet3,sort,array,m, massageData, runtime);
            System.out.println("\n********************************");
            System.out.println("********************************");
        }
    }

    /**
     * runForSyntheticDataSet2 is function to run simulations on dataset2
     * @param array
     * @param sort
     * @param rand
     * @param massageData
     * @param runtime
     */
    private static void runForSyntheticDataSet2(int[] array, Sort sort,
                                                Random rand,
                                                MassageData massageData,
                                                Runtime runtime)
    {
        double[] dataSet2;
        System.out.println("...................................");
        System.out.println("Simulation for Synthetic dataset2: ");
        System.out.println("...................................");

        for (int m = 0; m < array.length; m++)
        {
            dataSet2 = new double[array[m]];
            dataSet2 = getDataSet2(dataSet2, rand);

            bubbleSortSimulation(dataSet2, sort, array, m, runtime);
            insertionSortSimulation(dataSet2,sort,array,m,runtime);
            mergeSortSimulation(dataSet2,sort,array,m, runtime);
            selectionSortSimulation(dataSet2,sort,array,m, runtime);
            quickSortSimulation(dataSet2,sort,array,m, runtime);
            degreeOfSortedness(dataSet2,sort,array,m, massageData, runtime);
            System.out.println("\n********************************");
            System.out.println("********************************");
        }

    }

    /**
     * runForSyntheticDataSet1 is function to run simulations on dataset1
     * @param array
     * @param sort
     * @param rand
     * @param massageData
     * @param runtime
     */
    private static void runForSyntheticDataSet1(int[] array,
                                                Sort sort, Random rand,
                                                MassageData massageData, Runtime runtime)
    {
        double min = 10000.00;
        double max = 2500000.00;
        double[] dataSet1;
        System.out.println("...................................");
        System.out.println("Simulation for Synthetic dataset1: ");
        System.out.println("...................................");

        for (int m = 0; m < array.length; m++)
        {
            dataSet1 = new double[array[m]];
            dataSet1 = getDataSet1(dataSet1, min, max, rand);

            bubbleSortSimulation(dataSet1, sort, array, m, runtime);
            insertionSortSimulation(dataSet1,sort,array,m, runtime);
            mergeSortSimulation(dataSet1,sort,array,m, runtime);
            selectionSortSimulation(dataSet1,sort,array,m, runtime);
            quickSortSimulation(dataSet1,sort,array,m, runtime);
            degreeOfSortedness(dataSet1,sort,array,m, massageData, runtime);
            System.out.println("\n********************************");
            System.out.println("********************************");
        }
    }

    /**
     * degreeOfSortedness will run simulations as per specific degree
     * @param dataSet
     * @param sort
     * @param array
     * @param m
     * @param massageData
     * @param runtime
     */
    private static void degreeOfSortedness(double[] dataSet,
                                           Sort sort, int[] array, int m,
                                           MassageData massageData,
                                           Runtime runtime)
    {
        int[] degree = {0,20,40,60,80,100};
        for (int i = 0; i < degree.length; i++)
        {
            System.out.println("\n...................");
            System.out.println("For degree " + degree[i] + ": ");
            System.out.println("...................");
            long inversionCount = massageData.getInversionCount(dataSet.length,
                    degree[i]);
            double[] output = massageData.generateDegreeOfSortednessArray(dataSet
                    , inversionCount);

            bubbleSortSimulation(output, sort, array, m, runtime);
            insertionSortSimulation(output,sort,array,m, runtime);
            mergeSortSimulation(output,sort,array,m, runtime);
            selectionSortSimulation(output,sort,array,m, runtime);
            quickSortSimulation(output,sort,array,m, runtime);
        }

    }

    /**
     * quickSortSimulation is for quick sort
     * @param dataSet1
     * @param sort
     * @param array
     * @param m
     * @param runtime
     */
    private static void quickSortSimulation(double[] dataSet1,
                                            Sort sort, int[] array, int m,
                                            Runtime runtime)
    {
        System.out.println("\nQUICK SORT SIMULATION for " + array[m] + " " +
                "dataset.");
        double time;
        double averageTime;
        double averageMemory;
        double totalTime = 0;
        double spaceComplexitySort = 0;
        long usedMemoryBefore;
        long usedMemoryAfter;
        Instant startTime;
        Instant finishTime;

        for (int i = 0; i < 5; i++)
        {
            runtime.gc();
            usedMemoryBefore =
                    runtime.totalMemory() - runtime.freeMemory();

            startTime = Instant.now();
            sort.quickSort(dataSet1,0, dataSet1.length - 1);
            finishTime = Instant.now();
            usedMemoryAfter =
                    runtime.totalMemory() - runtime.freeMemory();
            time = Duration.between(startTime, finishTime).toMillis();
            totalTime += time;
            spaceComplexitySort += usedMemoryAfter - usedMemoryBefore;

        }

        averageMemory = (double)spaceComplexitySort/(MAX * MEGABYTE);
        averageTime = totalTime/(MAX * CONVERTSEC);
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        System.out.println("Average Time for (" + array[m] +
                ") : " + decimalFormat.format(averageTime) + " s");
        System.out.println("Average Memory for (" + array[m] +
                ") :" +
                " " + decimalFormat.format(averageMemory) + " MB");
    }

    /**
     * selectionSortSimulation is for selection sort
     * @param dataSet1
     * @param sort
     * @param array
     * @param m
     * @param runtime
     */
    private static void selectionSortSimulation(double[] dataSet1,
                                                Sort sort, int[] array, int m,  Runtime runtime)
    {
        System.out.println("\nSELECTION SORT SIMULATION for " + array[m] + " " +
                "dataset.");
        double time;
        double averageTime;
        double averageMemory;
        double totalTime = 0;
        double spaceComplexitySort = 0;
        long usedMemoryBefore;
        long usedMemoryAfter;
        Instant startTime;
        Instant finishTime;

        for (int i = 0; i < 5; i++)
        {
            runtime.gc();
            usedMemoryBefore =
                    runtime.totalMemory() - runtime.freeMemory();
            startTime = Instant.now();
            sort.selectionSort(dataSet1);
            finishTime = Instant.now();
            usedMemoryAfter =
                    runtime.totalMemory() - runtime.freeMemory();
            time = Duration.between(startTime, finishTime).toMillis();
            totalTime += time;
            spaceComplexitySort += usedMemoryAfter - usedMemoryBefore;

        }
        averageMemory = (double)spaceComplexitySort/(MAX * MEGABYTE);
        averageTime = totalTime/(MAX * CONVERTSEC);
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        System.out.println("Average Time for (" + array[m] +
                ") : " + decimalFormat.format(averageTime) + " s");
        System.out.println("Average Memory for (" + array[m] +
                ") :" +
                " " + decimalFormat.format(averageMemory) + " MB");
    }

    /**
     * mergeSortSimulation is for merge sort simulations
     * @param dataSet1
     * @param sort
     * @param array
     * @param m
     * @param runtime
     */
    private static void mergeSortSimulation(double[] dataSet1,
                                            Sort sort, int[] array, int m,  Runtime runtime)
    {
        System.out.println("\nMERGE SORT SIMULATION for " + array[m] + " " +
                "dataset.");
        double time;
        double averageTime;
        double averageMemory;
        double totalTime = 0;
        double spaceComplexitySort = 0;
        long usedMemoryBefore;
        long usedMemoryAfter;
        Instant startTime;
        Instant finishTime;

        for (int i = 0; i < 5; i++)
        {
            runtime.gc();
            usedMemoryBefore =
                    runtime.totalMemory() - runtime.freeMemory();

            startTime = Instant.now();
            sort.mergeSort(dataSet1);
            finishTime = Instant.now();
            usedMemoryAfter =
                    runtime.totalMemory() - runtime.freeMemory();
            time = Duration.between(startTime, finishTime).toMillis();
            totalTime += time;
            spaceComplexitySort += usedMemoryAfter - usedMemoryBefore;

        }
        averageMemory = (double)spaceComplexitySort/(MAX * MEGABYTE);
        averageTime = totalTime/(MAX * CONVERTSEC);
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        System.out.println("Average Time for (" + array[m] +
                ") : " + decimalFormat.format(averageTime) + " s");
        System.out.println("Average Memory for (" + array[m] +
                ") :" +
                " " + decimalFormat.format(averageMemory) + " MB");
    }

    /**
     * insertionSortSimulation is for insertion sort
     * @param dataSet1
     * @param sort
     * @param array
     * @param m
     * @param runtime
     */
    private static void insertionSortSimulation(double[] dataSet1,
                                                Sort sort, int[] array, int m,  Runtime runtime)
    {
        System.out.println("\nINSERTION SORT SIMULATION for " + array[m] + " " +
                "dataset.");
        double time;
        double averageTime;
        double averageMemory;
        double totalTime = 0;
        double spaceComplexitySort = 0;
        long usedMemoryBefore;
        long usedMemoryAfter;
        Instant startTime;
        Instant finishTime;

        for (int i = 0; i < 5; i++)
        {
            runtime.gc();
            usedMemoryBefore =
                    runtime.totalMemory() - runtime.freeMemory();

            startTime = Instant.now();
            sort.insertionSort(dataSet1);
            finishTime = Instant.now();
            usedMemoryAfter =
                    runtime.totalMemory() - runtime.freeMemory();
            time = Duration.between(startTime, finishTime).toMillis();
            totalTime += time;
            spaceComplexitySort += usedMemoryAfter - usedMemoryBefore;

        }
        averageMemory = (double)spaceComplexitySort/(MAX * MEGABYTE);
        averageTime = totalTime/(MAX * CONVERTSEC);
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        System.out.println("Average Time for (" + array[m] +
                ") : " + decimalFormat.format(averageTime) + " s");
        System.out.println("Average Memory for (" + array[m] +
                ") :" +
                " " + decimalFormat.format(averageMemory) + " MB");
    }

    /**
     * bubbleSortSimulation is for bubble sort
     * @param dataSet1
     * @param sort
     * @param array
     * @param m
     * @param runtime
     */
    private static void bubbleSortSimulation(double[] dataSet1,
                                             Sort sort, int[] array, int m,  Runtime runtime)
    {
        System.out.println("\nBUBBLE SORT SIMULATION for " + array[m] + " " +
                "dataset.");
        double time;
        double averageTime;
        double averageMemory;
        double totalTime = 0;
        double spaceComplexitySort = 0;
        long usedMemoryBefore;
        long usedMemoryAfter;
        Instant startTime;
        Instant finishTime;

        for (int i = 0; i < 5; i++)
        {
            runtime.gc();
            usedMemoryBefore =
                    runtime.totalMemory() - runtime.freeMemory();

            startTime = Instant.now();
            sort.bubbleSort(dataSet1);
            finishTime = Instant.now();
            usedMemoryAfter =
                    runtime.totalMemory() - runtime.freeMemory();
            time = Duration.between(startTime, finishTime).toMillis();
            totalTime += time;
            spaceComplexitySort += usedMemoryAfter - usedMemoryBefore;

        }
        averageMemory = (double)spaceComplexitySort/(MAX * MEGABYTE);
        averageTime = totalTime/(MAX * CONVERTSEC);
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        System.out.println("Average Time for (" + array[m] +
                ") : " + decimalFormat.format(averageTime) + " s");
        System.out.println("Average Memory for (" + array[m] +
                ") :" +
                " " + decimalFormat.format(averageMemory) + " MB");
    }


    /**
     * getDataSet2 generates dataset 2
     *
     * @param dataSet2 data set 2
     * @param rand random object
     *
     * @return generated array for dataset2
     */
    private static double[] getDataSet2(double[] dataSet2, Random rand)
    {
        int average = 500;
        int standardDeviation = 100;

        // Considering int for normal distribution
        for (int i = 0; i < dataSet2.length; i++)
        {
            double val =  Math.round(rand.nextGaussian() * standardDeviation
                                                            + average);
            dataSet2[i] = val;
        }

        return dataSet2;
    }

    /**
     * getDataSet1 generates dataset 1
     *
     * @param dataSet1 dataSet1
     * @param min min value
     * @param max max value
     * @param rand random object
     *
     * @return generated array for dataset1
     */
    private static double[] getDataSet1(double[] dataSet1, double min, double max,
                                     Random rand)
    {
        for (int i = 0; i < dataSet1.length; i++)
        {
              double val = min + (max - min) * rand.nextDouble();

            dataSet1[i] = val;
        }

        return dataSet1;
    }

}
