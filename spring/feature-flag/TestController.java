@RestController
@RequestMapping("/test")
public class TestController {
    private final UnleashService unleashService;

    public Controller(UnleashService unleashService) {
        this.unleashService = unleashService;
    }

    @GetMapping
    public String test() {
        if (unleashService.isEnabled()) {
            return "yes!";
        }

        return "no!";
    }
}
