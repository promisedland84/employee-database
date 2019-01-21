/*
 * EmployeeData.java 
 * Matt Koenen / Sidney Rens
 * IS 286 695
 * Project 3 - Employee Application
 * 07/11/18
 */
package business;

public class Employee {
    private long employeeNumber;
    private String firstName;
    private String lastName;
    private String middleName;
    private int phone;
    private int payCode;
    private String address1;
    private String address2;
    private String suffix;
    private String city;
    private String state;
    private String zip;
    private String gender;
    private String status;
    private String hireDate;
    private String terminateDate;
    private String fullName;

    public Employee(){
        employeeNumber = 0;
        phone = 0;
        payCode = 0;
        //create an array of the String fields
        String[] fields = {lastName,firstName,middleName,suffix,address1, 
            address2,city,state,zip,gender,status,hireDate,terminateDate};
        for (String x : fields){
         x = "";
        }
    }
    
    public long getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(long employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getPayCode() {
        return payCode;
    }

    public void setPayCode(int payCode) {
        this.payCode = payCode;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getTerminateDate() {
        return terminateDate;
    }

    public void setTerminateDate(String terminateDate) {
        this.terminateDate = terminateDate;
    }
    
    public String getFullName(){
        if (this.middleName == null){
            this.middleName = "";
        }
        
        this.fullName = this.lastName + ", " + this.firstName + " " + this.middleName;

        return fullName;
    }
    
    //override toString() method to update our CSV file
    @Override
    public String toString(){
        return this.employeeNumber + "," 
                + this.firstName + "," 
                + this.lastName + "," 
                + this.middleName+ "," 
                + this.suffix + "," 
                + this.address1 + "," 
                + this.address2 + "," 
                + this.city + "," 
                + this.state + "," 
                + this.zip + "," 
                + this.phone + "," 
                + this.gender + "," 
                + this.status + "," 
                + this.hireDate + "," 
                + this.terminateDate + "," 
                + this.payCode;
    }
}
