package gui.view;

import java.util.*;
import javax.swing.*;
import gui.BasicStats;
import model.BasicStatsModel;


public class NumbersView implements View {
        private JTextArea jtaNumbers;

        //Initialize numbers view
        public NumbersView(){
            jtaNumbers = new JTextArea(10,50);
            jtaNumbers.setEditable(false);

        }

        //get component
        public  JTextArea getComponent(){
            return jtaNumbers;
        }

        //reset numbers component
        public void resetComponent(){
            jtaNumbers.setText("");
        }

        //update the numbers component
        @Override
        public void update(BasicStatsModel model){
            double num = model.getArrayDouble()[model.getArrayDouble().length - 1];
            jtaNumbers.append(num + ",");
        }

}