


import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import gui.BasicStats;
import gui.BasicStatsGUI;
import model.BasicStatsModel;
import gui.view.CountView;
import gui.view.MeanView;
import gui.view.MedianView;
import gui.view.NumbersView;
import gui.view.MaxView;


public class BasicStatsTest {
    private static double EPS = 1e-9;

    @Test
    public void testInitialMeanView() {

      //testing initial Mean View Values
      BasicStatsGUI gui = new BasicStatsGUI();
      BasicStatsModel model = gui.getModel();
      MeanView meanComponent = new MeanView();

      //checking access of mean textfield
      assertNotNull("Can't access the Mean component", meanComponent.getComponent());

      //Value in mean textfield should be empty
      assertEquals("",meanComponent.getComponent().getText());

    }

    @Test
    public void testInitialMedianView() {

      //testing initial Median View Values
      BasicStatsGUI gui = new BasicStatsGUI();
      BasicStatsModel model = gui.getModel();
      MedianView medianComponent = new MedianView();

      //checking access of median textfield
      assertNotNull("Can't access the Median component", medianComponent.getComponent());

      //Value in median textfield should be empty
      assertEquals("",medianComponent.getComponent().getText());

    }

    @Test
    public void testInitialMaxView() {

      //testing initial Max View Values
      BasicStatsGUI gui = new BasicStatsGUI();
      BasicStatsModel model = gui.getModel();
      MaxView maxComponent = new MaxView();

      //checking access of max textfield
      assertNotNull("Can't access the Max component", maxComponent.getComponent());

      //Value in max textfield should be empty
      assertEquals("",maxComponent.getComponent().getText());

    }

    @Test
    public void testInitialCountView() {

      //testing initial Count View Values
      BasicStatsGUI gui = new BasicStatsGUI();
      BasicStatsModel model = gui.getModel();
      CountView countComponent = new CountView();

      //checking access of count textfield
      assertNotNull("Can't access the Number count component", countComponent.getComponent());

      //Value in count textfield should be empty
      assertEquals("",countComponent.getComponent().getText());

    }

    @Test
    public void testInitialNumbersView() {

      //testing initial Count View Values
      BasicStatsGUI gui = new BasicStatsGUI();
      BasicStatsModel model = gui.getModel();
      NumbersView numbersComponent = new NumbersView();

      //checking access of count textfield
      assertNotNull("Can't access the Numbers display component", numbersComponent.getComponent());

      //Value in count textfield should be empty
      assertEquals("",numbersComponent.getComponent().getText());

    }

    @Test
    public void testAddNumberSuccessful() {

      BasicStatsModel model = new BasicStatsModel();

      //Adding the number 4
      model.addNumber(4.0);
      assertTrue(Arrays.equals(new double[] {4.0}, model.getArrayDouble()));

      //Adding the number -3 
      model.addNumber(-3.0);
      assertTrue(Arrays.equals(new double[] {4.0, -3.0}, model.getArrayDouble()));

      //Adding number 1234
      model.addNumber(1234.0);
      assertTrue(Arrays.equals(new double[] {4.0, -3.0, 1234.0}, model.getArrayDouble()));

      //Adding number 0
      model.addNumber(0.0);
      assertTrue(Arrays.equals(new double[] {4.0, -3.0, 1234.0, 0.0}, model.getArrayDouble()));

    } 

    @Test(expected = IllegalArgumentException.class)
    public void testAddNumberFail() {
      //If the Number being added is null
      BasicStatsModel model = new BasicStatsModel();
      model.addNumber(null);

    } 

    @Test(expected = IllegalArgumentException.class)
    public void testMaxFailEmptyList() {
      //when numbers array is empty
      double[] nums = {};
      double max = BasicStats.max(nums);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxFailNullValue() {
      //when numbers array is null
      double[] nums = null;
      double max = BasicStats.max(nums); 
    }

    @Test
    public void testReset() {

      //testing values after reset
      BasicStatsGUI gui = new BasicStatsGUI();
      BasicStatsModel model = gui.getModel();
      gui.setNumber("2");
      JButton addButton = gui.getAddButton();
      addButton.doClick();

      JButton resetButton = gui.getResetButton();
      resetButton.doClick();

      MeanView meanView= gui.getMeanView();
      MedianView medianView= gui.getMedianView();
      MaxView maxView= gui.getMaxView();
      CountView countView= gui.getCountView();
      NumbersView numbersView= gui.getNumbersView();
      JTextField inputNumber = gui.getNumberTextField();

      assertEquals("",meanView.getComponent().getText());
      assertEquals("",medianView.getComponent().getText());
      assertEquals("",maxView.getComponent().getText());
      assertEquals("",countView.getComponent().getText());
      assertEquals("",numbersView.getComponent().getText());


      //Testing reset bug
      assertEquals("",inputNumber.getText());
    }

    @Test
    public void testCentralTendency() {
        double[] numbers = {2, 2, 3, 3, 3, 4, 4};
        double mean   = BasicStats.mean(numbers);
        assertEquals (3, mean, EPS);
        double median = BasicStats.median(numbers);
        assertEquals (3, median, EPS);
        double mode   = BasicStats.mode(numbers);
        assertEquals (3, mode, EPS);
    }

    @Test
    public void testMedian() {
      //Median should be 8.0 since size is even
      /* double[] numbers = {1, 4, 7, 9, 11, 21}; */
      double[] numbers = {9, 11, 1, 4, 7, 21};

      double median = BasicStats.median(numbers);
      assertEquals(8.0, median, EPS);

      //Median should be 7 since size is odd
      double[] numbers2 = {9, 1, 4, 7, 21};
      median = BasicStats.median(numbers2);
      assertEquals(7, median, EPS);

      //Median should be 3 since size is 1
      double[] numbers3 = {3};
      median = BasicStats.median(numbers3);
      assertEquals(3, median, EPS);

      //Median should be 0 since size is 0
      double[] numbers4 = {};
      median = BasicStats.median(numbers4);
      assertEquals(0, median, EPS);
    }

    @Test
    public void testMode() {
      //Mode should be 1 since we are taking the first mode
      double[] numbers = {1, 4, 7, 9, 11, 21};
      double mode   = BasicStats.mode(numbers);
      assertEquals (1, mode, EPS);

      //Mode should be 4
      double[] numbers2 = {1, 4, 4, 7, 9, 11, 21};
      mode   = BasicStats.mode(numbers2);
      assertEquals (4, mode, EPS);

      //Mode should be 7
      double[] numbers3 = {4, 4, 7, 7, 7, 11, 11};
      mode   = BasicStats.mode(numbers3);
      assertEquals (7, mode, EPS);

      //Mode should be 7
      double[] numbers4 = {7};
      mode   = BasicStats.mode(numbers4);
      assertEquals (7, mode, EPS);

      //Mode should be 0
      double[] numbers5 = {};
      mode   = BasicStats.mode(numbers5);
      assertEquals (0, mode, EPS);
    }

    @Test
    public void testMax() {
      //Max should be 9
      double[] numbers = {1, 4, 9, 8};
      double max   = BasicStats.max(numbers);
      assertEquals (9, max, EPS);

      //Max should be -1
      double[] numbers2 = {-123, -45, 1};
      max   = BasicStats.max(numbers2);
      assertEquals (1, max, EPS);

      //Max should be 4
      double[] numbers3 = {4};
      max   = BasicStats.max(numbers3);
      assertEquals (4, max, EPS);
    }


}
