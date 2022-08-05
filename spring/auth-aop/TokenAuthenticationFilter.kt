class TokenAuthenticationFilter(
    private val tokenProvider: AuthTokenProvider
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val tokenStr = getAccessToken(request)

        if (tokenStr == null) {
            filterChain.doFilter(request, response)
            return
        }

        val token = tokenProvider.convertAuthToken(tokenStr)

        if (token.isValid) {
            val authentication = tokenProvider.getAuthentication(token)
            SecurityContextHolder.getContext().authentication = authentication
        }

        filterChain.doFilter(request, response)
    }
}