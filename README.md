# Stock Grapher
 A simple stock graphing program in Java using Alpha Vantage and MatPlotLib4j.
 The Program was made with the following libaries and APIs:
 + Alpha Vantage API from [Here](https://github.com/crazzyghost/alphavantage-java) was used to get stock data.  
 + The UI was made using the Swing Library.  
 + MatPotLib for Java from [Here](https://github.com/sh0nk/matplotlib4j) was used to graph stock data. 
 
 # Please Have:
 A Java IDE, preferably intelliJ  
 A Maven Compatable IDE (Imports)  
 A Swing Compatable IDE (UI)  
 Python installed (Graphing)  
 
 # How to Use
 Go to [Here](https://www.alphavantage.co/support/#api-key) in order to get your own API key.  
 **THE API KEY MUST BE CHANGED VIA THE FOLLOWING DATA PATH:**  
Src/Main/Java/Display.  
The String is located at the top of the document, right after imports  
```java
...
import javax.swing.*;
import java.awt.event.*;
class Display extends JFrame implements ActionListener {
    /**
     * PUT API KEY IN FOLLOWING STRING
     */
    final static String APIKEY = "API KEY HERE";
    // JTextField
    static JTextField t;
    static JTextField x;
...
```

To use, run main method in display class, as found at Src/Main/Java/Display.  

# Useage
On startup a Swing window will open. It contains 2 text fields, with the upper field being for your ticker symbol, and the bottom field being for the data type you want.
## Ticker
Please provide the offical ticker for a stock on the NYSE or NASDAQ. You must provide the ticker, not the name.  
Example:  
TSLA would be a valid ticker.  
AAPL would be a valid ticker.  
APPLE would NOT be a valid ticker.  
KRW (Samung) would NOT be a vaild ticker because it is not part of the NASDAQ or NYSE.  
If an invalid ticker is provided, the program will simply throw and error and wait for another input.  
## Data Type
You can either choose the datatype that you would like to see graphed, or leave this feild blank. If the data type feild is left blank, the graph will show the high and low for the given ticker.  
The program is capable of displaying the following datasets:
+ High  
+ Low  
+ Close
+ Volume
Please ensure that the textfeild has no spaces, and is spelled exactly the same as above. If something is spelled wrong or with spaces, the program will throw an error and wait for a new text entry.  


