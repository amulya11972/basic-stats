package gui.view;

import java.util.*;
import javax.swing.*;
import gui.BasicStats;
import model.BasicStatsModel;


public class MaxView implements View {
        private JTextField jtfMax;
        private JLabel jlMax;

        //initialize the max view component
        public MaxView(){
            jtfMax = new JTextField(5);
            jtfMax.setEditable(false);
            jlMax = new JLabel("Max");
        }

        //get Max Label
        public JLabel getComponentLabel(){
            return jlMax;
        }

        //get Max component
        public  JTextField getComponent(){
            return jtfMax;
        }

        //reset Max component
        public void resetComponent(){
            jtfMax.setText("");
        }
    
        //get Max value
        public String getValue(){
            return jtfMax.getText();
        }

        //update the Max component
        @Override
        public void update(BasicStatsModel model){
            double max = BasicStats.max(model.getArrayDouble());
            jtfMax.setText("" + max);
        }

}