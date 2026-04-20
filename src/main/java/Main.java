import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] arg) throws IOException {
        try {
            FileReader fileReader = new FileReader("employees.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String employeecsv = bufferedReader.readLine();

            while((employeecsv = bufferedReader.readLine()) != null){
                System.out.println(employeecsv);
                String[] employeeData = employeecsv.split("\\|");
                int employeeId = Integer.parseInt(employeeData[0]);
                String employeeName = employeeData[1];
                double employeeWorkedHours = Double.parseDouble(employeeData[2]);
                double employeeHourlyPay = Double.parseDouble(employeeData[3]);

                System.out.printf("\n Employee Id: %d " +
                        "\n Employee Name: %s " +
                        "\n Payrate: $%.2f \n", employeeId, employeeName, employeeHourlyPay);

            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}
