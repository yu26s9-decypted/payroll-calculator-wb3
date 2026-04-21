import model.Employee;
import ui.Console;

import java.io.*;


    public static void main(String[] arg) throws IOException {
        try {
            String fileName = Console.askForString("Enter the name of the file to process: ").trim();
            String outputFileName = Console.askForString("Enter the name of the file output: ").trim();
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            FileWriter fileWriter = new FileWriter(outputFileName, false);
            fileWriter.write("ID|Name|Gross");
           // fileWriter.close();

            bufferedReader.readLine();

            String employeeCsv;
            while((employeeCsv = bufferedReader.readLine()) != null){

                String[] employeeData = employeeCsv.split("\\|");
                int employeeId = Integer.parseInt(employeeData[0]);
                String employeeName = employeeData[1];
                double employeeWorkedHours = Double.parseDouble(employeeData[2]);
                double employeeHourlyPay = Double.parseDouble(employeeData[3]);
                Employee e = new Employee(employeeId, employeeName, employeeWorkedHours, employeeHourlyPay);

                double grossPay = e.getGrossPay();

//                parseCsv(outputFileName, employeeId, employeeName, grossPay );
                writeToFile(fileWriter, e);
//                String grossPayStr = String.valueOf("$" + grossPay);
//                String empId = String.valueOf(employeeId);
//
//                fileWriter.write("\n" + empId + "|");
//                fileWriter.write(employeeName + "|");
//                fileWriter.write(grossPayStr);
            }

            fileWriter.close();


            System.out.println("\n Employee payroll has been parsed. You can view it at:" + outputFileName);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }

    public static String writeToFile(FileWriter fileWriter, Employee e) throws IOException {

        fileWriter.write("\n" + e.getEmployeeId() + "|");
        fileWriter.write(e.getName() + "|");
        fileWriter.write(String.format("$%.2f", e.getGrossPay()));
        return "Operation successful";
    }

//    public static String parseCsv(String fileName, int employeeId, String employeeName, double employeeGrossPay) throws IOException {
//    FileWriter fileWriter = new FileWriter(fileName, true);
//    fileWriter.write("\n" + employeeId + "|");
//    fileWriter.write(employeeName + "|");
//    fileWriter.write(String.format("$%.2f", employeeGrossPay));
//    fileWriter.close();
//    return "File has been parsed.";
//}

