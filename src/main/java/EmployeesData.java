import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;

public class EmployeesData {

    private static EmployeesData instance;
    private ArrayList<Employee> employees;
    private int page = 0;

    public static EmployeesData getInstance() {
        if (instance == null) {
            instance = new EmployeesData();
        }

        return instance;
    }

    private EmployeesData() {
        employees = new ArrayList<>();
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void restart() {
        page = 0;
        employees.clear();
    }

    void fetchNext() {
        ServiceGenerator.createService(RestEndpoint.class)
                .getEmployees(page)
                .enqueue(new Callback<DataResponse>() {
                    @Override
                    public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                        if (response.isSuccessful()) {
                            System.out.println(response.body().getItems().toString());
                            employees.addAll(response.body().getItems());
                            Main.getMainInstance().updateConsole();
                            page++;
                        }
                    }

                    @Override
                    public void onFailure(Call<DataResponse> call, Throwable t) {

                    }
                });
    }


    public class DataResponse {

        ArrayList<Employee> items = new ArrayList<>();

        public DataResponse() {

        }

        public ArrayList<Employee> getItems() {
            return items;
        }

        public void setItems(ArrayList<Employee> items) {
            this.items = items;
        }
    }
}
