import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@SuppressWarnings("unused")
public class ServiceGenerator {

    private static final String API_BASE_URL = "https://apex.oracle.com/pls/apex/freddie/hr/";

    private static OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();

    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass) {
        OkHttpClient httpClient = clientBuilder.build();
        return retrofitBuilder.client(httpClient).build().create(serviceClass);
    }
}