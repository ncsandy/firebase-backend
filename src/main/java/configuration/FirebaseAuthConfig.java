package configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class FirebaseAuthConfig  {

    @Value("service-account.json")
    Resource serviceAccount;
    @Bean
    public FirebaseAuth firebaseAuth() throws IOException {
        var options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream((InputStream) serviceAccount))
                .setDatabaseUrl("https://simple-app-d3cee-default-rtdb.firebaseio.com")
                .build();

        var firebaseApp = FirebaseApp.initializeApp(options);

        System.out.println("This works\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

        return FirebaseAuth.getInstance(firebaseApp);
    }
}
