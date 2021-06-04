import com.github.sh0nk.matplotlib4j.Plot;
import com.github.sh0nk.matplotlib4j.PythonExecutionException;

import java.io.IOException;
import java.util.List;


public class Graphing {
    /**
     * 0 arg constructor to allow instantiation
     * Still trying to figure out how to create mulitple graphs at once
     */
    public Graphing(){

    }

    /**
     * 3 param Method to create graph with useable settings, Includes name
     *
     * @param toPlot List of data points to plot
     * @param ticker ticker of stock to put on the graph
     * @param type String to label graph
     * @throws PythonExecutionException Error if Python fails
     * @throws IOException Error if IO fails
     */
    public void toGraph(List<Double> toPlot, String ticker, String type) throws PythonExecutionException, IOException {
        Plot plt = Plot.create();
        plt.plot().add(toPlot).color("red").linewidth(2.5).linestyle("-");
        plt.ylabel("Value, USD");
        plt.text(0.5, 0.2, "text");
        plt.title(type + " for " + ticker);
        plt.legend();
        plt.show();
    }
    /**
     * 3 param Method to create graph with useable settings, Includes name, but it has 2 data points
     *
     * @param upperLine The higher of the 2 values to graph, preferably the high
     * @param lowerLine The lower of the 2 values to graph, preferably the low
     * @param ticker ticker of stock to put on the graph
     * @param type String to label graph
     * @throws PythonExecutionException Error if Python fails
     * @throws IOException Error if IO fails
     */
    public void toGraph(List<Double> upperLine, String ticker, String type, List<Double> lowerLine ) throws PythonExecutionException, IOException {
        Plot plt = Plot.create();
        plt.plot().add(upperLine).color("green").linewidth(2.5).linestyle("-");
        plt.plot().add(lowerLine).color("red").linewidth(2.5).linestyle("-");
        plt.ylabel("Value, USD");
        plt.text(0.5, 0.2, "text");
        plt.title(type + " for " + ticker);
        plt.legend();
        plt.show();
    }


}
