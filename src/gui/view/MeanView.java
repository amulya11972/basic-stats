package gui.view;

import java.util.*;
import javax.swing.*;
import gui.BasicStats;
import model.BasicStatsModel;


public class MeanView implements View {
        private JTextField jtfMean;
        private JLabel jlMean;

        //Initilaize the Mean view
        public MeanView(){
            jtfMean = new JTextField(5);
            jtfMean.setEditable(false);
            jlMean = new JLabel("Mean");
        }

        //get Mean Label
        public JLabel getComponentLabel(){
            return jlMean;
        }

        //get Mean Component
        public  JTextField getComponent(){
            return jtfMean;
        }

        //reset the Mean Component
        public void resetComponent(){
            jtfMean.setText("");
        }


        //reset the component value
        public String getValue(){
            return jtfMean.getText();
        }

        //update the Mean Component
        @Override
        public void update(BasicStatsModel model){
            double mean = BasicStats.mean(model.getArrayDouble());
            jtfMean.setText("" + mean);
        }


}