@Component
class LoginUserArgumentResolver : HandlerMethodArgumentResolver {
    override fun supportsParameter(parameter: MethodParameter): Boolean {
        parameter.getParameterAnnotation(LoginUser::class.java) ?: return false

        if (!parameter.parameterType.isAssignableFrom(User::class.java)) {
            return false
        }

        return true
    }

    override fun resolveArgument(
        parameter: MethodParameter,
        mavContainer: ModelAndViewContainer?,
        webRequest: NativeWebRequest,
        binderFactory: WebDataBinderFactory?
    ): Any? {
        var principal: Any? = null

        val authentication = SecurityContextHolder.getContext().authentication

        if (authentication != null) {
            principal = authentication.principal
        }

        if (authentication == null || principal is String) {
            throw UnauthorizedException("로그인이 필요합니다!")
        }

        return principal
    }
}