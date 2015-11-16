
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Mezcla extends JPanel implements ActionListener {
    private static final long serialVersionUID = 8865647787011721299L;

    int n;
    int v[];
    JTextArea sal;
    JPanel bot;
    JButton introducir, mostrar;

    public Mezcla() {
        setLayout(new BorderLayout());
        n = 6;
        v = new int[n];
        interfaz();
    }

    public void interfaz() {

        sal = new JTextArea(15, 35);
        sal.setBorder(BorderFactory.createTitledBorder("     ordenamiento Mezcla natural     "));
        sal.setEditable(false);

        bot = new JPanel();
        bot.setLayout(new GridLayout(2, 0));
        introducir = new JButton("Introducir");
        introducir.setBackground(Color.BLACK);
        introducir.setForeground(Color.WHITE);
        introducir.addActionListener(this);
        mostrar = new JButton("Mostrar");
        mostrar.setBackground(Color.BLACK);
        mostrar.setForeground(Color.WHITE);
        mostrar.addActionListener(this);

        bot.add(introducir);
        bot.add(mostrar);

        add(sal, BorderLayout.CENTER);
        add(bot, BorderLayout.EAST);

    }

    public void vector() {
        for (int i = 0; i < v.length; i++) {
            try {
                v[i] = Integer.parseInt
                        (JOptionPane.showInputDialog(null, "introduce un numero", "metodo mezcla natural"
                                , JOptionPane.INFORMATION_MESSAGE));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "introduce un valor numerico"
                        , "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//fin vector


    private static void merge(int[] fuente1, int[] fuente2, int[] dest) {
// indices de los 3 array
        int srcIndex1 = 0;
        int srcIndex2 = 0;
        int destIndex = 0;

// merge hasta que uno de los arrays fuentes este vacio
        while (srcIndex1 < fuente1.length && srcIndex2 < fuente2.length) {
            if (fuente1[srcIndex1] < fuente2[srcIndex2]) {
                dest[destIndex] = fuente1[srcIndex1];
                srcIndex1++;
            } else {
                dest[destIndex] = fuente2[srcIndex2];
                srcIndex2++;
            }
            destIndex++;
        }

        if (srcIndex1 < fuente1.length)
            System.arraycopy(fuente1, srcIndex1, dest, destIndex,
                    fuente1.length - srcIndex1);
        else
            System.arraycopy(fuente2, srcIndex2, dest, destIndex,
                    fuente2.length - srcIndex2);
    } // fin de merge();

// Ordena usando mezcla natural
// Parametros: el array a ordenar

    public static void sort(int arr[]) {
        if (arr.length <= 1) return;

        int tam1 = arr.length / 2;
        int tam2 = arr.length - tam1;

        int primeraMitad[] = new int[tam1];
        int segundaMitad[] = new int[tam2];

        System.arraycopy(arr, 0, primeraMitad, 0, tam1);
        System.arraycopy(arr, tam1, segundaMitad, 0, tam2);

        sort(primeraMitad);
        sort(segundaMitad);

        Mezcla.merge(primeraMitad, segundaMitad, arr);
    }

    public static void main(String[] arg) {
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(3);
        frame.setLayout(new FlowLayout());
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        Mezcla mezcla = new Mezcla();
        frame.add(mezcla);
        frame.setVisible(true);
    }//fin main


    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource() == introducir) {
            sal.setText(" ");
            vector();

            System.out.println("fase 1");
        }
        if (ev.getSource() == mostrar) {
            sal.append("antes de ordenar:" + "\n");
            for (int i = 0; i < v.length; i++) {
                sal.append(" " + v[i] + " " + " ");
            }

            sal.append("\n" + "\n");
            sal.append("despues de ordenar:" + "\n");
            sort(v);
            for (int i = 0; i < v.length; i++) {
                System.out.print(v[i] + " ");
                sal.append(" " + v[i] + " " + " ");
            }
        }

    }//fin actionPerformed

}// fin clase
