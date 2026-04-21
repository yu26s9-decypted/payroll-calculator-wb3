import model.Employee;
import ui.Console;

import java.io.*;


    public static void main(String[] arg) throws IOException {
        try {
            String fileName = Console.askForString("Enter the name of the file to process: ").trim();
            String outputFileName = Console.askForString("Enter the name of the file output: ").trim();
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String employeeCsv = "";
            FileWriter fileWriter = new FileWriter(outputFileName);

            bufferedReader.readLine();


            while((employeeCsv = bufferedReader.readLine()) != null){

                String[] employeeData = employeeCsv.split("\\|");
                int employeeId = Integer.parseInt(employeeData[0]);
                String employeeName = employeeData[1];
                double employeeWorkedHours = Double.parseDouble(employeeData[2]);
                double employeeHourlyPay = Double.parseDouble(employeeData[3]);
                double grossPay = Employee.getGrossPay(employeeWorkedHours, employeeHourlyPay);


                String grossPayStr = String.valueOf(grossPay);
                String empId = String.valueOf(employeeId);

                fileWriter.write("\n" + empId + "|");
                fileWriter.write(employeeName + "|");
                fileWriter.write(grossPayStr);


                System.out.printf("\n %d %s " +
                        "Gross Pay: $%.2f", employeeId, employeeName, grossPay);



            }

            fileWriter.close();
            System.out.println("\n All payroll has been parsed. You can view it in" + outputFileName);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }



public static String parseCsv(String fileName, int employeeId, String employeeName, double employeeGrossPay) throws IOException {
    FileWriter fileWriter = new FileWriter(fileName);
    fileWriter.write(employeeId);
    fileWriter.write(employeeName);
    fileWriter.write((int) employeeGrossPay);
    fileWriter.close();
    return "Success";
}

