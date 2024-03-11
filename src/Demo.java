import javax.swing.*;
import java.util.ArrayList;

public class Demo extends JFrame{
    private JPanel panelMain;
    private JTextArea textArea1;
    private JButton predchoziBtn;
    private JButton dalsiBtn;
    private int aktualniIndex = 0;
    private ArrayList<Integer> cisla = new ArrayList<>();

    public Demo(){
        for (int i = 0; i < 5; i++){
            cisla.add(i);
        }
        initComponents();
    }

    private void initComponents(){
        setContentPane(panelMain);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Moje neco");
        predchoziBtn.addActionListener(e -> predchoziCislo());
        dalsiBtn.addActionListener(e -> dalsiCislo());
        zobrazCislo(aktualniIndex);
        predchoziBtn.setEnabled(aktualniIndex > 0);
        dalsiBtn.setEnabled(aktualniIndex < cisla.size()-1);
        pack();
    }

    private void predchoziCislo(){
        aktualniIndex--;
        zobrazCislo(aktualniIndex);
        predchoziBtn.setEnabled(aktualniIndex > 0);
        dalsiBtn.setEnabled(aktualniIndex < cisla.size()-1);
    }

    private void dalsiCislo(){
        aktualniIndex++;
        zobrazCislo(aktualniIndex);
        predchoziBtn.setEnabled(aktualniIndex > 0);
        dalsiBtn.setEnabled(aktualniIndex < cisla.size()-1);

        try{
            if (aktualniIndex == 3){
                throw new CisloCtyriException("Číslo nesmí být 4");
            }
        }
        catch (CisloCtyriException e){
            System.err.println("Chyba: " + e.getMessage());
        }
    }

    private void zobrazCislo(int aktualniIndex){
        textArea1.setText(cisla.get(aktualniIndex).toString());
    }
}
