/*
 * EmployeeData.java 
 * Matt Koenen / Sidney Rens
 * IS 286 695
 * Project 3 - Employee Application
 * 07/11/18
 */
package UI;

import business.Employee;
import business.EmployeeIO;
import java.awt.List;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.stream.Collectors;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import validation.Validator;

public class EmployeeData extends javax.swing.JFrame {
    
    Map<Long, Employee> emps;
    Map<String, Employee> nameList;
    Map<String, JTextField> screenMap;
    Map<String, JTextField> updateMap;
    String[] getMethods = {"getEmployeeNumber", "getLastName",  "getFirstName",
                            "getMiddleName", "getSuffix", "getAddress1", 
                            "getAddress2", "getCity", "getState", "getZip", 
                            "getPhone", "getGender", "getPayCode", "getStatus", 
                            "getHireDate", "getTerminateDate"};
    
    JTextField[] fields;
    int loading = 0;
    String filename;
    Long originalEmpNum;
    
    public EmployeeData() {
        initComponents();
        this.setLocationRelativeTo(this);
        this.setIconImage(new ImageIcon(getClass().getResource("employee.png")).getImage());
        JTextField[] flds = {txtEmployeeNum, txtLastName, txtFirstName, txtMiddle,
            txtSuffix, txtAddress1, txtAddress2, txtCity, txtState, txtZip, txtPhone, txtGender,
            txtPayCode, txtStatus, txtHireDate, txtTerminationDate};
        fields = flds;
        screenMap = new HashMap<>();
        //associate specified value with specified key
        for (int i = 0; i < getMethods.length; i++) {
            screenMap.put(getMethods[i], fields[i]);
        }     
    }

    public void buildComboBox(){
        loading = 1;
        comboEmployee.removeAllItems();
        if(radioRaw.isSelected()){
            HashMap<Long, Employee> hashMap = new HashMap<>(emps);
            for (Map.Entry<Long, Employee> entry : hashMap.entrySet()){
                Long k = entry.getKey();
                comboEmployee.addItem(String.valueOf(k));
            }
        } else if(radioTree.isSelected()){
            TreeMap<Long, Employee> treeMap = new TreeMap<>(emps);
            for (Map.Entry<Long, Employee> entry : treeMap.entrySet()){
                Long k = entry.getKey();
                comboEmployee.addItem(String.valueOf(k));
            }
        } else if (radioName.isSelected()){
            nameList = new TreeMap<>();
            for (Map.Entry<Long, Employee> entry : emps.entrySet()){
                Employee e = entry.getValue();
                String name = e.getFullName();
                nameList.put(name, e);
            }
            for (Map.Entry<String, Employee> entry : nameList.entrySet()){
            String k = entry.getKey();
            comboEmployee.addItem(k);
            }
        }
        comboEmployee.setSelectedIndex(-1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupMap = new javax.swing.ButtonGroup();
        jMenu1 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtEmployeeNum = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        txtFirstName = new javax.swing.JTextField();
        txtMiddle = new javax.swing.JTextField();
        txtSuffix = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtAddress1 = new javax.swing.JTextField();
        txtAddress2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCity = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtState = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtZip = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtGender = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtPayCode = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtStatus = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtHireDate = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtTerminationDate = new javax.swing.JTextField();
        radioRaw = new javax.swing.JRadioButton();
        radioTree = new javax.swing.JRadioButton();
        radioName = new javax.swing.JRadioButton();
        btnLeft = new javax.swing.JButton();
        btnRight = new javax.swing.JButton();
        comboEmployee = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblRecords = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMessage = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuLoad = new javax.swing.JMenuItem();
        menuExit = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menuAbout = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jPanel2.setBackground(new java.awt.Color(213, 213, 213));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Employee Number:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Last Name:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("First Name:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("MI:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Suffix:");

        txtEmployeeNum.setToolTipText("Employee number is required and must be EIGHT numbers.");
        txtEmployeeNum.setName("Employee Number"); // NOI18N

        txtLastName.setToolTipText("Enter last name.");
        txtLastName.setName("Last Name"); // NOI18N

        txtFirstName.setToolTipText("Enter first name.");
        txtFirstName.setName("First Name"); // NOI18N

        txtMiddle.setToolTipText("Enter middle initial, if applicable.");
        txtMiddle.setName("Middle Initial"); // NOI18N

        txtSuffix.setToolTipText("Enter suffix, if applicable.");
        txtSuffix.setName("Suffix"); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Address:");

        txtAddress1.setToolTipText("Enter street address.");
        txtAddress1.setName("Address One"); // NOI18N

        txtAddress2.setToolTipText("Enter apartment or unit number.");
        txtAddress2.setName("Address Two"); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("City:");

        txtCity.setToolTipText("Enter city.");
        txtCity.setName("City"); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("State:");

        txtState.setToolTipText("Enter state.");
        txtState.setName("State"); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Zip Code:");

        txtZip.setToolTipText("Enter five digit zip code.");
        txtZip.setName("Zip Code"); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Phone:");

        txtPhone.setToolTipText("Enter seven digit phone number (no area code).");
        txtPhone.setName("Phone Number"); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Gender:");

        txtGender.setToolTipText("Enter gender.");
        txtGender.setName("Gender"); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Pay Code:");

        txtPayCode.setToolTipText("Enter pay code, 1-5.");
        txtPayCode.setName("Pay Code"); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Status:");

        txtStatus.setToolTipText("Enter status. A = Active, X = Terminated, R = Retired.");
        txtStatus.setName("Employment Status"); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Hire Date:");

        txtHireDate.setToolTipText("Enter hire date.");
        txtHireDate.setName("Hire Date"); // NOI18N

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Termination Date:");

        txtTerminationDate.setToolTipText("Enter termination date, if applicable.");
        txtTerminationDate.setName("Termination Date"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtEmployeeNum))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtMiddle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSuffix, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAddress2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtAddress1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtPhone)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtState, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel10))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtGender, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtZip, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtPayCode, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addComponent(txtHireDate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addComponent(txtTerminationDate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmployeeNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMiddle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSuffix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAddress2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtZip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtPayCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txtHireDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(txtTerminationDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnGroupMap.add(radioRaw);
        radioRaw.setText("Raw HashMap");
        radioRaw.setToolTipText("Load RAW, unordered employee number list.");
        radioRaw.setEnabled(false);
        radioRaw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioRawActionPerformed(evt);
            }
        });

        btnGroupMap.add(radioTree);
        radioTree.setText("TreeMap by Employee Number");
        radioTree.setToolTipText("Load employee number list ordered in ascending order.");
        radioTree.setEnabled(false);
        radioTree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioTreeActionPerformed(evt);
            }
        });

        btnGroupMap.add(radioName);
        radioName.setText("Map with Name Key (sorted)");
        radioName.setToolTipText("Load employee list by last name.");
        radioName.setEnabled(false);
        radioName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNameActionPerformed(evt);
            }
        });

        btnLeft.setText("Previous Entry");
        btnLeft.setToolTipText("Select previous entry on the list.");
        btnLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeftActionPerformed(evt);
            }
        });

        btnRight.setText("Next Entry");
        btnRight.setToolTipText("Select next entry on the list.");
        btnRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRightActionPerformed(evt);
            }
        });

        comboEmployee.setToolTipText("Select an employee.");
        comboEmployee.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboEmployeeItemStateChanged(evt);
            }
        });
        comboEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEmployeeActionPerformed(evt);
            }
        });

        jLabel1.setText("Employees:");

        btnUpdate.setText("Update");
        btnUpdate.setToolTipText("Update current employee.");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.setToolTipText("Delete current employee. **THIS CANNOT BE UNDONE**");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.setToolTipText("Clear the form.");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.setToolTipText("Add new employee to the database.");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.setToolTipText("Save the employee database document.");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel3.setToolTipText("");

        lblRecords.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRecords.setText("0");
        lblRecords.setToolTipText("toolTipText\tThis will display the number of employees loaded in the database file.");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Records loaded from .CSV file:");
        jLabel17.setToolTipText("This will display the number of employees loaded in the database file.");

        txtMessage.setEditable(false);
        txtMessage.setBackground(new java.awt.Color(245, 245, 245));
        txtMessage.setColumns(20);
        txtMessage.setLineWrap(true);
        txtMessage.setRows(5);
        txtMessage.setToolTipText("Information will display here.");
        txtMessage.setWrapStyleWord(true);
        txtMessage.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jScrollPane1.setViewportView(txtMessage);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 11, Short.MAX_VALUE)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRecords, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(lblRecords, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(59, 59, 59)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(65, 65, 65)
                            .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(62, 62, 62)
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(radioRaw)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnLeft)
                                .addGap(51, 51, 51)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(radioTree)
                                    .addComponent(comboEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(68, 68, 68)
                                .addComponent(radioName))
                            .addComponent(btnRight))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(comboEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(radioRaw)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(radioName)
                                    .addComponent(radioTree))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnRight, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnClear)
                    .addComponent(btnAdd)
                    .addComponent(btnSave))
                .addContainerGap())
        );

        jMenuBar1.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.foreground"));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        menuFile.setText("File");

        menuLoad.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        menuLoad.setText("Load");
        menuLoad.setToolTipText("Load the employee .CSV file.");
        menuLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLoadActionPerformed(evt);
            }
        });
        menuFile.add(menuLoad);

        menuExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        menuExit.setText("Exit");
        menuExit.setToolTipText("Exit the program. Make sure to save your work!");
        menuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuExitActionPerformed(evt);
            }
        });
        menuFile.add(menuExit);

        jMenuBar1.add(menuFile);

        jMenu3.setText("Edit");

        menuAbout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        menuAbout.setText("About");
        menuAbout.setToolTipText("Display program information.");
        menuAbout.setName("menuAbout"); // NOI18N
        menuAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAboutActionPerformed(evt);
            }
        });
        jMenu3.add(menuAbout);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //method to exit the program, confirming file save
    private void menuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExitActionPerformed
        int confirmed = JOptionPane.showConfirmDialog(
                        null, "Are you sure you would like to exit the program?",
                            "Exit Program?", 
                            JOptionPane.YES_NO_OPTION);
        
        if(confirmed == JOptionPane.YES_OPTION) {
            int save = JOptionPane.showConfirmDialog(
                        null, "Please remember to save your file before exiting. \n"
                                + "Would you like to save the loaded file now?",
                            "Save Employee file?", 
                            JOptionPane.YES_NO_CANCEL_OPTION);
            switch (save) {
                case JOptionPane.YES_OPTION:
                    btnSave.doClick();
                    System.exit(0);
                case JOptionPane.CANCEL_OPTION:
                    break;
                default:
                    System.exit(0);
            }
        } 
    }//GEN-LAST:event_menuExitActionPerformed
    
    //method to display info about the program
    private void menuAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAboutActionPerformed
                    JOptionPane.showMessageDialog(null, 
                            "IS 287 695 - Summer 2018\n"
                            + "Employee Data Application\n\n"
                            + "Programmed by: \n"
                            + "Sidney Rens and Matthew Koenen", "About", 
                    JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_menuAboutActionPerformed
    
    //method to save the .CSV file
    public static String setEmps(String path, Map<Long, Employee> emps)
    {
        String status = "";
        try {
            PrintWriter out = new PrintWriter(new FileWriter(path));
            Iterator <Map.Entry<Long, Employee>> it = emps.entrySet().iterator();
            /// Assign csv file header
            out.println("Empno,Firstname,Lastname,MiddleInit,Suffix," +
                    "Address1,Address2,City,State,Zip,Phone,Gender," +
                    "Status,HireDate,TerminateDt,PayCd");

            while (it.hasNext())
            {
                Map.Entry<Long, Employee> empEntry = it.next();

                out.println(empEntry.getValue().toString().replace("null",""));
            }
            // flush the data to the file and close the output stream
            out.close();
            status = "Employee record successfully modified. ";
        }
        catch (Exception e)
        {
            status = "Save error.";
        }
        return status;
    }   
    
    //method to enable radio buttons
    //used upon successful loading of .CSV file
    private void enableRadios(){
        radioRaw.setEnabled(true);
        radioTree.setEnabled(true);
        radioName.setEnabled(true);
    }
    
    private void menuLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLoadActionPerformed
        JFileChooser f = new JFileChooser("."); // "." means current directory
        f.setDialogTitle("Select Employee File"); //dialog title
        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV file (*.csv)",
        "CSV"); //filter for CSV files only
        f.setFileFilter(filter); //filter for CSV
        JDialog jd = new JDialog();
        int rVal = f.showOpenDialog(jd);
        if (rVal == JFileChooser.CANCEL_OPTION){
            lblRecords.setText("Open Operation canceled");
        }
        else{
            filename = f.getSelectedFile().getAbsolutePath();
            emps = EmployeeIO.getEmployees(filename);
            enableRadios();
            lblRecords.setText(String.valueOf(emps.size()));
        }
    }//GEN-LAST:event_menuLoadActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        //make sure there is a file loaded before attempting to update a file
        if (filename == null){
            JOptionPane.showMessageDialog(null, "You must load a file before "
            + "attempting to save employee records!", "File Not Found", 
            JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String setEmps = setEmps(filename, emps);
        txtMessage.setText(setEmps);
        clearFields();
//        btnGroupMap.clearSelection();
//        comboEmployee.removeAllItems();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        addEmployee();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearFields();
        comboEmployee.removeAllItems();
    }//GEN-LAST:event_btnClearActionPerformed

    //method to delete employee database entry
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        //make sure there is a file loaded before attempting to update a file
        if (filename == null){
            JOptionPane.showMessageDialog(null, "Please load a file before "
            + "attempting to update employee records!", "File Not Found", 
            JOptionPane.ERROR_MESSAGE);
            return;
        } else if (comboEmployee.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(null, "Please load an employee record"
                    + " before attempting to change it.", "No Employee Selected", 
            JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Long empNum = Long.parseLong(txtEmployeeNum.getText());
        String deleteEmp = emps.get(empNum).getFullName();
        if (emps.containsKey(empNum)){
            int confirm = JOptionPane.showConfirmDialog(
                null, "Are you sure you would like to remove the following "
                + "employee from the Employee Records?\n\n" +
                "*****THIS CANNOT BE UNDONE*****\n\n" +
                "Employee Number: " + empNum.toString() + "\n" +
                "Employee Name: " + emps.get(empNum).getFullName(),
                "Confirm Employee Deletion",
                JOptionPane.YES_NO_OPTION);

            if(confirm == JOptionPane.YES_OPTION) {
                emps.remove(empNum);
                clearFields();
                buildComboBox();
                txtMessage.setText("Employee '" + deleteEmp + "' has been successfully removed.");
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void comboEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEmployeeActionPerformed
        //        if (comboEmployee.getSelectedItem() != null){
            //            populateFields();
            //        }else return;
    }//GEN-LAST:event_comboEmployeeActionPerformed

    private void comboEmployeeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboEmployeeItemStateChanged
        //ensure record loading is complete
        if (loading ==1){
            return;
        }
        if (comboEmployee.getSelectedIndex() == -1){
            btnGroupMap.clearSelection();
            txtMessage.setText("No mapping option selected. Please reselect "
                    + "your preferred method.");
            return;
        } else {
            Employee e;
            if (radioName.isSelected()){
                e=(Employee)nameList.get((String)comboEmployee.getSelectedItem());
            } else {

                e=(Employee)emps.get((Long)(Long.parseLong((String)comboEmployee.getSelectedItem())));
            }
            //update displayed values
            String recordinfo = "You are viewing records for: ";
            displayValues(e);
            if (String.valueOf(e.getMiddleName()).equals("null")){
                txtMiddle.setText("");
                recordinfo += e.getLastName() + ", " + e.getFirstName();
            } else {
                recordinfo += e.getLastName() + ", " + e.getFirstName() + " " + e.getMiddleName();
            }
            txtMessage.setText(recordinfo);
            //setting up original employee number for Update function
            originalEmpNum = e.getEmployeeNumber();
        }
    }//GEN-LAST:event_comboEmployeeItemStateChanged

    private void btnRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRightActionPerformed
        //make sure there is a file loaded before attempting to
        // scroll through the list
        if (filename == null){
            JOptionPane.showMessageDialog(null, "No employee data file"
                    + " has been loaded.", "File Not Found", 
            JOptionPane.ERROR_MESSAGE);
            return;
        } else if (btnGroupMap.getSelection() == null){
            JOptionPane.showMessageDialog(null, "Please select your method of"
                    + " displaying employee data. \n"
                    + "Choose one of the three radio buttons at the top"
                    + " of the application.", "No Mapping Selected", 
            JOptionPane.ERROR_MESSAGE);   
            return;
        }

        //determine number of items in the combo box
        int count = comboEmployee.getItemCount()-1;
        //determine current index of selected item
        int x = comboEmployee.getSelectedIndex();
        //set the selected index to the next index
        //unless it's the end of the list
        if(count > x){
            comboEmployee.setSelectedIndex(x+1);
        }else {
            JOptionPane.showMessageDialog(null, "You have reached"
                + " the end of the list.", "End of List",
                JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnRightActionPerformed

    private void btnLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeftActionPerformed
        //make sure there is a file loaded before attempting to
        // scroll through the list
        if (filename == null){
            JOptionPane.showMessageDialog(null, "No employee data file"
                    + " has been loaded.", "File Not Found", 
            JOptionPane.ERROR_MESSAGE);
            return;
        } else if (btnGroupMap.getSelection() == null){
            JOptionPane.showMessageDialog(null, "Please select your method of"
                    + " displaying employee data. \n"
                    + "Choose one of the three radio buttons at the top"
                    + " of the application.", "No Mapping Selected", 
            JOptionPane.ERROR_MESSAGE);    
            return;
        }

        //determine current index of selected item
        int x = comboEmployee.getSelectedIndex();
        //set the selected index to the previous index
        //unless it's the beginning of the list
        if(x >= 1){
            comboEmployee.setSelectedIndex(x-1);
        }else {
            JOptionPane.showMessageDialog(null, "You have reached"
                + " the beginning of the list.", "Beginning of List",
                JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnLeftActionPerformed

    private void radioNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNameActionPerformed
        clearFields();
        try{
            if (radioName.isSelected()){
                buildComboBox();
                txtMessage.setText("Name Map populated. Select Employee "
                    + "Name to display employee info.");
                loading = 0;
            }
        }
        catch(NullPointerException e){
            txtMessage.setText("Error!");
            menuFile.doClick();
            btnGroupMap.clearSelection();
        }
    }//GEN-LAST:event_radioNameActionPerformed

    private void radioTreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioTreeActionPerformed
        clearFields();
        try{
            if (radioTree.isSelected()){
                buildComboBox();
                txtMessage.setText("TreeMap populated. Select Employee "
                    + "number to display employee info.");
                loading = 0;
            }
        }
        catch(NullPointerException e){
            txtMessage.setText("Error!");
            menuFile.doClick();
            btnGroupMap.clearSelection();
        }
    }//GEN-LAST:event_radioTreeActionPerformed

    private void radioRawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioRawActionPerformed
        clearFields();
        try{
            if (radioRaw.isSelected()){
                buildComboBox();
                txtMessage.setText("Raw HashMap populated. Select Employee "
                    + "number to display employee info.");
                loading = 0;
            }
        }
        catch(NullPointerException e){
            txtMessage.setText("Error!");
        }
    }//GEN-LAST:event_radioRawActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        updateEmployee();                 
    }//GEN-LAST:event_btnUpdateActionPerformed
       
    //method to set all text fields to blank
    private void clearFields(){
        txtEmployeeNum.setText("");
        txtFirstName.setText("");
        txtLastName.setText("");
        txtMiddle.setText("");
        txtAddress1.setText("");
        txtAddress2.setText("");
        txtCity.setText("");
        txtState.setText("");
        txtZip.setText("");
        txtPhone.setText("");
        txtGender.setText("");
        txtPayCode.setText("");
        txtStatus.setText("");
        txtHireDate.setText("");
        txtTerminationDate.setText("");
        txtMessage.setText("");
        txtMessage.setText("The form has been cleared. Please reselect a "
                + "mapping option to continue");
    }

    //method for adding an employee record to the emps Map
    private void addEmployee(){
        //make sure there is a file loaded before attempting to update a file
        if (filename == null){
            JOptionPane.showMessageDialog(null, "Please load a file before "
            + "attempting to add employee records!", "File Not Found", 
            JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Employee e = new Employee();
        
        //Validate that the employee number and First/Last names are valid.
        //Then add the new employee to the emps Map after a confirmation
        //message.
        if(Validator.isValidEmployeeNumber(txtEmployeeNum) &&
                Validator.isValidName(txtFirstName) &&
                Validator.isValidName(txtLastName) &&
                Validator.isTextFieldNotEmpty(txtPhone) &&
                Validator.isPhoneValid(txtPhone)&&
                Validator.isTextFieldNotEmpty(txtPayCode)){
            Long empNum = Long.parseLong(txtEmployeeNum.getText());
                if (!emps.containsKey(empNum)){
                    setEmployeeInfo(e, empNum);
                } else {
                    JOptionPane.showMessageDialog(null, "That employee is already "
                        + "in the database!", "Duplicate Entry", 
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }  
                
            int confirm = JOptionPane.showConfirmDialog(
                null, "Are you sure you would like to add and save the"
                        + " following information to the Employee Records?\n\n" + 
                        "Employee Number: " + empNum.toString() + "\n" +
                        "Employee Name: " + e.getFullName(),
                    "Confirm Employee Addition", 
                    JOptionPane.YES_NO_OPTION);

            if(confirm == JOptionPane.YES_OPTION) {
                emps.put(empNum, e);
                clearFields();
                btnSave.doClick();
                reloadEmployees();
                txtMessage.setText("Employee '" + e.getFullName() +
                        "' successfully added and saved.");
            }
        }
    }
    
    private void updateEmployee(){
        //make sure there is a file loaded before attempting to update a file
        if (filename == null){
            JOptionPane.showMessageDialog(null, "Please load a file before "
            + "attempting to update employee records!", "File Not Found", 
            JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        emps.remove(originalEmpNum);
        Employee e = new Employee();
        int selected = comboEmployee.getSelectedIndex();
        
        if(Validator.isValidEmployeeNumber(txtEmployeeNum) &&
                Validator.isValidName(txtFirstName) &&
                Validator.isValidName(txtLastName) &&
                Validator.isTextFieldNotEmpty(txtPhone) &&
                Validator.isPhoneValid(txtPhone)&&
                Validator.isTextFieldNotEmpty(txtPayCode)){
            
            Long empNum = Long.parseLong(txtEmployeeNum.getText());
            
            //if updating the employee number, check to make sure the new one
            //isn't already in the emps list
            if (!Objects.equals(empNum, originalEmpNum)){
                if (emps.containsKey(empNum)){
                    JOptionPane.showMessageDialog(null, "That Employee Number "
                            + "is already in use! Please use a new number.", 
                            "Employee Number Error", 
                    JOptionPane.ERROR_MESSAGE);
                    txtEmployeeNum.setText("");
                    txtEmployeeNum.requestFocusInWindow();
                    return;
                }
            }
            
            setEmployeeInfo(e, empNum);
                
            int confirm = JOptionPane.showConfirmDialog(
                null, "Are you sure you would like to update and save the "
                        + "following information to the Employee Records?\n\n" + 
                        "Employee Number: " + empNum.toString() + "\n" +
                        "Employee Name: " + e.getFullName(),
                    "Confirm Employee Addition", 
                    JOptionPane.YES_NO_OPTION);

            if(confirm == JOptionPane.YES_OPTION) {
                emps.put(empNum, e);
                clearFields();
                btnSave.doClick();
                reloadEmployees();
                comboEmployee.setSelectedIndex(selected);
                txtMessage.setText("Employee '" + e.getFullName() +
                    "' successfully updated and saved.");
            } 
        }    
    }

        //method to reload employee list / combo box upon adding/updating
    private void reloadEmployees(){ 
        try{
            if (radioName.isSelected()){
                buildComboBox();
                loading = 0;
            }
        }
        catch(NullPointerException e){
            txtMessage.setText("Error!");
            menuFile.doClick();
            btnGroupMap.clearSelection();
        }
        
        try{
            if (radioTree.isSelected()){
                buildComboBox();
                loading = 0;
            }
        }
        catch(NullPointerException e){
            txtMessage.setText("Error!");
            menuFile.doClick();
            btnGroupMap.clearSelection();
        }

        try{
            if (radioRaw.isSelected()){
                buildComboBox();
                loading = 0;
            }
        }
        catch(NullPointerException e){
            txtMessage.setText("Error!");
        }
    }   
    private void displayValues(Employee e) {
        // use reflection method in java.lang.reflect package
        Class empClass = e.getClass();
        Method[] methods = empClass.getMethods(); // Method class is obtained from Class object
        try {
            for (Method m : methods) {
                if (screenMap.containsKey(m.getName())) { // ensure field exists in screenMap
                    JTextField field = screenMap.get(m.getName()); // obtain target field
                    switch (m.getName()) {
                        case "getEmpno":
                            long x = (long) m.invoke(e, null);
                            field = screenMap.get(m.getName());
                            field.setText(String.valueOf(x));
                            break;
                        case "getPhone":
                            int y = (int) m.invoke(e, null);
                            field = screenMap.get(m.getName());
                            field.setText(String.valueOf(y));
                            break;
                        case "getPaycode":
                            int z = (int) m.invoke(e, null);
                            field = screenMap.get(m.getName());
                            field.setText(String.valueOf(z));
                            break;
                        default:
                            if (String.valueOf(m.invoke(e, null)).equals("null")) {
                                field.setText("");
                            }
                            else {
                                field.setText(String.valueOf(m.invoke(e, null)));
                            }
                            break;    
                    }
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    //method for setting empoyee info in update/add methods
    public void setEmployeeInfo(Employee e, Long empNum){
        int payCode = Integer.parseInt(txtPayCode.getText());
        int phone = Integer.parseInt(txtPhone.getText());
        e.setEmployeeNumber(empNum);
        e.setFirstName(txtFirstName.getText());
        e.setLastName(txtLastName.getText());
        e.setMiddleName(txtMiddle.getText());
        e.setSuffix(txtSuffix.getText());
        e.setAddress1(txtAddress1.getText());
        e.setAddress2(txtAddress2.getText());
        e.setCity(txtCity.getText());
        e.setState(txtState.getText());
        e.setZip(txtZip.getText());
        e.setPhone(phone);
        e.setPayCode(payCode);
        e.setGender(txtGender.getText());
        e.setStatus(txtStatus.getText());
        e.setHireDate(txtHireDate.getText());
        e.setTerminateDate(txtTerminationDate.getText());
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmployeeData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeData().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.ButtonGroup btnGroupMap;
    private javax.swing.JButton btnLeft;
    private javax.swing.JButton btnRight;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> comboEmployee;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblRecords;
    private javax.swing.JMenuItem menuAbout;
    private javax.swing.JMenuItem menuExit;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenuItem menuLoad;
    private javax.swing.JRadioButton radioName;
    private javax.swing.JRadioButton radioRaw;
    private javax.swing.JRadioButton radioTree;
    private javax.swing.JTextField txtAddress1;
    private javax.swing.JTextField txtAddress2;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtEmployeeNum;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtGender;
    private javax.swing.JTextField txtHireDate;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextArea txtMessage;
    private javax.swing.JTextField txtMiddle;
    private javax.swing.JTextField txtPayCode;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtState;
    private javax.swing.JTextField txtStatus;
    private javax.swing.JTextField txtSuffix;
    private javax.swing.JTextField txtTerminationDate;
    private javax.swing.JTextField txtZip;
    // End of variables declaration//GEN-END:variables
}
