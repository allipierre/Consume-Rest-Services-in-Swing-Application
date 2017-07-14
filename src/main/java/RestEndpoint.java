import retrofit2.Call;
import retrofit2.http.*;

public interface RestEndpoint {

    @GET("employees/")
    Call<EmployeesData.DataResponse> getEmployees(@Query("page") int page);

    @POST("employees/")
    Call<Void> addEmployee(@Body Employee employee);

    @PUT("employees/{empId}")
    Call<Void> editEmployee(@Body Employee employee, @Path("empId") long empId);

    @DELETE("employees/{empId}")
    Call<Void> deleteEmployee(@Path("empId") long empId);
}
