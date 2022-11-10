package gui.view;

import java.util.*;
import javax.swing.*;
import gui.BasicStats;
import model.BasicStatsModel;


public class MedianView implements View {
        private JTextField jtfMedian;
        private JLabel jlMedian;

        public MedianView(){
            jtfMedian = new JTextField(5);
            jtfMedian.setEditable(false);
            jlMedian = new JLabel("Median");
        }

        public JLabel getComponentLabel(){
            return jlMedian;
        }

        public  JTextField getComponent(){
            return jtfMedian;
        }

        public void resetComponent(){
            jtfMedian.setText("");
        }

        @Override
        public void update(BasicStatsModel model){
            double median = BasicStats.median(model.getArrayDouble());
            jtfMedian.setText("" + median);
        }

}