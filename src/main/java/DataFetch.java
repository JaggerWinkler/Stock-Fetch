import com.crazzyghost.alphavantage.AlphaVantage;
import com.crazzyghost.alphavantage.timeseries.response.TimeSeriesResponse;
import java.util.ArrayList;
import java.util.Locale;

public class DataFetch {
    /**
     * 2 Pram Method to use API to fetch stock data
     * @param ticker the official ticker of the stock to fetch
     * @param type name of the datatype that is wanted
     * @return String of
     */
    public static ArrayList<Double> dailyData(String ticker, String type){
        //Fetches stock data
        ticker = ticker.toUpperCase(Locale.ROOT);
        //OUTSIDE JAVA SUBSET
        TimeSeriesResponse response = AlphaVantage.api()
                .timeSeries()
                .daily()
                .forSymbol(ticker)
                .fetchSync();
        String stockData = String.valueOf(response);
        //Spits list into each individual element and converts to arraylist
        String[] dataArray = stockData.split(",");
        for(String cur: dataArray)
        System.out.println (cur);
        ArrayList<String> dataSet = new ArrayList<>();
        for(int i=0; i<dataArray.length; i++)
            dataSet.add(dataArray[i]);
        //Makes list contain only the wanted parameter
        for (int i = dataSet.size() -1; i >= 0; i --) {
            if(! dataSet.get(i).contains(type)){
                dataSet.remove(i);
            }
        }
        // Removes the text part of the arraylist and turns the Arraylist into a set of ints
        ArrayList<Double> returnSet = new ArrayList<>();
        //First element is not a datapoint
        dataSet.remove(0);
        for (int i = 0; i < dataSet.size(); i++) {
            dataSet.set(i, dataSet.get(i).substring(dataSet.get(i).indexOf("=") + 1));
            returnSet.add(Double.valueOf(dataSet.get(i)));
        }

        return returnSet;

    }
    /**
     * 1 Pram Method to use API to fetch stock data
     * Used for troubleshooting
     * @param ticker the official ticker of the stock to fetch
     * @return Array of strings of all data that was requested
     */
    public static String[] allDailyData(String ticker){
        //Fetches data from stock API
        TimeSeriesResponse response = AlphaVantage.api()
                .timeSeries()
                .daily()
                .forSymbol(ticker)
                .fetchSync();
        String stockData = String.valueOf(response);
        return stockData.split(",");

    }
}
