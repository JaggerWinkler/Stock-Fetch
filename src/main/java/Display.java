import com.crazzyghost.alphavantage.AlphaVantage;
import com.crazzyghost.alphavantage.Config;
import com.github.sh0nk.matplotlib4j.PythonExecutionException;
import java.io.IOException;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
class Display extends JFrame implements ActionListener {
    // JTextField
    static JTextField t;
    static JTextField x;

    // JFrame
    static JFrame f;

    // JButton
    static JButton b;

    // label to display text
    static JLabel l;
    static JLabel y;

    // default constructor
    Display()
    {
    }

    // main class
    public static void main(String[] args)
    {
        // create a new frame to store text field and button
        f = new JFrame("ticker");

        // create a label to display text
        l = new JLabel("Please enter a ticker symbol");
        y = new JLabel("Please enter a datatype");


        // create a new button
        b = new JButton("submit");


        // create a object of the text class
        Display te = new Display();

        // addActionListener to button
        b.addActionListener(te);

        // create a object of JTextField with 16 columns
        t = new JTextField(16);
        x = new JTextField(16);

        // create a panel to add buttons and text field
        JPanel p = new JPanel();

        // add buttons and text field to panel
        p.add(l);
        p.add(t);
        p.add(y);
        p.add(x);
        p.add(b);

        // add panel to frame
        f.add(p);

        // set the size of frame
        f.setSize(300, 300);

        f.show();

        //configs finance API
        Config cfg = Config.builder()
                .key("8SF04MW0TDZBKJD9")
                .timeOut(10)
                .build();
        AlphaVantage.api().init(cfg);
    }

    // if the button is pressed
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        Graphing grapher = new Graphing();
        if (s.equals("submit")) {
            // set the text of the label to the text of the field
            l.setText(t.getText() + " has been submitted.");
            //if only a ticker is given
            if(x.getText().length() == 0) {
                //get list from finance API
                List<Double> toPlot = DataFetch.dailyData(t.getText(), "high");
                try {
                    //graph data
                    grapher.toGraph(toPlot, t.getText().toUpperCase(Locale.ROOT), "high");
                }
                //To prevent program from having too large of an issue when an error occurs
                catch (PythonExecutionException pythonExecutionException) {
                    pythonExecutionException.printStackTrace();
                }
                catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
            else{
                //get list from Finance API
                List<Double> toPlot = DataFetch.dailyData(t.getText().toUpperCase(Locale.ROOT), x.getText().toLowerCase(Locale.ROOT));
                try {
                    //Graph data
                    grapher.toGraph(toPlot, t.getText().toUpperCase(Locale.ROOT), x.getText().toLowerCase(Locale.ROOT));
                } catch (PythonExecutionException pythonExecutionException) {
                    pythonExecutionException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }
}