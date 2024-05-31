## 카카오페이 결제 모듈 구현

### DTO 구성

각 요청, 응답마다 DTO를 생성하는 방식으로 구현  
DTO클래스가 많아진다는 단점이 있지만 정적 클래스로 보완  
각 요청, 응답마다 생성하므로 다른 API에 영향을 주지 않음

- ReadyRequest (결제 준비 요청 DTO)
- ReadyResponse (결제 준비 요청에 대한 응답 DTO)
- ApproveRequest (결제 승인 요청 DTO)
- ApproveResponse (결제 승인 요청에 대한 응답 DTO)
- Amount (결제 금액 정보 응답 DTO)

### 서비스 구성

현재는 카카오페이 결제만 도입  
추 후 네이버, 토스페이 등 도입하게 되면 인터페이스 역할, 구현 분리 예정

1)결제 준비, 2)결제 승인 단계로 나뉘어짐

1)결제 준비 : readyKakaoPay()

- 상품정보(상품명, 금액 등)와 가맹점 코드(현재는 테스트 가맹점코드) 정보를 파라미터로 카카오페이 API 호출
- 응답으로 카카오페이 결제 창 URL을 받음

2)결제 승인 : approveKakaoPay()

- 카카오페이 결제 창에서 결제하면 pg_token을 발급받음
- 결제정보(가맹점 코드, 토큰정보 등)을 파라미터로 카카오페이 API 호출
- 응답으로 결제 완료 여부를 받음

### MockMvc 메서드

요청만들기 - MockHttpServletRequestBuilder
public MockHttpServletRequestBuilder param(String name, String... values)

public MockHttpServletRequestBuilder params(MultiValueMap<String,String> params)

: 요청파라미터를 설정한다

public MockHttpServletRequestBuilder header(String name, Object... values)

public MockHttpServletRequestBuilder headers(HttpHeaders httpHeaders)

: 요청 헤더를 설정한다. contentType이나 accept와 같은 특정 헤더를 설정할 수 있는 메서드도 제공한다.

public MockHttpServletRequestBuilder cookie(Cookie... cookies)

: 쿠키를 설정한다

public MockHttpServletRequestBuilder content(String content)

: 요청 본문을 설정한다

public MockHttpServletRequestBuilder requestAttr(String name, Object value)

: 요청스코프에 객체를 설정한다

public MockHttpServletRequestBuilder sessionAttr(String name, Object value)

public MockHttpServletRequestBuilder sessionAttrs(Map<String,Object> sessionAttributes)

: 세션 스코프에 객체를 설정한다.

public MockHttpServletRequestBuilder flashAttr(String name, Object value)

: 플래쉬 스코프에 객체를 설정한다.



검증 - MockMvcResultMatchers
public static ViewResultMatchers view()

: 컨트롤러가 반환한 뷰 이름을 검증한다.

public static StatusResultMatchers status()

: HTTP 상태 코드를 검증한다.

public static HeaderResultMatchers header()

: 응답 헤더의 상태를 검증한다.

public static ContentResultMatchers content()

: 응답 본문 내용을 검증한다. jsonPath나 xpath와 같은 특정 콘텐츠를 위한 메서드를 제공한다

public static CookieResultMatchers cookie()

: 쿠키의 상태를 검증한다

public static ModelResultMatchers model()

: 스프링 MVC 모델 상태를 검증한다.

public static ResultMatcher redirectedUrl(String expectedUrl)

: 리다이렉트 대상의 경로 또는 URL을 검증한다. 패턴으로 검증할 때는 redirectedUrlPattern 메서드를 사용한다.

public static ResultMatcher forwardedUrlPattern(String urlPattern)

: 이동 대상 경로를 검증한다. 패턴으로 검증할 때는 forwardedUrlPattern 메서드를 사용한다.

public static RequestResultMatchers request()

: 서블릿 3.부터 지원되는 비동기 처리의 상태나 요청스코프의 상태, 세션 스코프의 상태를 검증한다.