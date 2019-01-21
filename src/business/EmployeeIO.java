/*
 * EmployeeIO.java 
 * Matt Koenen / Sidney Rens
 * IS 286 695
 * Project 3 - Employee Application
 * 07/11/18
 */
package business;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class EmployeeIO
{
    //Hash can't work with primitive data types. So uppercase Long, instead of long    
    public static Map<Long, Employee> getEmployees(String path)
    {
        Map<Long, Employee> emplist = new HashMap<>();
        
        try {
            BufferedReader in = new BufferedReader(new FileReader(path));
            in.readLine();
            String s = in.readLine();
            
            while(s != null)
            {
                String[] edata = s.split(",");
                Employee emp = new Employee();
                long employeeNumber = Long.parseLong(edata[0]);
                emp.setEmployeeNumber(employeeNumber);
                
                if (!edata[1].isEmpty()) {
                    emp.setFirstName(edata[1]);
                }
                if (!edata[2].isEmpty()) {
                    emp.setLastName(edata[2]);
                }
                if (!edata[3].isEmpty()) {
                    emp.setMiddleName(edata[3]);
                }
                if (!edata[4].isEmpty()) {
                    emp.setSuffix(edata[4]);
                }
                if (!edata[5].isEmpty()) {
                    emp.setAddress1(edata[5]);
                }
                if (!edata[6].isEmpty()) {
                    emp.setAddress2(edata[6]);
                }
                if (!edata[7].isEmpty()) {
                    emp.setCity(edata[7]);
                }
                if (!edata[8].isEmpty()) {
                    emp.setState(edata[8]);
                }
                if (!edata[9].isEmpty()) {
                    emp.setZip(edata[9]);
                }
                if (!edata[10].isEmpty()) {
                    emp.setPhone(Integer.parseInt(edata[10]));
                }
                if (!edata[11].isEmpty()) {
                    emp.setGender(edata[11]);
                }
                if (!edata[12].isEmpty()) {
                    emp.setStatus(edata[12]);
                }
                if (!edata[13].isEmpty()) {
                    emp.setHireDate(edata[13]);
                }
                if (!edata[14].isEmpty()) {
                    emp.setTerminateDate(edata[14]);
                }
                if (!edata[15].isEmpty()) {
                    emp.setPayCode(Integer.parseInt(edata[15]));
                }
                emplist.put(employeeNumber, emp);
                s = in.readLine();  
            }
        }
        catch(Exception e)
        {
            System.out.println("Error in EmployeeIO: " + e.getMessage());
        }
        return emplist;
    }
}
