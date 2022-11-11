package gui.view;

import java.util.*;
import javax.swing.*;
import gui.BasicStats;
import model.BasicStatsModel;


public class MedianView implements View {
        private JTextField jtfMedian;
        private JLabel jlMedian;

        //Inititialize the Median Component
        public MedianView(){
            jtfMedian = new JTextField(5);
            jtfMedian.setEditable(false);
            jlMedian = new JLabel("Median");
        }

        //get Median Label
        public JLabel getComponentLabel(){
            return jlMedian;
        }

        //get Median Component
        public  JTextField getComponent(){
            return jtfMedian;
        }

        //reset median component
        public void resetComponent(){
            jtfMedian.setText("");
        }

        //get Median Value
        public void getValue(){
            jtfMedian.getText();
        }

        @Override
        public void update(BasicStatsModel model){
            double median = BasicStats.median(model.getArrayDouble());
            jtfMedian.setText("" + median);
        }

}