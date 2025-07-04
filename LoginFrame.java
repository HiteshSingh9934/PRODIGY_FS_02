package ui;
import dao.UserDAO;
import javax.swing.*;
public class LoginFrame extends JFrame{
    public LoginFrame(){
        JTextField user=new JTextField(15);
        JPasswordField pass=new JPasswordField(15);
        JButton login=new JButton("Login");
        login.addActionListener(a->{
            if(new UserDAO().auth(user.getText().trim(),new String(pass.getPassword()))!=null){
                new MainFrame().setVisible(true);
                dispose();
            }else JOptionPane.showMessageDialog(this,"Invalid","Error",JOptionPane.ERROR_MESSAGE);
        });
        JPanel p=new JPanel();
        p.add(new JLabel("User"));p.add(user);
        p.add(new JLabel("Pass"));p.add(pass);
        p.add(login);
        add(p);
        pack();
        setTitle("Login");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
