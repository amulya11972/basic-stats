package gui.view;

import java.util.*;
import javax.swing.*;
import gui.BasicStats;
import model.BasicStatsModel;


public class MaxView implements View {
        private JTextField jtfMax;
        private JLabel jlMax;

        public MaxView(){
            jtfMax = new JTextField(5);
            jtfMax.setEditable(false);
            jlMax = new JLabel("Max");
        }

        public JLabel getComponentLabel(){
            return jlMax;
        }

        public  JTextField getComponent(){
            return jtfMax;
        }

        public void resetComponent(){
            jtfMax.setText("");
        }

        @Override
        public void update(BasicStatsModel model){
            double max = BasicStats.max(model.getArrayDouble());
            jtfMax.setText("" + max);
        }

}