import model.Employee;

import java.io.*;

public class Main {
    public static void main(String[] arg) throws IOException {
        try {
            FileReader fileReader = new FileReader("employees.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String employeecsv = "";
            bufferedReader.readLine();



            while((employeecsv = bufferedReader.readLine()) != null){
                String[] employeeData = employeecsv.split("\\|");
                int employeeId = Integer.parseInt(employeeData[0]);
                String employeeName = employeeData[1];
                double employeeWorkedHours = Double.parseDouble(employeeData[2]);
                double employeeHourlyPay = Double.parseDouble(employeeData[3]);
                double grosspay = Employee.getGrossPay(employeeWorkedHours, employeeHourlyPay);

                System.out.printf("\n Employee Id: %d " +
                        "\n Employee Name: %s " +
                        "\n Payrate: $%.2f" +
                        "\n Gross Pay: $%.2f \n", employeeId, employeeName, employeeHourlyPay, grosspay);

            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}
