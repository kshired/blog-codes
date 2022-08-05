@Service
public class UnleashService {
    private final Unleash unleash;

    public UnleashService() {
        UnleashConfig config = UnleashConfig.builder()
                .appName("java-test")
                .instanceId("instance x")
                .environment("production")
                .unleashAPI("http://localhost:4242/api/")
                .customHttpHeader("Authorization", "*:production.901a0b7802e7259e4d8046973b135e7a8cbf4ba2f10f2d46e88288cb")
                .build();

        this.unleash = new DefaultUnleash(config);
    }

    public boolean isEnabled() {
        return unleash.isEnabled("test");
    }
}