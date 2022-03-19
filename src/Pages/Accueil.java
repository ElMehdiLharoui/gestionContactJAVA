package Pages;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class Accueil extends JFrame  {
    private JPanel contentPane;
    private JTextField num;
    private JComboBox type;
    private JComboBox reservation;
    private JComboBox zone;
    private JTextField Date;
    private JTextField numres;
    private JTextField hr;
    JLabel lblzone;
    JLabel lblDate;
    JLabel lbltype;
    JLabel lblreservation;
    JLabel lblnum;
    JLabel lblhr;
    JLabel lblnumres;
    JButton save;
    JButton reserve;
    JButton anuler;
    JButton saving;
    JPanel panel_5;
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Accueil frame = new Accueil("admin","admin");
                    frame.setTitle("Accueil");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    final static String DATE_FORMAT = "yyyy-MM-dd";

    public static boolean isDateValid(String date)
    {
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }


    public Accueil(String fn,String ln) {
        String lastname=ln;
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        
        JPanel panel = new JPanel();
        panel.setForeground(SystemColor.window);
        panel.setBounds(0, -32, 800, 500);
        contentPane.add(panel);
        panel.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(SystemColor.controlDkShadow);
        panel_1.setBounds(0, 0, 200, 500);
        panel.add(panel_1);
        panel_1.setLayout(null);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(Color.WHITE);
        panel_2.setBounds(200, 27, 950, 500);
        panel.add(panel_2);
        panel_2.setLayout(null);

        JPanel panel_3 = new JPanel();
        panel_3.setBounds(25, 77, 550, 320);
        panel_2.add(panel_3);
        panel_3.setLayout(null);



        JLabel lblWelcomeUser= new JLabel("Welcome :");
                lblWelcomeUser.setForeground(Color.WHITE);
                lblWelcomeUser.setBounds(10, 37, 80, 30);
                panel_1.add(lblWelcomeUser);

      JLabel lblfname= new JLabel(fn);
        lblfname.setForeground(Color.WHITE);
        lblfname.setBounds(10, 60, 112, 30);
        panel_1.add(lblfname);

        JLabel lbllname= new JLabel(ln);
        lbllname.setForeground(Color.WHITE);
        lbllname.setBounds(10, 80, 112, 30);
        panel_1.add(lbllname);

        JLabel lbllsl= new JLabel("Les positions du parking :");
        lbllsl.setForeground(Color.WHITE);
        lbllsl.setBounds(10, 112, 180, 30);
        panel_1.add(lbllsl);

        JPanel panel_4 = new JPanel();
        panel_4.setBackground(SystemColor.controlShadow);
        panel_4.setBounds(10, 140, 182, 300);

        panel_1.add(panel_4);

        panel_5 = new JPanel();
        panel_5.setBackground(SystemColor.controlShadow);
        panel_5.setBounds(200, 60, 350, 150);
        panel_5.setVisible(false);
        panel_3.add(panel_5);


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/exam?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
            String sql2 = "select  *from position ";
            pst = conn.prepareStatement(sql2); 
            ResultSet  rs2 = pst.executeQuery();
            int i=0;
            int x=155;
            while (rs2.next()==true)
            {i++;
            x+=30;
                JLabel label_1 = new JLabel("position : "+rs2.getInt(1)+" ||");
                label_1.setBounds(10, x, 150, 100);
                panel_4.add(label_1);
              }
}
        catch (Exception e) {
                JOptionPane.showMessageDialog(panel,e);
                }



        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/exam?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
            String sql2 = "select  *from position where reserve='oui'";
            pst = conn.prepareStatement(sql2);
            ResultSet  rs2 = pst.executeQuery();
            int i=0;
            while (rs2.next() == true)
            {i++;}
            JLabel label_1 = new JLabel("Nombre des positions reservées :  "+i);
            label_1.setBounds(25, 400, 220, 15);
            panel_2.add(label_1);

            String sql3 = "select  *from position ";
            pst = conn.prepareStatement(sql3);
            ResultSet  rs3 = pst.executeQuery();
            int j=0;
            while (rs3.next() == true)
            {j++;}
            JLabel label_2 = new JLabel("Nombre totale des positions :  "+j);
            label_2.setBounds(25, 430, 220, 15);
            panel_2.add(label_2);
        }

        catch (Exception e) {
            JOptionPane.showMessageDialog(panel,e);
        }


        num= new JTextField();
        num.setBounds(25, 39, 195, 35);
        panel_2.add(num);
        num.setColumns(10);

        lblnum= new JLabel("Numéro de la position :");
        lblnum.setBounds(25, 12, 125, 15);
        panel_2.add(lblnum);

        lblzone = new JLabel("zone :");
        lblzone.setBounds(225, 12, 200, 15);
        lblzone.setVisible(false);
        panel_3.add(lblzone);

        lbltype= new JLabel("Type :");
        lbltype.setVisible(false);
        lbltype.setBounds(40, 12, 125, 15);
        panel_3.add(lbltype);

        lblreservation = new JLabel("Resrevé  :");
        lblreservation.setVisible(false);
        lblreservation.setBounds(40, 70, 125, 15);
        panel_3.add(lblreservation);

        anuler = new JButton("Annuler une reservation");
        anuler.setBounds(20, 110, 150, 25);
        panel_3.add(anuler);
        anuler.setVisible(false);
        anuler.setForeground(Color.WHITE);
        anuler.setFont(new Font("Dialog", Font.BOLD, 14));
        anuler.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        anuler.setBorder(new LineBorder(UIManager.getColor("OptionPane.errorDialog.titlePane.shadow"), 2, true));
        anuler.setBackground(new Color(204, 102, 102));
        anuler.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saving.setVisible(true);
                lblnumres .setVisible(true);
                numres .setVisible(true);
            }
        });

        saving = new JButton("Confirmer");
        saving.setBounds(20, 150, 150, 25);
        panel_3.add(saving);
        saving.setVisible(false);
        saving.setForeground(Color.WHITE);
        saving.setFont(new Font("Dialog", Font.BOLD, 14));
        saving.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        saving.setBorder(new LineBorder(UIManager.getColor("OptionPane.errorDialog.titlePane.shadow"), 2, true));
        saving.setBackground(new Color(204, 102, 102));
        saving.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    conn = DriverManager.getConnection("jdbc:mysql://localhost/exam?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
                    String sql = "select id from user_en where lname='" + lastname + "'";

                    pst = conn.prepareStatement(sql);
                    ResultSet  rs = pst.executeQuery();
                    if (rs.next() == true) {
                    if ( numres.getText().equals("")) {
                        JOptionPane.showMessageDialog(panel, "Veulliez remplir tous les champs !!");
                    }
                    else {
                        String sql3 = "Select *from reservation where num_res='"+numres.getText()+"' and id='"+rs.getInt(1)+"'";
                        pst = conn.prepareStatement(sql3);
                        ResultSet rs1 = pst.executeQuery();

                        if (rs1.next() == true) {

                            String sql2 = " delete from reservation where num_res='"+numres.getText()+"'";
                            pst = conn.prepareStatement(sql2);
                            pst.executeUpdate();

                            String sql6= "Select *from reservation where num='"+num.getText()+"'";
                            pst = conn.prepareStatement(sql6);
                            ResultSet rs6 = pst.executeQuery();
                            if (!rs6.next() == true) {

                                String sql7 = " update position set reserve='non',id=NULL,date=NULL,hour=NULL where num='"+num.getText()+"' ";
                                pst = conn.prepareStatement(sql7);
                                pst.executeUpdate();

                            }

                            JOptionPane.showMessageDialog(panel, "Vous avez annuler la reservation numéro " + numres.getText());

                            try {
                                String sql5 = " select fname from user_en where lname='" + lastname + "'";
                                pst = conn.prepareStatement(sql5);
                                pst.executeQuery();
                               ResultSet rs5 = pst.executeQuery();
                                if (rs5.next() == true) {
                                    Accueil frame = new Accueil(rs5.getString(1), lastname);
                                    frame.setTitle("Accueil");
                                    frame.setVisible(true);
                                    dispose();

                                }
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(panel, e);
                            }

                        }
                        else{

                            JOptionPane.showMessageDialog(panel, "Vous avez aucune reservation avec ce numero : "+numres.getText());

                        }
                    }
                    }





                } catch (Exception e) {
                    JOptionPane.showMessageDialog(panel,e);
                }




            }
        });

        lblnumres = new JLabel("Numero de reservation :");
        lblnumres .setBounds(10, 180, 190, 10);
        lblnumres .setVisible(false);
        panel_3.add(lblnumres );

        numres = new JTextField();
        numres.setColumns(10);
        numres.setVisible(false);
        numres.setBounds(10, 195, 170, 30);
        panel_3.add(numres);


        lblDate = new JLabel("Date de reservation:(YYYY-MM-DD)");
        lblDate.setBounds(20, 265, 220, 15);
        lblDate.setVisible(false);
        panel_3.add(lblDate);

        Date = new JTextField();
        Date.setColumns(10);
        Date.setVisible(false);
        Date.setBounds(20, 280, 195, 35);
        panel_3.add(Date);

        lblhr = new JLabel("Heure de reservation:(ex:8:00-10:00)");
        lblhr.setBounds(240, 265, 220, 15);
        lblhr.setVisible(false);
        panel_3.add(lblhr);

        hr = new JTextField();
        hr.setColumns(10);
        hr.setVisible(false);
        hr.setBounds(240, 280, 220, 35);
        panel_3.add(hr);

         reserve = new JButton("Reserver cette position");
        reserve.setBounds(200, 230, 150, 25);
        panel_3.add(reserve);
        reserve.setVisible(false);
        reserve.setForeground(Color.WHITE);
        reserve.setFont(new Font("Dialog", Font.BOLD, 14));
        reserve.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        reserve.setBorder(new LineBorder(UIManager.getColor("OptionPane.errorDialog.titlePane.shadow"), 2, true));
        reserve.setBackground(new Color(204, 102, 102));
        reserve.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Date.setVisible(true);
                lblDate.setVisible(true);
                hr.setVisible(true);
                lblhr.setVisible(true);
                save.setVisible(true);

            }
        });
      
         save = new JButton("Enregistrer");             
        save.setBounds(85, 230, 100, 25);          
        panel_3.add(save);                                                        
        save.setVisible(false);
        save.setForeground(Color.WHITE);
        save.setFont(new Font("Dialog", Font.BOLD, 14));
        save.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        save.setBorder(new LineBorder(UIManager.getColor("OptionPane.errorDialog.titlePane.shadow"), 2, true));
        save.setBackground(new Color(204, 102, 102));
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {


                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    conn = DriverManager.getConnection("jdbc:mysql://localhost/exam?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
                    String sql = "Select *from position where num='"+num.getText()+"'";

                    pst = conn.prepareStatement(sql);
                    ResultSet  rs = pst.executeQuery();
                    if (Date.getText().equals("") ||  hr.getText().equals("")) {
                        JOptionPane.showMessageDialog(panel, "Veulliez remplir tous les champs !!");
                    }
                    if (!isDateValid(Date.getText())) {
                        JOptionPane.showMessageDialog(panel, "Veulliez respecter la format du date !!");
                    } else {
                        String sql3 = "select id from user_en where lname='" + ln + "'";
                        pst = conn.prepareStatement(sql3);
                        ResultSet rs1 = pst.executeQuery();

                        if (rs1.next() == true) {
                            int ty = rs1.getInt(1);
                            String sql2 = "insert into reservation(num,date_res,heur_res,id)  values('" + num.getText() + "','" + Date.getText() + "','" + hr.getText() + "','" + ty + "')";
                            pst = conn.prepareStatement(sql2);
                            pst.executeUpdate();

                            String sql4 = " update position set reserve='oui',id='" + ty + "',date='" + Date.getText() + "',hour='" + hr.getText() + "' where num='" + num.getText() + "' ";
                            pst = conn.prepareStatement(sql4);
                            pst.executeUpdate();

                            JOptionPane.showMessageDialog(panel, "Vous avez reservé la position numéro " + num.getText());

                            ResultSet rs5 = null;
                            try {
                                String sql5 = " select fname from user_en where lname='" + lastname + "'";
                                pst = conn.prepareStatement(sql5);
                                pst.executeQuery();
                                rs5 = pst.executeQuery();
                                if (rs5.next() == true) {
                                    Accueil frame = new Accueil(rs5.getString(1), lastname);
                                    frame.setTitle("Accueil");
                                    frame.setVisible(true);
                                    dispose();

                                }
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(panel, e);
                            }
                        }
                    }






                        } catch (Exception e) {
                    JOptionPane.showMessageDialog(panel,e);
                }




            }
        });


        JButton Disconnect = new JButton("se deconnecter");
        Disconnect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LoginM frames = new LoginM();
                frames.setTitle("Connexion");
                frames.setVisible(true);
                dispose();
            }
        });
        Disconnect.setBounds(5, 460, 114, 25);
        panel_1.add(Disconnect);
        Disconnect.setForeground(Color.WHITE);
        Disconnect.setFont(new Font("Dialog", Font.BOLD, 14));
        Disconnect.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        Disconnect.setBorder(new LineBorder(UIManager.getColor("OptionPane.errorDialog.titlePane.shadow"), 2, true));
        Disconnect.setBackground(new Color(204, 102, 102));

        JButton actualiser = new JButton("Actualiser");

        actualiser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    String sql5 = " select fname from user_en where lname='" + lastname + "'";
                    pst = conn.prepareStatement(sql5);
                    pst.executeQuery();
                    ResultSet rs5 = pst.executeQuery();
                    if (rs5.next() == true) {
                        Accueil frame = new Accueil(rs5.getString(1), lastname);
                        frame.setTitle("Accueil");
                        frame.setVisible(true);
                        dispose();

                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(panel, e);
                }
            }
        });
        actualiser.setBounds(130, 460, 80, 25);
        panel_1.add(actualiser);
        actualiser.setForeground(Color.WHITE);
        actualiser.setFont(new Font("Dialog", Font.BOLD, 14));
        actualiser.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        actualiser.setBorder(new LineBorder(UIManager.getColor("OptionPane.errorDialog.titlePane.shadow"), 2, true));
        actualiser.setBackground(new Color(204, 102, 102));

        JButton Rechercher = new JButton("Rechercher");
        Rechercher.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

            panel_5.removeAll();
                panel_5.repaint();
             Connection conn = null;
                PreparedStatement pst = null;
                ResultSet rs = null;

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    conn = DriverManager.getConnection("jdbc:mysql://localhost/exam?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
                    String sql2 = "select  *from position where num='"+num.getText()+"'";
                    pst = conn.prepareStatement(sql2);
                    ResultSet  rs2 = pst.executeQuery();

                    if (rs2.next() == true)
                    {
                        String ty=rs2.getString(2);
                        String ty2=rs2.getString(3);
                        String ty3=rs2.getString(7);

                        lblreservation.setText("Reservé : "+ty2);
                        lbltype.setText("Type : "+ty);
                        lblzone.setText("Zone : "+ty3);

                        lblzone.setVisible(true);
                        lbltype.setVisible(true);
                        lblreservation.setVisible(true);

                        if(rs2.getString(3).equals("non")){
                            panel_5.setVisible(false);
                            reserve.setVisible(true);
                            anuler.setVisible(false);
                            saving.setVisible(false);
                            numres.setVisible(false);
                            lblnumres.setVisible(false);

                        }
                        if(rs2.getString(3).equals("oui"))
                        {reserve.setVisible(true);
                            anuler.setVisible(true);
                            try {
                                Class.forName("com.mysql.cj.jdbc.Driver");
                                conn = DriverManager.getConnection("jdbc:mysql://localhost/exam?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
                                String sql3 = "select  *from reservation where num= '"+num.getText()+"'";
                                pst = conn.prepareStatement(sql3);
                                ResultSet  rs3 = pst.executeQuery();
                                int i=0;
                                int x=155;
                                while (rs3.next()==true)
                                {i++;
                                    x+=30;
                                    String sql4 = "select lname from user_en where id='" + rs3.getString(5) + "'";
                                    pst = conn.prepareStatement(sql4);
                                    ResultSet  rs4 = pst.executeQuery();
                                    if(rs4.next()==true){
                                    JLabel label_3 = new JLabel("Reservation numero "+ rs3.getInt(1)+" par : "+rs4.getString(1)+" ("+rs3.getString(3)+" || " +rs3.getString(4)+")");
                                    label_3.setBounds(5, x, 100, 100);
                                    panel_5.add(label_3);}
                                }
                            }
                            catch (Exception e) {
                                JOptionPane.showMessageDialog(panel,e);
                            }
                            panel_5.setVisible(true);
                           }
                    }
                    else{
                        JOptionPane.showMessageDialog(panel,"position Introuvable");
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(panel,e);
                }
           }
        });



        Rechercher.setForeground(Color.WHITE);
        Rechercher.setFont(new Font("Dialog", Font.BOLD, 14));
        Rechercher.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        Rechercher.setBorder(new LineBorder(UIManager.getColor("OptionPane.errorDialog.titlePane.shadow"), 2, true));
        Rechercher.setBackground(new Color(204, 102, 102));
        Rechercher.setBounds(280, 44, 114, 25);
        panel_2.add(Rechercher);

    }

    }














