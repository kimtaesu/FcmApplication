 ### Firebase FCM Application using kotlin

## Libraries used:
- Firebase FCM
- Retrofit 2.0
- RxKotlin
- OkHttp3
- RxAndroid
- Dagger 2
- Kotlin Android Extensions
# flow of registering token
FirebaseTokenService.kt
```
fun getToken(): Observable<String> {
        val token = FirebaseInstanceId.getInstance().token
        return Observable.just(token!!)
                .map { token ->
                    token ?: throw TokenNullException("Token is null")
                    token
                }
                .subscribeOn(Schedulers.io())
}
```
GooglePresenterImpl.kt
```
override fun updateGoogleToken(): Observable<GoogleTokenResponse> {
        val token = preferenceService.getGoogleInstanceToken()
        if (null != token) {
            return Observable.just(GoogleTokenResponse(token))
        }

        return tokenService.getToken()
                .map { token ->
                    preferenceService.setGoogleInstanceToken(token)
                    GoogleToken(token)
                }
                .concatMap { token ->
                    repository.saveGoogleToken(token)
                            .onDefaultThread()
                            .ifHttpFailThrowException()
                }
                .map(Response<GoogleTokenResponse>::body)
    }
```


# Graph of Dependecies injection 

![](https://github.com/kimtaesu/FcmApplication/blob/master/document/graph_di.jpg)
*** 
## 느낀점 : 
- DI를 통하여 약 결합 강 응집도를 구현하는 것은 좋은 방향이지만, Di를 구현하기 위한 apt complie 이 상당히 복잡하다. 
- Android Studio의 한계가 있다. Intellij는 Autowired 된 Refer를 찾아갈 수 있다. 
- 어떠한 Library API 객체를 사용하기 위하여 Singleton 으로 Provide할 경우에 적합한 것 같다. 
***

### 실행 화면 
![](https://github.com/kimtaesu/FcmApplication/blob/master/screenshot/Screenshot_1493824309.png)

***
