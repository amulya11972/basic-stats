package gui.view;

import java.util.*;
import javax.swing.*;
import gui.BasicStats;
import model.BasicStatsModel;


public class MeanView implements View {
        private JTextField jtfMean;
        private JLabel jlMean;

        public MeanView(){
            jtfMean = new JTextField(5);
            jtfMean.setEditable(false);
            jlMean = new JLabel("Mean");
        }

        public JLabel getComponentLabel(){
            return jlMean;
        }

        public  JTextField getComponent(){
            return jtfMean;
        }

        public void resetComponent(){
            jtfMean.setText("");
        }

        @Override
        public void update(BasicStatsModel model){
            double mean = BasicStats.mean(model.getArrayDouble());
            jtfMean.setText("" + mean);
        }

}