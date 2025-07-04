package ui;
import model.Employee;
import javax.swing.*;
public class EmployeeForm extends JDialog{
    public Employee result;
    public EmployeeForm(JFrame parent,Employee e){
        super(parent,true);
        JTextField name=new JTextField(20);
        JTextField email=new JTextField(20);
        JTextField salary=new JTextField(10);
        if(e!=null){name.setText(e.name());email.setText(e.email());salary.setText(String.valueOf(e.salary()));}
        JButton ok=new JButton("Save");
        ok.addActionListener(a->{
            String n=name.getText().trim();
            String m=email.getText().trim();
            double s=Double.parseDouble(salary.getText().trim());
            result=new Employee(e==null?0:e.id(),n,m,s);
            dispose();
        });
        JPanel p=new JPanel();
        p.add(new JLabel("Name"));p.add(name);
        p.add(new JLabel("Email"));p.add(email);
        p.add(new JLabel("Salary"));p.add(salary);
        p.add(ok);
        add(p);
        pack();
        setLocationRelativeTo(parent);
    }
}

