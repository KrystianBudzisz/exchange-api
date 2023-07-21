- zarejestrować się na jakiejś stronie exchange api (potrzebny klucz i bazowy adres)  https://exchangeratesapi.io/
- 
- Poczytać RestTemplate, WebClient, FeignClient
- spróbować zaimplementować wysyłkę zapytania do zewnętrznego api (pobranie wszystkich dostępnych walut)





RestTemplate: To był podstawowy klient HTTP Springa, używany do synchronicznej komunikacji z serwisami REST. 
RestTemplate dostarcza różne metody do wykonania różnych rodzajów żądań HTTP, takich jak GET, POST, DELETE i PUT.
Jest to dość proste i intuicyjne w użyciu, ale od wersji 5.1 Springa RestTemplate zostało oznaczone jako przestarzałe
na rzecz WebClienta.

WebClient: Jest to nowoczesny, niewspółblokujący klient webowy wprowadzony w Spring 5. WebClient jest częścią Spring WebFlux
, reaktywnego stosu sieciowego Springa, i jest przeznaczony do obsługi komunikacji HTTP w sposób niewspółblokujący.
Pozwala na obsługę strumieniowej i asynchronicznej komunikacji HTTP, 
co jest szczególnie przydatne przy obsłudze dużych wolumenów danych lub przy wielu żądaniach HTTP.

FeignClient: Jest to deklaratywny klient sieciowy, który upraszcza sposób pisania klientów HTTP.
Zamiast pisania szczegółowego kodu do obsługi żądań HTTP, jak ma to miejsce z RestTemplate czy WebClient,
możesz po prostu zdefiniować interfejs Javy i adnotować go za pomocą adnotacji FeignClient, 
a Spring automatycznie dostarczy implementację w czasie wykonywania. FeignClient jest częścią projektu Spring Cloud i
jest szczególnie przydatny w mikroserwisach, gdzie musisz komunikować się z wieloma innymi serwisami.