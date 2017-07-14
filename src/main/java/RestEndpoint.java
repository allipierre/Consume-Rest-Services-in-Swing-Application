import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestEndpoint {

    @GET("employees/")
    Call<EmployeesData.DataResponse> getEmployees(@Query("page") int page);

}
