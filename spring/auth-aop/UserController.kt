@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService
) {
    // before using aop
    @GetMapping
    fun getUser(): ApiResponse<UserResponseDto> {
        val principal = SecurityContextHolder.getContext().authentication.principal as User

        val findUser = this.userService.findUserByEmail(principal.email)
                ?: throw IllegalArgumentException("${principal.email} is not appropriate email")
                
        return ApiResponse.success(findUser.toUserResponseDto()) 
    }

    // after using aop
    @GetMapping
    fun getUser(@LoginUser loginUser: User): ApiResponse<UserResponseDto> {
        val findUser = this.userService.findUserByEmail(loginUser.email)
                ?: throw IllegalArgumentException("${loginUser.email} is not appropriate email")
                
        return ApiResponse.success(findUser.toUserResponseDto()) 
    }
}
