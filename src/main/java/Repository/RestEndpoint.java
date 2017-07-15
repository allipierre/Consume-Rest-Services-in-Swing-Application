package Repository;

import modell.Employee;
import modell.EmployeesData;
import retrofit2.Call;
import retrofit2.http.*;

public interface RestEndpoint {

	@GET("employees/")
	Call<EmployeesData.DataResponse> getEmployees();

	@POST("employees/")
	Call<Void> addEmployee(@Body Employee employee);

	@GET("employees/{empId}")
	Call<EmployeesData.DataResponse> GetEmployeeById(@Path("empId") long empId);

	@PUT("employees/{empId}")
	Call<Void> editEmployee(@Body Employee employee, @Path("empId") long empId);

	@DELETE("employees/{empId}")
	Call<Void> deleteEmployee(@Path("empId") long empId);
}
