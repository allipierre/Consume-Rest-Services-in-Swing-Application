package modell;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;

import Repository.RestEndpoint;
import Service.ServiceGenerator;
import View.JframeItems;
import View.Terminal;
import application.Main;

public class EmployeesData {

	private static EmployeesData instance;
	private ArrayList<Employee> employees;

	private EmployeesData() {
		employees = new ArrayList<>();
	}

	public static EmployeesData getInstance() {
		if (instance == null) {
			instance = new EmployeesData();
		}

		return instance;
	}

	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	public void restart() {
		employees.clear();
	}

	public void fetchNext() {

		ServiceGenerator.createService(RestEndpoint.class).getEmployees().enqueue(new Callback<DataResponse>() {
			@Override
			public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
				if (response.isSuccessful()) {
					employees.addAll(response.body().getItems());
					Main.getMainInstance().updateConsole();
				}
			}

			@Override
			public void onFailure(Call<DataResponse> call, Throwable t) {

			}
		});
	}

	public void fetchNextById() {
		if (Terminal.getEmpId().getText() == null || Terminal.getEmpId().getText().isEmpty()) {
			Main.getMainInstance().setStatus("Specify employee id");
			return;
		}
		ServiceGenerator.createService(RestEndpoint.class)
				.GetEmployeeById(Long.parseLong(Terminal.getEmpId().getText())).enqueue(new Callback<DataResponse>() {
					@Override
					public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
						if (response.isSuccessful()) {
							employees.addAll(response.body().getItems());
							Main.getMainInstance().updateConsole();
						} else {
							Main.getMainInstance().setStatus("Failed to delete employee");
							System.out.println(response.raw().toString());
						}
					}

					@Override
					public void onFailure(Call<DataResponse> call, Throwable t) {
						Main.getMainInstance().setStatus("Retry!");
					}
				});

	}

	public ArrayList<Employee> fetchNexts() {

		ServiceGenerator.createService(RestEndpoint.class).getEmployees().enqueue(new Callback<DataResponse>() {
			@Override
			public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
				if (response.isSuccessful()) {
					employees.addAll(response.body().getItems());

				}
			}

			@Override
			public void onFailure(Call<DataResponse> call, Throwable t) {

			}
		});
		return employees;
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
