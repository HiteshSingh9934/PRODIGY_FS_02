package ui;
import dao.EmployeeDAO;
import model.Employee;
import javax.swing.*;
import javax.swing.table.*;
import java.util.List;
public class MainFrame extends JFrame{
    private EmployeeDAO dao=new EmployeeDAO();
    private DefaultTableModel model=new DefaultTableModel(new String[]{"ID","Name","Email","Salary"},0);
    public MainFrame(){
        JTable table=new JTable(model);
        refresh();
        JScrollPane sp=new JScrollPane(table);
        JButton add=new JButton("Add");
        JButton edit=new JButton("Edit");
        JButton del=new JButton("Delete");
        add.addActionListener(a->{EmployeeForm f=new EmployeeForm(this,null);f.setVisible(true);if(f.result!=null){dao.insert(f.result);refresh();}});
        edit.addActionListener(a->{int i=table.getSelectedRow();if(i>-1){Employee e=row(i);EmployeeForm f=new EmployeeForm(this,e);f.setVisible(true);if(f.result!=null){dao.update(f.result);refresh();}}});
        del.addActionListener(a->{int i=table.getSelectedRow();if(i>-1){int id=(int)model.getValueAt(i,0);dao.delete(id);refresh();}});
        JPanel btns=new JPanel();btns.add(add);btns.add(edit);btns.add(del);
        add(sp,"Center");add(btns,"South");
        setTitle("Employee Management");
        setSize(600,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private void refresh(){
        model.setRowCount(0);
        List<Employee> list=dao.all();
        for(Employee e:list)model.addRow(new Object[]{e.id(),e.name(),e.email(),e.salary()});
    }
    private Employee row(int i){
        return new Employee((int)model.getValueAt(i,0),model.getValueAt(i,1).toString(),model.getValueAt(i,2).toString(),(double)model.getValueAt(i,3));
    }
}
